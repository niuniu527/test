package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * ClassName:RetryListener
 * Desc:重试注解属性监听类
 * Author:Administrator
 * Date:2020/9/20 22:15
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class RetryListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retryAnalyzer = annotation.getRetryAnalyzer();
        if(retryAnalyzer==null){
            //@Test没有设置retryAnalyzer属性，则设置一个属性
           annotation.setRetryAnalyzer(MyRetry.class);

        }
    }
}
