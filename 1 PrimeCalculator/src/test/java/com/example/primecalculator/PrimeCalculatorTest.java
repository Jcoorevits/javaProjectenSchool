package com.example.primecalculator;

import com.example.primecalculator.model.PrimeCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
public class PrimeCalculatorTest {

    @Test
    public void testGetListOfAllNumbersUntil(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 100; i++){
            list.add(i);
        }
        assertEquals(list, primeCalculator.getListOfAllNumbersUntil(0,100));
    }
    @Test
    public void testGetAllPrimeUntil(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        List<Integer> list = Arrays.asList(2,3,5,7,11);

        assertEquals(list, primeCalculator.getAllPrimeUntil(11));
    }
    @Test
    public void testIsPrime(){
        PrimeCalculator primeCalculator = new PrimeCalculator();
        assertEquals(true, primeCalculator.isPrime(3));
    }
}
