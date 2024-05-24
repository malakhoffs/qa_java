package com.example;


import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class FelineTest {

    Feline feline = new Feline();
    @Test
    public void eatMeatTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getKittensTest() {
        Assert.assertEquals(1, feline.getKittens());
    }
    @Test
    public void getKittensDefaultTest() {
        Assert.assertEquals(feline.getKittens(), feline.getKittens(1));
    }
    @Test
    public void getFamilyTest() {
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }
    @Test
    public void getFoodTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),feline.getFood("Хищник"));
    }
}