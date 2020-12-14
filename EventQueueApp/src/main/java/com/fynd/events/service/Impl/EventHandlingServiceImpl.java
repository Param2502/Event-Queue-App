package com.fynd.events.service.Impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fynd.events.Dao.EventDAO;
import com.fynd.events.event.Event;
import com.fynd.events.queueConfig.QueueDB;
import com.fynd.events.service.EventHandlingService;
import com.fynd.events.utility.EventUtility;

@Service
public class EventHandlingServiceImpl implements EventHandlingService {

	@Autowired
	EventDAO eventDAO;

	@Override
	public Event insertEvent(Event event) {
		boolean isEventNameValid = EventUtility.isEventNamePresent(event.getEventName());

		if (isEventNameValid) {
			Event eventData = eventDAO.addEvent(event);
			if (eventData != null)
				return eventData;
		}
		return null;
	}

	@Override
	public Event getEventByEventName(String eventName) {
		return eventDAO.getEventByEventName(eventName);
	}

	@Override
	public List<Event> insertEventList(List<Event> eventList) {
		if (eventList.size() > 0) {
			Iterator<Event> itr = eventList.iterator();
			while (itr.hasNext()) {
				Event event = (Event) itr.next();
				boolean isEventNameValid = EventUtility.isEventNamePresent(event.getEventName());
				if (!isEventNameValid) {
					return null;
				}
			}
			List<Event> events = eventDAO.addEventList(eventList);
			if (events != null)
				return events;
		}
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventDAO.getAllEvents();
	}

	@Override
	public Event convertEventByType(String eventName) {
		Event event = eventDAO.getEventByEventName(eventName);
		if (event != null) {
			switch (eventName) {
			case "INTEGER":
				int intVal = Integer.parseInt(event.getEventValue());
				QueueDB.integerQueue.add(intVal);
				return event;

			case "FLOAT":
				float floatVal = Float.parseFloat(event.getEventValue());
				QueueDB.floatQueue.add(floatVal);
				return event;

			case "DOUBLE":
				double doubleVal = Double.parseDouble(event.getEventValue());
				QueueDB.doubleQueue.add(doubleVal);
				return event;

			case "LONG":
				long longVal = Long.parseLong(event.getEventValue());
				QueueDB.longQueue.add(longVal);
				return event;

			case "CHARACTER":
				char charVal = event.getEventValue().charAt(0);
				QueueDB.charQueue.add(charVal);
				return event;
			}
		}
		return null;
	}

}
