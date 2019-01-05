package com.flairbit.examples.postgresjpa.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.osgi.service.component.annotations.Activate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flairbit.examples.postgresjpa.dto.api.ExampleEntityApi;
import com.flairbit.examples.postgresjpa.dao.api.ExampleEntityService;
import com.flairbit.examples.postgresjpa.dto.impl.JPAExampleEntity;

@Transactional
public class ExampleEntityServiceImpl implements ExampleEntityService {

	private final static Logger log = LoggerFactory.getLogger(ExampleEntityServiceImpl.class);
	
	@PersistenceContext(unitName = "myPersistenceUnit")
	private volatile EntityManager entityManager;
	
	public ExampleEntityServiceImpl() {
		super();
	}

	@Activate
	public void activate() {
		log.info("Persistence service is starting...");
	}

	public void deactivate() {}
	
	@Override
	@Transactional(TxType.SUPPORTS)
	public JPAExampleEntity getEntityById(long id) {
		JPAExampleEntity ExampleEntity =  entityManager.find(JPAExampleEntity.class, id);
		return ExampleEntity;
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
    public JPAExampleEntity addEntity(String value) {
		JPAExampleEntity ExampleEntity = new JPAExampleEntity(value);
		entityManager.persist(ExampleEntity);
		return ExampleEntity;
	}


	@Override
	@Transactional(TxType.REQUIRED)
	public void removeEntity(ExampleEntityApi e) {
		if (e != null) {
			entityManager.remove(e);
		}
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public ExampleEntityApi updateEntity(ExampleEntityApi e) {
		entityManager.merge(e);
		return getEntityById(e.getId());
	}
	
}
