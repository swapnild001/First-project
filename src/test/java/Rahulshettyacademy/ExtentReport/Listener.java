package Rahulshettyacademy.ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Listener implements ITestListener{
	//WebDriver driver= new ChromeDriver();
	ExtentTest test;
	ExtentReports extent; 
	@Override
	public void onTestStart(ITestResult result) {
		String path = System.getProperty("user.dir")+"\\Reports\\spark2.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Automation ORm Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		test= extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test is pass");
		}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		/*TakesScreenshot ts =(TakesScreenshot)driver;
		try {
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(System.getProperty("user.dir")+"//Screenshots" + result.getName() +".png"));
		} 	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//test.addScreenCaptureFromPath(null, null)
		*/}

	@Override
	public void onTestSkipped(ITestResult result) {
		}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}


	
}
