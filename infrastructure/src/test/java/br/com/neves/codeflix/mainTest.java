package br.com.neves.codeflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class mainTest {

    @Test
    public void testMain()
    {
        Assertions.assertNotNull(new Main());
        Main.main(new String[]{});
    }
}
