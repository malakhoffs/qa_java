package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.MockitoAnnotations.*;


@RunWith(Parameterized.class)
public class FelineParamTest {

    @Before
    public void init() {
        openMocks(this);
    }

    private final String animalKind;



    public FelineParamTest(String animalKind) {
        this.animalKind = animalKind;
    }

    @Parameterized.Parameters (name = "{index} Value = {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Хищник"},
                {"Пресмыкающееся"},
                {"Человек"},
        };
    }

    @Test
    public void getFelineFoodTest() {
        Feline feline = new Feline();
        try {
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood(animalKind));
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}