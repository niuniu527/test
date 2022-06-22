package common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * ClassName: BaseCase
 * @author Administrator
 * @version V1.0.0 
 * @Desc 父类
 * @since JDK 1.8
 * date: 2020/9/11 14:01
 */
public class BasePage {
    //添加log
    private Logger log = Logger.getLogger(BasePage.class);
    //driver由子类通过构造方法super（driver）传递给父类
    //protected专门用来提供给子类的
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    /**
     * 封装显示等待：元素可见
     * @param by 元素定位信息
     * @return   元素对象
     */
    public WebElement waitElementVisibility(By by){
        log.info(by);
        WebElement element=null;
        try{
            WebDriverWait wait=new WebDriverWait(driver,5);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch (Exception e){
            log.error("元素定位异常："+e.getMessage());
        }
        return element;
    }

    /**
     * 封装显示等待：元素可点击
     * @param by 元素定位信息
     * @return   元素对象
     */
    public WebElement waitElementClickable(By by){
        log.info(by);
        WebElement element=null;
        try{
            WebDriverWait wait=new WebDriverWait(driver,5);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }catch (Exception e){
            log.error("元素定位异常："+e.getMessage());
        }
        return element;
    }

    /**
     * 输入文本框
     * @param by 元素定位信息
     * @param content 用例具体值
     */
    public void input(By by,String content) {
        WebElement element = waitElementVisibility(by);
        element.clear();
        if (element != null) {
            element.sendKeys(content);
        }
    }

    /**
     * 元素点击
     * @param by 元素定位信息
     */
    public void click(By by){
        WebElement element = waitElementVisibility(by);
        if(element!=null){
            element.click();
        }
    }

    /**
     * 获取元素文本
     * @param by 元素定位信息
     * @return   元素对象
     */
    public String getElementText(By by){
        WebElement element = waitElementVisibility(by);
        if(element!=null){
            return element.getText();
        }
        return "";
    }

    /**
     * 获取元素属性值
     * @param by            元素定位信息
     * @param attributeName 属性名称
     * @return              属性值
     */
    public String getElementAttribute(By by,String attributeName){
        WebElement element = waitElementVisibility(by);
        String value = "";
        if (element != null) {
            value = element.getAttribute(attributeName);
        }
        return value;
    }

    /**
     * 判断元素是否可见
     * @param by 元素定位信息
     * @return   ture或false
     */
    public Boolean elementIsDisplayed(By by){
        WebElement element = waitElementVisibility(by);
        if (element!=null){
            return element.isDisplayed();
        }
        return false;
    }

    /**
     * 输入键盘key
     * @param by   元素定位信息
     * @param key  键盘key
     */
    public void inputKey(By by, Keys key){
        WebElement element=waitElementVisibility(by);
        if (element!=null){
            element.sendKeys(key);
        }
    }

    /**
     * 下拉框选择（根据文本选择）
     * @param by    元素定位信息
     * @param value 选择文本
     */
    public void select(By by,String value){
        WebElement element = waitElementVisibility(by);
        if (element!=null){
            Select select = new Select(element);
            select.selectByValue(value);
            List<WebElement> options = select.getOptions();
            log.info(options);
        }
    }

    /**
     * 随机一个索引并点击（元素）
     * @param by  元素定位信息
     */
    public void randomSelectElement(By by){
        List<WebElement> elements = driver.findElements(by);
        if(elements.get(0)!=null){
            Random random = new Random();
            int index = random.nextInt(elements.size());
            WebElement element = elements.get(index);
            element.click();
        }else{
        log.info("没有可选择项");}
    }

    /**
     * 输入一个索引并点击（元素）
     * @param by  元素定位信息
     */
    public void inputIndexSelect(By by,Integer index){
        List<WebElement> elements = driver.findElements(by);
        if(elements.get(0)!=null){
            WebElement element = elements.get(index);
            element.click();
        }else{
        log.info("没有可选择项");}
    }


    /**
     * 页面刷新
     */
    public void refresh(){
        driver.navigate().refresh();
    }
}

