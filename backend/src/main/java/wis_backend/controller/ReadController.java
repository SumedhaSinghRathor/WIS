package wis_backend.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wis_backend.dto.ReadRequestDTO;
import wis_backend.dto.ReadResponseDTO;
import wis_backend.dto.lite_dto.AuthorLiteDTO;
import wis_backend.dto.lite_dto.MagazineLiteDTO;
import wis_backend.model.Author;
import wis_backend.model.Magazine;
import wis_backend.model.Read;
import wis_backend.repo.AuthorRepo;
import wis_backend.repo.MagazineRepo;
import wis_backend.repo.ReadRepo;
import wis_backend.service.ReadService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ReadController {
    @Autowired
    ReadRepo readRepo;
    @Autowired
    MagazineRepo magazineRepo;
    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    private ReadService readService;

    @GetMapping("/")
    public String main() {
        return "<h1>What Is Shoujo? backend</h1>";
    }

    @GetMapping("/reads")
    public List<Read> getAllReads() {
        return readRepo.findAll();
    }

    @GetMapping("/reads/{id}")
    public ResponseEntity<ReadResponseDTO> getRead(@PathVariable ObjectId id) {
        Read read = readRepo.findById(id).orElseThrow(() -> new RuntimeException("Read not found"));

        Author author = authorRepo.findById(read.getAuthor()).orElseThrow(() -> new RuntimeException("Author not found"));

        AuthorLiteDTO authorDTO = new AuthorLiteDTO();
        authorDTO.setId(author.getId());
        authorDTO.setName(author.getName());

        List<MagazineLiteDTO> magazineDTOs = new ArrayList<>();

        if (read.getMagazine() != null && !read.getMagazine().isEmpty()) {
            List<Magazine> magazines = magazineRepo.findAllById(read.getMagazine());

            magazineDTOs = magazines.stream().map(m -> {
                MagazineLiteDTO dto = new MagazineLiteDTO();
                dto.setId(m.getId());
                dto.setMagazineTitle(m.getMagazineTitle());
                return dto;
            }).toList();
        }

        ReadResponseDTO response = new ReadResponseDTO();
        response.setId(read.getId());
        response.setTitle(read.getTitle());
        response.setDemographic(read.getDemographic());
        response.setGenres(read.getGenres());
        response.setAuthor(authorDTO);
        response.setMagazines(magazineDTOs);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/reads")
    public ResponseEntity<List<Read>> createRead(@RequestBody List<ReadRequestDTO> requests) {
        List<Read> savedReads = new ArrayList<>();

        for (ReadRequestDTO request : requests) {
            Read read = new Read();
            read.setTitle(request.getTitle());
            read.setDemographic(request.getDemographic());
            read.setGenres(request.getGenres());
            read.setHasAnime(request.isHasAnime());
            read.setImgLink(request.getImgLink());

            Read saved = readService.createRead(read, request.getAuthorName(), request.getMagazineTitles());

            savedReads.add(saved);
        }

        return ResponseEntity.ok(savedReads);
    }

    @GetMapping("/reads/filter")
    public List<Read> filterRead(@RequestParam List<String> genres) {
        return readRepo.findByGenresAll(genres);
    }
}
