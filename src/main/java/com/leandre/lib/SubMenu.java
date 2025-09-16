package com.leandre.lib;

import java.util.HashMap;
import java.util.Objects;

public class SubMenu extends MenuEntry<String> {

    final HashMap<String, Entry> options;

    public SubMenu(String name, HashMap<String, Entry> options, String exit) {
        super(name, exit);
        this.options = options;
    }

    @Override
    public HashMap<String, Entry> getOptions() {
        return this.options;
    }

    @Override
    public void run() {
        String input = null;

        this.show();
        for (Entry entry : this.options.values()) {
            entry.show();
            try {
                input = this.read();
                if (Objects.equals(input, this.exit)) {
                    final int exitCode = this.exit();
                    if (exitCode == 0) {
                        break;
                    }
                }
                entry.execute(input);
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public void list() {
        this.show();
        for (Entry entry : this.options.values()) {
            entry.show();
        }
    }

    @Override
    public void show() {
        System.out.println(this.name);
    }
}
