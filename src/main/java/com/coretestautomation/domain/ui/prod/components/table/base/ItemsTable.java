package com.coretestautomation.domain.ui.prod.components.table.base;

import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import static com.codeborne.selenide.Condition.visible;

public class ItemsTable {

    protected TableBody tableBody;
    protected SearchItems searchItems;

    public ItemsTable(SelenideElement tableLocator) {
        tableBody = new TableBody(tableLocator);
        searchItems = new SearchItems();
    }

    public void searchEnterSearchText(String searchingText) {
        Log.info("Enter text " + searchingText + " to 'Search Grid Data' field");


        searchItems.searchEnterSearchText
                .shouldBe(visible)
                .setValue(searchingText)
                .pressEnter();
    }

    public void searchSelectSearchField(String optionToBeSelected) {
        Log.info("Select " + optionToBeSelected + " from dropDown");

        searchItems.searchSelectSearchField
                .setValue(optionToBeSelected)
                .pressEnter();
    }

    public void searchStartTypingToFilterGrid(String searchingText) {
        Log.info("Enter text " + searchingText + " to 'Filter Grid Data' field");

        searchItems.searchStartTypingToFilterGrid
                .setValue(searchingText)
                .pressEnter();
    }

    public void clickOnSearchButton() {
        Log.info("Perform click on Search button");

        searchItems.searchBtn.click();
    }

    public boolean isProductInTheList() {
        boolean isFound = !searchItems.noDataToDisplayMessage.isDisplayed();

        Log.info("Is product found in the list: " + isFound);
        return isFound;
    }


    /**
     * Find table row and by value from columnName header
     *
     * @param columnName - table header
     * @param tableValue - value to search in column
     * @return TableItem
     */
    public TableRowItem searchInTable(String columnName, String tableValue) {
        return tableBody.findItemBy(columnName, tableValue);
    }
}
