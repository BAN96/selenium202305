package com.proj.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/com/features"},
		glue= {"com.proj.appHooks","com.proj.stepDefinations"},
		plugin= {"pretty","html:target/index.html"},
		publish = true
		)
public class testRunner {

}
