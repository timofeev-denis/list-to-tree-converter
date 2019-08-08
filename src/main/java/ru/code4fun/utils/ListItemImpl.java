package ru.code4fun.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
@Data
@AllArgsConstructor
public class ListItemImpl implements ListItem {
    private String name;
    private String path;

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
}
