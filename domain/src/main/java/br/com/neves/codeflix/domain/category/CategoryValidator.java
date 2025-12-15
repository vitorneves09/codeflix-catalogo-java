package br.com.neves.codeflix.domain.category;

import br.com.neves.codeflix.domain.validation.Error;
import br.com.neves.codeflix.domain.validation.ValidationHandler;
import br.com.neves.codeflix.domain.validation.Validator;

/**
 * O validador é criado fora
 */
public class CategoryValidator extends Validator {

    public static final int NAME_MAX_LENGTH = 255;
    public static final int NAME_MIN_LENGTH = 3;
    private final Category category;

    public CategoryValidator(final Category aCategory, final ValidationHandler ahandler) {
        super(ahandler);
        this.category = aCategory;
    }

    @Override
    public void validate() {
        checkNameConstraint();

        if(this.category.getName() != null &&
                (this.category.getName().length() <= 3 || this.category.getName().length() >= 255)){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }
    }

    private void checkNameConstraint() {
        final String name = this.category.getName();

        if(name == null) {
            this.validationHandler().append(new Error("'name' should not be null"));
            return ;
        }

        if(name.isBlank()){
            this.validationHandler().append(new Error("'name' should not be empty"));
            return;
        }

        if(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH){
            this.validationHandler().append(new Error("'name' must be between 3 and 255 characters"));
        }

    }
}
