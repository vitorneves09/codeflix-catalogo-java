package br.com.neves.codeflix.domain.validation;


/**
 * class de assinatura das demais class de validacao. As class que foram implementar as regras de negocisa das entidade,
 * obrigatoriamente precisam implementar essa class.
 */
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

