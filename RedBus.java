package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		//implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//Load the URL
		driver.get("https://www.redbus.in/");
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//clear the From city
		
		driver.findElement(By.id("src")).clear();
		
		//Enter the From city
		
		driver.findElement(By.id("src")).sendKeys("Chennai");
		
		driver.findElement(By.xpath("//li[@class='selected']/i")).click();
	  //Thread 
		
		Thread.sleep(500);
		//clear the To city
		
	    driver.findElement(By.id("dest")).clear();
	    
	  //Enter the To city
	    
	    driver.findElement(By.id("dest")).sendKeys("Bangalore");
	    
	    driver.findElement(By.xpath("//li[@class='selected']/i")).click();
	    
	    //select date field
	    driver.findElement(By.id("onward_cal")).click();
	    
	    
	    //select date
	    
	    driver.findElement(By.xpath("//tr[@class='rb-monthHeader']/following::td[26]")).click();
	    
	    //click search buses button
	    
	    
	    driver.findElement(By.id("search_btn")).click();
	    
	    
	    //Thread . sleep
	    
	    Thread.sleep(25000);
	    
	    
	    //print the no. of buses found
	    String buses =driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
	    
	    System.out.println("No. of buses found "+ buses);
	    
	    
	    //scroll down
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,200)");
	    
	    //select the sleeper
	    
	    driver.findElement(By.xpath("//label[text()='SLEEPER']")).click();
	    
	    //SCROLL AGAIN
	    js.executeScript("window.scrollBy(0,400)");
	    
	    //print the second bus name
	    
	   String busname= driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
	    
		System.out.println("The second bus name:" +busname);
		
		//click view seats
		
		driver.findElement(By.xpath("(//div[@class='clearfix m-top-16'])[2]/div")).click();
		
		//pop up close
		
		driver.findElement(By.xpath("//div[@class='close-primo']/i")).click();
		
		
		//Thread sleep
		
		Thread.sleep(10000);
		//Take screen shots
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("snap1.png");
		FileUtils.copyFile(source, dest);
		
		System.out.println("screen shot taken");
		
		
		
		
		
		
		
		
		

	}

}
