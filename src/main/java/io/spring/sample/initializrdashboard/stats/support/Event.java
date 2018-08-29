package io.spring.sample.initializrdashboard.stats.support;

import java.time.LocalDate;

public class Event {

	private String name;

	private LocalDate date;

	private Type type;

	public Event(String name, LocalDate date, Type type) {
		this.name = name;
		this.date = date;
		this.type = type;
	}

	public Event() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {

		RELEASE;

		public int transformValue(int value) {
			return value;
		}

	}
}
