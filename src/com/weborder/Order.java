package com.weborder;


import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Order {
	

	
public static void main(String[] args) throws InterruptedException {

	
	Random random = new Random();
	int result = random.nextInt(100);
	
	Random random1 = new Random();
	int num = random1.nextInt(90);

	while(result<65) {
		num = random1.nextInt(90);
	}
	char c = (char) num;
	String s = c+".";
	
	System.setProperty("webdriver.chrome.driver",
			"/Users/fozbek/Documents/selenium dependencies/drivers/chromedriver");
	
	WebDriver driver =new ChromeDriver();
	
	driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	
	Thread.sleep(2000);
	
	driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
	
	
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(String.valueOf(result));

	driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + s + "Smith");
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("CA");
	
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Piscataway");
	
	Random random2 = new Random();
	int zip = random2.nextInt(99999);
	
	while(zip<10000) {
		zip=random2.nextInt(99999);
	}
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(String.valueOf(zip));
	
	Random card = new Random();
	int cardType = card.nextInt(3);
	
	Random cardNumber = new Random();
	int cardX = cardNumber.nextInt(10);
	
	System.out.println(cardType);
	if(cardType==0) {
		driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_0']")).click();
		StringBuilder sb = new StringBuilder();
		sb.append(4);		
		for (int i = 0; i <= 15; i++) {		
			sb.append(cardNumber.nextInt(10));
		}
	         
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());
		
	}else if (cardType==1) {
		driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_1']")).click();
		StringBuilder sb = new StringBuilder();
		sb.append(5);		
		for (int i = 0; i <= 15; i++) {		
			sb.append(cardNumber.nextInt(10));
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());
		
	}else if(cardType==2) {
		driver.findElement(By.cssSelector("label[for='ctl00_MainContent_fmwOrder_cardList_2']")).click();
		StringBuilder sb = new StringBuilder();
		sb.append(3);		
		for (int i = 0; i <= 14; i++) {		
			sb.append(cardNumber.nextInt(10));
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(sb.toString());

    }
	driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("05/23");
	
	driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
	
	String expected = "New order has been successfully added.";

	String actual = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong"))
			.getText();
	System.out.println(actual);
	if(expected.equals(actual))
		System.out.println("Expected result matches the actual result.");
	else
		System.out.println("Expected result does not match the actual result.");
		
	}
	
	//driver.close();
}