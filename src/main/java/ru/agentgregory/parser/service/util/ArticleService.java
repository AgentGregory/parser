package ru.agentgregory.parser.service.util;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.model.User;
import ru.agentgregory.parser.repository.ArticleRepository;
import ru.agentgregory.parser.repository.UserRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    public final ArticleRepository articleRepository;
    public final UserRepository userRepository;

    public List<Article> getNew() {
        Instant instant = Instant.now().minus(1, ChronoUnit.DAYS);
        return articleRepository.findAll().stream()
                .filter(article -> article
                        .getPublishDate()
                        .isAfter(instant)
                )
                .collect(Collectors.toList());
    }

    public List<Article> getByUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            return Collections.emptyList();
        return articleRepository.getAllByUser(user.get());
    }

    public List<Article> getByPublishDate(Instant date) {
        return articleRepository.getAllByPublishDate(date);
    }
}
