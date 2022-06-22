package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * ClassName:MyRetry
 * Desc:重试机制
 * Author:Administrator
 * Date:2020/9/20 21:59
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class MyRetry implements IRetryAnalyzer {
        //当前重试次数
        private int retryCount = 0;
        //最大重试次数
        private static final int maxRetryCount = 3;

        @Override
        public boolean retry(ITestResult result) {
            //如果当前重试次数大于最大重试次数，不再重试
            if (retryCount < maxRetryCount) {
                retryCount++;
                return true;
            }
            return false;
        }

}
