package assementeByDarma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_OverActions {

	static WebDriver driver;
	WebElement element;

	public void Broswer(String URL) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}

	public void locateElement(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			element = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equals("name")) {
			element = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equals("className")) {
			element = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equals("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equals("tagName")) {
			element = driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equals("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
	}
	
	public void locateElementAndClick(String locatorType, String locatorValue) {
		if (locatorType.equals("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equals("name")) {
			 driver.findElement(By.name(locatorValue)).click();;
		} else if (locatorType.equals("className")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorType.equals("xpath")) {
			 driver.findElement(By.xpath(locatorValue)).click();;
		} else if (locatorType.equals("tagName")) {
			  driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorType.equals("css")) {
			 driver.findElement(By.cssSelector(locatorValue)).click();
		}
	}

	
	
	public void Hover(String locatorType, String locatorValue) {
		locateElement(locatorType, locatorValue);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void HoverAndClick(String locatorType, String locatorValue) {
		locateElement(locatorType, locatorValue);
		Actions action = new Actions(driver);
		action.moveToElement(element).click(element).build().perform();
	}

	public static void main(String[] args) throws InterruptedException {
		 Mouse_OverActions  obj = new  Mouse_OverActions ();
		obj.Broswer("https://www.amazon.in/");
		Thread.sleep(1000);
		obj.Hover("xpath", "//span[text()='Category']");
		obj.Hover("xpath", "//span[text()='Home, Kitchen, Pets']");
		obj.HoverAndClick("xpath", "//span[text()='Home Furnishing']");
		obj.locateElementAndClick("xpath", "//button[@class='a-button-text a-text-center']");
		
	}
}





