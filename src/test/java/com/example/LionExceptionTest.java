package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertThrows;


@RunWith(Parameterized.class)
public class LionExceptionTest {

    String sex;

    @Parameterized.Parameters (name = "{index} Value = {0}")
    public static Object [][] getData () {
        return new Object[][] {
                {"Неопределено"},
                {null},
        };
    }

    public LionExceptionTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void sexExceptions() {
        Exception sexException = assertThrows ( Exception.class, () -> new Lion(sex, null));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", sexException.getMessage());
    }
}
