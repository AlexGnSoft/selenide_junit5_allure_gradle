package com.coretestautomation.domain.ui.prod.components.table.base;

import java.util.LinkedHashMap;
import java.util.Map;

public class TableRowItem {

    private Map<String, String> data;

    public TableRowItem() {
        data = new LinkedHashMap<>();
    }

    public void addData(String header, String value) {
        data.put(header, value);
    }

    public String getDataByHeader(String header) {
        return data.get(header);
    }
}
