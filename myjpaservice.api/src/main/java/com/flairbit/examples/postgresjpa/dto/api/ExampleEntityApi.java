package com.flairbit.examples.postgresjpa.dto.api;

public class ExampleEntityApi {
	
	protected long id;
	protected String value;
	
	public ExampleEntityApi() {
		super();
	}

	public ExampleEntityApi(String value) {
		super();
		this.value = value;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
