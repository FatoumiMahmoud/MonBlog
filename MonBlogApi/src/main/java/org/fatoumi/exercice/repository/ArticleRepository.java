package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
