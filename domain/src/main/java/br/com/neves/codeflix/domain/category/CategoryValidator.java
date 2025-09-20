package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.validation.Error;
import br.com.neves.codeflix.domain.validation.ValidationHandler;
import br.com.neves.codeflix.domain.validation.Validator;

public class CategoryValidator  extends Validator {


    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler ahandler) {
        super(ahandler);
        this.category = aCategory;

    }

    @Override
    public void validate() {
        if(this.category.getName() ==null || this.category.getName().isEmpty()){
            this.validationHandler().append(new Error("'name' should not be null"));
        }
    }
}
