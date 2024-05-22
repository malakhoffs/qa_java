package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LionParamTest {

    String sex;
    Boolean expected;


    @Parameterized.Parameters (name = "{index} = {0}")
    public static Object [][] GetData () {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    public LionParamTest(String sex, Boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Test
    public void doesHaveMane() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);
        Assert.assertEquals(expected,lion.doesHaveMane());
        Assert.assertEquals(feline.getKittens(),lion.getKittens());
        Assert.assertEquals(feline.getFood("Хищник"), lion.getFood());
    }
}