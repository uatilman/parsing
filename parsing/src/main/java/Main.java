import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://www.world-food.ru/ru-RU/about/exhibitor-list.aspx");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //elem.findElement(By.className("link")).click();

        getElements(driver);


        try {
            int i = 1;
            while (true) {

                WebElement elem = driver.findElement(By.className("pager"));
                String s = ".//a[" + i + "]";
                // System.out.println(s);/
                elem.findElement(By.xpath(s)).click();
                i++;
                if (i == 11)
                    i = 2;//ввести второй индекс для элементов больше 20, если 11 попоадается второй раз то +1 (или как то так)
                getElements(driver);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {

        }
        driver.quit();
    }

    public static void getElements(WebDriver driver) {

        for (int j = 1; j < 21; j++) {


            WebElement e = driver.findElement(By.xpath(".//div[@class=\"list exhibitorlist\"]/em[" + j + "]/a"));
            WebElement e1 = driver.findElement(By.xpath(".//div[@class=\"list exhibitorlist\"]/em[" + j + "]/span[1]"));
            WebElement e2 = driver.findElement(By.xpath(".//div[@class=\"list exhibitorlist\"]/em[" + j + "]/span[2]"));
            WebElement e3 = driver.findElement(By.xpath(".//div[@class=\"list exhibitorlist\"]/em[" + j + "]/span[3]"));
            String s = e.getText() + "***" + e1.getText() + "***" + e2.getText() + "***" + e3.getText();
            System.out.println(s);
        }
    }


}
