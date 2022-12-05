package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.util.List;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComputerNetworksCategoriesTest extends BaseTest {

    private static final List<String> EXPECTED_COMPUTER_NETWORKS_CATEGORIES
            = List.of("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(@Optional String server, @Optional String browser){
        super.setupListeners();
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"ui"})
    @Description("Verify that Computer Networks link has expected list of categories")
    public void testCatalogBarHasExactLinksNames(){
        navigateToOnlinerHomePage();
        new Header().clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и")
                .assertCatalogBlockCategoriesHaveSomeOfExpectedNames(EXPECTED_COMPUTER_NETWORKS_CATEGORIES);
    }
}
