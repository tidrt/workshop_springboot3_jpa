package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	/* 
	 * we have to control the code of every operation to prevent
	 * an future error
	*/
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);	
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code; 
	}
	
	// to make this enum public
	public int getCode() {
		return code;
	}
	
	// to convert an numeric value to a enum type
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value; 
			}	
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
