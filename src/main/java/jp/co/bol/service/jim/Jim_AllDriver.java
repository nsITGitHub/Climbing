package jp.co.bol.service.jim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.springframework.stereotype.Service;

@Service
public  class Jim_AllDriver {
	public WebDriver driver(){
		//デスクトップパスの取得
		String desktop = System.getProperty("user.home") + "/Desktop";
		//Chromeドライバーを格納したパスをシステム変数にセット    
		System.setProperty("webdriver.chrome.driver", desktop+"/exe/chromedriver-win64/chromedriver.exe");
		//Chromeドライバーのインスタンス
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
		
}

/*
System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "chromedriver.exe");
*/
 