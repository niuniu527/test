package cases;

import common.BaseCase;
import common.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BackstageLoginPage;
import pages.LoginPage;
import pages.SystemManagePage;

/**
 * ClassName:SystemManageCase
 * Desc:平台管理用例
 * Author:10
 * Date:2022/5/24 17:35
 * Version:V1.0.0
 * JDK:1.8.0_111
 **/
public class SystemManageCase extends BaseCase {
    @BeforeClass //只执行一次
    public void setupClass() throws InterruptedException {
        //打开浏览器，访问登录页面
        driver = open(Constants.BROWSER_TYPE);
        driver.get(Constants.LOGIN_URL);
        //网页最大化
        driver.manage().window().maximize();
        //管理员登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputAccount(Constants.ACCOUNT);
        loginPage.inputPassword(Constants.PWD);
        loginPage.clickLoginBtn();
        //访问平台管理页面
        driver.get(Constants.SYSTEM_URL);
    }

    @Test(description = "展开基础管理列表")
    public void basicManage(){
        //点击基础管理，展开列表
        SystemManagePage systemManagePage = new SystemManagePage(driver);
        systemManagePage.clickBasicManage();

    }
    @AfterClass
    public void tearDown() throws Exception {
        //关闭浏览器
        close(driver);
    }
}
