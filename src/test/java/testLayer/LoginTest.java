package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basePacakage.BaseHRMClass;
import pompacakage.pomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	pomLogin Log;
	
	public LoginTest() {
		super();
	}
		
		@BeforeMethod
		public void initsetup() {
			initiate();
			screenshots("Login");
			Log=new pomLogin();			
		}
		
		@Test(priority=1)
		public void Tittle() {
		String actual=Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
		//Assert.assertEquals(actual,"Walmart Canada");
		}
		@DataProvider
		public Object[][] Details(){
			Object result[][]=ExcelSheet.readdata("Sheet1");
			return result;
		}
		
		@Test(priority=2, dataProvider="Details")
		public void Login(String name, String password) {
			Log.typeUsername(name);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.typepassword(password);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Log.clickbtn();
			
			
		}
		
		@AfterMethod
		public void close() {
			driver.close();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	


