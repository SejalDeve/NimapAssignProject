package com.nimap.MachineTest1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	  public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chromedriver","C:\\Users\\LENOVO\\Downloads\\chromedriver-win64\\chromedriver-win64.exe");
    WebDriver driver = new ChromeDriver();
   driver.manage().window().maximize();
   Thread.sleep(3000);
    driver.get("https://testffc.nimapinfotech.com/");
    
   driver.findElement(By.name("username")).sendKeys("sejaldeve123@gmail.com");
	  
   /* driver.findElement(By.name("password")).sendKeys("Betafield@456");
    WebElement username=driver.findElement(By.name("username"));
    username.sendKeys("sejaldeve123@gmail.com");
    WebElement password =driver.findElement(By.name("password"));
    password.sendKeys("Betafield@456");*/
   
   driver.findElement(By.id("kt_login_signin_submit")).click();

	  
}
}