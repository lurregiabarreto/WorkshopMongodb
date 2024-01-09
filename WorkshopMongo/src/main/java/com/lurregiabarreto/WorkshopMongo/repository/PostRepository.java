package com.lurregiabarreto.WorkshopMongo.repository;

import com.lurregiabarreto.WorkshopMongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
