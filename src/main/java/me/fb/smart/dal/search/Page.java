package me.fb.smart.dal.search;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author fb
 * @version
 * @since 2015年8月12日
 */
public class Page<T> implements Pageable<T>, Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7225054428640116730L;

	private int currentPage = 1;

	private int pageSize = Page.DEFAULT_PAGE_SIZE;

	/**
	 * 是否计算总数
	 */
	private boolean isCalcTotal = true;

	/**
	 * 总记录数
	 */
	private int totalResults = 0;

	private int offset = -1;
	
	@SuppressWarnings("unchecked")
	private List<T> content = Collections.EMPTY_LIST;

	@Override
	public Integer getCurrentPage() {
		return this.currentPage;
	}
	
	public Pageable<T> setCurrentPage(Integer currentPage) {
		if(currentPage > 0){
			this.currentPage = currentPage; 
		}
		return this;
	}

	public Pageable<T> setPage(int currentPage,int pageSize){
		
		return setPage(currentPage,pageSize,true);
	}
	
	public Pageable<T> setPage(int currentPage,int pageSize,boolean isCalcTotal){
		this.setCurrentPage(currentPage)
			.setPageSize(pageSize)
			.setCalcTotal(isCalcTotal);
		return this;
	}

	public Pageable<T> setLimit(int offset,int limit){
		return setLimit(offset,limit,false);
	}
	
	public Pageable<T> setLimit(int offset,int limit,boolean isCalcTotal){
		this.setOffset(offset)
		.setPageSize(limit)
		.setCalcTotal(isCalcTotal);
		return this;
	}

	@Override
	public Integer getPageSize() {
		return this.pageSize;
	}

	@Override
	public Pageable<T> setPageSize(Integer pageSize) {
        this.pageSize = (pageSize < 1 ? 1 : pageSize);
		return this;
	}

	@Override
	public Integer getOffset() {
	  return this.offset == -1 ? (this.currentPage - 1) * this.pageSize : this.offset;
	}

	@Override
	public Pageable<T> setOffset(Integer offset) {
		this.offset = (offset < 0 ? 0 : offset);
		return this;
	}

	@Override
	public List<T> getContent() {
		if(content==null){
			return Collections.emptyList();
		}
		return this.content;
	}

	@Override
	public Pageable<T> setContent(List<T> content) {
		this.content = content;
		return this;
	}


	@Override
	public Boolean isCalcTotal() {
		return this.isCalcTotal;
	}


	@Override
	public Pageable<T> setCalcTotal(boolean isCalc) {
		this.isCalcTotal = isCalc;
		return this;
	}

	@Override
	public Integer getTotalPages() {
		int r = this.totalResults % this.pageSize;

        if (r == 0) {
            return this.totalResults / this.pageSize;
        }
        return this.totalResults / this.pageSize + 1;
	}

	@Override
	public Integer getTotalResults() {
        return this.totalResults;
	}

	@Override
	public Pageable<T> setTotalResults(Integer total) {
		this.totalResults = total;
        return this;
	}
}
