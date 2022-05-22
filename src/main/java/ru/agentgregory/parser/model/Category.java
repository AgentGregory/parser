package ru.agentgregory.parser.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categories")

public class Category {

    @Id
    @GeneratedValue(generator = "categories_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categories_gen", sequenceName = "categories_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String url;

    @ManyToMany(mappedBy = "categories")
    private List<Article> articles;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
