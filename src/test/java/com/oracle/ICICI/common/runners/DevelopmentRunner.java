package com.oracle.ICICI.common.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = { "src/test/java/com/oracle/ICICI/HCM/features" }, 
        		plugin = { "pretty", "json:target/json/report.json",
        				"html:target/html/ofs"}, glue = {  "com.oracle.ICICI.common.steps",
                        "com.oracle.ICICI.common.runners", "com.oracle.ICICI.HCM.steps" }, dryRun = false)

public class DevelopmentRunner {

}
