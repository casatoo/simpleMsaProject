package com.mskim.webfluxmongodb.repository;

import com.mskim.webfluxmongodb.document.Table1Collection;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Table1Repository  extends ReactiveMongoRepository<Table1Collection,String> {
}
