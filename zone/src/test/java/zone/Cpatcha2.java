package zone;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Cpatcha2 
{
	public static void main(String[] args) throws IOException, TesseractException 
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("disable-notifications");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://captcha.com/articles/captcha-best-practices.html");
		
		WebElement captcha=driver.findElement(By.xpath("(//img[contains(@alt,'BotDetect CAPTCHA  image style screenshot')])[1]"));
		
		TakesScreenshot sc=(TakesScreenshot)captcha;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dsc= new File("./captcha2.png");
		FileHandler.copy(src, dsc);
		
		Tesseract ts = new Tesseract();
		
		ts.setDatapath("C:\\Users\\Mounika1\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String image = ts.doOCR(dsc);
		System.out.println(image);
		
		
		
	}

}
