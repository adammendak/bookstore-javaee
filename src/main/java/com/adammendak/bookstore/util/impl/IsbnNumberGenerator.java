package com.adammendak.bookstore.util.impl;

import com.adammendak.bookstore.util.NumberGenerator;
import lombok.NoArgsConstructor;

import javax.faces.bean.RequestScoped;
import java.util.Random;

@RequestScoped
@NoArgsConstructor
@ISBN
public class IsbnNumberGenerator implements NumberGenerator {

    @Override
    public String generateNumber() {
        return Integer.toString(Math.abs(new Random().nextInt()));
    }

}
