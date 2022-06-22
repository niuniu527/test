package pages.systemManagePages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * ClassName:SchoolManagePage
 * Desc:学校管理页面
 * Author:10
 * Date:2022/5/25 10:07
 * Version:V1.0.0
 * JDK:1.8.0_111
 **/
public class SchoolManagePage extends BasePage {
    public SchoolManagePage(WebDriver driver) {
        super(driver);//调用父类的构造，把driver对象传给父类
    }

    //1.对象的属性private（全局变量）--页面元素定位
    //1.1定位学校名称
    private By schoolNameBy = By.xpath("//*[@codefield='schoolName']");
    //1.2定位查询按钮
    private By queryBy = By.xpath("//*[@text='查询']");
    //1.3定位查询数据
    private By dataCountBy = By.cssSelector(".ant-pagination-total-text");
    //1.4定位地区
    private By areaBy = By.xpath("//*[@placeholder='请选择']");
    //1.4-2定位地区输入选择框(输入区名)
    private By areaSelectBy = By.className("ant-cascader-menu-item");
    //1.5定位审核状态
    private By auditBy = By.id("status");
    //1.5-1点击审核通过状态
    private By auditPassBy = By.xpath("//*[text()='审核通过']");
    //1.6定位启用状态
    private By enableBy = By.id("isEnabled");
    //1.6-1点击已启用状态
    private By enablePassBy = By.xpath("//*[text()='已启用']");
    //1.7定位学校管理
    private By schoolManageBy = By.xpath("//*[text()='学校管理']");
    //1.8定位学校列表行
    private By selectRowBy = By.cssSelector(".ant-table-row.ant-table-row-level-0");
    //1.9定位编辑
    private By editBtnBy = By.xpath("//tbody/tr[1]/td[1]/div[1]/button[1]/span[1]");
    //1.10定位编辑学校的地区
    private By schoolAreaBy = By.xpath("//body/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/input[1]");
    //1.11定位确认按钮
    private By confirmBtnBy = By.xpath("//*[text()='确 认']");
    //1.12定位启用状态按钮
    private By enableBtnBy = By.xpath("//tbody/tr[1]/td[5]/button[1]");
    //1.13定位点击启用按钮后的弹框--确定
    private By yesBtnBy =By.xpath("//*[text()='确 定']");
    //1.14定位审核启用按钮
    private By auditEnableBtnBy = By.xpath("//span[contains(text(),'审核启用')]");
    //1.15定位审核启用弹出框的”通过“
    private By passBtnBy = By.xpath("//*[text()='通过']");

    //2.对象的行为public（方法）--页面操作
    //2.1输入学校名称
    public void inputSchoolName(String content){
        input(schoolNameBy,content);
    }
    //2.2点击查询
    public void clickQueryBtn(){
        click(queryBy);
    }
    //2.3判断查询数据是否可见
    public void dataCountVisible(){
        Boolean elementIsDisplayed = elementIsDisplayed(dataCountBy);
        System.out.println("是否查询到数据:"+elementIsDisplayed.toString());
    }
    //2.4-1点击地区
    public void clickArea(){
        click(areaBy);
    }
    //2.4-2输入地区
    public void inputArea(String areaName){
        input(areaBy,areaName);
    }
    //2.4-3点击选择地区
    public void clickSelectArea(){
        click(areaSelectBy);
    }
    //2.5-1点击审核状态
    public void clickAuditStatus(){
        click(auditBy);
    }
    //2.5-2选择审核状态(点击审核通过)
    public void clickAuditPassStatus(){
        click(auditPassBy);
    }
    //2.6-1点击启用状态
    public void clickEnableStatus(){
        click(enableBy);
    }
    //2.6-2点击已启用状态
    public void clickEnablePassStatus(){
        click(enablePassBy);
    }
    //2.7点击学校管理
    public void clickSchoolManage(){
        click(schoolManageBy);
    }
    //2.8根据序号选择学校行
    public void selectRow(Integer index){
        inputIndexSelect(selectRowBy,index);
    }
    //2.9点击编辑
    public void clickEditBtn(){
        click(editBtnBy);
    }
    //2.10点击地区
    public void clickSchoolArea(){
        click(schoolAreaBy);
    }
    //2.10-1输入学校地区
    public void inputSchoolArea(String schoolAreaName){
        input(schoolAreaBy,schoolAreaName);
    }
    //2.11点击确认
    public void clickConfirmBtn(){
        click(confirmBtnBy);
    }
    //2.12获取启用状态按钮的值
    public String getEnableBtnValue() {
        String text = getElementAttribute(enableBtnBy,"aria-checked");
        System.out.println("获取到的启动按钮状态："+text);
        return text;
    }
    //2.13点击启用按钮
    public void clickEnableBtn(){
        click(enableBtnBy);
    }
    //2.14点击启用按钮后的弹框--确定
    public void clickYesBtn(){
        click(yesBtnBy);
    }
    //2.15点击审核启用
    public void clickAuditEnableBtn(){
        click(auditEnableBtnBy);
    }
    //2.16点击审核通过
    public void clickPassBtn(){
        click(passBtnBy);
    }
}
