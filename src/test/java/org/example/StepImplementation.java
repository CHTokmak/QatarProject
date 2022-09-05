package org.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.BaseTest.appiumDriver;

public class StepImplementation {
    @Step("<time> saniye bekle")
    public void waitForsecond(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
    }

    @Step("<id> button elementini bul ve tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("<Aid> elementine tıkla")
    public void clickByAid(String Aid) {
        appiumDriver.findElementByAccessibilityId(Aid).click();
        System.out.println("Element tıklandı");
    }
    @Step("<id> elementi bul ve <text> değerini yaz")
    public void sendKeysByid(String id,String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(text + "değeri yazıldı");
    }
    @Step("<xpath> Xpath elementine tıkla")
    public void clickByXpath(String xpath) {
        appiumDriver.findElementByXPath(xpath).click();
        System.out.println("Element tıklandı");
    }
    @Step("<xpath> Xpath'li elementler arasında rasgele bir tanesine tıkla")
    public void clickByrandomElement(String xpath){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("idex====" + index);
        elements.get(index).click();
    }
    @Step("<id> İd'li element <text> değerini içeriyor mu kontrol et")
    public void ControltoElementEquality(String id,String text){
        MobileElement element = appiumDriver.findElement(By.id(id));
        System.out.println("Alınan elementın text değeri " + element.getText());
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil",element.getText().equals(text));
    }
    @Step("<id> İd'li element bulunuyor mu kontrol et")
    public void ControlElement(String id){
        MobileElement element = appiumDriver.findElement(By.id(id));
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil", element.isDisplayed());
        System.out.println("Element bulunmakta");
    }
    @Step("<xpath> XPATH'li element bulunuyor mu kontrol et")
    public void ControlElementXPATH(String xpath){
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil", element.isDisplayed());
        System.out.println("Element bulunmakta");
    }


}
