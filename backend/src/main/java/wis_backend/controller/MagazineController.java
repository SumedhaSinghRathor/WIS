package wis_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import wis_backend.dto.MagazineResponseDTO;
import wis_backend.dto.lite_dto.AuthorLiteDTO;
import wis_backend.dto.lite_dto.ReadLiteDTO;
import wis_backend.model.Magazine;
import wis_backend.model.Read;
import wis_backend.repo.AuthorRepo;
import wis_backend.repo.MagazineRepo;
import wis_backend.repo.ReadRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MagazineController {
    @Autowired
    MagazineRepo magazineRepo;
    @Autowired
    ReadRepo readRepo;
    @Autowired
    AuthorRepo authorRepo;

    @GetMapping("/magazines")
    public List<Magazine> getAllMagazines() {
        return magazineRepo.findAll();
    }

    @GetMapping("/magazines/{id}")
    public ResponseEntity<MagazineResponseDTO> getMagazine(@PathVariable ObjectId id) {
        Magazine magazine = magazineRepo.findById(id).orElseThrow(() -> new RuntimeException("Magazine not found"));

        List<ReadLiteDTO> readDTOs = new ArrayList<>();

        if (magazine.getReads() != null && !magazine.getReads().isEmpty()) {
            List<Read> reads = readRepo.findAllById(magazine.getReads());

            readDTOs = reads.stream().map(r -> {
                ReadLiteDTO dto = new ReadLiteDTO();
                dto.setId(r.getId());
                dto.setTitle(r.getTitle());
                dto.setGenres(r.getGenres());

                if (r.getAuthor() != null) {
                    authorRepo.findById(r.getAuthor()).ifPresent(author -> {
                        AuthorLiteDTO authorLite = new AuthorLiteDTO();
                        authorLite.setId(author.getId());
                        authorLite.setName(author.getName());

                        dto.setAuthorDto(authorLite);
                    });
                }

                return dto;
            }).toList();
        }

        MagazineResponseDTO response = new MagazineResponseDTO();
        response.setId(magazine.getId());
        response.setMagazineTitle(magazine.getMagazineTitle());
        response.setCover(magazine.getCover());
        response.setReads(readDTOs);
        response.setFirstIssue(magazine.getFirstIssue());
        response.setFinalIssue(magazine.getFinalIssue());

        return ResponseEntity.ok(response);
    }
}
