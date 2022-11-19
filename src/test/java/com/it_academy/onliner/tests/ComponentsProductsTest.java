package com.it_academy.onliner.tests;

import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.Test;

import static com.it_academy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComponentsProductsTest {

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
