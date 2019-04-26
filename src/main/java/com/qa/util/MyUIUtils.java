package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyUIUtils {
	
	WebDriver driver;
	
	
	public MyUIUtils(WebDriver driver){
		this.driver=driver;
	}
	
	public static void Input(WebElement we, String ValueToInput) throws IOException, InterruptedException{
		//WebElement we= getWebElement(ORElementName);
		we.clear();
	//String ValueToInput=getTestData(ORElementName);
		we.sendKeys(ValueToInput);
	}
	
	public void click(WebElement we) throws IOException, InterruptedException{
//		WebElement we=getWebElement(ORElementName);
		//System.out.println(we.getText());
		we.click();
	}
	
	public void click(List<WebElement> we){
		 // we=MyUIUtils.getListWebElement("Standard_Division_SelectAllDivisionGroup2");
		  int count= we.size();
		  System.out.println(count);
		  for(int i=1;i<=count-1;i++){
			  WebElement webelement= we.get(i);
			  webelement.click();
		}
	}
	
	public  void PressEnterKey(WebElement we) throws IOException, InterruptedException{
		//WebElement we = getWebElement(ORElementName);
		we.sendKeys(Keys.RETURN);
	}
	
	public String getText(WebElement we) throws IOException, InterruptedException{
		//WebElement we=getWebElement(ORElementName);
		return(we.getText());

		}
	
	public  void ActionMouseHover(WebElement we) throws IOException, InterruptedException{
		 Actions clicker=new Actions(driver);
	//	WebElement we= getWebElement(ORElementName);
		clicker.moveToElement(we).build().perform();
		
	}
	
	public void ActionDoubleclick(WebElement we) throws IOException, InterruptedException{
		 Actions clicker = new Actions(driver);
		//WebElement we= getWebElement(ORElementName);
		   Actions eventopen=clicker.doubleClick(we);
		   eventopen.build().perform();
	}
	
	public  void uploadResume(String filepath) throws IOException, AWTException, InterruptedException{
		//UIUtil.fn_click("SelectTypeuplopadResume_RB");
		//UIUtil.fn_hoverandclick("uploadResume_BTN","null");
		//put path to your image in a 
		   StringSelection ss = new StringSelection(filepath);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		   //imitate mouse events like ENTER, CTRL+C, CTRL+V
		   Robot robot = new Robot();
		   robot.keyPress(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_V);
		   robot.keyRelease(KeyEvent.VK_CONTROL);
		   robot.keyPress(KeyEvent.VK_ENTER);
		   robot.keyRelease(KeyEvent.VK_ENTER);
		   Thread.sleep(3000);
		}
	
	public void uploadAncillary(String filepath) throws InterruptedException, AWTException{
		 StringSelection ss = new StringSelection(filepath);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		 Thread.sleep(1000);
		      
		  // Press Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		// Release Enter
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		  // Press CTRL+V
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_V);
		 
		// Release CTRL+V
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(1000);
		        
		       //  Press Enter 
		 robot.keyPress(KeyEvent.VK_ENTER);
		 robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void SwitchtoWindow(){
		String child = driver.getWindowHandle();
		
		driver.switchTo().window(child);    //// SwitchTo().Frame("popupFrame")
	}
	
	public  void click(List<WebElement> we, int x, int y){
		int z= random(x,y);
		System.out.println(z);
		//int count=we.size();
		//System.out.println(count);
		WebElement webelement=we.get(z);
		System.out.println(webelement);
		webelement.click();
			}
	
	public  int random(int min,int max){
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		   return randomNum;
		}
	
	public  void JSScroll(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)", "");///// Original value was 700 instead of 300
	
	}
	
	public  void JSScroll1100(){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1100)", "");///// Original value was 700 instead of 300
	
	}
	 public void JSScrollup(){
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("window.scrollBy(0,-400)", "");
		 }
	 
	 public  int clickRandom(List<WebElement> we){
			int count=we.size();
			if(count>1){
			int z=random(1,count);
			count=z;
			System.out.println(z);
			for(int i=0;i<=z-1;i++){
			 WebElement webelement= we.get(i);
			 webelement.click();
			}
			}
			return count;
		}
	 public void fn_verifynum(int actual, int expected){
			if(actual==expected){
			Assert.assertEquals(actual,expected);
			System.out.println("Pass");
			}
			else
			{
			System.out.println("Failed");
			}
			}
	
	
	 public  String currentTimeStamp(){
		 Calendar calendar = Calendar.getInstance();
		 String randomvalue=new java.sql.Timestamp(calendar.getTime().getTime()).toString();
		 return randomvalue;
		 }
	 
	 public  void ActionScrollAndClick(WebElement we) throws IOException, InterruptedException{
			Actions	clicker = new Actions(driver);
			    clicker.sendKeys(Keys.PAGE_DOWN);
		      //  WebElement we= getWebElement(ORElementName);
		        clicker.click(we).perform();
			}

	 public  void search(WebElement we, String searchText, WebElement we1) throws IOException, InterruptedException{
			Input(we, searchText);
			Thread.sleep(5000);
			click(we1);
		}
	 	 
	public  void fn_verifytext(WebElement we, String expected) throws IOException, InterruptedException{
		//WebElement we = getWebElement(ORElementName);
		String actual=we.getText();
		System.out.println(actual);
		if(expected.equalsIgnoreCase(actual)){
		System.out.println("Pass");
		}else{
			Thread.sleep(5000);
		Assert.assertEquals(actual, expected);
		System.out.println("Fail");
		}
		}
	
	public void CustomWaitandClick(int waitime, WebElement we) throws IOException, InterruptedException{
	WebDriverWait wait1= new WebDriverWait(driver, waitime);
	//WebElement element1= wait1.until(ExpectedConditions.elementToBeClickable(we));
	WebElement element1= wait1.until(ExpectedConditions.visibilityOf(we));
   // click(element1);
	Actions clicker=new Actions(driver);
	clicker.moveToElement(element1).click().build().perform();
	}
	
	public void CustomWauntilloaderdisaapear(int waitime, WebElement we) throws IOException, InterruptedException{
		WebDriverWait wait1= new WebDriverWait(driver, waitime);
		//WebElement element1= wait1.until(ExpectedConditions.elementToBeClickable(we));
		wait1.until(ExpectedConditions.invisibilityOf(we));
	   // click(element1);
		//Actions clicker=new Actions(driver);
		//clicker.moveToElement(element1).click().build().perform()
		}
	 /**
	* Check page loading is completed.
	*
	*/
	public void verifyLinksActive( String linkUrl){
		try{
			URL url=new URL(linkUrl);
			HttpURLConnection httpURLconnc= (HttpURLConnection)url.openConnection();
			httpURLconnc.setConnectTimeout(3000);
			httpURLconnc.connect();
			if(httpURLconnc.getResponseCode()==200){
				System.out.println(linkUrl + " - " +httpURLconnc.getResponseMessage() );
			}
			
		}
		catch(Exception e){
			
		}
		
		
		
	}
	
	
}		

