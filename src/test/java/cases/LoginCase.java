package cases;

import common.BaseCase;
import common.Constants;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
/**
 * ClassName:AddLoanCase
 * Desc:登录用例
 * Author:Administrator
 * Date:2022/5/20 15:01
 * Version:V1.0.0
 * JDK:1.8.0_231
 * PS:SAAS生产环境
 */
public class LoginCase extends BaseCase {
    @BeforeClass
    public void setUp() {
        //打开浏览器
        driver = open(Constants.BROWSER_TYPE);
        //网页最大化
        driver.manage().window().maximize();

    }
    @BeforeMethod
    public void setUpMethod(){
        //每个方法执行一次，实现同时多个方法顺序执行
        //访问SAAS登陆页面
        driver.get(Constants.LOGIN_URL);
    }

    @Test(description = "成功登录")
    public void testSuccess() throws InterruptedException {
        //错误账号
        LoginPage loginPage=new LoginPage(driver);
        //输入手机
        loginPage.inputAccount(Constants.ACCOUNT);
        //输入密码
        loginPage.inputPassword(Constants.PWD);
        //点击登录按钮
        loginPage.clickLoginBtn();
        //获取当前URL并断言
        Thread.sleep(3000);
        String actual = driver.getCurrentUrl();
        String expected=Constants.INDEX_URL;
        Assert.assertEquals(actual,expected);
    }

    @Test(dataProvider = "data1",description = "登录失败--为空错误")
    public void testFailed1(String account,String pwd,String expected1,String expected2) throws InterruptedException {
        //账号为空，密码为空，账号和密码都为空
        LoginPage loginPage = new LoginPage(driver);
        //输入账号
        loginPage.inputAccount(account);
        //输入密码
        loginPage.inputPassword(pwd);
        //点击登录按钮
        loginPage.clickLoginBtn();
        //获取账号/密码为空提示并断言
        String actual1 = loginPage.getNullAccountText();
        String actual2 = loginPage.getNullPwdText();
        Assert.assertEquals(actual1, expected1);
        Assert.assertEquals(actual2, expected2);
    }
    @Test(dataProvider = "data2",description = "登录失败--格式错误")
    public void testFailed2(String account,String pwd) throws InterruptedException {
        //密码为空且手机号为空，同时出现两个错误提示
        LoginPage loginPage=new LoginPage(driver);
        //输入账号
        loginPage.inputAccount(account);
        //输入密码
        loginPage.inputPassword(pwd);
        //点击登录按钮
        loginPage.clickLoginBtn();
        //获取错误提示并断言
        String actual = loginPage.getErrorText();
        String expected="错误提示";
        Assert.assertEquals(actual,expected);
 }

    @DataProvider()
    public Object[][] data1(){
        Object[][] datas={
                {"",Constants.PWD,"请输入账号",""},
                {Constants.ACCOUNT,"","","请输入密码"},
                {"","","请输入账号","请输入密码"},
        };
        return datas;
    }

    //账号错误、密码错误、账号前后空格、密码前后空格（账号不区分大小写）
    @DataProvider()
    public Object[][] data2(){
        Object[][] datas={
                {"123456",Constants.PWD},
                {Constants.ACCOUNT,"123456"},
                {" admin ",Constants.PWD},
                {Constants.ACCOUNT," 123456@2022"}
        };
        return datas;
    }


    @AfterClass
    public void tearDown() throws Exception {
        //关闭浏览器
        close(driver);
    }
}


