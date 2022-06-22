package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ClassName:BackstgeLoginPage
 * Desc:后台登录页面
 * Author:Administrator
 * Date:2020/9/13 14:46
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class BackstageLoginPage extends BasePage {

    public BackstageLoginPage(WebDriver driver){
        super(driver);
    }
    //1.页面元素定位
    //定位后台管理员账号
    private By adminNameBy = By.xpath("//input[@name='admin_name']");
    //定位后台管理员密码
    private By adminPwdBy = By.xpath("//input[@name='admin_pwd']");
    //定位后台登录验证码
    private By verifyBy = By.xpath("//input[@class='admin_login_verify']");
    //定位后台登录按钮
    private By btnBy = By.xpath("//button[@class='admin_login_btn denglu']");

    //2.页面操作
    //输入管理员账号
    public void inputAdminName(String adminName){
        input(adminNameBy,adminName);
    }
    //输入管理员密码
    public void inputAdminPwd(String pwd){
        input(adminPwdBy,pwd);
    }
    //输入验证码
    public void inputVerify(String verify){
        input(verifyBy,verify);
    }
    //点击登录
    public void clickBtn(){
        click(btnBy);
    }
}

