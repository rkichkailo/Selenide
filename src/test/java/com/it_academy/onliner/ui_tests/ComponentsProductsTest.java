package com.it_academy.onliner.ui_tests;

import com.it_academy.onliner.framework.driver.DriverManager;
import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.*;

import static com.it_academy.onliner.navigation.ui.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComponentsProductsTest {

    @BeforeClass
    @Parameters({"server", "browser"})
    public void setUp(String server, @Optional String browser){
        DriverManager.initDriver(server, browser);
    }

    @Test(groups = {"smoke test"})
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
