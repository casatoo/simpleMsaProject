package com.mskim.webfluxmongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "table1")
@Data
public class Table1Collection {

    @Id
    private String _id;
    private String name;
}
