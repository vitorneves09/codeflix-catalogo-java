package br.com.neves.codeflix.domain.validation;

public abstract class Validator {
    private final ValidationHandler handler;

    public Validator(ValidationHandler handler) {
        this.handler = handler;
    }

    public abstract void validate();

    public ValidationHandler validationHandler(){
        return handler;
    }
}

