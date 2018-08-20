package me.fb.smart.dal.dialect.pagination;

/**
 * sql分页限制处理
 *@author fb
 *@version 
 *@since 2015年8月18日
 */
public interface LimitHandler {
	
	/**
	 * sql 处理
	 * @param sql
	 * @param firstRow,offset 起始行数,从0开始
	 * @param maxRows 页大小
	 * @return
	 */
	String processSql(String sql,int firstRow,int maxRows);
	
	/**
	 * 将sql语句转化为计算总数语句
	 * @param sql
	 * @return
	 */
	String countSql(String sql);
}
