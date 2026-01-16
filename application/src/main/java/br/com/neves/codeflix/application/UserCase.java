package br.com.neves.codeflix.application;

import br.com.neves.codeflix.domain.category.Category;

public abstract class UserCase<IN,OUT> {
    public abstract OUT execute(IN aInput);
}