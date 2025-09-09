package com.leandre.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public abstract class MenuEntry<T> implements Executable<T>, Inputable<T>, Showable, Listable, Runnable, Exitable {
    static final Scanner sc = new Scanner(System.in);

    final HashMap<T, MenuEntry> options;
    final String name;
    final T exit;

    public MenuEntry(String name, HashMap<T, MenuEntry> options, T exit) {
        this.name = name;
        this.options = options;
        this.exit = exit;
    }

    @Override
    public void run() {
        T input = null;
        while (true) {
            this.show();
            this.list();
            input = this.read();
            if (Objects.equals(input, this.exit)) {
                final int exitCode = this.exit();
                if (exitCode == 0) {
                    break;
                }
            }
            this.execute(input);
        }
    }

    @Override
    public void execute(T input) {
        for (Map.Entry<T, MenuEntry> entry : options.entrySet()) {
            if (Objects.equals(entry.getKey(), input)) {
                entry.getValue().run();
                return;
            }
        }
        System.out.println(input.toString() + " Choix non prix en charge !");
    }
}
