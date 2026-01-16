package br.com.neves.codeflix.application.category.create;

import br.com.neves.codeflix.domain.category.Category;
import br.com.neves.codeflix.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {
    /**
     * FACTORY-METHOD
     * @param aCategory
     * @return
     */
    public static CreateCategoryOutput from(final Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }
}
