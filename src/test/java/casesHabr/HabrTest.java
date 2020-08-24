package casesHabr;


import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesHabr.HabrMainPage;
import pagesHabr.HabrNewsPage;
import pagesHabr.HabrPostsPage;



public class HabrTest extends HabrBaseTest {

// Проверка, что логотип отображается на главной странице
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал главной страницы")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения логотипа на главной странице")
    @Test
    public void habrTest1() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open();
        Assert.assertTrue(habrMainPage.getMainLogo().isDisplayed());
        logger.info("logo has link");
    }

// Проверка, что при переходе на страницу Авторизации есть заголовок "Вход"
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы Авторизации")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображаения заголовка на странице Авторизации")
    @Test
    public void habrTest2() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .auth();

        WebElement authTitle = driver.findElement(By.xpath("//div[contains(text(),'Вход')]"));
        Assert.assertEquals(authTitle.getText(), "Вход");
        logger.info("Title Вход is true");
    }

// Проверка, что на странице авторизации есть кнопка Вход
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы Авторизации")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения кнопки 'Вход' на странице Авторизации")
    @Test
    public void habrTest14() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .auth();

        WebElement enterButton = driver.findElement(By.xpath("//button[@name = 'go']"));
        Assert.assertTrue(enterButton.isDisplayed());
    }

// Проверка, что при переходе на страницу Регистрации есть заголовок "Регистрация"
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы Регистрации")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображаения заголовка на странице Регистрации")
    @Test
    public void habrTest3() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        WebElement regTitle = driver.findElement(By.xpath("//div[contains(text(),'Регистрация')]"));
        Assert.assertEquals(regTitle.getText(), "Регистрация");
        logger.info("Title Регистарция is true");
    }

// Проверка, что на странице Регистрации отображается кнопка Регистрация
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы Регистрации")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения кнопки 'Регистрация' на странице Регистрации")
    @Test
    public void habrTest15() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .reg();

        WebElement registrationButton = driver.findElement(By.xpath("//button[@id = 'registration_button']"));
        Assert.assertTrue(registrationButton.isDisplayed());
    }

// Проверка, что при переходе на страницу поиска значение value в поле поиска, совпадает с введенным на главной странице
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка соответствия заданного значения и результатов поиска")
    @Test
    public void habrTest4() {
        String myText = "что-то";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .search(myText);
        String xpath = "//input[contains(@value,'" + myText + "')]";
        WebElement searchText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(searchText.getAttribute("value"), myText);
        logger.info("Search page HABR has myText search");
    }
// Проверка, что в списке есть пользователь, которого искали
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы пользователей")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка отображения пользователя по которому осуществлялся поиск")
    @Test
    public void habrTest5() {
        String myUserSearch = "oldadmin";
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .users()
                    .search(myUserSearch);
        String xpath = "//*[contains(@class, 'list-snippet__username')]/a[contains(@class,'list-snippet__nickname') and contains(text(), '" + myUserSearch + "')]";
        WebElement userText = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(userText.getText(), myUserSearch);
    }

//Проверка открытия попапа смены языка
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал модального окна смены языка")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения модального ока смены языка")
    @Test
    public void habrTest6() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();
        Assert.assertTrue(habrMainPage.showLangPopup().isDisplayed());
        logger.info("lang popup is visible");
    }

//Проверка, что отображается кнопка сохранения настроек в окне смены языка
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал модального окна смены языка")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения кнопки сохранения настроек в модальном окне смены языка")
    @Test
    public void habrTest13() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .openLangPopup();

        WebElement saveSettingsButton = driver.findElement(By.xpath("//div[@class='form__footer form__footer_lang-settings']"));
        Assert.assertTrue(saveSettingsButton.isDisplayed());
    }

//Проверка заголовка статьи
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы новостей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображаения заголовка для первой статьи из списка")
    @Test
    public void habrTest7() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrNewsPage habrNewsPage = habrMainPage.open()
                .news()
                .openFirstArticle();

        WebElement titleNews = driver.findElement(By.xpath("//h2[contains(@class, 'post__title')]"));
        String textTitleNews = titleNews.getText();
        Assert.assertEquals(habrNewsPage.getTitleNewsFirst(), textTitleNews);
    }

// Проверка, что первый в списке пользователь с рейтингом 1
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы пользователей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображения пользователя с рейтингом 1 первым в списке")
    @Test
    public void habrTest8() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        WebElement firstRate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        String firstRateText = firstRate.getText();
        Assert.assertEquals(firstRateText, "1–й");
    }

// Проверка, что отображается рейтинг у зарегестированного пользователя
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы пользователей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображения общего рейтинга у первого пользователя в списке")
    @Test
    public void habrTest12() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .users()
                .openPersonalInfoFirstUser();

        WebElement userRate = driver.findElement(By.xpath("//a[contains(@class, 'user-info__stats-item stacked-counter') and (@title='Рейтинг пользователя' )] "));
        Assert.assertTrue(userRate.isDisplayed());
    }

// Проверка открытия первого поста
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы статей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображения первой статьи из списка")
    @Test
    public void habrTest9() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        HabrPostsPage habrPostsPage = habrMainPage.open()
                .posts()
                .openFirstPost();

        WebElement titlePost = driver.findElement(By.xpath("//h2[contains(@class, 'post__title')]"));
        String textTitlePost = titlePost.getText();
        Assert.assertEquals(habrPostsPage.getTitlePostFirst(), textTitlePost);
    }

// Проверка открытия страницы информации об авторе первого поста
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы статей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображения полной информации об авторе статьи")
    @Test
    public void habrTest10() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                    .posts()
                    .openPostAuthor();

        WebElement rate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        Assert.assertTrue(rate.isEnabled());
    }

// Проверка наличия приглашения у автора
    @Epic("Тестирование сервиса HABR")
    @Feature(value="функционал страницы статей")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка отображения приглашения у автора статьи")
    @Test
    public void habrTest11() {
        HabrMainPage habrMainPage = new HabrMainPage(driver);
        habrMainPage.open()
                .posts()
                .openPostAuthor();

        WebElement invite = driver.findElement(By.xpath("//p[@class = 'profile-section__invited']"));
        Assert.assertTrue(invite.isDisplayed());
    }

}





