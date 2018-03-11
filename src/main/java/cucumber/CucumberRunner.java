package cucumber;

import com.relevantcodes.extentreports.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        format={"pretty", "html:target/","json:target/cucumber.json"},
        glue={"stepDefinition"},
        features={"src/cucumberfeatures/"}
)
public class CucumberRunner {
    @AfterSuite
    public static void generateReport() throws IOException {

        /**
         * Report Generated Under "Custom-Report".
         */
        File reportOutputDirectory = new File("./Custom-Report");
        List<String> jsonFiles = new ArrayList<String>();
        String jenkinsBasePath = "";
        String buildNumber = "1";
        String buildProject = "cucumber-jvm";
        boolean skippedFails = true;
        boolean pendingFails = false;
        boolean undefinedFails = true;
        boolean missingFails = true;
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
        boolean artifactsEnabled=false;
        String artifactConfig="";
        boolean flashCharts=false;
        boolean highCharts=false;
        jsonFiles.add("target/cucumber.json");
        Configuration configuration = new Configuration(reportOutputDirectory);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, reportOutputDirectory, "", buildNumber, buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins, artifactsEnabled, artifactConfig, highCharts, parallelTesting);
        reportBuilder.generateReports();
    }
}
