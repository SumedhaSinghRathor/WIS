package wis_backend.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Reads")
public class Read {
    @Id
    private ObjectId id;
    private String title;
    private String demographic;
    private String imgLink;
    private ObjectId author;
    private List<String> genres;
    private boolean hasAnime;
    @Field("magazine")
    private List<ObjectId> magazineIds;
    
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ObjectId getAuthor() {
        return author;
    }
    public void setAuthor(ObjectId author) {
        this.author = author;
    }
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    public String getDemographic() {
        return demographic;
    }
    public void setDemographic(String demographic) {
        this.demographic = demographic;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public boolean isHasAnime() {
        return hasAnime;
    }
    public void setHasAnime(boolean hasAnime) {
        this.hasAnime = hasAnime;
    }
    public List<ObjectId> getMagazine() {
        return magazineIds;
    }
    public void setMagazine(List<ObjectId> magazineIds) {
        this.magazineIds = magazineIds;
    }
}
