package com.axxes.testing.mocking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
       Greeter greeter = new Greeter();

       @Test
    void whenInputIsBob_HelloBob_IsReturnedt(){
           String greet = greeter.greet("Bob");
           String greetNull = greeter.greet(null);
           String greetUpper = greeter.greet("JEFF");



           assertThat(greet).isEqualTo("Hello, Bob");
           assertThat(greetNull).isEqualTo("Hello there");
           assertThat(greetUpper).isEqualTo("HELLO, JEFF");

       }
    @Test
       void when_BobAndJane_Hello_IsReturned(){

           String greetArray = greeter.greet("Jill", "Jane");

           assertThat(greetArray).isEqualTo("Hello, Jill and Jane");
       }
}