package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private Integer noOfCucumbers;
    private Integer noOfCucumberEaten;
    private Integer noOfRemainingCucumber;

    @Given("There are {int} cucumbers")
    public void cucumberTest_nrOne(Integer noOfCucumber) throws Throwable{
        noOfCucumbers = noOfCucumber;
    }

    @When("I eat {int} cucumbers")
    public void cucumberTest_nrTwo(Integer noOfCucumberEaten) throws Throwable{
        noOfCucumbers = noOfCucumbers - noOfCucumberEaten;
    }

    @Then("I should have {int} cucumbers")
    public void cucumberTest_nrThree(Integer noOfRemainingCucumber) throws Throwable{
        assertEquals(noOfCucumbers, noOfRemainingCucumber);
    }


}
