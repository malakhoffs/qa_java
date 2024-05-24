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
public class LionTest{
    @Mock
    Feline feline;
    Lion lion;
    private List<String> expectedFood;

    @Before
    public void setLion() {
        try {
            lion = new Lion( "Самец", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        expectedFood = List.of("Животные", "Птицы", "Рыба");
    }
    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> lionFood = lion.getFood();
        Assert.assertEquals(expectedFood, lionFood);
    }
    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        Assert.assertEquals(feline.getKittens(), lion.getKittens());
    }

}