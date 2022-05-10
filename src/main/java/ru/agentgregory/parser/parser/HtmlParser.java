package ru.agentgregory.parser.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.agentgregory.parser.ParserRunning;
import ru.agentgregory.parser.model.Article;

import java.util.ArrayList;
import java.util.List;

public class HtmlParser {

    public List<Article> parse(String html) {
        Document document = Jsoup.parse(html);

        Elements articleElems = document.select(".tm-articles-list__item");

        List<Article> articles = new ArrayList<>();

        for (Element articleElem : articleElems) {
            String username = articleElem.select(".tm-user-info__user").text();

            Elements titleEl = articleElem.select(".tm-article-snippet__title-link");
            String title = titleEl.select("span").text();
            String url = ParserRunning.HABR_DOMAIN + titleEl.attr("href");

            String description = articleElem.select(".article-formatted-body p").text();

            articles.add(new Article(username, title, description, url));
        }
        return articles;
    }
}
