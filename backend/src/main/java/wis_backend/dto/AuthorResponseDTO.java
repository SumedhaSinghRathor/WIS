package wis_backend.dto;

import java.util.List;

import org.bson.types.ObjectId;

import wis_backend.dto.lite_dto.ReadLiteDTO;

public class AuthorResponseDTO {
    private ObjectId id;
    private String name;
    private String imgLink;
    private List<ReadLiteDTO> reads;
    
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
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    public List<ReadLiteDTO> getReads() {
        return reads;
    }
    public void setReads(List<ReadLiteDTO> reads) {
        this.reads = reads;
    }
}
