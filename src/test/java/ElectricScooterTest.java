import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.ElectricScooterPage;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class ElectricScooterTest{
        private WebDriver driver;
        private final String URL = "https://qa-scooter.praktikum-services.ru/";
        private final String firstName;
        private final String lastName;
        private final String address;
        private final String stationName;
        private final String phoneNumber;
        private final String date;
        private final String rent;
        private final String colourName;
        private final String comment;

        public ElectricScooterTest(String firstName, String lastName, String address, String stationName, String phoneNumber, String date, String rent, String colourName, String comment) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.stationName = stationName;
            this.phoneNumber = phoneNumber;
            this.date = date;
            this.rent = rent;
            this.colourName = colourName;
            this.comment = comment;
        }

        @Parameterized.Parameters
        public static Object[][] getParameters() {
            return new Object[][]{
                    {"Александр", "Пушкин", "Улица Пушкина", "Комсомольская", "78888888888", "10.06.2024", "трое суток", "grey", "Капитанская дочка"},
                    {"Михаил", "Лермонтов", "Улица Лермонтова", "Комсомольская", "79999999999", "11.06.2024", "двое суток", "black", "Герой нашего времени"},
            };
        }


    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testPassedScooterOrderByPageUpButton() {

        ElectricScooterPage electricScooterPage = new ElectricScooterPage(driver);
        electricScooterPage.clickCookieButton();
        electricScooterPage.clickUpOrder();
        electricScooterPage.fillFirstPage(firstName, lastName, address, phoneNumber, stationName);
        electricScooterPage.selectScooterColor(colourName);
        electricScooterPage.fillSecondPage(comment, date, rent);
        electricScooterPage.clickEndOrder();
        electricScooterPage.clickEndYes();
        electricScooterPage.isVisible();
    }

    @Test
    public void testPassedScooterOrderByPageMiddleButton() {

        ElectricScooterPage electricScooterPage = new ElectricScooterPage(driver);
        electricScooterPage.clickCookieButton();
        electricScooterPage.clickMiddleOrder();
        electricScooterPage.fillFirstPage(firstName, lastName, address, phoneNumber, stationName);
        electricScooterPage.selectScooterColor(colourName);
        electricScooterPage.fillSecondPage(comment, date, rent);
        electricScooterPage.clickEndOrder();
        electricScooterPage.clickEndYes();
        electricScooterPage.isVisible();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
