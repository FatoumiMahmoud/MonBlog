package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
