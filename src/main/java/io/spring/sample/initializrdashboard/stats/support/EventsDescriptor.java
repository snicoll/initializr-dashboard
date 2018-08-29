package io.spring.sample.initializrdashboard.stats.support;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventsDescriptor {

	private final List<Event> events;

	@JsonCreator
	EventsDescriptor(@JsonProperty("events") List<Event> events) {
		this.events = events;
	}

	public List<Event> getEvents() {
		return this.events;
	}

}
