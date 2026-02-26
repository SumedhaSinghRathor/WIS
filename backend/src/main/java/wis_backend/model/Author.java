package wis_backend.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Authors")
public class Author {
    @Id
    private ObjectId id;
    private String name;
    private List<ObjectId> readIds;
    private String imgLink;

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
    public List<ObjectId> getReads() {
        return readIds;
    }
    public void setReads(List<ObjectId> readIds) {
        this.readIds = readIds;
    }
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
