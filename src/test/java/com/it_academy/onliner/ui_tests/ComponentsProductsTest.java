package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComponentsProductsTest extends BaseTest {

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(@Optional String server, @Optional String browser){
        super.setupListeners();
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"ui"})
    @Description("Verify that Components has list of Products with data")
    public void testComponentsCategoryHasProductsWithNamesCountAndPrice(){
        navigateToOnlinerHomePage();
        new Header().clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и")
                .moveToCatalogBlockCategoryLink("Комплектующие")
                .assertEachProductHasTitle()
                .assertEachProductHasData()
                .assertEachProductHasCount()
                .assertEachProductHasPrice();
    }
}
