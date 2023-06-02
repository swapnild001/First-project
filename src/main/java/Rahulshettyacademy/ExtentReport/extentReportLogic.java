package Rahulshettyacademy.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReportLogic {

	  
	public static ExtentReports reportLogic()
	{
		
		String path = System.getProperty("user.dir")+"\\Reports\\spark.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Automation ORm Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		return extent;
		
	}
	
	}
