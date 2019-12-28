//this testscripts shows the execution of send message with invalid details
package sendmsg002;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SendMessage {
	WebDriver driver;
  @Test
  public void sendmsg() throws InterruptedException {
	  driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
	  driver.findElement(By.id("cyclosPassword")).sendKeys("1234");
	  driver.findElement(By.xpath("//input[@value='1']")).click();

	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/span[2]")).click();
	  driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li[9]/ul/li[1]/span[2]")).click();
	  driver.findElement(By.id("newButton")).click();
	  driver.findElement(By.id("memberUsername")).sendKeys("saanvi");
	  driver.findElement(By.id("memberName")).sendKeys("saanvi");
	 Thread.sleep(3000);
	  Select category  = new Select(driver.findElement(By.id("categorySelect")));
		category.selectByValue("2");
		
	  driver.findElement(By.id("subjectText")).sendKeys("asdfghjkewdrjhklwesdruhlesdfghjkleertyuikjhcvbnm");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//iframe[@title='Rich text editor, bodyText']")).click();
	  Thread.sleep(3000); 
	  driver.switchTo().frame(0);
	  driver.findElement(By.xpath("//body//p")).sendKeys("yooo");
	  Thread.sleep(3000); 
	  driver.switchTo().defaultContent();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
	  String expresult = "The message was unsuccessfully sent";
	  Alert alert = driver.switchTo().alert();
	 String actresult = alert.getText();
	 System.out.println(actresult);
	 Assert.assertTrue(actresult.contains(expresult));
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
