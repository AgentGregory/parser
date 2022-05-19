package ru.agentgregory.parser.service.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import ru.agentgregory.parser.ParserRunning;
import ru.agentgregory.parser.model.Article;
import ru.agentgregory.parser.model.Statistic;
import ru.agentgregory.parser.model.User;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class HtmlParser {

    public List<Article> parse(String html) {
        Document document = Jsoup.parse(html);

        Elements articleElems = document.select(".tm-articles-list__item");

        List<Article> articles = new ArrayList<>();

        for (Element articleElem : articleElems) {


            Elements userInf = articleElem.select(".tm-user-info__user");
            String username = userInf.select(".tm-user-info__user").text();
            String urlUser = ParserRunning.HABR_DOMAIN + userInf.attr("href");

            Elements titleEl = articleElem.select(".tm-article-snippet__title-link");
            String title = titleEl.select("span").text();
            String url = ParserRunning.HABR_DOMAIN + titleEl.attr("href");

            String description = articleElem.select(".article-formatted-body p").text();


            Elements pubDate = articleElem.select(".tm-article-snippet__datetime-published");
            Elements publDate = pubDate.select("time");
            ZonedDateTime publishDateTime = ZonedDateTime.parse(publDate.attr("datetime"));

            User user = new User(username, urlUser);
/*

            String rep = articleElem.select(".tm-votes-meter__value").text();
            String view = articleElem.select(".tm-icon-counter__value").text();
            String rep = articleElem.select(".tm-votes-meter__value").text();
            String rep = articleElem.select(".tm-votes-meter__value").text();

 */



            articles.add(new Article(user, username, title, description, url, publishDateTime));
        }
        return articles;
    }
}
