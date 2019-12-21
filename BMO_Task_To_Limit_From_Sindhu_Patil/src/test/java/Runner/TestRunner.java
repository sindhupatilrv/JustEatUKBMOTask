package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author SindhuVeerapp
 * This is TestRunner to get Junit result and which call both feature and step Definition 
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/main/java/Feature", glue="src/main/java/stepDefinitions")



public class TestRunner {

}
