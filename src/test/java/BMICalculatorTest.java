import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BMICalculatorTest {

    // KG/CMS
    @Test
    public void calculateKgCMSNormal() {
        /*
    1. открыть сайт https://healthunify.com/bmicalculator/
    2. ввести вес 83
    3. ввести рост 185
    4. нажать кнопку Calculate
    5. проверить категорию (индексы)
     */

        // установить переменную среды
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        // открыть браузер
        WebDriver browser = new ChromeDriver();
        //открыть сайт https://healthunify.com/bmicalculator/
        browser.get("https://healthunify.com/bmicalculator/");
        // ввести вес 83
        browser.findElement(By.name("wg")).sendKeys("83");
        // ввести рост 185
        browser.findElement(By.name("ht")).sendKeys("185");
        // нажать кнопку Calculate
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        // проверить категорию (индексы)
        Assert.assertEquals(category, "Your category is Normal",
                "Категория не соответствует ожидаемой");
        // закрыть браузер
        browser.quit();
    }

    @Test
    public void calculateKgCMSObese() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("83");
        browser.findElement(By.name("ht")).sendKeys("150");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculateKgCMSStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("40");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    // Inch/KG
    @Test
    public void calculateKgInchNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("83");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(5);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(1);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculateKgInchObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        browser.findElement(By.name("wg")).sendKeys("83");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(3);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(11);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculateKgInchStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        browser.findElement(By.name("wg")).sendKeys("40");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(4);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(11);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    // Pounds/CMS
    @Test
    public void calculatePoundCMSNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("80");
        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("ht")).sendKeys("185");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculatePoundCMSObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("183");
        browser.findElement(By.name("ht")).sendKeys("150");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculatePoundCMSStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("30");
        browser.findElement(By.name("ht")).sendKeys("180");
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }


    // Pound/Inch
    @Test
    public void calculatePoundInchNormal() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("80");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(4);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(11);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Normal",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculatePoundInchObese() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("183");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(3);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(11);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Obese",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void calculatePoundInchStarvation() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");

        new Select(browser.findElement(By.name("opt1"))).selectByIndex(0);
        browser.findElement(By.name("wg")).sendKeys("30");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(4);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(11);
        browser.findElement(By.name("cc")).click();

        String category = browser.findElement(By.name("desc")).getAttribute("value");
        Assert.assertEquals(category, "Your category is Starvation",
                "Категория не соответствует ожидаемой");
        browser.quit();
    }

    @Test
    public void testInchToCMS() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("https://healthunify.com/bmicalculator/");
        new Select(browser.findElement(By.name("opt2"))).selectByIndex(2);
        new Select(browser.findElement(By.name("opt3"))).selectByIndex(3);

        String cms = browser.findElement(By.name("ht")).getAttribute("value");
        Assert.assertEquals(cms, "99", "Не правильная конвертация Фут/Дюйм - Сантиметр");
        browser.quit();
    }
}

