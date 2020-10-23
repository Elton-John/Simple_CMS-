package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Article {
    //    title - pole wymagane, maksymalnie 200 znaków
//    content - pole wymagane, minimalnie 500 znaków
//    categories - minimum jedna wybrana kategoria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    @NotBlank
    @Size(max = 200)
    private String title;
    @ManyToOne
    private Author author;
    @Size(min = 1)
    @ManyToMany
    @JoinTable(name = "articles_categories",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    @Size(min = 50)
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;
    private boolean draft;

    @PrePersist
    public void setCreatedTime() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdatedTime() {
        this.updated = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
