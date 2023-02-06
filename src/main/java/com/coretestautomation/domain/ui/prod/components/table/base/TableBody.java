package com.coretestautomation.domain.ui.prod.components.table.base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.coretestautomation.core.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TableBody {

    private SelenideElement tableLocator;
    private SelenideElement table;
    private static final ElementsCollection TABLE_ROWS_ELEMENTS = $$(By.xpath("//tbody/tr[@role='row']"));
    private static final ElementsCollection TABLE_HEADERS = $$(By.xpath("//div[@class='x-column-header-text-wrapper']/div/span[text()]"));
    private static final ElementsCollection TABLE_CELLS = $$(By.xpath("//td[@role='gridcell']"));
    private static final ElementsCollection TABLE_CELL_LOCATOR = $$(By.xpath("//tr[@role]//td[@role='gridcell']/div"));

    public TableBody(SelenideElement tableLocator){
        this.tableLocator = tableLocator;
    }

    public TableRowItem findItemBy(String tableHeader, String valueToSearch) {
        Log.info("Searching for '" + valueToSearch + "' in column '" + tableHeader + "'");
        try {

            tableLocator.shouldBe(visible);
            table = tableLocator;

            Map<String, Integer> headersMap = getHeadersMap();

            TABLE_ROWS_ELEMENTS.shouldHave(CollectionCondition.size(1));

            List<SelenideElement> rows = TABLE_ROWS_ELEMENTS;

            if (rows.size() >= 2) {
                if (TABLE_CELLS.size() < headersMap.size()) {
                    Log.info("Item with value '" + valueToSearch + "' wasn't found in table");
                    return null;
                }
            }
            //skip 0 index here because first element is Id, which is filled with th items
            for (int i = 0; i < TABLE_CELL_LOCATOR.size(); i++) {
                if(TABLE_CELL_LOCATOR.get(i).getText().contains(valueToSearch)){
                    Log.info("Item found!");
                    return createTableRowItem(rows.get(i-1), headersMap);
                }
            }

        } catch (Throwable t) {
            //Error during table analyzing, do nothing here
            Log.error("Failed to parse table", t);
        }
        Log.error("Item with value '" + valueToSearch + "' in column '" + tableHeader + "' wasn't found in table");
        return null;
    }


    /**
     * Returns header name its span position index starting from 1
     *
     * @return getHeadersMap
     */
    private Map<String, Integer> getHeadersMap() {
        Map<String, Integer> headersMap = new HashMap<>();
        List<SelenideElement> headers = TABLE_HEADERS;
        int number = 0;
        for (int i = 0; i < headers.size(); i++) {
            String key = headers.get(i).getText().trim();
            if (headersMap.get(key) != null) {
                ++number;
                headersMap.put(key + "[" + number + "]", i + 1);
            } else {
                headersMap.put(key, i + 1);
            }
        }
        return headersMap;
    }

    /**
     * Returns table from TableRowItem
     */
    private TableRowItem createTableRowItem(WebElement row, Map<String, Integer> headersMap) {
        TableRowItem tableRowItem = new TableRowItem();
        for (int i = 1; i <= headersMap.size()-3; i++) {
            String value = row.getText();
            tableRowItem.addData(getHeaderByIndex(i, headersMap), value);
        }
        return tableRowItem;
    }

    /**
     * Returns header name by index
     */
    private String getHeaderByIndex(int index, Map<String, Integer> headersMap) {
        for (Map.Entry<String, Integer> entry : headersMap.entrySet()) {
            if (index == entry.getValue()) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("No such header by index " + index);
    }
}
