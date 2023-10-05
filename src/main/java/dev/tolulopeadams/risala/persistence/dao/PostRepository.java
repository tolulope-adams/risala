package dev.tolulopeadams.risala.persistence.dao;

import dev.tolulopeadams.risala.persistence.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Override
    List<Post> findAll();
}
