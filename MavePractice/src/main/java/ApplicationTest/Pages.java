package ApplicationTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {
	
	public static WebDriver driver;
	
	public void SqlConnect() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String Sql1="";
		ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver");

//		Connection con= DriverManager.getConnection("jdbc:mysql://root@localhost/firstdb");
		Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/information", "root","dP_k99j@");
		
		Statement stmt=con.createStatement();
		 
		Sql1="SELECT * FROM userinfo";
		rs=stmt.executeQuery(Sql1);
		 while(rs.next()) {
			 System.out.println(rs.getString("name"));
		 }
		
	}
	
	 public static void Chromedriver() {
		  
		 // System.setProperty("webdriver.chrome.driver",
		  //"C:\\Users\\HP\\eclipse-workspace\\PracticeProject\\lib\\src\\main\\resources\\Drivers\\chromedriver.exe");
		  
		  ChromeOptions chrome=new ChromeOptions();
		  chrome.addArguments("--remote-allow-origins=*"); driver = new
		  ChromeDriver(chrome); driver.manage().window().maximize();
		  }
		 

		public static void EdgeDriver() {
			
			// System.setProperty("webdriver.edge.driver",
				//		"C:\\Users\\HP\\eclipse-workspace\\PracticeProject\\lib\\src\\main\\resources\\Drivers\\msedgedriver.exe");
			
			 
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		public static void WaitforVisiblityof(WebDriver driver1, WebElement element, long timeout) throws Exception {
			new WebDriverWait(driver1, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));

		
		}
		

}
