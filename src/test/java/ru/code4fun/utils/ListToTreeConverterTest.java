package ru.code4fun.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by: Denis Timofeev
 * Date: 04.08.2019
 */
class ListToTreeConverterTest {
    private List<ListItemImpl> list;

    @BeforeEach
    void setUp() {
        List<ListItemImpl> items = Arrays.asList(
                new ListItemImpl("Item 0", "0"),
                new ListItemImpl("Item 0.0", "0.0"),
                new ListItemImpl("Item 0.0.0", "0.0.0"),
                new ListItemImpl("Item 0.0.1", "0.0.1"),
                new ListItemImpl("Item 0.0.2", "0.0.2"),
                new ListItemImpl("Item 0.0.2.0", "0.0.2.0"),
                new ListItemImpl("Item 0.1", "0.1"),
                new ListItemImpl("Item 0.1.0", "0.1.0"),
                new ListItemImpl("Item 0.2", "0.2"),
                new ListItemImpl("Item 0.2.0", "0.2.0"),
                new ListItemImpl("Item 0.3", "0.3"));
        list = new ArrayList<>(items);
    }

    @Test
    void rootHasNameOfTheFirstElement() {
        TreeItemImpl root = ListToTreeConverter.convert(list);
        assertEquals(list.get(0).getName(), root.getName());
    }

    @Test
    void rootHasFourChildren() {
        TreeItemImpl root = ListToTreeConverter.convert(list);
        assertEquals(4, root.getChildren().size());
    }

    @Test
    void isChildLevelOne() {
        assertTrue(ListToTreeConverter.isChild("0.0", "0"));
    }

    @Test
    void isChildLevelTwo() {
        assertTrue(ListToTreeConverter.isChild("0.1.2", "0.1"));
    }

    @Test
    void isChildSamePathFails() {
        assertFalse(ListToTreeConverter.isChild("0.0", "0.0"));
    }

    @Test
    void isChildPathMismatchFails() {
        assertFalse(ListToTreeConverter.isChild("0.1.0", "0.0"));
    }

    @Test
    void isChildNextCharIsNotSeparatorFails() {
        assertFalse(ListToTreeConverter.isChild("0.0", "00"));
    }

    @Test
    void isChildGrandchildFails() {
        assertFalse(ListToTreeConverter.isChild("0.0", "0.0.0"));
    }

}
