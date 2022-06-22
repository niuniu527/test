package pages;

import common.BasePage;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ClassName:LoanDetailPage
 * Desc:投标详情页
 * Author:Administrator
 * Date:2020/9/15 16:41
 * Version:V1.0.0
 * JDK:1.8.0_231
 */
public class LoanDetailPage extends BasePage {
    public LoanDetailPage(WebDriver driver){
        super(driver);
    }
    //定位可用余额
    private By investAmountBy=By.xpath("//input[@data-url='/Invest/invest']");
    //定位投标按钮
    private By biddingBtnBy=By.xpath("//button[contains(text(),'投标')]");
    //定位投标成功
    private By biddingSuccessBy= By.xpath("//div[@class='layui-layer-content']//div[@class='capital_font1 note']");
    //定位剩余
    private By surplusBy = By.xpath("//span[text()='剩余：']//following-sibling::span");

    //输入可用余额
    public void inputInvestAmount(String amount){
        input(investAmountBy,amount);
    }
    //点击投标按钮
    public void clickBiddingBtn(){
        click(biddingBtnBy);
    }
    //判断投标成功弹出框是否可见
    public boolean biddingSuccessIsDisplayed(){
       return elementIsDisplayed(biddingSuccessBy);
    }
    //获取剩余文本
    public String getSurplusText() {
        return getElementText(surplusBy);
    }
}
