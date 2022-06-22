package listeners;

import common.BaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

/**
 * ClassName:AllureReportListener
 * Desc:allure报表截图
 * Author:Administrator
 * Date:2020/9/20 21:28
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class AllureReportListener implements IHookable {
    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        //执行@Test方法
        iHookCallBack.runTestMethod(iTestResult);
        Throwable throwable = iTestResult.getThrowable();
        if(throwable!=null){
            //throwable!=null说明@Test出现异常，执行截图
            //获取@Test执行类对象
            Object instance = iTestResult.getInstance();
            //强转成BaseCase,通过BaseCase取driver
            BaseCase baseCase = (BaseCase)instance;
            //把diver转出可截图对象
            TakesScreenshot screenshot = (TakesScreenshot)baseCase.driver;
            //截图并返回字符数组（文件流）
            byte[] screenShot = screenshot.getScreenshotAs(OutputType.BYTES);
            //allure收集图片信息
            saveScreenshot(screenShot);
        }
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
