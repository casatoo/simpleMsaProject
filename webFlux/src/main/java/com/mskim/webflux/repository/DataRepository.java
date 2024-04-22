package com.mskim.webflux.repository;

import com.mskim.webflux.entity.DataEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface DataRepository extends R2dbcRepository<DataEntity, Integer> {
}
