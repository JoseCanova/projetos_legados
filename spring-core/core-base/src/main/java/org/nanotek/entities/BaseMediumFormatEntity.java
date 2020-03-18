package org.nanotek.entities;

import java.util.Optional;

import org.nanotek.BaseEntity;

public interface BaseMediumFormatEntity extends BaseEntity{

	@Override
	default Optional<BaseEntity> asOptional() {
		return BaseEntity.super.asOptional();
	}
}
