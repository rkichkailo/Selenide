package com.it_academy.onliner.tests;

import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;

public class ComputerNetworksCategoriesTest {

    private static final List<String> EXPECTED_COMPUTER_NETWORKS_CATEGORIES
            = List.of("Ноутбуки, компьютеры, мониторы", "Комплектующие", "Хранение данных", "Сетевое оборудование");

    @Test(groups = {"smoke test"})
    public void testCatalogBarHasExactLinksNames(){
        navigateToOnlinerHomePage();
        new Header().clickOnCatalogLink()
                .selectCatalogBlock("Компьютеры и")
                .assertCatalogBlockCategoriesHaveSomeOfExpectedNames(EXPECTED_COMPUTER_NETWORKS_CATEGORIES);
    }
}
