package listeners;

import common.BaseCase;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import utils.ScreenShotUtils;

/**
 * ClassName:ScreenShotListener
 * Desc:截图监听类
 * Author:Administrator
 * Date:2020/9/20 20:26
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class ScreenShotListener implements IHookable {

    @Override
    public void run(IHookCallBack iHookCallBack, ITestResult iTestResult) {
        //iHookCallBack 执行@Test方法
        //iTestResult @Test方法的结果（@Test对象、方法名、是否抛出异常...）
        //监听每个@Test结果
        iHookCallBack.runTestMethod(iTestResult);
        //结果异常信息捕获
        Throwable throwable = iTestResult.getThrowable();
        if(throwable!=null){
            //throwable不等于空，说明@Test出现异常了，执行截图
            System.out.println("throwable:"+throwable);
        }
        //获取当前@Test对象
        Object instance = iTestResult.getInstance();
        //强转成BaseCase,通过BaseCase取driver
        BaseCase baseCase = (BaseCase)instance;
        //获取当前@Test方法名
        String methodName = iTestResult.getName();
        //获取当前@Test类名
        String className = iTestResult.getInstanceName();
        String destFileName = className+"_"+methodName+"_"+System.currentTimeMillis()+".png";
        ScreenShotUtils.screenShot(baseCase.driver,destFileName);
    }
}
