package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ClassName: LoginPage
 * Description: 登录
 * date: 2020/9/10 10:10
 * @author Administrator
 * @version V1.0.0
 * @since JDK 1.8
 */
public class LoginPage extends BasePage {
    //page object设计
    //webDriver对象，通过业务传给页面（保证业务和页面是同一个driver）
    public LoginPage(WebDriver driver){
        super(driver);//调用构造，把driver对象传给父类
    }

    //1.对象的属性private（全局变量）--页面元素定位
    //1.1定位手机号输入框
    private By accountBy= By.id("account");
    //1.2定位密码输入框
    private By pwdBy= By.id("password");
    //1.3定位登录按钮
    private By longinBtnBy=By.xpath("//*[@type='button']");
    //1.4定位账号栏错误信息&定位密码栏错误信息
    private By formErrorInfoBy = By.xpath("//*[text()='错误提示']");
    //1.5账号为空错误提示
    private By nullAccountBy =By.xpath("//*[text()='请输入账号']");
    //1.6密码为空错误提示
    private By nullPwdBy =By.xpath("//*[text()='请输入密码']");


    //2.对象的行为public（方法）--页面操作
    //2.1输入手机号
    public void inputAccount(String account){
       input(accountBy,account);
    }
    //2.2输入密码
    public void inputPassword(String pwd){
        input(pwdBy,pwd);
    }
    //2.3点击登录
    public void clickLoginBtn(){
        click(longinBtnBy);
    }
    //2.4获取账号/密码错误信息
    public String getErrorText(){
      return getElementText(formErrorInfoBy);
    }
    //2.5账号为空错误信息
    public String getNullAccountText(){
        return getElementText(nullAccountBy);
    }
    //2.6密码为空错误信息
    public String getNullPwdText(){
        return getElementText(nullPwdBy);
    }
}

