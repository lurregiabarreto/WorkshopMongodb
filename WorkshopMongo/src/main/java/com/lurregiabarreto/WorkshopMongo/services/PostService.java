package com.lurregiabarreto.WorkshopMongo.services;

import com.lurregiabarreto.WorkshopMongo.domain.Post;
import com.lurregiabarreto.WorkshopMongo.repository.PostRepository;
import com.lurregiabarreto.WorkshopMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
