package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ClassName:BackstageIndexPage
 * Desc:后台首页
 * Author:Administrator
 * Date:2020/9/13 15:40
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class BackstageIndexPage extends BasePage {
    public BackstageIndexPage(WebDriver driver){
        super(driver);
    }
    //1.页面元素定位
    //定位借款管理
    private By loanManageBy = By.xpath("//span[text()='借款管理']");
    //iframe切换--mainFrame
    private By mainFrameBy = By.id("mainFrame");
    //定位加标
    private By addLoanBy = By.id("add");
    //借款信息(自动锁定)
    //（1）借款人
    private By borrowerBy = By.xpath("//input[@placeholder='输入手机号码进行查找']");
    //（2）定位贷款标题
    private By loanTitleBy = By.xpath("//td[text()='贷款标题:']/following-sibling::td/input");
    //（3）定位年利率利息
    private By loanRateBy = By.xpath("//input[@name='LoanRate']");
    //（4）定位借款期限
    private By loanTermBy = By.xpath("//input[@name='LoanTerm']");
    //（5）定位借款额度
    private By loanAmountBy = By.xpath("//input[@name='Amount']");
    //（6）定位竞标期限
    private By biddingDaysBy = By.xpath("//input[@name='BiddingDays']");
    //定位风控评测
    private By riskEvaluationBy = By.xpath("//span[text()='风控评测']");
    //（1）定位评估价值
    private By evaluAmountBy = By.xpath("//input[@name='EvaluAmount']");
    //定位项目录入
    private By projectInputBy = By.xpath("//span[text()='项目录入']");
    //（1）定位籍贯
    private By nativeBy = By.xpath("//input[@name='Native']");
    //（2）定位职业
    private By professionBy = By.xpath("//input[@name='Profession']");
    //（3）定位年龄
    private By ageBy = By.xpath("//input[@name='Age']");
    //（4）定位提交
    private By addDoBy = By.xpath("//span[text()='提交']");
    //定位提交的记录（行tr）
    //需要传入title变量，因此元素直接在方法中定位
    //定位审核
    private By checkBy = By.xpath("//span[text()='审核']");
    //定位审核通过
    private By checkPassBy = By.xpath("//span[text()='审核通过']");

    //2.页面操作
    //点击借款管理
    public void clickLoanManage(){
        click(loanManageBy);
    }
    //切换iframe（需要传入element--iframe可见元素）
    public void switchIframe(){
        WebElement element = waitElementVisibility(mainFrameBy);
        driver.switchTo().frame(element);
    }
    //点击加标
    public void clickAddLoan(){
        click(addLoanBy);
    }
    //借款人：输入手机号，选择用户
    public void chooseBorrower(String phone){
        try {
            click(borrowerBy);
            input(borrowerBy, phone);
            //输入后，当借款人元素可见且不为空，点击向下箭头2次，选中用户
            Thread.sleep(1000);
            inputKey(borrowerBy, Keys.ARROW_DOWN);
            inputKey(borrowerBy, Keys.ARROW_DOWN);
            //键盘回车
            Thread.sleep(1000);
            inputKey(borrowerBy, Keys.ENTER);
        }catch (Exception e){
            System.out.println("元素定位异常："+e.getMessage());
        }
    }
    //输入贷款标题
    public void inputLoanTitle(String title){
        input(loanTitleBy,title);
    }
    //输入年利率利息
    public void inputLoanRate(String rate){
        input(loanRateBy,rate);
    }
    //输入借款期限
    public void inputLoanTerm(String term){
        input(loanTermBy,term);
    }
    //输入借款额度
    public void inputLoanAmount(String loanAmount){
        input(loanAmountBy,loanAmount);
    }
    //输入竞标期限
    public void inputBiddingDays(String biddingDays){
        input(biddingDaysBy,biddingDays);
    }
    //点击风控评测
    public void clickRiskEvaluation(){
        click(riskEvaluationBy);
    }
    //输入评估价值
    public void inputEvaluAmount(String evaluAmount){
        input(evaluAmountBy,evaluAmount);
    }
    //点击项目录入
    public void clickProjectInput(){
        click(projectInputBy);
    }
    //输入籍贯
    public void inputNative(String homeTown){
        input(nativeBy,homeTown);
    }
    //输入职业
    public void inputProfession(String profession){
        input(professionBy,profession);
    }
    //输入年龄
    public void inputAge(String age){
        input(ageBy,age);
    }
    //点击提交
    public void clickAddDo(){
        click(addDoBy);
    }
    //点击标题行
    //审核通过后有加载等待的过程，元素可见，但是因为渲染网速等原因，仍无法定位到，这里需要硬性等待
    public void clickTitleRow(String title){
        try {
            Thread.sleep(2000);
            By titleRowBy = By.xpath("//div[text()='" + title + "']//parent::td//parent::tr");
            click(titleRowBy);
        }catch (Exception e){
            System.out.println("元素定位异常："+e.getMessage());
        }
    }
    //点击审核
    public void clickCheck(){
        click(checkBy);
    }
    //点击审核通过
    public void clickCheckPass(){
        click(checkPassBy);
    }
}
