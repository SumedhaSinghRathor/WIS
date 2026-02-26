package wis_backend.dto;

import java.util.List;

import org.bson.types.ObjectId;

import wis_backend.dto.lite_dto.AuthorLiteDTO;
import wis_backend.dto.lite_dto.MagazineLiteDTO;

public class ReadResponseDTO {
    private ObjectId id;
    private String title;
    private String demographic;
    private String imgLink;
    private AuthorLiteDTO author;
    private List<String> genres;
    private boolean hasAnime;
    private List<MagazineLiteDTO> magazines;
    
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
    public String getDemographic() {
        return demographic;
    }
    public void setDemographic(String demographic) {
        this.demographic = demographic;
    }
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    public AuthorLiteDTO getAuthor() {
        return author;
    }
    public void setAuthor(AuthorLiteDTO author) {
        this.author = author;
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
    public List<MagazineLiteDTO> getMagazines() {
        return magazines;
    }
    public void setMagazines(List<MagazineLiteDTO> magazines) {
        this.magazines = magazines;
    }
}
