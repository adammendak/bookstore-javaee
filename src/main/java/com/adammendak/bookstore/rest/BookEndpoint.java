package com.adammendak.bookstore.rest;

import com.adammendak.bookstore.model.Book;
import com.adammendak.bookstore.repository.BookRepository;
import com.adammendak.bookstore.util.impl.ISBN;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/book")
@RequestScoped
public class BookEndpoint {

    @Inject
    private BookRepository bookRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBooks() {
        List<Book> books = bookRepository.findAll();

        if(books.size()== 0) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(books).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBook(@Pattern(regexp = "\\d+") @PathParam("id")Long id) {
        Book book = bookRepository.find(id);

        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

    //todo DELETE

    //todo CREATE
}
