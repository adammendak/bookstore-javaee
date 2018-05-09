package com.adammendak.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "unit_cost")
    private Float unitCost;

    @Column(name = "isbn")
    private String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    @Column(name = "img_url", length = 1000)
    private String imgUrl;

    @Enumerated
    @Column(name = "language")
    private Language language;

}
