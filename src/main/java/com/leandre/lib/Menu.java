package com.leandre.lib;

import java.util.HashMap;
import java.util.Map;

public abstract class Menu extends MenuEntry<Integer> {

    public Menu(String name, HashMap<Integer, MenuEntry> options,  Integer exit) {
        super(name, options, exit);
    }

    @Override
    public void show() {
        System.out.println(name);
    }

    @Override
    public void list() {
        for (Map.Entry<Integer, MenuEntry> entry : options.entrySet()) {
            MenuEntry menuEntry = entry.getValue();
            System.out.print(entry.getKey() + ": ");
            menuEntry.show();
        }
    }

    @Override
    public Integer read() {
        return sc.nextInt();
    }
}
