package com.it_academy.onliner.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import static org.apache.commons.io.FileUtils.openInputStream;

public class ScreenshotUtils {

    public static void takeScreenshotAndAttachToAllureReport() {
        try {
            File screenshot = Screenshots.takeScreenShotAsFile();
            assert screenshot != null;
            Allure.addAttachment("screenshot", openInputStream(screenshot));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
