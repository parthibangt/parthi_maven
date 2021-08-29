package Projectng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Main {

	private static 
	FileInputStream f;
	Properties p;
	WebDriver driver;
	Actions a;
	JavascriptExecutor jse;
	TakesScreenshot ts;
	
	
	@BeforeTest
	@Parameters("browsername")
	private void Browser(String browsername) throws IOException {
		
		f = new FileInputStream("pp.properties");
		p= new Properties();
		p.load(f);
		
		if(browsername.equalsIgnoreCase("chrome")) 
		{

			//System.setProperty("system", "path");
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\PARTHIBAN\\\\eclipse-workspace\\\\Selenium\\\\Driver\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(p.getProperty("url"));
						}
	}
	
		@DataProvider (name="correct")
		private Object[][] datas() throws IOException
		{
		File f = new File(p.getProperty("excelpath"));
		FileInputStream excel = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(excel);
		Sheet sheet = wb.getSheet("project");
		Row r = sheet.getRow(0);
		int rcount = sheet.getPhysicalNumberOfRows();
		System.out.println(rcount);
		Cell c = r.getCell(rcount);
		int ccount = r.getPhysicalNumberOfCells();
		Object[][]tot=new Object[rcount][ccount];
		
		
		for (int i = 0; i < rcount; i++)
		{
			for (int j = 0; j < ccount; j++)
			{
				Row r1 = sheet.getRow(i);
				Cell val = r1.getCell(j);
				String s = val.getStringCellValue();
				System.out.println(s);
				tot[i][j]=s;
				}
		}
		return tot;
		
		}
		
			@Test (dataProvider="correct")	
		private void mth (String username , String password) throws InterruptedException, IOException
		{
			PageFactory.initElements(driver, Elements.class);
			
			
			Elements.email.sendKeys(username);
			Elements.password.sendKeys(password);
			Elements.login.click();
			Elements.menu.click();
			a = new Actions(driver);
	    	a.moveToElement(Elements.mouseover).build().perform();
	    	a.moveToElement(Elements.addtocartbutton).click().build().perform();
		Thread.sleep(5000);
		Elements.addcart.click();
		Elements.column.click();
		Elements.button.click();
		Elements.agree.click();
		Elements.checkout.click();
		Elements.payment.click();
		Elements.confirm.click();
		a = new Actions(driver);
    	a.moveToElement(Elements.news).build().perform();
    	Thread.sleep(3000);
    	System.out.println("hi");
    	ts = (TakesScreenshot) driver;
   	 	File so = ts.getScreenshotAs(OutputType.FILE);
   		File Dec = new File("C:\\Users\\PARTHIBAN\\eclipse-workspace\\Selenium\\Screenshot\\confirm.png");
   		FileHandler.copy(so, Dec);
   		System.out.println("how");
		Elements.backtoorder.click();
		System.out.println("are");
		//a.moveToElement(Elements.price).build().perform();
		Thread.sleep(3000);
		ts=(TakesScreenshot)driver;
		   	 File so2 = ts.getScreenshotAs(OutputType.FILE);
		   		File Dec2 = new File("C:\\Users\\PARTHIBAN\\eclipse-workspace\\Selenium\\Screenshot\\history.png");
		   	FileHandler.copy(so2, Dec2);
		
			}
	@AfterSuite
		private void closebrowser() {
			driver.close();
		}
	}