package cases;

import common.BaseCase;
import common.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SystemManagePage;
import pages.systemManagePages.SchoolManagePage;
import pages.systemManagePages.StudentManagePage;

import java.io.IOException;

/**
 * ClassName:StudentManageCase
 * Desc:学生管理用例
 * Author:10
 * Date:2022/6/17 10:32
 * Version:V1.0.0
 * JDK:1.8.0_111
 **/
public class StudentManageCase extends BaseCase{
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
        //访问平台管理页面--基础管理
        driver.get(Constants.SYSTEM_URL);
        SystemManagePage systemManagePage = new SystemManagePage(driver);
        systemManagePage.clickBasicManage();
    }

    @Test(description = "批量添加学生-下载/上传文件")
    public void testBatchAddStudent() throws IOException, InterruptedException {
        StudentManagePage studentManagePage = new StudentManagePage(driver);
        //点击学生管理
        studentManagePage.clickStudentManage();
        //学生管理页面点击批量添加
        studentManagePage.clickBatchAdd();
        //批量添加弹出框点击下载模板
        studentManagePage.clickDownLoadMode();
        Thread.sleep(2000);
        //点击上传文件
        studentManagePage.clickUploadFile();
        Thread.sleep(5000);
        //执行脚本转换后的auto.exe,执行第三方脚本上传文件
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("C:\\Users\\10\\Desktop\\上传学生模板.exe");
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        //关闭浏览器
        close(driver);
    }
}

