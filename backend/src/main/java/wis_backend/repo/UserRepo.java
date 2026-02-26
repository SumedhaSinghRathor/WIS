package wis_backend.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import wis_backend.model.User;

public interface UserRepo extends MongoRepository<User, ObjectId> {

}
