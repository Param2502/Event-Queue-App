package com.fynd.events.controller;

import static com.fynd.events.constant.EventConstantI.ADD_EVENT;
import static com.fynd.events.constant.EventConstantI.CONVERT_EVENT_BY_TYPE;
import static com.fynd.events.constant.EventConstantI.EVENT_ROOT_END_POINT;
import static com.fynd.events.constant.EventConstantI.GET_EVENT_BY_NAME;

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
@RequestMapping(EVENT_ROOT_END_POINT)
public class EventController {

	@Autowired
	private EventHandlingService eventService;

	@GetMapping(path = GET_EVENT_BY_NAME)
	public ResponseEntity<Response> getEventByEventname(String eventName) {
		Response response = new Response();
		Event event = eventService.getEventByEventName(eventName);
		if (event != null) {
			response.setResponseData(event);
			response.setResponseMessage("Data fetched successfully..!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setResponseMessage("Data Not Available With The Provided Event Name..!!");
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(path = ADD_EVENT)
	public ResponseEntity<Response> addEvent(Event event) {
		Response response = new Response();
		Event eventData = eventService.insertEvent(event);
		if (eventData != null) {
			response.setResponseData(event);
			response.setResponseMessage("Event Added successfully..!!");
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		} else {
			response.setResponseMessage("Failed To Add Event, Event Name Not Valid..!!");
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path = CONVERT_EVENT_BY_TYPE)
	public ResponseEntity<Response> convertEventByType(String eventName) {
		Response response = new Response();
		Event event = eventService.convertEventByType(eventName);
		if (event != null) {
			response.setResponseData(event);
			response.setResponseMessage("Event converted successfully..!!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setResponseMessage("The provided Event name not exist..!!");
			return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
	}

}
