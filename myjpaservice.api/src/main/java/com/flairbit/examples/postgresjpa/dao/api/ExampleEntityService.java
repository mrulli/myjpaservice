package com.flairbit.examples.postgresjpa.dao.api;

import com.flairbit.examples.postgresjpa.dto.api.ExampleEntityApi;

public interface ExampleEntityService {
	public ExampleEntityApi addEntity(String value);
	public ExampleEntityApi getEntityById(long id);
	public void removeEntity(ExampleEntityApi e);
	public ExampleEntityApi updateEntity(ExampleEntityApi e);
}
