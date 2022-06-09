package com.codacuum.springboothelloworld.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class HelloWorldControllerTest {


    private HelloWorldController helloWorldController;

    @BeforeEach
    void setUp(){
        helloWorldController = new HelloWorldController();
    }

    @Test
    void HelloWorld_returns_HelloWorld_message(){
         String response = helloWorldController.HelloWorld();
         assertThat(response).isEqualTo("Hello World");
    }

}
