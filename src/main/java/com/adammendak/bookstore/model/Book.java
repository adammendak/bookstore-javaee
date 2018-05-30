package com.adammendak.bookstore.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
            name = Book.COUNT_ALL,
            query = "SELECT count (b) from Book b order by b.title desc"),
        @NamedQuery(
            name = Book.FIND_ALL,
            query = "SELECT b from Book b order by b.title desc ")
})
@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
public class Book  extends AbstractTimestampableEntity {

    public static final String COUNT_ALL = "Book.countAll";
    public static final String FIND_ALL = "Book.findAll";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title", length = 200)
    @NotNull
    @Size(min = 1, max = 200)
    private String title;

    @Column(name = "description", length = 1000)
    @Size(min = 1, max = 1000)
    private String description;

    @Column(name = "unit_cost")
    @NotNull
    private Float unitCost;

    @Column(name = "isbn")
    private String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "number_of_pages")
    @Min(1)
    private Integer numberOfPages;

    @Column(name = "img_url", length = 1000)
    @Size(min = 1, min = 1000)
    private String imgUrl;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

}
