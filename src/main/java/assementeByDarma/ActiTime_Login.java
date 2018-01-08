package assementeByDarma;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;



public class ActiTime_Login {
	static ChromeDriver ff;
	Workbook w1;
	Sheet s1;
	Row r1;

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		String path = "D:/Actitime/Book3.xlsx";
		RandomData rd = new RandomData();
		FileInputStream fis = new FileInputStream(path);
		Workbook w1 = WorkbookFactory.create(fis);
		Sheet s1 = w1.getSheet("Sheet1");
		Row r1 = s1.getRow(1);
		String Fn = r1.getCell(0).getStringCellValue();
		String Ln = r1.getCell(1).getStringCellValue();
		String Email = r1.getCell(2).getStringCellValue();
		String Company = r1.getCell(3).getStringCellValue();
		String Expected = r1.getCell(4).getStringCellValue();

		ff = new ChromeDriver();
		ff.get("https://www.actitime.com/free-online-trial.php");
		ff.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ActiTime_Login gm = new ActiTime_Login();
		gm.gmailSignup(rd.randomName(), Ln, Email, Company, Expected);

		FileOutputStream fos = new FileOutputStream(path);
		w1.write(fos);

	}

	public void gmailSignup(String Fn, String Ln, String Email, String Company, String Expected) {

		ff.findElement(By.name("firstName")).sendKeys(Fn);
		ff.findElement(By.name("lastName")).sendKeys(Ln);
		ff.findElement(By.name("emailAddress")).sendKeys(Email);
		ff.findElement(By.name("company")).sendKeys(Company);
		ff.findElement(By.name("sendRequest")).click();
		String Actres = ff.findElement(By.xpath("//h1[@class='page-title']")).getText();
		r1.createCell(5).setCellValue(Actres);

		if (Expected.equals(Actres)) {
			r1.createCell(6).setCellValue("pass");
		} else {
			r1.createCell(6).setCellValue("fail");
		}
	}
}



