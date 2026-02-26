package wis_backend.dto.lite_dto;

import org.bson.types.ObjectId;

public class AuthorLiteDTO {
    private ObjectId id;
    private String name;
    
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
