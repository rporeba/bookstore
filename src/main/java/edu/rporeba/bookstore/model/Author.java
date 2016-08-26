package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Author")
public class Author implements Serializable{

    private static final long serialVersionUID = 7456831297727758404L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private Long authorId;

    @Length(min = 3, max = 20)
    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Length(min = 3, max = 20)
    @NotEmpty
    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private Set<Book> books;


}
