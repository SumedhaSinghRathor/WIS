package wis_backend.dto.lite_dto;

import java.util.List;

import org.bson.types.ObjectId;

public class ReadLiteDTO {
    private ObjectId id;
    private String title;
    private List<String> genres;
    private AuthorLiteDTO author;

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
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public AuthorLiteDTO getAuthorDto() {
        return author;
    }
    public void setAuthorDto(AuthorLiteDTO authorDto) {
        this.author = authorDto;
    }
}
