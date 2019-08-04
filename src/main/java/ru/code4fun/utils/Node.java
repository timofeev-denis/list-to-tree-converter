package ru.code4fun.utils;

import java.util.List;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */

public class Node extends TreeNodeBase {
    private String name;

    public Node(String name, List<Node> children) {
        super(children);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
