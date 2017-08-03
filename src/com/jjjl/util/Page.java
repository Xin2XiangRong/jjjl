package com.jjjl.util;

public class Page {
	
	/** 每页的数量 */
	private int everyPage;

	/** 总页数 */
	
	private int totalPage;

	/** 当前页 */
	private int currentPage;

	/** 起始点 */	
	
	private int beginIndex;

	/** 总记录数 */
	private int totalCount;

	/**
	 * @return totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount
	 *            要设置的 totalCount
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getBeginIndex() {
		return (getCurrentPage() - 1) * getEveryPage();
	}

	/**
	 * @param beginIndex
	 *            The beginIndex to set.
	 */
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	/**
	 * @return Returns the currentPage.
	 */
	public int getCurrentPage() {
		return currentPage == 0 ? 1 : currentPage;
	}

	/**
	 * @param currentPage
	 *            The currentPage to set.
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return Returns the everyPage.
	 */
	public int getEveryPage() {
		return everyPage == 0 ? 10 : everyPage;
	}

	/**
	 * @param everyPage
	 *            The everyPage to set.
	 */
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}

	
	/**
	 * @return Returns the totalPage.
	 * 
	 */
	public int getTotalPage() {
		int totalPage = 1; 
		if(getTotalCount()>everyPage){
		if (getTotalCount() % everyPage == 0)
			totalPage = getTotalCount() / everyPage;
		else
			totalPage = getTotalCount() / everyPage + 1;
		}
		return totalPage;
	}

	/**
	 * @param totalPage
	 *            The totalPage to set.
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


    @Override
    public String toString() {
        return "Page{" +
                "everyPage=" + everyPage +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", beginIndex=" + beginIndex +
                ", totalCount=" + totalCount +
                '}';
    }
}
