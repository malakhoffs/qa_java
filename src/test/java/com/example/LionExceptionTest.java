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
    public static Object [][] GetData () {
        return new Object[][] {
                {"Неопределено"},
                {null},
        };
    }

    public LionExceptionTest(String sex) {
        this.sex = sex;
    }

    @Test
    public void SexExceptions() {
        Exception SexException = assertThrows ( Exception.class, () -> new Lion(sex, null));
        Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", SexException.getMessage());
    }
}
