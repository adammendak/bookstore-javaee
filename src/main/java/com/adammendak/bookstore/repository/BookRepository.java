package com.adammendak.bookstore.repository;

import com.adammendak.bookstore.model.Book;
import lombok.NoArgsConstructor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;

@Stateless
@NoArgsConstructor
public class BookRepository {

    @PersistenceContext(name = "bookStorePU")
    private EntityManager entityManager;

    public Book find (Long id) {
        return entityManager.find(Book.class, id);
    }

    @Transactional(REQUIRED)
    public Book create (Book book) {
        entityManager.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete (Long id) {
        entityManager.remove(entityManager.getReference(Book.class, id));
    }

    public Long countAll () {
        TypedQuery<Long> query = entityManager.createQuery(
                "SELECT count (b) from Book b order by b.title desc", Long.class);
        return query.getSingleResult();
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = entityManager.createQuery(
                "SELECT b from Book b order by b.title desc ", Book.class);
        return query.getResultList();
    }
}
