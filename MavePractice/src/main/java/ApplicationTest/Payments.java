package ApplicationTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Payments extends Pages{


	 @FindBy(xpath="//*[contains(text(),' Pay user ')]")
	 public static WebElement PayUser;
	 
	 @FindBy(xpath="//*[@class='btn btn-icon ml-2']")
	 public static WebElement ToUserList;
	 
	 @FindBy(xpath="//*[contains(text(),' Car repair ')]")
	 public static WebElement Car_Repair ;
	 
	 @FindBy(xpath="//input[@id='id_3']")
	 public static WebElement AmountEnter;
	 
	 @FindBy(xpath="//*[@class='form-control text-left custom-select w-100']")
	 public static WebElement SelectScheuling;
	 
	 @FindBy(xpath="//*[contains(text(),' Recurring payments ')]")
	 public static WebElement RecurringPayments;
	 
	 @FindBy(xpath="//*[contains(text(),' Pay now ')]")
	 public static WebElement  Pay_now ;
	
	 
	 @FindBy(xpath="//*[@type='button']/../*[@class='btn d-flex justify-content-center align-items-center w-100 h-100 btn-primary']")
	 public static WebElement NextBtn;
	 
	 @FindBy(xpath="//*[@rows='3']")
	 public static WebElement DescriptionSpace;
	 
	 @FindBy(xpath="//*[@type='button']/../*//*[contains(text(),'Confirm')]")
	 public static WebElement  Confirm_Btn ;
	 
	 
	
	 
	
	@Test
	 public static void PaymentPage() throws Exception {
		
		
		
		SqlConnection Sql1=new SqlConnection();
		Connection con=Sql1.connection();
		Statement Stmt=con.createStatement();
		
		
		String Sql2="";
		ResultSet rs;
		
		Sql2="SELECT * FROM userinfo";
		rs=Stmt.executeQuery(Sql2);
		 while(rs.next()) {
			 System.out.println(rs.getString("name"));
		 }
		 con.close();
		Login.LoginApp();
	    PageFactory.initElements(driver,Payments.class);
			WaitforVisiblityof(driver,PayUser,20);
			PayUser.click();
			WaitforVisiblityof(driver,ToUserList,20);
			ToUserList.click();
			WaitforVisiblityof(driver,Car_Repair,20);
			Car_Repair.click();
			WaitforVisiblityof(driver,AmountEnter,20);
			AmountEnter.sendKeys("200");
			WaitforVisiblityof(driver,DescriptionSpace,30);
			DescriptionSpace.sendKeys("Paid");
			Thread.sleep(2000);
			WaitforVisiblityof(driver,NextBtn,40);
			NextBtn.click();
			WaitforVisiblityof(driver,Confirm_Btn,40);
			Confirm_Btn.click();
		Logout.LogoutApp();
			
		
}


}
