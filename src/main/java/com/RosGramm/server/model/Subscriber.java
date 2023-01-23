package com.RosGramm.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "_subscriber")
public class Subscriber {

    @BsonProperty("_id")
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String idUser;
    private String subscriberId;

    public Subscriber(String idUser, String subscriberId) {
        this.idUser = idUser;
        this.subscriberId = subscriberId;
    }
}
