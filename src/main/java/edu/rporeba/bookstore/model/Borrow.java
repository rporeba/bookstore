package edu.rporeba.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Borrow")
public class Borrow implements Serializable {

    private static final long serialVersionUID = -8624853582167347469L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BORROW_ID")
    private Long borrowId;

    @Column(name = "BORROW_DATE")
    private LocalDate borrowDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_ID")
    @JsonIgnoreProperties("item")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BORROWER_ID")
    @JsonManagedReference
    private Borrower borrower;


}
