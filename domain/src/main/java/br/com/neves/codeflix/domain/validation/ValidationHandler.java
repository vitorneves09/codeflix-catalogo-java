package br.com.neves.codeflix.domain.validation;

import java.util.List;

/**
 * Assinatura da(s) que implementem a logica que ira lidar/tratar dos erros.
 */
public interface ValidationHandler {

    ValidationHandler append(Error anError);
    ValidationHandler append(ValidationHandler anHandle);
    ValidationHandler validate(validation aValidation);

    List<Error> getErrors();

    default boolean hasError(){
     return getErrors() !=  null && !getErrors().isEmpty();
    }

    public interface validation{
        void validate();
    }



}
