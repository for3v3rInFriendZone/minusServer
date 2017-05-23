package com.minusServer.www.app.mapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import com.minusServer.www.app.model.AbstractBaseEntity;

@Component
public class ReferenceMapper {

	@PersistenceContext
	private EntityManager entityManager;

	public <T extends AbstractBaseEntity> T resolve(Long id, @TargetType Class<T> entityClass) {
		return id != null ? entityManager.find(entityClass, id) : null;
	}

	public Long toReference(AbstractBaseEntity entity) {
		return entity != null ? entity.getId() : null;
	}
	
}
