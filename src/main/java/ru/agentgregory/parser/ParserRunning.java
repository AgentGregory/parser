package ru.agentgregory.parser;

import ru.agentgregory.parser.loader.Loader;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.parser.HtmlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ParserRunning {

    public static final String HABR_DOMAIN = "https://habr.com";
    private static final String HABR_URL = HABR_DOMAIN + "/ru/all/";

    public static void main(String[] args) throws IOException {
        Loader loader = new Loader();

        HtmlParser parser = new HtmlParser();
        String response = loader.load(HABR_URL);

        List<Article> articles = parser.parse(response);
    }
}
