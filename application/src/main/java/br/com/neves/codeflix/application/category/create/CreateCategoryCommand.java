package br.com.neves.codeflix.application.category.create;

import br.com.neves.codeflix.domain.category.Category;

public record CreateCategoryCommand(
        String name,
        String description,
        boolean isActive
) {

    /**
     * FACTORY-METHOD
     * @param name
     * @param description
     * @param isActive
     * @return CreateCategoryCommand
     */
    public static CreateCategoryCommand with(final String name, final String description, final boolean isActive) {
        return new CreateCategoryCommand(name, description, isActive);
    }

}
