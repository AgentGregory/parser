package ru.agentgregory.parser.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.agentgregory.parser.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
