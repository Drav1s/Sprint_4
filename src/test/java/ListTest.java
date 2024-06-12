import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.ListPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ListTest{
    private WebDriver driver;
    private final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final int numberOfQuestion;
    private final int answerNumber;

    public ListTest(int numberOfQuestion, int answerNumber) {
        this.numberOfQuestion = numberOfQuestion;
        this.answerNumber = answerNumber;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters(){
        return new Object[][]{
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 4},
                {5, 5},
                {6, 6},
                {7, 7},
                {8, 8}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public void testPassedTextInImportantThings() {

        ListPage listPage = new ListPage(driver);
        listPage.clickCookieButton();
        listPage.scrollToQuestions();
        listPage.questionClick(numberOfQuestion);

        assertTrue("Текст ответа на вопрос должен быть виден после клика по кнопке", listPage.isVisible(answerNumber));
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}

