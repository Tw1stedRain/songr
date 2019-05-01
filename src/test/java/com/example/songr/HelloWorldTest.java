package com.example.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {


    @Test
    public void testhelloWorld() {
        HelloWorld hello = new HelloWorld();

        assertEquals("Hello, Bob!", hello.helloWorld("Bob"));
        assertEquals("Hello, Nicole!", hello.helloWorld("Nicole"));
        assertEquals("Hello, Kel!", hello.helloWorld("Kel"));
    }

    @Test
    public void testCaps() {
        HelloWorld caps = new HelloWorld();

        String results = caps.capitalize("hello, user!");
        assertEquals("HELLO, USER!", results);

        String moreResults = caps.capitalize("buttsbuttsbutts");
        assertEquals("BUTTSBUTTSBUTTS", moreResults);

        String moreMoreResults = caps.capitalize("ummmm...");
        assertEquals("UMMMM...", moreMoreResults);
    }


}