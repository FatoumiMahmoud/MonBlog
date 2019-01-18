package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer> {
}
