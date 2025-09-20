package br.com.neves.codeflix.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class useCaseTest {

    @Test
    public void testCreateUseCase() {
        UserCase userCase = new UserCase();

        Assertions.assertNotNull(userCase);
        Assertions.assertNotNull(userCase.execute());
    }
}
