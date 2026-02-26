package wis_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wis_backend.model.Author;
import wis_backend.model.Magazine;
import wis_backend.model.Read;
import wis_backend.repo.AuthorRepo;
import wis_backend.repo.MagazineRepo;
import wis_backend.repo.ReadRepo;

@Service
public class ReadService {

    @Autowired
    private ReadRepo readRepository;

    @Autowired
    private AuthorRepo authorRepository;

    @Autowired
    private MagazineRepo magazineRepository;

    public Read createRead(Read readRequest, String authorName, List<String> magazineTitles) {

        // ===== NULL SAFETY =====
        if (authorName == null || authorName.isBlank()) {
            throw new IllegalArgumentException("Author name is required");
        }

        if (magazineTitles == null) {
            magazineTitles = new ArrayList<>();
        }

        // ===== AUTHOR =====
        Author author = authorRepository.findByName(authorName)
                .orElseGet(() -> {
                    Author newAuthor = new Author();
                    newAuthor.setName(authorName);
                    newAuthor.setReads(new ArrayList<>());
                    return authorRepository.save(newAuthor);
                });

        readRequest.setAuthor(author.getId());

        // ===== MAGAZINES =====
        List<ObjectId> magazineIds = new ArrayList<>();
        List<Magazine> magazineDocs = new ArrayList<>();

        for (String title : magazineTitles) {

            if (title == null || title.isBlank()) continue;

            Magazine mag = magazineRepository.findByMagazineTitle(title)
                    .orElseGet(() -> {
                        Magazine newMag = new Magazine();
                        newMag.setMagazineTitle(title);
                        newMag.setReads(new ArrayList<>());
                        return magazineRepository.save(newMag);
                    });

            magazineIds.add(mag.getId());
            magazineDocs.add(mag);
        }

        readRequest.setMagazine(magazineIds);

        // ===== SAVE READ =====
        Read savedRead = readRepository.save(readRequest);

        // ===== UPDATE AUTHOR =====
        if (author.getReads() == null) {
            author.setReads(new ArrayList<>());
        }

        if (!author.getReads().contains(savedRead.getId())) {
            author.getReads().add(savedRead.getId());
            authorRepository.save(author);
        }

        // ===== UPDATE MAGAZINES =====
        for (Magazine mag : magazineDocs) {

            if (mag.getReads() == null) {
                mag.setReads(new ArrayList<>());
            }

            if (!mag.getReads().contains(savedRead.getId())) {
                mag.getReads().add(savedRead.getId());
                magazineRepository.save(mag);
            }
        }

        return savedRead;
    }
}
