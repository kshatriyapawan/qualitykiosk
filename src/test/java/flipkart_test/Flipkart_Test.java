package flipkart_test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Flipkart_Test {
	WebDriver driver=null;
  @Test
  public void f() throws InterruptedException {
//	  try {
	  String driverPath="/home/pawan/Desktop/chromedriver";
	  System.setProperty("webdriver.chrome.driver", driverPath);
	  String url="https://www.flipkart.com/";
	  String search_string="Samsung Galaxy S10";
	  driver=new ChromeDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  WebDriverWait wait=new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@tabindex='-1']/div/button")));
	  driver.findElement(By.xpath("//*[@tabindex='-1']/div/button")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='q']")));	
	  driver.findElement(By.xpath("//*[@name='q']")).sendKeys(search_string);
	  driver.findElement(By.xpath("//*[@type='submit']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='Mobiles']")));
	  driver.findElement(By.xpath("//*[@title='Mobiles']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div[1]/div/section[3]/label/div[1]")));
	  driver.findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div[1]/div/section[3]/label/div[1]")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='SAMSUNG']")));
//	  JavaScriptExecutor js=(JavaScriptExecutor)driver;
	  WebElement brand=driver.findElement(By.xpath("//div[text()='SAMSUNG']"));
	  Actions ac=new Actions(driver);
	  ac.moveToElement(brand).build().perform();
	  ac.click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Price -- High to Low']")));
	  driver.findElement(By.xpath("//div[text()='Price -- High to Low']")).click();
	  List<WebElement> res=driver.findElements(By.xpath("//*[@class='_2kHMtA']"));
	  for(int i=0;i<res.size();i++)
	  {
		  String prod_name=driver.findElement(By.xpath("//*[@class='_3pLy-c row']/div[1]/div")).getText();
		  String mrp=driver.findElement(By.xpath("//*[@class='_3pLy-c row']/div[2]/div/div/div")).getText();
		  String link_text=driver.findElement(By.xpath("//*[@class='_2kHMtA']/a")).getAttribute("href");
		  System.out.println(prod_name+mrp+link_text);
	  }
	  driver.close();
//	  }catch(Exception e)
//	  {
//		  
//		  System.out.println(e);
//		  driver.close();
//	  }
	  
  }
}
