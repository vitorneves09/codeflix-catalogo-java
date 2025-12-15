package br.com.neves.codeflix.domain.validation.handler;

import br.com.neves.codeflix.domain.exceptions.DomainException;
import br.com.neves.codeflix.domain.validation.Error;
import br.com.neves.codeflix.domain.validation.ValidationHandler;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(final Error anError) {
        throw DomainException.with(anError);
    }

    @Override
    public ValidationHandler append(final ValidationHandler anHandle) {
        throw DomainException.with(anHandle.getErrors());
    }

    @Override
    public ValidationHandler validate(validation aValidation) {
        return null;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }

    @Override
    public boolean hasError() {
        return ValidationHandler.super.hasError();
    }
}
