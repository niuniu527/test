package utils;

import listeners.ScreenShotListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * ClassName:ScreenShotUtils
 * Desc:截图工具类
 * Author:Administrator
 * Date:2020/9/20 20:53
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class ScreenShotUtils {
    /**
     * 截图工具
     * @param driver  驱动浏览器
     * @param destFileName  目标文件名称
     */
    public static void screenShot(WebDriver driver, String destFileName){
        //截图TakesScreenshot
        //向下，强转，图片用.File类型
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(srcFile.getAbsolutePath());//获取临时文件（截图）路径
        //必须创建File对象，否则传入destFile,类型不一致
        File destFile = new File("src/test/resources/"+destFileName);
        //srcFile剪切
        try {
            FileUtils.moveFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
