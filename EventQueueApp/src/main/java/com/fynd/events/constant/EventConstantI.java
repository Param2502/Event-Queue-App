package com.fynd.events.constant;

public interface EventConstantI {

	String EVENT_ROOT_END_POINT = "/eventController";

	String GET_EVENT_BY_NAME = EVENT_ROOT_END_POINT + "/get-event-by-event-name";
	
	String ADD_EVENT = EVENT_ROOT_END_POINT + "/add-event";
	
	String CONVERT_EVENT_BY_TYPE = EVENT_ROOT_END_POINT + "/convert-events-by-type";
	
	String EVENT_LIST_ROOT_END_POINT = "/eventListController";

	String GET_ALL_EVENTS = EVENT_LIST_ROOT_END_POINT + "/get-events";
	
	String ADD_EVENT_LIST = EVENT_LIST_ROOT_END_POINT + "/add-event-list";

	String CONVERT_ALL_EVENTS_BY_TYPE = EVENT_LIST_ROOT_END_POINT + "/convert-events-by-type";

}
