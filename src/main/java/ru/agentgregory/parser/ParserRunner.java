package ru.agentgregory.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.service.loader.Loader;
import ru.agentgregory.parser.service.loader.exception.LoaderException;
import ru.agentgregory.parser.service.parser.HtmlParser;
import ru.agentgregory.parser.service.storage.ApplicationStorage;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ParserRunner implements CommandLineRunner {

    private final Loader loader;
    private final HtmlParser parser;
    private final ApplicationStorage storage;

    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";

    public static void main(String[] args) {
        SpringApplication.run(ParserRunner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            String response = loader.load(HABR_URL);
            List<Article> articles = parser.parse(response);
            storage.saveData(articles);
        } catch (LoaderException e) {
            e.printStackTrace();
        }

    }
}
