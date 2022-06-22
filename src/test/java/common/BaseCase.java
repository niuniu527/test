package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * ClassName:BaseCase
 * Desc:测试用例父类
 * Author:Administrator
 * Date:2020/9/12 17:36
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class BaseCase {
    //成员变量
    public WebDriver driver;

    /**
     * 打开浏览器
     * @param type  浏览器类型
     * @return
     */
    public static WebDriver open(String type) {
        WebDriver driver = null;
        if ("chrome".equalsIgnoreCase(type)) {
            //引入驱动位置
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            //创建谷歌的驱动对象
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(type)) {
            //firefox默认安装在c盘，如果不是默认的安装路径，这里要指定路径，防止报错
            System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            //引入驱动位置
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
            //创建火狐的驱动对象
            driver = new FirefoxDriver();
        } else if ("ie".equalsIgnoreCase(type)) {
            //IE启动设置
            //1.1创建IE启动设置
            DesiredCapabilities capability = new DesiredCapabilities();
            //1.2设置忽略缩放
            capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            //1.3忽略保护模式
            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            //1.4设置百度为浏览器初始化地址
            capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://www.baidu.com");
            //引入IE驱动位置
            System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
            //创建IE的驱动对象
            driver = new InternetExplorerDriver(capability);
        }
        return driver;
    }

    /**
     * 关闭驱动
     * @param driver
     * @throws InterruptedException
     */
    public static void close(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
