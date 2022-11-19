package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.framework.BasePage;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {

    public static final String CATALOG_BAR_LINKS =
            "//*[@class = 'catalog-navigation-classifier__item-title-wrapper']";

    public CatalogBlock selectCatalogBlock(String link){
        $$x(CATALOG_BAR_LINKS)
                .findBy(text(link))
                .shouldBe(and("clickable", visible, enabled))
                .click();
        return new CatalogBlock();
    }

    public ElementsCollection getCatalogBarLinks(){
        return $$x(CATALOG_BAR_LINKS)
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    public void assertCatalogBarLinksTextMatchExpected(List<String> expectedLinksText){
        getCatalogBarLinks()
                .should(exactTexts(expectedLinksText));
    }
}
