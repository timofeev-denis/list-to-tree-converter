package ru.code4fun.utils;

import java.util.List;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
public class TreeNodeBase {
    private List<Node> children;

    public TreeNodeBase(List<Node> children) {
        this.children = children;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
