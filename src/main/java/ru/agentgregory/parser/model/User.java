package ru.agentgregory.parser.model;

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
    @GeneratedValue(generator = "", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "users_gen", sequenceName = "users_id_seq")
    private Long id;
    private String username;
    private String url;

    @OneToMany(mappedBy = "user")
    private List<Article> articles;

    public User(String username, String url) {
        this.username = username;
        this.url = url;
    }
}

