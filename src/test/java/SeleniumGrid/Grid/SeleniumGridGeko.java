package SeleniumGrid.Grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridGeko {
	public class SeleniumTrial {

		WebDriver driver;
		JavascriptExecutor js;

		WebDriverWait wait;

		@BeforeMethod
		void setUp() throws MalformedURLException {

			String node = " http://192.168.0.31:4444/wd/hub";

			DesiredCapabilities obj = new DesiredCapabilities();
			obj.setPlatform(Platform.WINDOWS);
			obj.setBrowserName("firefox");
			//ChromeOptions obj1 = new ChromeOptions();
			FirefoxOptions obj1  = new FirefoxOptions();
			obj1.merge(obj);
			
			//FirefoxOptions fx=new FirefoxOptions();
			
			

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\shami\\eclipse-workspace\\Grid\\Drivers\\chromedriver.exe");

			driver = new RemoteWebDriver(new URL(node), obj1);

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get("https://www.google.co.in/");

			wait = new WebDriverWait(driver, 20);

		}

		@Test(priority = 1)
		void googleTitle() {

			String titleOfPage = driver.getTitle();

			Assert.assertEquals(titleOfPage, "Google");
			
			System.out.println(driver.getTitle());
			System.out.println("First Priorty Test");

		}

		@Test(priority = 2)
		void searchInput() {

			WebElement logo = driver.findElement(By.id("hplogo"));

			Assert.assertTrue(logo.isDisplayed());
			System.out.println(driver.getTitle());
			System.out.println("Second Priorty Test");

		}

		@Test(priority = 3)
		void searchOutput() {
			
			WebElement about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
			Assert.assertTrue(about.isDisplayed());
			System.out.println(driver.getTitle());
			System.out.println("Third Priorty Test");
		}

		@AfterMethod
		void tearDown() {
			System.out.println("This is modification");

			driver.quit();

		}

	}


}
