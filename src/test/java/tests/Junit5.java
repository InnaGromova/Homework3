package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Junit5 {
    @BeforeAll
    static void beforeAll(){
        System.out.println("Something before all");
    }

    @Test
    void firstTest(){
      System.out.println("Started First test");
    }

    @Test
    void secondTest(){
        System.out.println("*****Started Second test");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Something after all");
    }
}
