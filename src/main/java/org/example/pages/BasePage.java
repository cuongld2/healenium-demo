package org.example.pages;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BasePage {

	public static SelfHealingDriver driver;

	public static WebDriver delegate;
	String url = System.getenv().getOrDefault("APP_URL", "http://localhost:3000");
	public static ExtentTest logger;
	public static ExtentReports report;

	@BeforeSuite(alwaysRun=true)
	public void setup(ITestContext context) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		delegate = new ChromeDriver(options);
		driver = SelfHealingDriver.create(delegate);
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
	}

	@AfterSuite(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
