package jp.co.bol.service.jim;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;


@Service
public  class Jim_AllDriver {
	public WebDriver driver(){
		//ヘッドレスモードを付与
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
		//Chromeドライバーのインスタンス
		WebDriver driver = new ChromeDriver(options);
		
		return driver;
	}
}

/*  自動でchromedriverのパスを取得
WebDriverManager.chromedriver().setup();
//ChromeDriverManager.getInstance().setup();
String driverPath=System.getProperty("webdriver.chrome.driver");
System.out.println(driverPath);
*/
/*
//カレントディレクトリの絶対パスを取得
 Path AbsolutePath = Paths.get("").toAbsolutePath();
System.out.println(AbsolutePath);
 
//Chromeドライバーを格納したパスをシステム変数にセット    
 System.setProperty("webdriver.chrome.driver", AbsolutePath+"/exe/chromedriver-win64/chromedriver.exe");
*/