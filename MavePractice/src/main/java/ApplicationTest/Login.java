package ApplicationTest;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Pages {
	@FindBy(xpath="//*[@autocomplete='username']")
	 public static WebElement UserName;
	 
	 @FindBy(xpath="//*[@placeholder='Password']")
	 public static WebElement Password;
	 

	 @FindBy(xpath="//*[contains(text(),'Submit')]")
	 public static WebElement SubmitBtn;
	
	 
	 @FindBy(xpath="//*[@id='logout-trigger']")
	 public static WebElement Logout;
	
	
	
	public static void LoginApp() throws Exception {
		
		ParseJSON JP=new ParseJSON();
		JSONObject JsonObj=JP.JSONparse();
		
		String UName=(String)JsonObj.get("UserName");
		String Pwd =(String)JsonObj.get("Password");
		String URL =(String)JsonObj.get("URL");
		
		
		  Chromedriver();
		  //EdgeDriver();
		  driver.navigate().to(URL); 

	     PageFactory.initElements(driver,Login.class);
		 WaitforVisiblityof(driver,SubmitBtn,20);
		 UserName.sendKeys(UName);
		 Password.sendKeys(Pwd);
		 SubmitBtn.click();
		
		 //WaitforVisiblityof(driver,Logout,20);
		 //Logout.click();

}
	
	
	
	

}
