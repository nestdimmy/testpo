package FireFoxTest;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by di452 on 26.05.2017.
 */
public class AddBankPushSaveButtonTest {
    private final Browsers BROWSER = Browsers.FIREFOX;
    private WebDriver driver;
    private WebDriverWait driverWait;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before

    public void setUps()
    {
        driver =Constants.getDriver(BROWSER);
        driverWait = Constants.getDriverWait(driver);
    }
    @Test
    public void PushSaveButton() throws Exception {
        Constants.OpenBrowser();
        Constants.login(driver);
        driver.findElement(By.xpath("html/body/header/div[1]/div/div/div/ul[2]/li[1]/div/a/img")).click();
        Thread.sleep(2000);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/section[2]/div[1]/main/div[1]/div/a[2]"))).click();
        // driver.findElement(By.linkText("Профиль")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("html/body/section[2]/div[1]/aside/section[1]/div/div/div[2]/div[1]/div[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@value=''])[4]")).clear();
        driver.findElement(By.xpath("(//input[@value=''])[4]")).sendKeys("В");
        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("html/body/div[6]/section/div/form/div/div[1]/div/div/div/span[2]/div/span/div[1]/p"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(".//*[@id='uiSelect_1']/div[1]/div[1]"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath(".//*[@id='uiSelect_1']/div[2]/div/div/div[1]/div/div[2]"))).click();
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button.button--blue"))).click();
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
