package edu.rporeba.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Borrower")
public class Borrower implements Serializable{

    private static final long serialVersionUID = -3723289802711977258L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BORROWER_ID", nullable = false, updatable = false)
    private Long borrowerId;

    @Size(min = 3, max = 20)
    @NotNull
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 3, max = 20)
    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @Valid
    @Column(name = "HAS_BOOK_BORROWED")
    private Boolean hasBookBorrowed = false;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Borrow> borrows;


}
