package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  
	  System.out.println("The thread ID for chrome is "+ Thread.currentThread().getId());
		
		  String dir =System.getProperty("user.dir"); 
		  
		  String chromedriverlocation= dir + "\\/src/test/java\\driver/chromedriver.exe";
		  System.setProperty("webdriver.chrome.driver", chromedriverlocation);
		 
		  //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");  //for runnable jar file use this and pc should have Drivers folder --> chromedriver.exe
	  
		
	  WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/"); 
		Thread.sleep(1000);
		
		
		
		List<WebElement>  links = driver.findElements(By.cssSelector("a"));
		
		System.out.println(links.size());
		for (WebElement x : links) {
		String t=x.getText();
		
			//if (x.isDisplayed()) {
			System.out.println(x.isDisplayed());
			
			System.out.println(x.getAttribute("href"));
			System.out.println("------------------------------------------------------------------------");
			
			
			}

	  driver.close();
	  
  }
  
  @Test
  public void f1() throws InterruptedException {
	  System.out.println("The thread ID for chrome is "+ Thread.currentThread().getId());
		
		
		  String dir =System.getProperty("user.dir");
		  String chromedriverlocation= dir + "\\/src/test/java\\driver/chromedriver.exe";
		  
		  System.setProperty("webdriver.chrome.driver", chromedriverlocation);
		 
	  //System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); 
	  		
	         WebDriver driver = new ChromeDriver();
	         String expm= "January 2022";
	 		 String exd="8";
	
		driver.get("https://www.trivago.in/"); 
	    driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@key='checkInButton']/span")).click();
		Thread.sleep(1000);
		String currm= driver.findElement(By.xpath("//div[@class='two-month-calendar']/descendant::table[1]/descendant::th/child::*")).getText();
		System.out.println(currm);
	    int c =0;
		while (!currm.contains(expm)) {
		
			driver.findElement(By.cssSelector("button.cal-btn-next")).click();;
			c++;
			Thread.sleep(1000);
			currm=driver.findElement(By.xpath("//div[@class='two-month-calendar']/descendant::table[1]/descendant::th/child::*")).getText();
			if(c==12) {
				break;
			}
			}
		
		List<WebElement> dates= driver.findElements(By.xpath("//div[@class='two-month-calendar']/descendant::table[1]/descendant::td"));
		for(WebElement date:dates) {
			String x=date.getText().trim();
			if(x.equals(exd)) {
				date.click();		
				}
		}
	driver.close();	
	//Assert.assertTrue(false);
	
	
	
  }  

  
  
}
