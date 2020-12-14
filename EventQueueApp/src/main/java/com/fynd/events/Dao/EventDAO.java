package com.fynd.events.Dao;

import java.util.List;

import com.fynd.events.event.Event;

public interface EventDAO {

	public Event addEvent(Event event);
	
	public Event getEventByEventName(String eventName);
	
	public List<Event> getAllEvents();
	
	public List<Event> addEventList(List<Event> eventList);
	
}
