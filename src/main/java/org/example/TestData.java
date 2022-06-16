package org.example;

import java.util.List;

public class TestData {
    private List<Item> list;

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public static class Item {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
