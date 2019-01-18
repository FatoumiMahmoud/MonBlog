package org.fatoumi.exercice.article.repository;

import org.fatoumi.exercice.article.Article2;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article2, Integer> {
}
