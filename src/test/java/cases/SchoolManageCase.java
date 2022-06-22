package cases;

import common.BaseCase;
import common.Constants;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.systemManagePages.SchoolManagePage;
import pages.SystemManagePage;

import java.util.List;
import java.util.Map;

/**
 * ClassName:SchoolManageCase
 * Desc:学校管理--查询用例
 * Author:10
 * Date:2022/5/25 11:33
 * Version:V1.0.0
 * JDK:1.8.0_111
 **/
public class SchoolManageCase extends BaseCase {
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

    @Test(description = "筛选学校并修改地区后启用")
    public void schoolManage() throws InterruptedException {
        //第一步：根据学校名称查询
        //点击学校管理
        SchoolManagePage schoolManagePage = new SchoolManagePage(driver);
        schoolManagePage.clickSchoolManage();
        Thread.sleep(2000);
        //输入学校名称（模糊查询）
        schoolManagePage.inputSchoolName("艳伟");
        //地区，审核和启用状态选择（精确查询）
        //exactChoose(schoolManagePage);
        //点击查询
        schoolManagePage.clickQueryBtn();
        //第二步：选择第一条数据并编辑
        //判断是否有数据(有)
        schoolManagePage.dataCountVisible();
        //选择第一行数据
        schoolManagePage.selectRow(0);
        //获取第一个启用状态的值，判断是否开启，开启状态需点击取消，否则直接点击编辑
        String value = schoolManagePage.getEnableBtnValue();
        if("true".equals(value)){
            clickEnableBtnAndConfirm(schoolManagePage);
        }
        //点击编辑
        schoolManagePage.clickEditBtn();
        //点击学校地区并输入并点击选择
        schoolManagePage.clickSchoolArea();
        schoolManagePage.inputSchoolArea("中山");
        schoolManagePage.clickSelectArea();
        //点击确认
        schoolManagePage.clickConfirmBtn();
        Thread.sleep(3000);
        //第三步:编辑好的学校，打开启用状态并审核启用
        clickEnableBtnAndConfirm(schoolManagePage);
        schoolManagePage.clickAuditEnableBtn();
        schoolManagePage.clickPassBtn();
    }

    private void clickEnableBtnAndConfirm(SchoolManagePage schoolManagePage) throws InterruptedException {
        //点击启用按钮并且确定
        schoolManagePage.clickEnableBtn();
        //点击弹框的“确定”
        schoolManagePage.clickYesBtn();
    }

    private void exactChoose(SchoolManagePage schoolManagePage) {
        //点击地区，输入地区并选择地区
        schoolManagePage.clickArea();
        schoolManagePage.inputArea("中山");
        schoolManagePage.clickSelectArea();
        //点击审核状态，并选择通过的审核
        schoolManagePage.clickAuditStatus();
        schoolManagePage.clickAuditPassStatus();
        //点击启用状态，选择已启用状态
        schoolManagePage.clickEnableStatus();
        schoolManagePage.clickEnablePassStatus();
    }

    @AfterClass
    public void tearDown() throws Exception {
        //关闭浏览器
        close(driver);
    }
}
