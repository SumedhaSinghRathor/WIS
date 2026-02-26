package wis_backend.dto;

import java.util.List;

public class ReadRequestDTO {

    private String title;
    private String demographic;
    private List<String> genres;
    private boolean hasAnime;
    private String imgLink;

    private String authorName;
    private List<String> magazineTitles;
    
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
    public String getImgLink() {
        return imgLink;
    }
    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public List<String> getMagazineTitles() {
        return magazineTitles;
    }
    public void setMagazineTitles(List<String> magazineTitles) {
        this.magazineTitles = magazineTitles;
    }

}
