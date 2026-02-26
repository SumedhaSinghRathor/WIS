package wis_backend.repo;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import wis_backend.model.Magazine;

public interface MagazineRepo extends MongoRepository<Magazine, ObjectId> {
    Optional<Magazine> findByMagazineTitle(String magazineTitle);
}
