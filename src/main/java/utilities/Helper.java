package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    private WebDriver driver;

    public static void takeScreenshot(WebDriver driver) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_YYYY_HH_mm_ss");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("./image" + simpleDateFormat.format(date.getTime()) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
