package wis_backend.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import wis_backend.model.Author;

public interface AuthorRepo extends MongoRepository<Author, ObjectId> {
    Optional<Author> findByName(String name);
}
