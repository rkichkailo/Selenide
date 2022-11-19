package com.it_academy.onliner.tests;

import com.it_academy.onliner.page_object.Header;
import org.testng.annotations.Test;

import java.util.List;

import static com.it_academy.onliner.navigation.OnlinerNavigation.navigateToOnlinerHomePage;

public class CatalogBarLinksTest {
    private static final List<String> EXPECTED_CATALOG_BAR_LINKS
            = List.of("Onlíner Prime", "Электроника", "Компьютеры и сети",
            "Бытовая техника", "Стройка и ремонт", "Дом и сад",
            "Авто и мото", "Красота и спорт", "Детям и мамам", "Работа и офис");

    @Test(groups = {"smoke test"})
    public void testCatalogBarHasExactLinksNames(){
        navigateToOnlinerHomePage();
        new Header()
                .clickOnCatalogLink()
                .assertCatalogBarLinksTextMatchExpected(EXPECTED_CATALOG_BAR_LINKS);
    }
}
