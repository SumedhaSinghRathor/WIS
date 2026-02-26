package wis_backend.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import wis_backend.dto.lite_dto.ReadLiteDTO;

class UserReads {
    private Read read;
    private String status;
    private int rating;
    private int leftOff;
    
    public Read getRead() {
        return read;
    }
    public void setRead(Read read) {
        this.read = read;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getLeftOff() {
        return leftOff;
    }
    public void setLeftOff(int leftOff) {
        this.leftOff = leftOff;
    }
}

@Document(collection = "Users")
public class User {
    @Id
    private ObjectId id;
    @Indexed
    private String username;
    private String email;
    private String password;
    private ReadLiteDTO[] favorites = new ReadLiteDTO[4];
    private List<UserReads> readIds = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public ReadLiteDTO[] getFavorites() {
        return favorites;
    }
    public void setFavorites(ReadLiteDTO[] favorites) {
        this.favorites = favorites;
    }
    public List<UserReads> getReads() {
        return readIds;
    }
    public void setReads(List<UserReads> readIds) {
        this.readIds = readIds;
    }
}
