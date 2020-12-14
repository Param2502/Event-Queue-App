package com.fynd.events.event;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Event {

	public String eventName;

	public String eventValue;

}
