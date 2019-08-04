package ru.code4fun.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
class ListToTreeConverter {

    private static final String PATH_SEPARATOR = ".";

    static Node convert(List<ListItem> list) {
        ArrayList<Node> children = new ArrayList<>();
        Node root = new Node(list.get(0).getName(), children);
        String currentNodePath = list.get(0).getPath();

        addChildren(list.toArray(new ListItem[0]), children, 1, currentNodePath);

        return root;
    }

    private static int addChildren(ListItem[] items, List<Node> target, Integer startAt, String parentPath) {
        String prevNodePath = null;
        List<Node> prevNodeChildren = null;
        int i = startAt;
        while (i < items.length) {
            if (isChild(items[i].getPath(), parentPath)) {
                // TODO: Реализовать конвертер из ListItem в Node
                prevNodePath = items[i].getPath();
                prevNodeChildren = new ArrayList<>();
                target.add(new Node(items[i].getName(), prevNodeChildren));
                i++;
            } else if (isGrandChild(items[i].getPath(), parentPath)) {
                i = addChildren(items, prevNodeChildren, i, prevNodePath);
            } else {
                return i;
            }
        }
        return items.length;
    }

    static boolean isChild(String childPath, String parentPath) {
        return childPath.startsWith(parentPath)
                && childPath.indexOf(PATH_SEPARATOR, parentPath.length()) == parentPath.length()
                && childPath.indexOf(PATH_SEPARATOR, parentPath.length() + 1) == -1;
    }

    private static boolean isGrandChild(String childPath, String parentPath) {
        return childPath.startsWith(parentPath)
                && childPath.indexOf(PATH_SEPARATOR, parentPath.length()) == parentPath.length()
                && childPath.indexOf(PATH_SEPARATOR, parentPath.length() + 1) != -1;
    }
}
