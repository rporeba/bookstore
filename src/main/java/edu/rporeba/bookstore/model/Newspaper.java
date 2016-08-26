package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "Newspaper")
public class Newspaper extends Item {

    @Size(min = 3, max = 30)
    @Column(name = "NEWSPAPER_TITLE")
    private String newspaperTitle;


}
