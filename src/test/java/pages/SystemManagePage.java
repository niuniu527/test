package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ClassName: SystemManagePage
 * @author Administrator
 * @version V1.0.0
 * @Desc 首页
 * @since JDK 1.8
 * date: 2020/9/10 16:21
 */
public class SystemManagePage extends BasePage {
    public SystemManagePage(WebDriver driver) {
        super(driver);//调用父类的构造，把driver对象传给父类
    }

    //1.对象的属性private（全局变量）--页面元素定位
    //1.1定位基础管理
    private By basicManageBy = By.xpath("//*[text()='基础管理']");
    //1.2定位学校管理
    private By schoolManageBy = By.xpath("//*[text()='学校管理']");
    //1.3定位教师管理
    private By teacherManageBy = By.xpath("//*[text()='教师管理']");
    //1.4定位代理商管理
    private By agentManageBy = By.xpath("//*[text()='代理商管理']");
    //1.5定位学生管理
    private By studentManageBy = By.xpath("//*[text()='学生管理']");
    //1.6定位班级管理
    private By classManageBy = By.xpath("//*[text()='班级管理']");

    //2.对象的行为public（方法）--页面操作
    //2.1点击基础管理
    public void clickBasicManage() {
        click(basicManageBy);
    }

    //2.2点击学校管理
    public void clickSchoolManage() {
        click(schoolManageBy);
    }

    //2.3点击教师管理
    public void clickTeacherManage() {
        click(teacherManageBy);
    }

    //2.4点击代理商管理
    public void clickAgentManage() {
        click(agentManageBy);
    }

    //2.5点击学生管理
    public void clickStudentManage() {
        click(studentManageBy);
    }

    //2.6点击班级管理
    public void clickClassManage() {
        click(classManageBy);
    }
}