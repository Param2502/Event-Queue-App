package com.fynd.events.utility;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EventUtility {

	public static List<String> eventList = Arrays.asList("INTEGER", "FLOAT", "DOUBLE", "LONG", "CHARACTER");

	public static boolean isEventNamePresent(String eventName) {
		boolean bool = false;
		if (eventList.contains(eventName))
			bool = true;
		return bool;
	}

}
