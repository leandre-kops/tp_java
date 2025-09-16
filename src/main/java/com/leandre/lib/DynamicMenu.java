package com.leandre.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class DynamicMenu extends MenuEntry<Integer> {
    public DynamicMenu(String name, Integer exit) {
        super(name, exit);
    }

    public abstract HashMap<Integer, Entry> getOptions();

    @Override
    public void show() {
        System.out.println(name);
    }

    @Override
    public void list() {
        for (Map.Entry<Integer, Entry> entry : this.getOptions().entrySet()) {
            final Entry menuEntry = entry.getValue();
            System.out.print(entry.getKey() + ": ");
            menuEntry.show();
        }
    }

    @Override
    public Integer read() {
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }
}
