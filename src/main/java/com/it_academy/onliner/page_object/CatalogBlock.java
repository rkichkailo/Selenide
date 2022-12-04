package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class CatalogBlock extends BasePage {

    public static final ElementsCollection CATALOG_BLOCK_CATEGORIES
            = $$x("//*[@style = 'display: block;']//*[contains(@class, 'aside-title')]");

    public ElementsCollection getCatalogBlockCategories(){
        return CATALOG_BLOCK_CATEGORIES
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Step
    public void assertCatalogBlockCategoriesHaveSomeOfExpectedNames(List<String> expectedCategories){
        getCatalogBlockCategories()
                .shouldHave(noneMatch("Some categories are empty",
                        element -> element.getText().isBlank()), ofSeconds(10))
                .shouldHave(containExactTextsCaseSensitive(expectedCategories), ofSeconds(10));
    }

    @Step ("moveToCatalogBlockCategoryLink {}")
    public Product moveToCatalogBlockCategoryLink(String link){
        CATALOG_BLOCK_CATEGORIES
                .findBy(text(link))
                .hover();
        return new Product();
    }
}
