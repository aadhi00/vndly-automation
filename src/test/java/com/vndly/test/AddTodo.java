package com.vndly.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddTodo {

	@Test
	public void addTodo() {
		System.setProperty("webdriver.edge.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://qa-challenge.beta.vndly.com/");

		WebElement btnAddTodo = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

		btnAddTodo.click();

		boolean b;
		try {
			WebElement addTodoDialog = driver.findElement(By.className("modal-dialog"));
			b = addTodoDialog.isDisplayed();
		} catch (NoSuchElementException e) {
			b = false;
		}
		
		Assert.assertTrue(b);

		WebElement txtDescription = driver.findElement(By.id("new-todo-text"));
		
		String expDescription = "Test todo";
		
		String expPriority = "low";
		
		String expDuedate = "Wed Jul 06 2022";

		txtDescription.sendKeys(expDescription);

		WebElement ddPriority = driver.findElement(By.id("new-todo-priority"));

		Select select = new Select(ddPriority);

		select.selectByIndex(2);

		List<WebElement> lstTxtFields = driver.findElements(By.xpath("//input[@type='text']"));

		lstTxtFields.get(1).click();

		WebElement date6 = driver
				.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--006']"));

		date6.click();

		WebElement btnSubmit = driver.findElement(By.id("add-todo"));

		btnSubmit.click();
		//race condition
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SoftAssert softAssert = new SoftAssert();
		
		List<WebElement> lstPriority = driver.findElements(By.xpath("//div[@data-testid='todo-list-item-priority']"));

		String actualPriority = lstPriority.get(3).getText();
		
		List<WebElement> lstDescriptions = driver.findElements(By.xpath("//div[@data-testid='todo-list-item-text']"));
		
		String actualDescription = lstDescriptions.get(3).getText();
		
		List<WebElement> lstDueDates = driver.findElements(By.xpath("//div[@data-testid='todo-list-item-due-date']"));
		
		String actualDueDate = lstDueDates.get(3).getText();
		
		softAssert.assertEquals(actualPriority, expPriority, "Priority mismatch");
		
		softAssert.assertEquals(actualDescription, expDescription, "Description mismatch");
		System.out.println("Description matches");
		
		softAssert.assertEquals(actualDueDate, expDuedate, "Due date mismatch");
		System.out.println("Due date matches");
		softAssert.assertAll();
		
		// driver.quit();
	}

}
