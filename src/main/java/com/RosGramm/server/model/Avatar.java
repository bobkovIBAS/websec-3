package com.RosGramm.server.model;

import com.RosGramm.server.user.User;
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
@Document(collection = "_avatar")
public class Avatar {

    @BsonProperty("_id")
    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;
    private String encodedPhoto;
    private String idUser;

    public Avatar(String encodedPhoto, String idUser) {
        this.encodedPhoto = encodedPhoto;
        this.idUser = idUser;
    }
}
