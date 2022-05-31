package ru.agentgregory.parser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "article_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_gen", sequenceName = "users_id_seq", allocationSize = 1)
    private Long id;
    private String username;
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Article> articles;

    public User(String username, String url) {
        this.username = username;
        this.url = url;
    }
}

