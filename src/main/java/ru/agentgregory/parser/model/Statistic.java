package ru.agentgregory.parser.model;

public class Statistic {
    private int rep;
    private int view;
    private int bookmarks;
    private int comments;

    public Statistic(int rep, int view, int bookmarks, int comments) {
        this.rep = rep;
        this.view = view;
        this.bookmarks = bookmarks;
        this.comments = comments;
    }
}
