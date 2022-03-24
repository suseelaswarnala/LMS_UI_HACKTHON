package actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import stepdef.Login;



public class Actions {
	WebDriver driver;
	public Actions() throws Exception {
		Login login=new Login();
		login.driver=driver;
		}


	public void takeScreenshot(String fileName) throws IOException {
		// 1.take screenshot and store it as a file format:
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// now copy the screenshot to desired location using copyFile method:
		FileUtils.copyFile(file, new File("C:\\Users\\ramba\\eclipse-workspace2\\LMS_UI_HACKTHON\\Screenshots" + fileName + ".jpg"));
	}

	// Selecting the calenderdate
	// If february month selected and date is greater than 29 and if in any month,
	// date is greater than 31 then it will return nothing and prints wrong date
	// with given month and year

	public void selectDate(String exDay, String exMonth, String exYear) {
		if (exMonth.equals("February") && Integer.parseInt(exDay) > 29) {
			System.out.println("Wrong date:" + exMonth + ":" + exDay);
			return;
		}
		if (Integer.parseInt(exDay) > 31) {
			System.out.println("wrong date:" + exMonth + ":" + exDay);
			return;
		}
		String monthYearVal = driver.findElement(By.id("ui-datepicker-title")).getText();
		// System.out.println(monthYearVal);

		// month year
		String[] monthYear = monthYearVal.split(" ");
		// when month and year does not match,keep looping
		while (!(monthYear[0].equals(exMonth) && monthYear[1].equals(exYear)))
			driver.findElement(By.xpath("//a[@title='Next'")).click();

		monthYearVal = driver.findElement(By.className("ui=datepicker-title")).getText();
		try {
			driver.findElement(By.xpath("//a[text()='" + exDay + "']")).click();
		} catch (Exception e) {
			System.out.println("wrong date:" + exMonth + ":" + exDay);
		}
	}

	// Admin checks total no.of rows
	// It will store the total no.of.rows (Elements) in the List
	public int acount() {
		List<WebElement> Assignmentlist = driver.findElements(By.className("Assignment List"));
		int count = Assignmentlist.size();
		return count;

	}

}

