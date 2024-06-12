package ru.yandex.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ListPage {
    private final WebDriver driver;

    public ListPage(WebDriver driver){
        this.driver = driver;
    }

    //Локатор сообщений оважных вещах
    private final By importantThings = By.className("Home_FourPart__1uthg");

    //Кнопка куки
    private final By cookieButton = By.className("App_CookieButton__3cvqF");

    //локатор кнопок с вопросами
    public void questionClick(int numberOfQuestion){

        driver.findElement(By.xpath(".//div[@id='accordion__heading-"+(numberOfQuestion - 1)+"']")).click();
    }

    //прокрутка до вопросов
    public void scrollToQuestions() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(importantThings));
    }

    //Клик на кнопку принятия куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    //проверка наличия ответов на вопросы
    public boolean isVisible(int answerNumber) {
        return driver.findElement(By.xpath(".//div[@id='accordion__panel-" + (answerNumber- 1) + "']")).isDisplayed();
    }

}
