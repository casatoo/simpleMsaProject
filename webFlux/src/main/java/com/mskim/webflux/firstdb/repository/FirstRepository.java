package com.mskim.webflux.firstdb.repository;

import com.mskim.webflux.firstdb.entity.FirstEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface FirstRepository extends R2dbcRepository<FirstEntity, Integer> {
}
