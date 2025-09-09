package com.leandre.lib;

import java.util.HashMap;

public class SubMenu extends Menu {
    public SubMenu(String name, HashMap<Integer, MenuEntry> options, Integer exit) {
        super(name, options, exit);
    }

    @Override
    public int exit() {
        return 0;
    }
}
