package ru.code4fun.utils;

import java.util.List;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
public interface TreeItem {
    List<TreeItem> getChildren();

    void setChildren(List<TreeItem> children);
}
