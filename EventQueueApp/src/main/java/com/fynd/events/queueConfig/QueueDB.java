package com.fynd.events.queueConfig;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.springframework.stereotype.Component;

import com.fynd.events.event.Event;

@Component
public class QueueDB {

	public static Queue<Event> myQueue = new PriorityQueue<>();

	public static Queue<Integer> integerQueue = new LinkedList<>();

	public static Queue<Float> floatQueue = new LinkedList<>();

	public static Queue<Double> doubleQueue = new LinkedList<>();

	public static Queue<Long> longQueue = new LinkedList<>();

	public static Queue<Character> charQueue = new LinkedList<>();

}
