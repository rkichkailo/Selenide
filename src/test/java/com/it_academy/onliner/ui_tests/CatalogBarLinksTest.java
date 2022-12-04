package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.*;

import java.util.List;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class CatalogBarLinksTest extends BaseTest {
    private static final List<String> EXPECTED_CATALOG_BAR_LINKS
            = List.of("Onlíner Prime", "Электроника", "Компьютеры и сети",
            "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(@Optional String server, @Optional String browser){
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"ui"})
    public void testCatalogBarHasExactLinksNames(){
        navigateToOnlinerHomePage();
        new Header()
                .clickOnCatalogLink()
                .assertCatalogBarLinksTextMatchExpected(EXPECTED_CATALOG_BAR_LINKS);
    }
}
