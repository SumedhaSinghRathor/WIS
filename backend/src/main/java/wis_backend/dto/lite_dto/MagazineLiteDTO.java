package wis_backend.dto.lite_dto;

import org.bson.types.ObjectId;

public class MagazineLiteDTO {
    private ObjectId id;
    private String magazineTitle;
    
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getMagazineTitle() {
        return magazineTitle;
    }
    public void setMagazineTitle(String magazineTitle) {
        this.magazineTitle = magazineTitle;
    }
}
