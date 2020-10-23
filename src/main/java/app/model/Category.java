package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 100)
    @Size(min = 5)
    @NotBlank
    private String name;

    @Column(nullable = true)
    private String description;

    @ManyToMany(mappedBy = "categories")

    private List<Article> articles;
}
