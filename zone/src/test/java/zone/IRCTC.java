package zone;

import java.io.IOException;
import java.time.Duration;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;
//import zone.Captcha1;

@Test
public class IRCTC 
{ 
	
	WebDriver driver;
	
	public void irctc() throws InterruptedException, IOException, TesseractException
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.navigate().to("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(2000);
	
		String mainWin = driver.getWindowHandle();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for(int i=0;i<3;i++)
		{
			js.executeScript("window.scrollBy(0,300)");
			Thread.sleep(1000);
		}
		
		WebElement hotel = driver.findElement(By.cssSelector("span[class='allcircle circletwo']"));
		hotel.click();
		
		Set<String> all = driver.getWindowHandles();
		
		for(String win:all)
		{
			driver.switchTo().window(win);
			String title = driver.getTitle();
			System.out.println(title);
			if(title.contains(win))
			{
				break;
			}
		}
		WebElement place = driver.findElement(By.id("inputbox"));
		place.sendKeys("Anantapur , City in Andhra Pradesh");
		
		Thread.sleep(4000);
		List<WebElement> AllPlaces = driver.findElements(By.xpath("//li"));
		for(WebElement allP:AllPlaces)
		{
			
			if(allP.equals(place))
			{
				allP.click();
			}
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Check-in Date']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='2024']/ancestor::div[@class='bs-datepicker-head']//span[text()='September']/ancestor::div[@class='bs-calendar-container ng-tns-c20-1']/descendant::span[text()='24']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Check-out Date']")).click();
		
		int year=2024;
		String month="November";
		int date=12;
//		driver.findElement(By.xpath("//span[text()="+year+"]/ancestor::div[@class='bs-datepicker-head']//span[text()="+month+"]/ancestor::div[@class='bs-datepicker ng-tns-c20-2 theme-dark-blue ng-star-inserted']/descendant::span[text()="+date+"]"));
	
		for(;;)
		{
			try
			{
			driver.findElement(By.xpath("//span[text()='2024']/ancestor::div[@class='bs-datepicker-head']//span[text()='November']/ancestor::div[@class='bs-datepicker ng-tns-c20-2 theme-dark-blue ng-star-inserted']/descendant::span[text()='12']")).click();
			
			}
		
			catch(Exception i)
			{
				driver.findElement(By.xpath("//button[@class='next']")).click();
			}
			break;
		}
		
		driver.findElement(By.xpath("//input[@formcontrolname='guest']")).click();
		WebElement rooms = driver.findElement(By.xpath("//select[@formcontrolname='rooms']"));
		
		Select sel = new Select(rooms);
		sel.selectByVisibleText("4");
		
		WebElement adults = driver.findElement(By.xpath("//select[@formcontrolname='adults']"));
		Select sel1=new Select(adults);
		sel1.selectByVisibleText("7");
		
		WebElement child = driver.findElement(By.xpath("//select[@formcontrolname='childs']"));
		Select sel2=new Select(child);
		sel2.selectByVisibleText("4");
		
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		
		Thread.sleep(2000);
		driver.switchTo().window(mainWin);
		
		
		Captcha1 capt= new Captcha1();
		capt.cap();
		
		
	}

}
