package jp.co.bol.service.jim;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bol.entity.Calender;
import jp.co.bol.entity.News;

@Service
public class Jim_news_Nobolock {
	
	public List<News> jm_news_Nobolock() throws UnsupportedEncodingException{
		Jim_AllDriver JDriver = new Jim_AllDriver(); 
		//returnするlistResultをインスタンス化
		List<News> listResult = new ArrayList<>();
		
		WebDriver driver = JDriver.driver();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		//対象のページ開く
		driver.get("https://noborock-climbing.com/news/");
		
		//bolJimの取得
		String bolJim = driver.findElement(By.xpath("//h1[@class='logo']")).getText();
		
		//DBへの格納対象をリストに加える。
		for(int i =2; i<5 ;i++) {
			//DBへの格納対象を含むdiv要素を取得
			List<WebElement> newsAll = driver.findElements(By.cssSelector("li.clearfix"));
		
		for(WebElement n : newsAll) {
			//listResultに格納する用のインスタンス作成
			News newsList = new News();
			//年月日を取得
			String eDate = n.findElement(By.cssSelector("p.date")).getText();
			//格納対象の取得　年、月、日、イベント内容
			int bolYear = Integer.parseInt(eDate.substring(0, 4));
			int bolMonth = Integer.parseInt(eDate.substring(5, 7));
			int bolDate = Integer.parseInt(eDate.substring(8, 10));
			//イベントの内容取得
			String event = n.findElement(By.cssSelector("a")).getText();
			//イベントのリンク取得
			String eventLink = n.findElement(By.cssSelector("a")).getAttribute("href");
			String encoding = "UTF-8";
			String result = URLDecoder.decode(eventLink, encoding);
			
			newsList.setBolDate(bolDate);
			newsList.setBolJim(bolJim);
			newsList.setBolMonth(bolMonth);
			newsList.setBolYear(bolYear);
			newsList.setBolnews(event);
			newsList.setBollink(result);
			listResult.add(newsList);
		}
		
		//次ページをクリック
		driver.findElement(By.xpath("//a[@class='page-numbers'][contains(@href,'"+ i +"')]")).click();
		
		//目的の要素が出るまで待機
		wait.until (ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='page-numbers current'][contains(text(),'"+ i +"')]")));	
		
		}
		driver.quit();
		return listResult;
	}
}
