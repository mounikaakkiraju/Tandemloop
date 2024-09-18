package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp 
{
	public SignUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first-name")
	private WebElement Firstname;
	
	@FindBy(id="lastName")
	private WebElement Lastname;
	
	@FindBy(id="email")
	private WebElement Email;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="check-password")
	private WebElement Cnfrmpass;
	
	@FindBy(xpath = "//label[contains(@class,'ant-checkbo')]")
	private WebElement checkBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	



    public void signUpPage(String Fname,String Lname,String email,String pass,String Cpass)
    {
         Firstname.sendKeys(Fname);
         Lastname.sendKeys(Lname);
         Email.sendKeys(email);
         password.sendKeys(pass);    
         Cnfrmpass.sendKeys(Cpass);
         checkBox.click();
         submit.click();
    }
    
}