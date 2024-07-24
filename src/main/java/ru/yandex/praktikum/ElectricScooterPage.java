package ru.yandex.praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class ElectricScooterPage {

    //"Заказать" в верхнем правом углу
    private final By upOrder = By.className("Button_Button__ra12g");

    //Кнопка куки
    private final By cookieButton = By.className("App_CookieButton__3cvqF");

    //"Заказать" в центре страницы
    private final By middleOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Локаторы для полей первой странциы заполнения заказа
    //Локатор поля имя
    private final By firstNameInput = By.xpath(".//input[@placeholder = '* Имя']");

    //Локатор поля фамилия
    private final By lastNameInput = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Локатор поля адрес
    private final By addressInput = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //Локатор поля станция метро
    private final By metroInput = By.xpath(".//input[@placeholder = '* Станция метро']");

    //Локатор поля номер телефона
    private final By phoneNumberInput = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");


    //Кнопка "Далее" на первой странице оформления заказа
    private final By nextButton = By.className("Button_Middle__1CSJM");

    //Локаторы для полей первой странциы заполнения заказа
    //Локатор для поля даты доставки
    private final By dateInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Локатор для поля с длительностью аренды самоката
    private final By rentInput = By.xpath(".//span[@class='Dropdown-arrow']");

    //Локатор для поля с комментарием
    private final By commentInput = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    //"Заказать" - после заполнения формы
    private final By endOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    //локатор кнопки "Да" для подтверждения заказа
    private final By endYes = By.xpath(".//button[text()='Да']");

    //локаторы чекбоксов серого и чёрного
    private static final By scooterColorCheckboxBlack = By.xpath(".//label[@for='black']/input");
    private static final By scooterColorCheckboxGrey = By.xpath(".//label[@for='grey']/input");

    //Локатолр окна офрмленного заказа
    private static final By orderConfirmation = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    private final WebDriver driver;

    public ElectricScooterPage (WebDriver driver){
        this.driver = driver;
    }

    //Клик на кнопку Заказать в верхней панели
    public void clickUpOrder(){
        driver.findElement(upOrder).click();
    }

    //Клик на кнопку приняти куки
    public void clickCookieButton(){
        driver.findElement(cookieButton).click();
    }

    //Клик на кнопку Заказать в центре страницы
    public void clickMiddleOrder(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(middleOrder));
        driver.findElement(middleOrder).click();
    }

    //заполнение формы на персвой странице и нажатие кнопки далее
    public void fillFirstPage(String firstName, String lastName, String address, String phoneNumber, String stationName){
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(addressInput).sendKeys(address);
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);

        driver.findElement(metroInput).click();
        driver.findElement(By.xpath(".//button/div[text() = '" + stationName + "']")).click();
        driver.findElement(nextButton).click();
    }

    //заполнение формы на второй странице
    public void fillSecondPage(String comment, String date, String rent){
        driver.findElement(commentInput).sendKeys(comment);
        driver.findElement(dateInput).sendKeys(date);

        driver.findElement(rentInput).click();
        driver.findElement(By.xpath("//div[contains(text(), '"+rent+"')]")).click();

    }

    //проверка увета самоката
    public void selectScooterColor(String colourName) {
        if (colourName.equalsIgnoreCase("black")) {
            driver.findElement(scooterColorCheckboxBlack).click();
        } else if (colourName.equalsIgnoreCase("grey")) {
            driver.findElement(scooterColorCheckboxGrey).click();
        }
    }

    //Клик на кнопку Заказать в конце формы
    public void clickEndOrder (){
        driver.findElement(endOrder).click();
    }

    //Клик на кнопку Да при подтверждении заказа
    public void clickEndYes (){
        driver.findElement(endYes).click();
    }

    //проверка видимости окна оформления заказа
    public boolean isVisible() {
        return driver.findElement(orderConfirmation).isDisplayed();
    }


}
