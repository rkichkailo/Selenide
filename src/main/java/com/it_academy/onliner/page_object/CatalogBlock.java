package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.framework.BasePage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;

public class CatalogBlock extends BasePage {

    public static final String CATALOG_BLOCK_CATEGORIES
            = "//*[@style = 'display: block;']//*[contains(@class, 'aside-title')]";

    public ElementsCollection getCatalogBlockCategories(){
        return $$x(CATALOG_BLOCK_CATEGORIES)
                .shouldHave(sizeGreaterThan(0));
    }

    public void assertCatalogBlockCategoriesHaveSomeOfExpectedNames(List<String> expectedCategories){
        getCatalogBlockCategories()
                .shouldHave(noneMatch("Some categories are empty",
                        element -> element.getText().isBlank()))
                .shouldHave(containExactTextsCaseSensitive(expectedCategories));
    }

    public Product moveToCatalogBlockCategoryLink(String link){
        $$x(CATALOG_BLOCK_CATEGORIES)
                .findBy(text(link))
                .hover();
        return new Product();
    }
}
