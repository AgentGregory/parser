package ru.agentgregory.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.model.User;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByUserAndUrl(User user, String url);

    List<Article> getAllByUser(User user);

    List<Article> getAllByPublishDate(Instant date);
}
