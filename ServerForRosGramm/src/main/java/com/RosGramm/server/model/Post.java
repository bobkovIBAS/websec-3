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
@Document(collection = "_post")
public class Post {

    @BsonProperty("_id")
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String encodedPhoto;
    private String label;
    private String idUser;
    private Integer counterLike;

    public Post(String encodedPhoto, String label, String idUser, Integer counterLike) {
        this.encodedPhoto = encodedPhoto;
        this.label = label;
        this.idUser = idUser;
        this.counterLike = counterLike;
    }

    public Post(String encodedPhoto, String label, String idUser) {
        this.encodedPhoto = encodedPhoto;
        this.idUser = idUser;
        this.label = label;
    }
}