package com.fynd.events.service;

import java.util.List;

import com.fynd.events.event.Event;

public interface EventHandlingService {

	public Event insertEvent(Event event);

	public Event getEventByEventName(String eventName);

	public List<Event> getAllEvents();

	public List<Event> insertEventList(List<Event> eventList);
	
	public Event convertEventByType(String eventName);
	
}
