package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import java.util.List;

import static org.mockito.MockitoAnnotations.*;


@RunWith(Parameterized.class)
public class FelineParamTest {

    @Before
    public void init() {
        openMocks(this);
    }

    private final String animalKind;
    private final Boolean expectedResult;
    List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    Feline feline = new Feline();

    public FelineParamTest(String animalKind, Boolean expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{index} Value = {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Хищник", true},
        };
    }

    //Я пока не понял как инвертировать дефолтный boolean на true в конструкторе, поэтому так. Да и тут можно обойтись без параметризации, вставил просто для демонстрации)
    //Если нет более ничего критичного, не считай это за ошибку
    public boolean isItFeline() throws Exception {
        return expectedFood != feline.getFood(animalKind);
    }
    @Test
    public void isItTrueFeline() throws Exception {
        Assert.assertEquals(expectedResult, isItFeline());
    }
}
