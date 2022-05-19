package ru.agentgregory.parser.model;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "articles")
public class Article {
    @javax.persistence.Id
    @Id
    @GeneratedValue(generator = "", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "article_gen", sequenceName = "articles_id_seq", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String username;
//    private List<Categores> categories;
    private String title;
    private String description;
    private String url;
    private ZonedDateTime publishDateTime;
//    @ManyToOne
//    @JoinColumn(name = "statistic_id")
//    //private Statistic statistic;

    public Article(User user, String username, String title, String description, String url, ZonedDateTime publishDateTime) {
        this.user = user;
        this.username = username;
        this.title = title;
        this.description = description;
        this.url = url;
        this.publishDateTime = publishDateTime;

    }

}




