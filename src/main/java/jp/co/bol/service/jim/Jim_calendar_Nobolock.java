package jp.co.bol.service.jim;


import java.time.Duration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import jp.co.bol.entity.Calender;
import jp.co.bol.modal.Jim;
import jp.co.bol.repository.ClimbingRepository;


@Service
public class Jim_calendar_Nobolock {
	
	@Autowired
	private Jim_AllDriver JDriver; 
	
	public List<Calender> Jim_Nobolock(){
		//driverのインスタンス作成
		WebDriver driver = JDriver.driver();
		
		//対象のページ開く
		driver.get("https://noborock-climbing.com/");
		//今月と来月の値を取得
		Calendar calendar = Calendar.getInstance();
		
		//カテゴリーの内容を全てを取得 10種類
		List<WebElement> category = driver.findElements(By.xpath("//*[@id=\"ai1ec-calendar\"]/div[contains(@class,\"ai1ec-calendar-toolbar\")]/ul/li/div/div/a/span"));
		//List作成　DBへ保存用
		List<Calender> list = new ArrayList<>();
		//★bolyearを取得
		int bolYear = calendar.get(Calendar.YEAR);
		//★bolMonthを取得
		int monthThis = calendar.get(Calendar.MONTH)+1; 
		
		String bolJim = driver.findElement(By.cssSelector("#logo_text > h1 > a")).getText();
		
		/*//来月をクリック
		driver.findElement(By.xpath("//*[@id=\"ai1ec-calendar-view\"]/div[@class=\"ai1ec-clearfix\"]"
				+ "/div[contains(@class,\"ai1ec-title-buttons\")]"
				+ "/div"
				+ "/a[contains(@class,\"ai1ec-next-month\")]"))
			  .click();
		
		//JSが発生し、目的の要素が出るまで待機
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until (ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@id=\"ai1ec-calendar-view\"]/div[@class=\"ai1ec-clearfix\"]"
				+ "/div[contains(@class,\"ai1ec-title-buttons\")]"
				+ "/div"
				+ "/a[contains(@data-date," + "\"" + (monthThis+1) + "\"" +")]")));	
		*/
		
		try{
		for(int m = 0; m < 3; m++) {
			//目的の月を取得
			int bolMonth = monthThis + m;
			if(bolMonth>12) {
				bolMonth -= 12;
				bolYear += 1;
			}
			//目的の月の来月を取得
			int monthNext = bolMonth+1;
			if(monthNext>12) {
				monthNext -= 12;
			}
			
				
		
			for(int i = 0; i < category.size(); i++) {
				//★bolNameを取得　カテゴリーを一つずつ
				String bolname = category.get(i).getAttribute("title");	
				//System.out.println(bolname);
				//bolNameを含んだ今月の要素をすべて取得　 
				List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"ai1ec-calendar-view\"]/table/tbody/tr/td/div[@class=\"ai1ec-day\"]/a/div/span[contains(text()," 
																+ "\"" + bolname + "\"" + ")]"));
				//月の要素分繰り返す
				for(int k = 0; k < elements.size();k++) {
					WebElement e = elements.get(k);
					Calender clim = new Calender();
			
					//テキストを取得
					//★bolText()で格納
					String bolText=e.getText();		
					//日付を取得
					WebElement eDate = e.findElement(By.xpath(".//../../../div[@class=\"ai1ec-date\"]/a"));
					//★bolDay()で格納
					int bolDate = Integer.parseInt(eDate.getText());

					clim.setBolJim(bolJim);
					clim.setBolName(bolname);
					clim.setBolText(bolText);
					clim.setBolDate(bolDate);
					clim.setBolMonth(bolMonth);
					clim.setBolYear(bolYear);
					//clim.setBolnews("news");
					list.add(clim);
					}
				
			}
			
			//来月をクリック
			driver.findElement(By.xpath("//*[@id=\"ai1ec-calendar-view\"]/div[@class=\"ai1ec-clearfix\"]"
					+ "/div[contains(@class,\"ai1ec-title-buttons\")]"
					+ "/div"
					+ "/a[contains(@class,\"ai1ec-next-month\")]"))
				  .click();
			
			//JSが発生し、目的の要素が出るまで待機
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until (ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@id=\"ai1ec-calendar-view\"]/div[@class=\"ai1ec-clearfix\"]"
					+ "/div[contains(@class,\"ai1ec-title-buttons\")]"
					+ "/div"
					+ "/a[contains(@data-date," + "\"" + monthNext + "\"" +")]")));	
			
		}
	}catch (Exception e){
		 System.out.println("要素がありません");
	}finally {
		//driverを閉じる。
		driver.quit();
		return list;
	}
	}
}
