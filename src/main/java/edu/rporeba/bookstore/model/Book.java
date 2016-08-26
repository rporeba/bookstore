package edu.rporeba.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class Book extends Item implements Serializable {

    private static final long serialVersionUID = -7447877676635026239L;

    @Length(min = 3, max = 20)
    @NotNull
    @Column(name = "ISBN")
    private String isbn;

    @Length(min = 3, max = 20)
    @NotNull
    @Column(name = "BOOK_TITLE")
    @JsonProperty("bookTitle")
    private String bookTitle;

    @Column(name = "TYPE_OF_BOOK")
    @Enumerated(EnumType.STRING)
    private BookType typeOfBook;

    @NotNull
    @Column(name = "NUMBER_OF_PAGE")
    private Long numberOfPage;

    @Column(name = "PUBLISHED")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    @NotNull
    private LocalDate published;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private Author author;

    @Column(name = "IS_BOOK_BORROWED")
    private boolean isBookBorrowed;

    public Optional<Borrow> getMaxBorrow() {
        return getBorrows().stream().reduce((a, b) -> a.getBorrowId() > b.getBorrowId() ? a : b);
    }


}
