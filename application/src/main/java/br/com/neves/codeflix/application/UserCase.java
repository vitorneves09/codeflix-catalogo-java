package br.com.neves.codeflix.application;

import br.com.neves.codeflix.domain.category.Category;

public class UserCase {

    public Category execute() {
        return Category.newCategory("Test Category", "A test category", true);
    }

}