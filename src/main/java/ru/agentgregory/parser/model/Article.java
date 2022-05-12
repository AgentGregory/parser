package ru.agentgregory.parser.model;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Article {
    private User user;
    private String username;
    //private List<Category> categories; //[name, url]
    private String title;
    private String description;
    private String url;
    private ZonedDateTime publishDateTime;
    private Statistic statistic [int rep, view, bookmarks, comments]
}




