package com.adammendak.bookstore.repository;

import com.adammendak.bookstore.model.Book;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Stateless
@NoArgsConstructor
public class BookRepository {

    @PersistenceContext(name = "bookStorePU")
    private EntityManager entityManager;

    public Book find (@NotNull Long id) {
        return entityManager.find(Book.class, id);
    }

    @Transactional(REQUIRED)
    public Book create (@NotNull Book book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete (@NotNull Long id) {
        entityManager.remove(entityManager.getReference(Book.class, id));
    }

    public Long countAll () {
        TypedQuery<Long> query = entityManager.createNamedQuery(
                Book.COUNT_ALL , Long.class);
        return query.getSingleResult();
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createNamedQuery(
                Book.FIND_ALL, Book.class);
        return query.getResultList();
    }
}
