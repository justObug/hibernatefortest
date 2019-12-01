package com.example.springbootforautomation.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestngForTest {

    @BeforeClass
    public void before(){
        System.out.println("before class*****************");
    }

    @Test
    public void test1(){
        System.out.println("test1 *********************");
    }

    @Test
    public void test2(){
        System.out.println("test2 ********************");
    }

    @AfterClass
    public void after(){
        System.out.println("after class ****************");
    }
}
