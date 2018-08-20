package me.fb.smart.dal.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * 排序，参考{ org.springframework.data.domain.Sort}
 *@author fb
 *@version 
 *@since 2015年8月12日
 */
public class Sort implements Iterable<Sort.Order>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616747979727580417L;

	public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final List<Order> orders;

    public Sort(Order... orders) {
        this(Arrays.asList(orders));
    }

    public Sort(List<Order> orders) {

        if (null == orders || orders.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }

        this.orders = orders;
    }

    /**
     * Creates a new {@link Sort} instance. Order defaults to { Direction#ASC}.
     * 
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings
     */
    public Sort(String... properties) {
        this(DEFAULT_DIRECTION, properties);
    }

    /**
     * Creates a new {@link Sort} instance.
     * 
     * @param direction defaults to {@linke Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null}, empty or contain {@literal null} or empty strings.
     */
    public Sort(Direction direction, String... properties) {
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    /**
     * Creates a new {@link Sort} instance.
     * 
     * @param direction defaults to {@linke Sort#DEFAULT_DIRECTION} (for {@literal null} cases, too)
     * @param properties must not be {@literal null} or contain {@literal null} or empty strings.
     */
    public Sort(Direction direction, List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<Order>(properties.size());

        for (String property : properties) {
            this.orders.add(new Order(property, direction));
        }
    }

    /**
     * Returns a new {@link Sort} consisting of the {@link Order}s of the current {@link Sort} combined with the given
     * ones.
     * 
     * @param sort can be {@literal null}.
     * @return
     */
    public Sort and(Sort sort) {

        if (sort == null) {
            return this;
        }

        ArrayList<Order> these = new ArrayList<Order>(this.orders);

        for (Order order : sort) {
            these.add(order);
        }

        return new Sort(these);
    }

    /**
     * Returns the order registered for the given property.
     * 
     * @param property
     * @return
     */
    public Order getOrderFor(String property) {

        for (Order order : this) {
            if (order.getProperty().equals(property)) {
                return order;
            }
        }

        return null;
    }

    /**
     * 添加一个排序
     * @param order
     * @return
     */
    public Sort addOrder(Order order){
    	if(order != null){
        	this.orders.add(order);
    	}
    	return this;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<Order> iterator() {
        return this.orders.iterator();
    }
    
    public List<Order> getOrders(){
    	return this.orders;
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Sort)) {
            return false;
        }

        Sort that = (Sort) obj;

        return this.orders.equals(that.orders);
    }

    /**
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;
        result = 31 * result + orders.hashCode();
        return result;
    }


    /**
     *
     */
   public static enum Direction {
        /**
         * 正序,从小到大
         */
        ASC,
        /**
         * 倒序,从大到小
         */
        DESC;

        /**
         * Returns the {@link Direction} enum for the given {@link String} value.
         * 
         * @param value
         * @throws IllegalArgumentException in case the given value cannot be parsed into an enum value.
         * @return
         */
        public static Direction fromString(String value) {

            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format(
                        "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).",
                        value), e);
            }
        }

        /**
         * Returns the {@link Direction} enum for the given {@link String} or null if it cannot be parsed into an enum
         * value.
         * 
         * @param value
         * @return
         */
        public static Direction fromStringOrNull(String value) {

            try {
                return fromString(value);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    /**
     * 排序
     */
    public static class Order implements Serializable {
        /**	
         * Member Description
         */

        private static final long serialVersionUID = 1L;

        private final Direction direction;

        private String property;

        // private final boolean ignoreCase;

        Order(String property, Direction direction) {
            this.property = property;
            this.direction = direction;
        }

        /**
         * 从小到大
         * @param property
         * @return
         */
        public static Order asc(String property) {
            return new Order(property, Direction.ASC);
        }

        /**
         * 倒序
         * @param property
         * @return
         */
        public static Order desc(String property) {
            return new Order(property, Direction.DESC);
        }

        public Direction getDirection() {
            return direction;
        }

        public String getProperty() {
            return property;
        }

		public void setProperty(String property) {
			this.property = property;
		}
        
        
    }
}

