package org.example;

import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(
        classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
@ContextConfiguration(
        classes = Application.class,
        loader = SpringBootContextLoader.class
)
public class CucumberSpringContextConfiguration {
    @Before
    public void setUp() {
        System.out.println("-------------- Spring Context Initialized For Executing Cucumber Tests --------------");
    }
}
