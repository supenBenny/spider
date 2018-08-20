package me.fb.smart.dal.search;

import java.util.List;

/**
 * @author fb
 * @param <T>
 */
public interface Pageable<T> {
	

	
	/** 每页默认的项数(10)。 */
	int DEFAULT_PAGE_SIZE = 15;
	
	/**不分页判断*/
	  int NO_PAGE = Integer.MAX_VALUE;
	
	/**
	 * 获取当前页码,从一开始
	 * @return
	 */
	Integer getCurrentPage();
	
	/**
	 * 分页大小,limit,rows
	 * @return
	 */
	Integer getPageSize();

	/**
	 * 分页大小
	 * @param pageSize
	 * @return
	 */
	Pageable<T> setPageSize(Integer pageSize);
	
	/**
	 * 起始记录数,从0开始,优先级高于currentPage
	 * @return
	 */
	Integer getOffset();

	/**
	 * 起始记录数,从0开始,优先级高于currentPage
	 * @param offset
	 * @return
	 */
	Pageable<T> setOffset(Integer offset);
	
	/**
	 * 分页查询结果值
	 * @return
	 */
	List<T> getContent();
	
	/**
	 * 设置内容
	 * @param content
	 * @return
	 */
	Pageable<T> setContent(List<T> content);
	
	/**
	 * 是否计算总记录数
	 * @return
	 */
	Boolean isCalcTotal();
	
	/**
	 * 是否计算总页数
	 * @param isCalc
	 * @return
	 */
	Pageable<T> setCalcTotal(boolean isCalc);
	
	/**
	 * 获取总页数
	 * @return
	 */
	Integer getTotalPages();
	
	/**
	 * 获取总结果数
	 * @return
	 */
	Integer getTotalResults();
	
	/**
	 * 设置总记录
	 * @param total
	 * @return
	 */
	Pageable<T> setTotalResults(Integer total);
	
	




}
