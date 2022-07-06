package com.vndly.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DeleteTodo {
	
	@Test
	public void deleteTodo() {
		//find browser driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\chromedriver.exe");
		
		//initialize browser driver as 'driver'
		WebDriver driver = new ChromeDriver();
		
		//load up the website to test
		driver.get("https://qa-challenge.beta.vndly.com/");
		
		//select delete button element
		WebElement deleteBtn = driver.findElement(By.xpath("//button[@data-testid='todo-list-item-delete']"));
		
		//automate clicking action to delete
		deleteBtn.click();
		
		//output when the action is performed 
		System.out.println("You have deleted a todo. Yay!");
	}

}
