package com.topcoder.trainmanager.util;

import com.topcoder.trainmanager.model.TrainFields;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.springframework.data.domain.Sort.Direction;
import static org.springframework.data.domain.Sort.Order;

public class SortOrder {
	
	public static List<Order> ConstructSortOrders(String sorts) {
		String[] sortTokens = sorts.split(",");
		List<Order> orders = new ArrayList<>();
		
		for (int i = 0; i < sortTokens.length; i += 2) {
			orders.add(new Order(Direction.fromString(sortTokens[i + 1].toUpperCase()), Objects.requireNonNull(TrainFields.fromJson(sortTokens[i])).name()));
		}
		
		return orders;
	}
}
