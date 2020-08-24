package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HabrMainPage extends HabrBasePage{
    public static String URL = "https://habr.com/ru";
    private By authBtn = By.xpath("//a[@id=\"login\"]");
    private By regBtn = By.xpath("//a[contains(@class, 'btn_navbar_registration')]");
    private By searchBtn = By.xpath("//button[@id=\"search-form-btn\"]");
    private By searchField = By.xpath("//input[@id=\"search-form-field\"]");
    private By logo = By.xpath("//a[@class='logo']");
    private By usersLink = By.xpath("//h3[contains(text(),'Авторы')]");
    private By langBtn = By.xpath("//button[contains(@class, 'btn_navbar_lang')]");
    private By langPopup = By.xpath("//*[@id=\"js-lang_settings\"]/div[@class=\"popup\"]");
    private By newsLink = By.xpath("//h3[contains(text(),'Новости')]");
    private By postsLink = By.xpath("//h3[contains(text(),'Статьи')]");

    public HabrMainPage(WebDriver driver) {
        super(driver);
    }

    @Step("открытие главной страницы HABR")
    public HabrMainPage open() {
        driver.get(URL);
        logger.info("Main page HABR is open");
        return new HabrMainPage(driver);
    }

    public WebElement getMainLogo(){
        return driver.findElement(logo);
    }

    @Step("открытие страницы авторизации")
    public HabrAuthPage auth() {
        driver.findElement(authBtn).click();
        logger.info("Auth page HABR is open");
        return new HabrAuthPage();
    }

    @Step("открытие страницы регистрации")
    public HabrRegPage reg() {
        driver.findElement(regBtn).click();
        logger.info("Reg page HABR is open");
        return new HabrRegPage();
    }

    @Step("открытие страницы поиска")
    public HabrSearchPage search(String myText) {
        driver.findElement(searchBtn).click();
        driver.findElement(searchField).sendKeys(myText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        logger.info("Search page HABR is open");
        return new HabrSearchPage();
    }

    @Step("открытие страницы списка пользователей")
    public HabrUsersPage users() {
        driver.findElement(usersLink).click();
        logger.info("Users page HABR is open");
        return new HabrUsersPage(driver);
    }

    @Step("открытие страницы смены языка")
    public HabrMainPage openLangPopup() {
        driver.findElement(langBtn).click();
        logger.info("Users page HABR is open");
        //new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"js-lang_settings\"]/div[@class=\"popup\"]")));
        return new HabrMainPage(driver);
    }

    @Step("отображение попапа смены языкаи")
    public WebElement showLangPopup() {
        return driver.findElement(langPopup);
    }

    @Step("открытие страницы новостей")
    public HabrNewsPage news() {
        driver.findElement(newsLink).click();
        logger.info("News page HABR is open");
        return new HabrNewsPage(driver);
    }

    @Step("открытие страницы статей")
    public HabrPostsPage posts() {
        driver.findElement(postsLink).click();
        logger.info("Posts page HABR is open");
        return new HabrPostsPage(driver);
    }

}
