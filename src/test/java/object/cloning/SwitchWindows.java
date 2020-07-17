package object.cloning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindows {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		
		WebDriverManager.chromedriver().setup();
		
		BaseDriver driverThread1 = new BaseDriver();
		
		driverThread1.superdriver.get("http://www.leafground.com/pages/Window.html");

		String parentWindow = driverThread1.superdriver.getWindowHandle();
		
		driverThread1.superdriver.findElement(By.id("home")).click();
		
		Set<String> allwinhandles = driverThread1.superdriver.getWindowHandles();
		List<String> allhandles = new ArrayList<>();
		for (String handle : allwinhandles) {
			allhandles.add(handle);
		}
		
		driverThread1.superdriver.switchTo().window(allhandles.get(1));
		
		driverThread1.superdriver.close();
		
		BaseDriver driverThread2 = (BaseDriver)driverThread1.clone();
		
		driverThread2.superdriver.switchTo().window(parentWindow);
		
		System.out.println(driverThread2.superdriver.getTitle());
		
		driverThread2.superdriver.close();
		
	}

}
