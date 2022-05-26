package ru.agentgregory.parser.web.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.service.util.ArticleService;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article") //localhost:8000
public class Controller {

    private final ArticleService articleService;

    private final ObjectMapper objectMapper;

    @GetMapping("/new")
    public List<Article> getNewArticle() { //localhost:8000/article/new
        return articleService.getNew();
    }

    @GetMapping("/user?user={userId}")
    public List<Article> getArticlesByUsers(@RequestParam Long userId) { //localhost:8000/article/user?userId = 2
        return List.of();
    }

    @PostMapping("/date")
    public List<Article> gerArticlesByDate(@RequestBody Instant date) {
        return List.of();
    }

    @GetMapping(value = "/new/file", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public byte[] getNewArticlesAsFile() {
        List<Article> articleList = articleService.getNew();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] bytes = objectMapper.writeValueAsBytes(articleList);
            byteArrayOutputStream.writeBytes(bytes);
            return byteArrayOutputStream.toByteArray();

        } catch (IOException e) {
            return new byte[0];
        }
    }
    @PostMapping("/write/file")
    public void writeArticles(@RequestBody byte[] bytes) throws IOException {
        String s = new String(bytes, StandardCharsets.UTF_8);
        String decode = URLDecoder.decode(s, StandardCharsets.UTF_8);
        List<Article> articles = objectMapper.readValue(decode, new TypeReference<List<Article>>() {});
        for (Article article : articles){
            System.out.println(article.getTitle());
        }
    }
}
