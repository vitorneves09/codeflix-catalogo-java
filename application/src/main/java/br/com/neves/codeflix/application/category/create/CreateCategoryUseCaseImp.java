package br.com.neves.codeflix.application.category.create;

import br.com.neves.codeflix.domain.category.Category;
import br.com.neves.codeflix.domain.category.CategoryGateway;
import br.com.neves.codeflix.domain.validation.handler.ThrowsValidationHandler;

import java.util.Objects;

public class CreateCategoryUseCaseImp extends CreateCategoryUseCase {

    private final CategoryGateway categoryGateway;

    public CreateCategoryUseCaseImp(CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public CreateCategoryOutput execute(final CreateCategoryCommand aInput) {

        final Category aCategory = Category.newCategory(aInput.name(),aInput.description(),aInput.isActive());
        aCategory.validate(new ThrowsValidationHandler());

        return CreateCategoryOutput.from(this.categoryGateway.create(aCategory));
    }
}
