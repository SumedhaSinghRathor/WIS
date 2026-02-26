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

import wis_backend.dto.AuthorResponseDTO;
import wis_backend.dto.lite_dto.ReadLiteDTO;
import wis_backend.model.Author;
import wis_backend.model.Read;
import wis_backend.repo.AuthorRepo;
import wis_backend.repo.ReadRepo;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthorController {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    ReadRepo readRepo;

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthor(@PathVariable ObjectId id) {
        Author author = authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        List<ReadLiteDTO> readDTOs = new ArrayList<>();

        if (author.getReads() != null && !author.getReads().isEmpty()) {
            List<Read> reads = readRepo.findAllById(author.getReads());

            readDTOs = reads.stream().map(r -> {
                ReadLiteDTO dto = new ReadLiteDTO();
                dto.setId(r.getId());
                dto.setTitle(r.getTitle());
                dto.setGenres(r.getGenres());
                return dto;
            }).toList();
        }

        AuthorResponseDTO response = new AuthorResponseDTO();
        response.setId(author.getId());
        response.setName(author.getName());
        response.setImgLink(author.getImgLink());
        response.setReads(readDTOs);

        return ResponseEntity.ok(response);
    }
}
