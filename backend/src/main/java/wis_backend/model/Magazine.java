package wis_backend.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Magazines")
public class Magazine {
    @Id
    private ObjectId id;
    private String magazineTitle;
    private String cover;
    @Field("reads")
    private List<ObjectId> readIds;
    private Integer firstIssue;
    private Integer finalIssue;
    
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
    public String getCover() {
        return cover;
    }
    public void setCover(String cover) {
        this.cover = cover;
    }
    public List<ObjectId> getReads() {
        return readIds;
    }
    public void setReads(List<ObjectId> readIds) {
        this.readIds = readIds;
    }
    public Integer getFirstIssue() {
        return firstIssue;
    }
    public void setFirstIssue(Integer firstIssue) {
        this.firstIssue = firstIssue;
    }
    public Integer getFinalIssue() {
        return finalIssue;
    }
    public void setFinalIssue(Integer finalIssue) {
        this.finalIssue = finalIssue;
    }
}
