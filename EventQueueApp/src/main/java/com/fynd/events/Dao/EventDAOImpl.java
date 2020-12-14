package com.fynd.events.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fynd.events.event.Event;
import com.fynd.events.queueConfig.QueueDB;
import com.fynd.events.utility.EventUtility;

public class EventDAOImpl implements EventDAO {

	@Override
	public Event addEvent(Event event) {
		boolean eventData = QueueDB.myQueue.add(event);
		if (eventData)
			return event;
		else
			return null;
	}

	@Override
	public Event getEventByEventName(String eventName) {
		if (EventUtility.isEventNamePresent(eventName)) {
			Iterator<Event> itr = QueueDB.myQueue.iterator();
			while (itr.hasNext()) {
				Event eventElement = QueueDB.myQueue.peek();
				boolean key = eventElement.getEventName().equals(eventName);
				if (key)
					return eventElement;
				break;
			}
			return null;
		}
		return null;

	}

	@Override
	public List<Event> getAllEvents() {
		List<Event> eventList = new ArrayList<>();
		Iterator<Event> iterator = QueueDB.myQueue.iterator();
		while (iterator.hasNext()) {
			eventList.add(iterator.next());
		}
		return eventList;
	}

	@Override
	public List<Event> addEventList(List<Event> eventList) {
		Iterator<Event> iterator = eventList.iterator();
		while (iterator.hasNext()) {
			QueueDB.myQueue.add(iterator.next());
		}
		return eventList;
	}

}
