package br.com.neves.codeflix.domain.validation.handler;

import br.com.neves.codeflix.domain.exceptions.DomainException;
import br.com.neves.codeflix.domain.validation.ValidationHandler;
import br.com.neves.codeflix.domain.validation.Error;

import java.util.List;

public class ThrowsValidationHandler implements ValidationHandler {
    @Override
    public ValidationHandler append(Error anError) {
        throw new DomainException(List.of(anError));
    }

    @Override
    public ValidationHandler append(ValidationHandler anHandle) {
        throw new DomainException(anHandle.getErrors());
    }

    @Override
    public ValidationHandler validate(final ValidationHandler aValidation) {
        try{
            aValidation.validate(aValidation);
        }catch (final Exception exception){
            throw DomainException.with(List.of(new Error(exception.getMessage())));
        }

        return  this;
    }

    @Override
    public List<Error> getErrors() {
        return List.of();
    }
}
