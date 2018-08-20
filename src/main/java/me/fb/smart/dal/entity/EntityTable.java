package me.fb.smart.dal.entity;

import java.util.List;
import java.util.Map;

/**
 * 实体表映射,java类和表映射关系
 * @author fb
 *
 */
public class EntityTable {
	
	/**
	 * 表名称
	 */
	private String tableName = null;
	
	/**
	 * 类 名称,简称
	 */
	private String clsName = null;
	
	/**
	 * 所有属性,包含不需要存储至数据库的类
	 * k:属性名不区分大小写
	 * v:类属性表列
	 */
	private Map<String,FieldColumn> fields;
	
	/**
	 * 需要保存至数据库中的列和数据库一一对应
	 */
	private List<FieldColumn> tableColumns;
	
	/**
	 * 主键,单一主键
	 */
	private FieldColumn identifier;
	
	/**
	 * 关联class名称
	 */
	private final Class<?> clazz;
	

	public EntityTable(Class<?> clazz) {
		this.clazz = clazz;
	}
	
	public static EntityTableBuilder newBuilder(Class<?> clazz) {
		return EntityTableBuilder.newBuilder(clazz);
	}
	
}
class EntityTableBuilder {
	
    private final Class<?> clazz;
	
    
    public EntityTableBuilder(Class<?> clazz) {
    	this.clazz = clazz;
    }
    
	public static EntityTableBuilder newBuilder(Class<?> clazz) {
		return new EntityTableBuilder(clazz);
	}
	
	public EntityTable build() {
		
		return null;
	}

}