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
    public static Object [][] getData () {
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
    }
}