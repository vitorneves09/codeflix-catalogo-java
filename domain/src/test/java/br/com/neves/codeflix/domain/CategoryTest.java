package br.com.neves.codeflix.domain;

import br.com.neves.codeflix.domain.category.Category;
import br.com.neves.codeflix.domain.exceptions.DomainException;
import br.com.neves.codeflix.domain.validation.ValidationHandler;
import br.com.neves.codeflix.domain.validation.handler.ThrowsValidationHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    @Test
    public void givenAValidParams_whencallNewCategory_thenInstantiated() {
        final var expectName = "Filmes";
        final var expectDescription = "A categoria mais assistida";
        final boolean expectIsActive = true;


        final var actulaCategory = Category.newCategory(expectName, expectDescription, expectIsActive);
        Assertions.assertNotNull(actulaCategory);
        Assertions.assertNotNull(actulaCategory.getId());
        Assertions.assertEquals(expectName, actulaCategory.getName());
        Assertions.assertEquals(expectDescription, actulaCategory.getDescription());
        Assertions.assertEquals(expectIsActive, actulaCategory.isActive());
        Assertions.assertNotNull(actulaCategory.getCreatedAt());
    }

    @Test
    public void givenAnInvalidNullNameEmpty_whenNewCategoryAndValidate_thenShouldThrowException() {
        final String expectName = "";
        final var expectErrorCount = 1;
        final var expectDescription = "A categoria mais assistida";
        final var expectErrorMessage = "'name' should not be null";
        final boolean expectIsActive = true;

        final var actulaCategory = Category.newCategory(expectName, expectDescription, expectIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actulaCategory.validate( new ThrowsValidationHandler()));

        Assertions.assertEquals(expectErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectErrorMessage, actualException.getErrors().get(0).message());
    }

    @Test
    public void givenAnInvalidNullNameLengthLessThan3_whenNewCategoryAndValidate_thenShouldThrowException() {
        final String expectName = "1";
        final var expectErrorCount = 1;
        final var expectDescription = "A categoria mais assistida";
        final var expectErrorMessage = "'name' must be between 3 and 255 characters";
        final boolean expectIsActive = true;

        final var actulaCategory = Category.newCategory(expectName, expectDescription, expectIsActive);

        final var actualException =
                Assertions.assertThrows(DomainException.class, () -> actulaCategory.validate( new ThrowsValidationHandler()));

        Assertions.assertEquals(expectErrorCount, actualException.getErrors().size());
        Assertions.assertEquals(expectErrorMessage, actualException.getErrors().get(0).message());
    }


}
