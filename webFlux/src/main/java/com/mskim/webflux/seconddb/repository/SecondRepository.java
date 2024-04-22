package com.mskim.webflux.seconddb.repository;

import com.mskim.webflux.seconddb.entity.SecondEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface SecondRepository extends R2dbcRepository<SecondEntity, Integer> {
}
