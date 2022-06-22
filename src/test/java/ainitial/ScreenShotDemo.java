package ainitial;

import common.BaseCase;
import common.Constants;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * ClassName:ScreenShotDemo
 * Desc:截图示例
 * Author:Administrator
 * Date:2020/9/20 19:51
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class ScreenShotDemo extends BaseCase {
    @BeforeClass
    public void setUp(){
        driver = BaseCase.open("chrome");
        driver.get(Constants.LOGIN_URL);
    }
    @Test
    public void test() throws Exception {
        //截图TakesScreenshot
        //向下，强转
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        //必须创建File对象，否则传入destFile,类型不一致
        File destFile = new File("D://LOGIN.png");
        //srcFile剪切
        FileUtils.moveFile(srcFile,destFile);
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        close(driver);
    }
}
