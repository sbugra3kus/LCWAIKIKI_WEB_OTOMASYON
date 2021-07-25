package Test;

import Test.BaseTest;
import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static Constants.Constants.*;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.List;

public class StepImplementation extends BasePage {
    private static Logger logger = LogManager.getLogger(BasePage.class);

    @Step("Hoverla")
    public void HoverByid() {
        logger.info("ERKEK MENÜSÜ AÇILIYOR");
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(By.id(MENU));
        actions.moveToElement(webElement).moveToElement(driver.findElement(By.id(MENU))).build().perform();
        logger.info("ERKEK MENÜSÜ AÇILDI");
    }

    @Step("Sıralama listesine tıklama")
    public void SortList() {
        logger.info("SIRALAMA AÇILIYOR");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id(SORT))).click();
        logger.info("SIRALAMA AÇILDI");
    }
    @Step("Tümünü seç")
    public void SelectAll() {
        logger.info("TÜMÜNÜ SEÇMEYE BASILDI");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id(SELECT_ALL))).click();
        logger.info("TÜMÜ SEÇİLDİ");
    }
    @Step("Kaldır")
    public void DeleteAll() {
        logger.info("SEÇİLENLER KALDIRILIYOR");
        driverWait.until(ExpectedConditions.elementToBeClickable(By.id(DELETE_ALL))).click();
        logger.info("SEÇİLENLER KALDIRILDI");
    }

    @Step("Gömlek listeleme")
    public void GomlekTıklama() {
        logger.info("Gömlek kısmı açılıyor");
        driver.findElement(By.cssSelector(MAN)).click();
        logger.info("Gömlek kısmı açıldı");
    }
    @Step("COOKIE KAPATMA")
    public void Cookie(){
        logger.info("cookie kapatılıyor");
        driver.findElement(By.xpath(COOKİE)).click();
        logger.info("cookie kapatıldı");
    }
    @Step("Sıralama")
    public void List(){
        logger.info("sıralama yapılıyor");
        driver.findElement(By.xpath(LIST)).click();
        logger.info("sıralama yapıldı");

    }
    @Step("GOMLEK 1")
    public void Shirt1(){
        logger.info("1. gömlek seçiliyor");
       driver.findElement(By.xpath(GOMLEK_1)).click();
        //listElements(by).get()
        logger.info("1. gömlek seçildi");
    }
    @Step("GOMLEK 2")
    public void Shirt2(){
        logger.info("2. gömlek seçiliyor");
        driver.findElement(By.xpath(GOMLEK_2)).click();
        logger.info("2. gömlek seçildi");
    }
    @Step("GOMLEK 3")
    public void Shirt3(){
        logger.info("3. gömlek seçiliyor");
        driver.findElement(By.xpath(GOMLEK_3)).click();
        logger.info("3. gömlek seçildi");
    }
    @Step("FAVORİ")
    public void Fav(){
        logger.info("Favoriler Açılıyor");
        driver.findElement(By.xpath(FAV_BUTTON)).click();
        logger.info("Favoriler açıldı");
    }
    @Step("<x> saniye kadar bekle")
    public void waitForSecond(Integer x) throws InterruptedException {
        logger.info("Static bekleme konuluyor");
        Thread.sleep(1000 * x);
        logger.info("Static bekleme yapıldı");
    }

    @Step("Sayfa kontrol")
    public void AnaSayfaKontrol(){
        logger.info("Giriş Menüsü Açılıyor");
        Assert.assertEquals(FIRST_LINK, driver.getCurrentUrl());
        logger.info("Giriş Menüsü Açılıyor");
    }
    @Step("Erkek Gömlek Sayfası")
    public void GomlekKontrol(){
        logger.info("Erkek gömlek sayfası kontrol ediliyor");
        Assert.assertEquals(SECOND_LINK, driver.getCurrentUrl());
        logger.info("Erkek gömlek sayfası kontrol edildi");
    }
    @Step("Listeleme kontrol")
    public void listelemeKontrol(){
        logger.info("Listeleme Kontrol Ediliyor");
        Assert.assertEquals(DESC_LINK,driver.getCurrentUrl());
        logger.info("Listeleme Kontrol Edildi");
    }

    @Step("Gömlekleri seçtirme")
    public void shirts(){
        logger.info("GÖMLEKLER SEÇİLİYOR");
        List <WebElement> webElementList = driver.findElements(By.xpath(ALL_SHIRTS));
        int i;
        for (i = 0 ;i<3; i++){
        webElementList.get(i).click();
        }
        logger.info("GÖMLEKLER SEÇİLDİ");
    }
    @Step("ASSERT COUNT")
    public void AssertBack() {
        logger.info("ÜRÜNLER KONTROL EDİLİYOR");
        WebElement element = (WebElement) driver.findElement(By.xpath(COUNT_SHIRTS)) ;
        String elText = element.getText();
        System.out.println(elText);
        Assert.assertEquals(COUNT,elText);
        logger.info("ÜRÜNLER KONTROL EDİLDİ");
    }
    @Step("ASSERT FAV")
    public void AssertFav() {
        logger.info("FAVORİLERİN TEMİZLENDİĞİ KONTROL EDİLİYOR");
        WebElement element = (WebElement) driver.findElement(By.xpath(NO_FAV)) ;
        String elText1 = element.getText();
        System.out.println(elText1);
        Assert.assertEquals(NO_FAV_TEXT,elText1);
        logger.info("FAVORİLER TEMİZLENDİĞİ KONTROL EDİLDİ");
    }
    @Step("ASSERT CHOOSEN")
    public void AssertChoosen() {
        logger.info("FAVORİLERİN SECİLDİĞİ KONTROL EDİLİYOR");
        WebElement element = (WebElement) driver.findElement(By.xpath(CHOOSEN_PRODUCT)) ;
        String elText2 = element.getText();
        System.out.println(elText2);
        Assert.assertEquals(COUNT,elText2);
        logger.info("FAVORİLER SECİLDİĞİ KONTROL EDİLDİ");
    }
}


