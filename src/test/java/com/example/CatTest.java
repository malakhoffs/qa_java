package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    private List<String> expectedFood;
    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void setCat() {
        cat = new Cat(feline);
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> foodCat = cat.getFood();
        Assert.assertEquals(expectedFood, foodCat);
    }
    @Test
    public void getSoundMockTest() {
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу",cat.getSound());
    }
}