package com.mskim.singlemongodb.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Data
public class User {

    @Id
    private String _id;

    private String data;
}
