package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.*;

import java.util.List;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComputerNetworksCategoriesTest extends BaseTest {

    private static final List<String> EXPECTED_COMPUTER_NETWORKS_CATEGORIES
            = List.of("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(@Optional String server, @Optional String browser){
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"ui"})
    public void testCatalogBarHasExactLinksNames(){
        navigateToOnlinerHomePage();
        new Header().clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и")
                .assertCatalogBlockCategoriesHaveSomeOfExpectedNames(EXPECTED_COMPUTER_NETWORKS_CATEGORIES);
    }
}
