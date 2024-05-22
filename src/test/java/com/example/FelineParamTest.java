package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.MockitoAnnotations.*;


@RunWith(Parameterized.class)
public class FelineParamTest {

    @Before
    public void init() {
        openMocks(this);
    }

    private final String animalKind;
    private final int childrenValue;

    public FelineParamTest(String animalKind, int childrenValue) {
        this.animalKind = animalKind;
        this.childrenValue = childrenValue;
    }

    @Parameterized.Parameters (name = "{index} Value = {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Травоядное", 0},
                {"Хищник", 1},
                {"Пресмыкающееся", 2}
        };
    }

    @Mock
    Feline feline;

    @Test
    public void getFelineFoodTest() throws Exception {
        feline.getFood(animalKind);
        Mockito.verify(feline, Mockito.times(1)).getFood(animalKind);
        Assert.assertTrue(feline.getFood(animalKind).isEmpty());
    }

    @Test
    public void getFelineKittensTest() {
        feline.getKittens(childrenValue);
        Mockito.verify(feline, Mockito.times(1)).getKittens(childrenValue);
        Assert.assertEquals(0, feline.getKittens(childrenValue));
    }
}