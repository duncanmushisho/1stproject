package homework;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class WrkPptThree {

	By USERNAME = By.id("username");
	By PASSWORD = By.id("password");
	By LOGIN = By.name("login");
	By DASHBOARD = By.xpath(" //h2");
	By TRANSACTION = By.xpath("//span[contains(text(),'Transactions')]");
	By NEWDEPO = By.xpath("//a[contains(text(),'New Deposit')]");
	By NEWACCOUNT = By.xpath("//span[@id='select2-account-container']");
	By DESCRIPTION = By.xpath("//*[@id=\"description\"]");
	By AMOUNT = By.xpath("//input[@id='amount']");
	String userName = "demo@techfios.com";
	String passWord = "abc123";

	WebDriver driver;

	@Before
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mwamb\\Selenium\\1stSelenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void login() throws InterruptedException {

		driver.findElement(USERNAME).sendKeys(userName);
		driver.findElement(PASSWORD).sendKeys(passWord);
		driver.findElement(LOGIN).click();
		Assert.assertEquals("page not found", driver.findElement(DASHBOARD).getText(), "Dashboard");
		driver.findElement(TRANSACTION).click();

		Thread.sleep(3000);

		driver.switchTo().parentFrame();
		driver.findElement(NEWDEPO).click();

		Thread.sleep(3000);

		driver.switchTo().parentFrame();
		driver.findElement(NEWACCOUNT).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//li[@id='select2-account-result-y0ij-Techfios']")).click();
//		WebElement dd = driver.findElement(By.xpath("//*[@id=\"select2-account-container\"]")); 
//		Select  sel = new Select(dd);
//		sel.selectByVisibleText("Techfios");
		
		
//		driver.switchTo().parentFrame();
//		driver.findElement(By.xpath("//*[@id=\"select2-account-result-akzg-bbbb\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("Money");

		driver.findElement(AMOUNT).sendKeys("10,0000");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

	}
	//*[@id="select2-account-result-akzg-bbbb"]
}
