package com.it_academy.onliner.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.it_academy.onliner.framework.BasePage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$$x;
import static java.time.Duration.ofSeconds;

public class CatalogPage extends BasePage {

    public static final ElementsCollection CATALOG_BAR_LINKS =
            $$x("//*[@class = 'catalog-navigation-classifier__item-title-wrapper']");

    @Step
    public CatalogBlock selectCatalogBlock(String link){
       CATALOG_BAR_LINKS
                .findBy(text(link))
                .shouldBe(and("clickable", visible, enabled), ofSeconds(10))
                .click();
        return new CatalogBlock();
    }

    public ElementsCollection getCatalogBarLinks(){
        return CATALOG_BAR_LINKS
                .shouldHave(sizeGreaterThan(0), ofSeconds(10));
    }

    @Step
    public void assertCatalogBarLinksTextMatchExpected(List<String> expectedLinksText){
        getCatalogBarLinks()
                .should(exactTexts(expectedLinksText), ofSeconds(10));
    }
}
