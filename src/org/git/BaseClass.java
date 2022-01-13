package org.git;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver ;
	public static Actions a;
	
	public static void browserlaunch() {	
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}
	
	public static void launchUrl(String Url) {
	driver.get(Url);	
	}
	
	public static void maxiWindow() {
		driver.manage().window().maximize();
		
	}

	public static void titleGet( ) {
		String title = driver.getTitle();
		System.out.println(title);	
	}

	public static void chromeClose() {
		driver.close();
	}

	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		return currentUrl;
	}
		
	public static void sendvalue(WebElement element,String value) {
	element.sendKeys(value);	
	}
	

	public static void btnclick(WebElement element) {
		element.click();
	}
	

    public static void moveElement(WebElement target) {
		 a = new Actions(driver);
		a.moveToElement(target).perform();
	}

	
	public static void dragAndDrop(WebElement source,WebElement target) {
		a = new Actions(driver);
	
		a.dragAndDrop(source, target).perform();
		
	}
	public static void screenShort(String fileName) throws IOException {
		TakesScreenshot tk =  (TakesScreenshot)driver;
		File screenshotAS = tk.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject1\\screenshot\\"+fileName+".png");
		FileUtils.copyFile(screenshotAS, f);
		
	}
	
	public static String  getData(int rowNumber, int cellNumber, String sheetName, String fileName) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenProject1\\excel\\Testdata.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet(sheetName);
		Row r = s.getRow(rowNumber);
		Cell c = r.getCell(cellNumber);
		int cellType = c.getCellType();
		String value = "";
		
		if (cellType == 1) {
			value = c.getStringCellValue();
			System.out.println("value");
		}else if (cellType == 0 ) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
				value = sim.format(d);
				System.out.println(value);
			}else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long)numericCellValue;
				value = String.valueOf(1);
			}
		}
		return value;
		}
		
	public void ramsai() {
		System.out.println("ramsai updated to his project");
		System.out.println("ramsai pushed second time");
	}
	
	}
	


