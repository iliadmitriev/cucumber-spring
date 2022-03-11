package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"org.example"},
        plugin = {"pretty", "json:target/cucumber-report.json"},
        stepNotifications = true,
        tags = "@all"
)
public class RunCucumberTest {
    public static void main(String[] args) {
        JUnitCore.main(RunCucumberTest.class.getName());
    }
}
