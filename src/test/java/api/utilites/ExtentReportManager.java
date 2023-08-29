package api.utilites;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{


	public  ExtentSparkReporter sparkReporter;  // user interface
	public ExtentReports extentReports;        // common information
	public ExtentTest test;                   // entries for test

	String repName;
//	On Start method is called when any test starts
	public void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()); //time stamp
		repName = "Test_Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName); //Specify the location of the report

		sparkReporter.config().setDocumentTitle("APIAutomationReport"); //Title of the report
		sparkReporter.config().setReportName("API Report"); // Name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();

		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Application", "User API");
		extentReports.setSystemInfo("Operation System", System.getProperty("os.name"));
		extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user","Amol");

	}
// On TestSuccess method is called when any test are success
	public void onTestSuccess(ITestResult result) {
		test = extentReports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.PASS, "Test Passed");
	}
//	On TestFailure method is called when any test are failed
	public void onTestFailure(ITestResult result) {
		test = extentReports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
//	On TestSkipped method is called when any test are skipped
	public void onTestSkipped(ITestResult result) {
		test = extentReports.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
//	On TestFinish method is called when all tests are executed
	public void onFinish(ITestContext context) {
		if(extentReports != null)
			extentReports.flush();

	}

}
