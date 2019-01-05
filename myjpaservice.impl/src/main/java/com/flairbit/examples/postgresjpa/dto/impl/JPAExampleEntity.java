package com.flairbit.examples.postgresjpa.dto.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.flairbit.examples.postgresjpa.dto.api.ExampleEntityApi;

@Entity(name = "ExampleEntity")
public class JPAExampleEntity extends ExampleEntityApi {
	
	public JPAExampleEntity(String value) {
		super(value);
		this.value = value;
	}
	
	public JPAExampleEntity() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Override
	public long getId() {
		return super.getId();
	}

	@Override
	public void setId(long id) {
		super.setId(id);
	}
	
	@Column(name = "value")
	@Override
	public String getValue() {
		return super.getValue();
	}
	
	@Override
	public void setValue(String value) {
		super.setValue(value);
	}
}
