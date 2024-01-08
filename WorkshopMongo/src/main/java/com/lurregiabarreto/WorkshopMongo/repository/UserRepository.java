package com.lurregiabarreto.WorkshopMongo.repository;

import com.lurregiabarreto.WorkshopMongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
