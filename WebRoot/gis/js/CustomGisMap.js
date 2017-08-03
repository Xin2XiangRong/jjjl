/**
 * 定义CustomGisMap对象，加载地图及初始化地图常用的工具
 */
var CustomGismap = function() {
	/**
	 * 定义基本类型变量
	 */
	var left="";
	var bottom="";
	var right="";
	var top="";
	var mapInWinInitX = "";
	var mapInWinInitY = "";
	var mapInWinX = ""; // 标记指令中心点（经度）
	var mapInWinY = ""; // 标记指令中心点（纬度）
	var mapScale = ""; // 标记地图比例尺
	var gishost = ""; // GIS服务器地址
	var gisport = ""; // GIS服务端口号
	var webhost = ""; // WEB服务器主机
	var webport = ""; // WEB服务端口号

	/**
	 * 定义非基本类型
	 */
	CustomGismap.prototype.getMap = function() {
		return this.map;
	};
	CustomGismap.prototype.setMap = function(map) {
		this.map = map;
	};

	/**
	 * 定义非基本类型
	 */
	// chooseArea/*框选区域层*/
	CustomGismap.prototype.getChooseArea = function() {
		return this.chooseArea;
	};
	CustomGismap.prototype.setChooseArea = function(chooseArea) {
		this.chooseArea = chooseArea;
	};

	/**
	 * 定义操作变量
	 */
	// 定义control
	CustomGismap.prototype.getControl = function() {
		return this.control;
	};
	CustomGismap.prototype.setControl = function(control) {
		this.control = control;
	};

	// 定义queryBounds
	CustomGismap.prototype.getQueryBounds = function() {
		return this.queryBounds;
	};
	CustomGismap.prototype.setQueryBounds = function(queryBounds) {
		this.queryBounds = queryBounds;
	};
	/**
	 * 定义初始化函数
	 */
	CustomGismap.prototype.init = function() {
		// 初始化地图/////////////////////////////////////////////////////////////////////////////
		this.map = new SuperMap.Map("map", {
			controls : [ new SuperMap.Control.LayerSwitcher(),
					new SuperMap.Control.ScaleLine(),
					new SuperMap.Control.MousePosition(),
					new SuperMap.Control.Navigation({
						dragPanOptions : {
							enableKinetic : true
						}
					}) ]
		});
		var bounds=new SuperMap.Bounds(this.left,this.bottom,this.right,this.top);
		this.map.restrictedExtent=bounds;
		// 创建框选区域层
		this.chooseArea = new SuperMap.Layer.Vector("框选区域层");

	}
	/**
	 * 定义添加图层方法
	 */
	CustomGismap.prototype.createXXXXLayer = function() {

	}
	/**
	 * 将图层添加到地图中去
	 */
	CustomGismap.prototype.addLayers = function() {
		this.map.addLayers([]);
		this.viewEntire();
		this.createClusterLayerSelect();
	}

	/**
	 * 聚类层选择事件方法
	 */
	CustomGismap.prototype.createClusterLayerSelect = function() {
		var clusterLayerArray = [];
		clusterLayerArray.push();
		var clusterSelect = new SuperMap.Control.SelectCluster(
				clusterLayerArray, {
					callbacks : {
						click : function(f) { // 点击兴趣点弹出信息窗口
							this.closeInfoWin;
							if (!f.isCluster) { // 当点击聚散点的时候不弹出信息窗口
								this.openInfoWin(f);
							}
						},
						clickout : function() { // 点击空白处关闭信息窗口
							this.closeInfoWin;
						}
					}
				});
		this.map.addControl(clusterSelect);
		clusterSelect.activate();
	}

	/**
	 * 根据SQL语句条件查询
	 */
	CustomGismap.prototype.queryBySQL = function(layerurl, layername,
			itemParamFilter) {
		var queryParam, queryBySQLParams, queryBySQLService;
		queryParam = new SuperMap.REST.FilterParameter({
			name : layername,
			attributeFilter : itemParamFilter
		});

		queryBySQLParams = new SuperMap.REST.QueryBySQLParameters({
			queryParams : [ queryParam ]
		});

		queryBySQLService = new SuperMap.REST.QueryBySQLService(layerurl, {
			eventListeners : {
				"processCompleted" : this.processCompleted,
				"processFailed" : this.processFailed
			}
		});
		queryBySQLService.processAsync(queryBySQLParams);
	};

	/**
	 * 根据根据框选范围查询
	 */
	CustomGismap.prototype.queryByBounds = function(layerurl, layername,
			queryBounds) {

		var queryParam, queryByBoundsParams, queryService;

		queryParam = new SuperMap.REST.FilterParameter({
			name : layername
		});// FilterParameter设置查询条件，name是必设的参数，（图层名称格式：数据集名称@数据源别名）

		queryByBoundsParams = new SuperMap.REST.QueryByBoundsParameters({
			queryParams : [ queryParam ],
			bounds : queryBounds
		});// queryParams查询过滤条件参数数组。bounds查询范围

		queryService = new SuperMap.REST.QueryByBoundsService(layerurl, {
			eventListeners : {
				"processCompleted" : this.processCompleted,
				"processFailed" : this.processFailed
			}
		});
		queryService.processAsync(queryByBoundsParams);// 向服务端传递参数，然后服务端返回对象
	};

	/**
	 * marker标记位
	 */
	CustomGismap.prototype.getMarker = function() {
		return this.marker;
	};
	CustomGismap.prototype.setMarker = function(marker) {
		this.marker = marker;
	};
	/**
	 * 查询成功结果,并对结果进行渲染
	 */
	CustomGismap.prototype.processCompleted = function(queryEventArgs) {
		var i, j, feature, result = queryEventArgs.result;
		var ps = [];// 存放聚散点的数组
		if (result && result.recordsets) {
			for (i = 0; i < result.recordsets.length; i++) {
				if (result.recordsets[i].features) {
					if (result.recordsets[i].features.length == 0) {
						// alert("*_*没有查到");
						return false;
					}
					for (j = 0; j < result.recordsets[i].features.length; j++) {
						feature = result.recordsets[i].features[j];
						feature.info = {
							"objname" : feature.attributes.NAME,
							"objcode" : feature.attributes.ID
						};
						ps.push(feature);
					}
				}
			}
		}
	}
	/**
	 * 查询失败，提示失败原因
	 */
	CustomGismap.prototype.processFailed = function(queryEventArgs) {
		alert("*_* " + queryEventArgs.error.errorMsg);
	};
	/**
	 * 定义框选范围查询方法
	 */
	CustomGismap.prototype.queryByDrawGeometry = function(layerurl, layername) {

		control = new SuperMap.Control();
		SuperMap.Util.extend(control, {// Util工具类 extend指的是将复制所有的属性的源对象到目标对象
			draw : function() {
				this.box = new SuperMap.Handler.Box(control, {
					"done" : this.notice
				});// 此句是创建一个句柄，Box是一个处理地图拖放一个矩形的事件，这个矩形显示是开始于在按下鼠标，然后移动鼠标，最后完成在松开鼠标。
				this.box.boxDivClassName = "qByBoundsBoxDiv";// boxDivClassName用于绘制这个矩形状的图形
				this.box.activate();// 激活句柄
			},
			// 将拖动的矩形显示在地图上
			notice : function(bounds) {
				this.box.deactivate();// 处理关闭激活句柄

				var ll = this.map.getLonLatFromPixel(new SuperMap.Pixel(
						bounds.left, bounds.bottom)), // getLonLatFromPixel从视口坐标获得地理坐标
				ur = this.map.getLonLatFromPixel(new SuperMap.Pixel(
						bounds.right, bounds.top));
				var queryBounds = new SuperMap.Bounds(ll.lon, ll.lat, ur.lon,
						ur.lat);
				var feature = new SuperMap.Feature.Vector();
				feature.geometry = queryBounds.toGeometry();
				feature.style = _this.styleArea;
				this.chooseArea.addFeatures(feature);
				this.queryByBounds(layerurl, layername, queryBounds);
			}
		});
		this.map.addControl(control);
	};
	/**
	 * Marker标记弹出信息
	 */
	CustomGismap.prototype.getInfowin = function() {
		return this.infowin;
	};
	CustomGismap.prototype.setInfowin = function(infowin) {
		this.infowin = infowin;
	};
	/**
	 * Marker标记弹出对话框信息
	 */
	CustomGismap.prototype.openInfoWin = function(feature) {
		this.closeInfoWin();
		var geo = feature.geometry;
		var bounds = geo.getBounds();
		// 点信息
		lonlat = bounds.getCenterLonLat();
		var contentHTML = "";
		// 根据类型不同查询不同的详细信息
		var actionURL = _this.webhost + _this.webport + "/sxdsw/";
		contentHTML = "<div style='min-width:180px; min-height:150px; font-size:.96em; color:black; overflow-y:hidden;'><br/>"
				+ "<div>" + "<table class='table_blue'>";
		contentHTML += "<tr><th>名称</th><td>" + feature.info.objname
				+ "</td></tr>" + "<tr><th>代码</th><td>" + feature.info.objcode
				+ "</td></tr>";
		if (actionURL == "") {
			contentHTML += "</table>" + "</div>" + "</div>";
		} else {
			contentHTML += "</table>" + "</div>" + "<br/>" + "<div>"
					+ "<a href='javascript:customGismap.openWindow(\""
					+ actionURL + "\");' style=\"color:black;\">详细信息</a>"
					+ "</div>" + "</div>";
		}
		var popup = new SuperMap.Popup.FramedCloud("popwin",
				new SuperMap.LonLat(lonlat.lon, lonlat.lat), null, contentHTML,
				null, true);
		this.infowin = popup;
		this.map.addPopup(popup);
	}
	/**
	 * 关闭弹出气泡
	 */
	CustomGismap.prototype.closeInfoWin = function() {
		if (this.infowin) {
			try {
				this.infowin.hide();
				this.infowin.destroy();
			} catch (e) {

			}
		}
	};
	/**
	 * 打开详细信息页面
	 */
	CustomGismap.prototype.openWindow = function(url) {
		if (null != url && "" != url) {
			window.open(url, "",
					"width=600, height=400,resizable=yes, scrollbars=yes");
		} else {
			alert("敬请期待 ^_^");
		}
	};

	/**
	 * 清除地图渲染图层
	 */
	CustomGismap.prototype.clearMap = function() {

	}
	/**
	 * 地图全屏
	 */
	CustomGismap.prototype.viewEntire = function() {
		this.map.zoomToMaxExtent(true);
	}
	/**
	 * 地图缩小
	 */
	CustomGismap.prototype.zoomIn = function() {
		this.map.zoomIn();
	};
	/**
	 * 地图放大
	 */
	CustomGismap.prototype.zoomOut = function() {
		this.map.zoomOut();
	};
}