package object.cloning;

import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver implements Cloneable{
	
	
	ChromeDriver superdriver = new ChromeDriver();
	

	public Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	} 
	
	

}
