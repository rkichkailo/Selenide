package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.BaseTest;
import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.*;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComponentsProductsTest extends BaseTest {

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(@Optional String server, @Optional String browser){
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"ui"})
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
