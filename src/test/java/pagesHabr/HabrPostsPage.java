package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HabrPostsPage extends HabrBasePage{

    public List<WebElement> posts = driver.findElements(By.xpath("//li[contains(@class, 'content-list__item_post')]//h2[contains(@class, 'post__title')]"));
    private final String titlePostFirst = posts.get(0).getText();
    public List<WebElement> postAuthors = driver.findElements(By.xpath("//a[contains(@class, 'post__user-info user-info') and (@title='Автор публикации' )] "));

    public HabrPostsPage(WebDriver driver) {
        super(driver);
    }

    @Step("открытие первой статьи")
    public HabrPostsPage openFirstPost() {
        posts.get(0).click();
        logger.info("First Post HABR is open");
        return this;
    }

    @Step("получение заголовка первой статьи")
    public String getTitlePostFirst() {return titlePostFirst;}

    @Step("открытие информации об авторе первой статьи")
    public HabrPostsPage openPostAuthor() {
        postAuthors.get(0).click();
        logger.info("First post author info is open");
        return this;
    }
}
