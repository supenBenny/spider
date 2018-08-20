package me.fb.smart.dal.entity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import jdk.internal.reflect.MethodAccessor;
import jdk.internal.reflect.ReflectionFactory;

/**
 * ，java
 * @author xfb
 *
 */

public class FieldColumn {
	
	/**
	 * 表 列名
	 */
	private String columnName = null;
	
	/**
	 * 类，属性名
	 */
	private String fieldName = null;
	
	/**
	 * 是否属于数据库字段，同transient
	 * true 不会保存到数据库
	 */
	private Boolean temporary;
	
	/**
	 * 类型
	 */
	private Type clsType;
	
	private List<Annotation> annotations;
	
	public Object get(Object obj) {
	//	this.getClass().getDeclaredFields()[0].getu
		MethodAccessor newMethodAccessor = ReflectionFactory.getReflectionFactory().newMethodAccessor(this.getClass().getMethods()[0]);

		return null;
	}

	public Object set(Object obj) {
		return null;
	}
	
}
