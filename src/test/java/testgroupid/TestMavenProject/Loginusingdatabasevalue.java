package testgroupid.TestMavenProject;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Loginusingdatabasevalue {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException{
		
		String host = "localhost";
		String port = "3306";
		Connection db = DriverManager.getConnection("jdbc:mysql://" +host+ ":" +port+ "/testdb","Walkydelta","Debajunior");

		Statement stmt = db.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Website_Credential where website_name = 'Facebook'");
		
		while(rs.next())
		{	
			System.setProperty("webdriver.chrome.driver","C:/Users/Debanjan Ghosh/Desktop/Selenium/Downloads/chromedriver_win32/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
			driver.get(rs.getString("url"));
			Thread.sleep(4000);
						
			//Enter username
			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys(rs.getString("username"));
			
			Thread.sleep(2000);
			
			//Enter password
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys(rs.getString("password"));
			Thread.sleep(2000);
			
			//Click on Login button
			driver.findElement(By.id("u_0_b")).click();
			
			Thread.sleep(5000);
			
			driver.quit();
		}
	}

}
