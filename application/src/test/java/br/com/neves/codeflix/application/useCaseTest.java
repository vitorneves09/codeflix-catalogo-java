package br.com.neves.codeflix.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class useCaseTest {

    @Test
    public void testCreateUseCase()
    {
        MockitoAnnotations.initMocks(this);
    }

}
