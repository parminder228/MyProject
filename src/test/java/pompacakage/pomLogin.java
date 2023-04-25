package pompacakage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePacakage.BaseHRMClass;

public class pomLogin extends BaseHRMClass{
	
	
	//object repository
	//@FindBy(css="div.oxd-form-row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)") 
	@FindBy(id="txtUsername") 
//	@FindBy(css ="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
	WebElement Username;
	//@FindBy(css="div.oxd-form-row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)")
	@FindBy(id="txtPassword")//div.oxd-form-row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)
	//@FindBy(cssselector ="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
	WebElement Password;
	@FindBy(id="btnLogin")
	//@FindBy(css=".css-vfxkzw")//css-vfxkzw edzik9p0
	//@FindBy(css =".oxd-button")
	WebElement Login;
	//.oxd-button
	
	
	/*
	@FindBy(xpath="//*[@name='username']")
	WebElement Username;
	@FindBy(xpath="//*[@name='password']")
	WebElement Password;
	@FindBy(css ="//button[@type='submit']")
	WebElement Loginbtn;
	*/
	
	//initiate page elements
	public pomLogin() {
		
		PageFactory.initElements(driver, this);
	}
		
		public void typeUsername(String name) {
			
	 Username.sendKeys(name);
	}
		public void typepassword(String pass) {
			Password.sendKeys(pass);
		}
	public void clickbtn() {
		Login.click();
		}
	public String verify() {
		return driver.getTitle();
	}
	
	
	
	
	
	
	

}
