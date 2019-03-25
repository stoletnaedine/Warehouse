package com.stoletnaedine.model;

public class Session {

	private final Storage storage;

	private final String name;

	public Session(Storage storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	public Storage getStorage() {
		return storage;
	}

	public String getName() {
		return name;
	}
}
