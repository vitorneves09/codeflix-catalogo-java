package br.com.neves.codeflix.application.category.create;

import br.com.neves.codeflix.domain.category.Category;
import br.com.neves.codeflix.domain.category.CategoryGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class CreateCategoryUserCaseTest {

    @Test
    public void givenAValidComnad_whenCallsCreateCategory_shouldReturnCategorydId() {

        final var expectedName = "Filmes";
        final var expectedDescription = "a categoria mais assistida";
        final var expectedIsactive = true;
        final var expectedCategory = Category.newCategory(expectedName, expectedDescription, expectedIsactive);

        final var aCommand = CreateCategoryCommand.with(expectedName,expectedDescription,expectedIsactive);

        final CategoryGateway categoryGateways = Mockito.mock(CategoryGateway.class);

        // o returnFirstArgo retorna o primeiro argumento/parametro que foi passado para o metodo create que sera
        Mockito.when(categoryGateways.create(Mockito.any()))
                .thenAnswer(returnsFirstArg());

        final var useCase  = new CreateCategoryUseCaseImp(categoryGateways);

        final var  actualOutPut = useCase.execute(aCommand);

        Assertions.assertNotNull(actualOutPut);
        Assertions.assertNotNull(actualOutPut.id());

        Mockito.verify(categoryGateways,Mockito.times(1))
                .create(Mockito.argThat(aCategory ->{
                    return Objects.equals(aCategory.getName(), expectedName)
                            && Objects.equals(aCategory.getDescription(), expectedDescription)
                            && Objects.equals(aCategory.isActive(), expectedIsactive)
                            && Objects.nonNull(aCategory.getId())
                            && Objects.nonNull(aCategory.getCreatedAt())
                            && Objects.nonNull(aCategory.getUpdatedAt())
                            && Objects.isNull(aCategory.getDeletedAt());
                }));
    }
}
