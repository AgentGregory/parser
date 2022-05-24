package ru.agentgregory.parser.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.service.util.ArticleService;

import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article") //localhost:8000
public class Controller {

    private final ArticleService articleService;

    @GetMapping("/new")
    public List<Article> getNewArticle(){ //localhost:8000/article/new
        return articleService.getNew();
    }
    @GetMapping("/user?user={userId}")
    public List<Article> getArticlesByUsers(@RequestParam Long userId){ //localhost:8000/article/user?userId = 2
        return List.of();
    }

    @PostMapping ("/date")
    public List<Article> gerArticlesByDate( @RequestBody Instant date){
        return List.of();
    }
}
