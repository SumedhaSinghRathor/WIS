package wis_backend.repo;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import wis_backend.model.Read;

public interface ReadRepo extends MongoRepository<Read, ObjectId> {
    @Query("{ 'genres': { $all: ?0 } }")
    public List<Read> findByGenresAll(List<String> genres);
}
