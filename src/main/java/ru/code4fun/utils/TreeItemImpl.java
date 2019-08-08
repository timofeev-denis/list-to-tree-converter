package ru.code4fun.utils;

import java.util.List;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
public class TreeItemImpl implements TreeItem {
    private String name;
    private List<TreeItem> children;

    TreeItemImpl(String name, List<TreeItem> children) {
        this.name = name;
        this.children = children;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<TreeItem> getChildren() {
        return this.children;
    }

    @Override
    public void setChildren(List<TreeItem> children) {
        this.children = children;
    }
}
