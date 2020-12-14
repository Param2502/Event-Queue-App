package com.fynd.events.controller;

import static com.fynd.events.constant.EventConstantI.ADD_EVENT_LIST;
import static com.fynd.events.constant.EventConstantI.EVENT_LIST_ROOT_END_POINT;
import static com.fynd.events.constant.EventConstantI.GET_ALL_EVENTS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fynd.events.event.Event;
import com.fynd.events.response.Response;
import com.fynd.events.service.EventHandlingService;

@RestController
@RequestMapping(path = EVENT_LIST_ROOT_END_POINT)
public class EventListController {

	@Autowired
	private EventHandlingService eventService;

	@GetMapping(path = GET_ALL_EVENTS)
	public ResponseEntity<Response> getAllEvents() {
		Response response = new Response();
		List<Event> eventList = eventService.getAllEvents();
		if (eventList != null) {
			response.setResponseData(eventList);
			response.setResponseMessage("Data fetched successfully..!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setResponseMessage("No Event Available..!!");
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(path = ADD_EVENT_LIST)
	public ResponseEntity<Response> addEvent(List<Event> eventList) {
		Response response = new Response();
		List<Event> events = eventService.insertEventList(eventList);
		if (events != null) {
			response.setResponseData(events);
			response.setResponseMessage("Event List Added successfully..!!");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.setResponseMessage("Failed To Add Events, Event Name Not Valid..!!");
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
		}

	}

}
