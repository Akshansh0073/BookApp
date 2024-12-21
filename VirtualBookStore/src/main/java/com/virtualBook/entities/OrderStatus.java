package com.virtualBook.entities;

import java.util.Arrays;

public enum OrderStatus {

	PENDING,DELIVERED,CANCELLED,UPDATE;
	
	 public static String[] valuesAsString() {
        return Arrays.stream(values()).map(Enum::name).toArray(String[]::new);
    }
}
