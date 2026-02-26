package wis_backend.dto;

import java.util.List;

import org.bson.types.ObjectId;

import wis_backend.dto.lite_dto.ReadLiteDTO;

public class MagazineResponseDTO {
    private ObjectId id;
    private String magazineTitle;
    private String cover;
    private List<ReadLiteDTO> reads;
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
    public List<ReadLiteDTO> getReads() {
        return reads;
    }
    public void setReads(List<ReadLiteDTO> reads) {
        this.reads = reads;
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
