package com.oracle.ICICI.common.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//tags = "@T001, @T002, @T003, @T004",
        tags = "@T001",
		features = { "src/test/resources/features" },
		plugin = {"html:target/cucumber-html-report", "json:target/report.json",
						"pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
						"junit:target/cucumber-results.xml","pretty"},
		glue = {  "com.oracle.ICICI.common.steps",
                        "com.oracle.ICICI.common.runners", "com.oracle.ICICI.HCM.steps" }, dryRun = false)

public class DevelopmentRunner {

}
