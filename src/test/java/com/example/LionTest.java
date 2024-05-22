package com.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class LionTest{


    @Test
    public void getKittensTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void doesHaveFoodTest() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion("Самец", feline);
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}