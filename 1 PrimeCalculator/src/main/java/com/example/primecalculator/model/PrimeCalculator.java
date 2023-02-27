package com.example.primecalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeCalculator {


    public List<Integer> getListOfAllNumbersUntil(int start, int end) {
        return IntStream.range(start, end + 1).boxed().toList();
    }

    public List<Integer> getAllPrimeUntil(int number) {
        List<Integer> primes = getListOfAllNumbersUntil(2, number);
        //
        return primes.stream().filter(i -> isPrime(i)).toList();
    }

    public boolean isPrime(int number) {
        List<Integer> primes = getListOfAllNumbersUntil(2, number / 2);
        // map = vervangen door de berekening in lambda
        return primes.stream().map(i -> number % i).noneMatch(i -> i == 0);
    }
}
