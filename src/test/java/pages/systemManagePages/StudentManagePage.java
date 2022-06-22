package pages.systemManagePages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ClassName:StudentManagePage
 * Desc:学生管理页面
 * Author:10
 * Date:2022/6/17 10:34
 * Version:V1.0.0
 * JDK:1.8.0_111
 **/
public class StudentManagePage extends BasePage {
    //调用父类的构造，把driver对象传给父类
    public StudentManagePage(WebDriver driver) {
        super(driver);}

    //1.对象的属性private（全局变量）--页面元素定位
    //定位学生管理
    private By schoolManageBy =By.xpath("/html[1]/body[1]/div[1]/section[1]/section[1]/aside[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li[4]");
    //1.1定位批量添加
    private By batchAddBy = By.xpath("//span[text()='批量添加']");
    //1.2定位下载模板
    private By downloadModeBy = By.xpath("//span[text()='下载模板']");
    //1.3定位上传文件按钮
    private By uploadFileBy = By.xpath("//span[contains(text(),'上传文件')]");

    //2.对象的行为public（方法）--页面操作
    //点击学生管理，打开学生管理页面
    public void clickStudentManage(){
        click(schoolManageBy);
    }
    //2.1点击批量添加
    public void clickBatchAdd(){
        click(batchAddBy);
    }
    //2.2点击下载模板
    public void clickDownLoadMode(){
        click(downloadModeBy);
    }
    //2.3点击上传文件
    public void clickUploadFile(){
        click(uploadFileBy);
    }
}
