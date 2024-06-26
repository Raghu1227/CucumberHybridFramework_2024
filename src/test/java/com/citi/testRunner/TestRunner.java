package com.citi.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "srcc/test/resources/features",
                 glue = {"stepdefinations","hooks"},
                 publish = true ,
                 plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"}
		     )

public class TestRunner {
	
	

}
