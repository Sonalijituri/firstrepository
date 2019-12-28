//this testscripts opens message list and next opens send message.
package Alert;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Alert {
	WebDriver driver;
   @Test
	  public void Alertmsg() {
		
		  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
		  driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
		  driver.findElement(By.xpath("//input[@value='1']")).click();

		  driver.findElement(By.xpath("//input[@value='2']")).click();
		  driver.findElement(By.xpath("//input[@value='3']")).click();
		  driver.findElement(By.xpath("//input[@value='4']")).click();
		  driver.findElement(By.xpath("//input[@value='Submit']")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/span[2]")).click();
		  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/ul/li[1]/span[2]")).click();
		  Select Messagebox  = new Select(driver.findElement(By.id("messageBoxSelect")));
			Messagebox.selectByVisibleText("Sent items");
			 Select Categories  = new Select(driver.findElement(By.id("categoriesSelect")));
				Categories.selectByVisibleText("Administration");
				driver.findElement(By.id("newButton")).click();
				
				String expected= "Send message";
				String actual = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
				Assert.assertEquals(actual, expected);
				
						
				

	  }	  

  @BeforeMethod
  public void beforeMethod() {
	  driver.get("http://localhost:8585/");
	
	 
		 
  }
  

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
	  
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	  driver = new ChromeDriver();

  }

  @AfterTest
  public void afterTest() {
	

  }

}
