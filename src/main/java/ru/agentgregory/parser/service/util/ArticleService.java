package ru.agentgregory.parser.service.util;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.repository.ArticleRepository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

public final ArticleRepository articleRepository;

public List<Article> getNew(){
    return articleRepository.findAll().stream()
            .filter(article -> article
                    .getPublishDate()
                    .isAfter(Instant.now().minus(1, ChronoUnit.DAYS))
            )
            .collect(Collectors.toList());
}
}
