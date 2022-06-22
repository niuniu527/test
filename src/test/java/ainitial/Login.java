package ainitial;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        //1.打开浏览器
        driver = open("chrome");
        //2.访问前程贷登陆页面
        driver.get("http://120.78.128.25:8765/Index/login.html");
    }

    @Test
    public void test() throws InterruptedException {
        //3.输入用户名(未注册账户)
        driver.findElement(By.name("phone")).sendKeys("15859019266");
        //4.输入密码
        driver.findElement(By.name("password")).sendKeys("lemon123456");
        //5.点击登录按钮
        driver.findElement(By.xpath("//*[@type='button']")).click();
        //6.断言
        //6.1 url断言（不严谨）
//        Thread.sleep(2000);
//        String actualUrl=driver.getCurrentUrl();
//        String expectedUrl="http://120.78.128.25:8765/Index/index";
//        Assert.assertEquals(actualUrl,expectedUrl);
        //6.2 用户名匹配断言
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'自动化测试')]")));
            boolean displayed = until.isDisplayed();
            Assert.assertTrue(displayed);
        }catch (TimeoutException e){
            e.getStackTrace();
            Assert.assertTrue(false);
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        //7.关闭浏览器
        close(driver);
    }

    private static WebDriver open(String type) {
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

    private static void close(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

