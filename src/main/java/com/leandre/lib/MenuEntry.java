package com.leandre.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public abstract class MenuEntry<T> extends Entry<T> implements Listable, Exitable {
    static final Scanner sc = new Scanner(System.in);

    protected final String name;
    final T exit;

    public MenuEntry(String name, T exit) {
        this.name = name;
        this.exit = exit;
    }

    public abstract HashMap<T, Entry> getOptions();

    @Override
    public void run() {
        T input = null;

        while (true) {
            this.show();
            this.list();
            try {
                input = this.read();
                if (Objects.equals(input, this.exit)) {
                    final int exitCode = this.exit();
                    if (exitCode == 0) {
                        break;
                    }
                }
                this.execute(input);
            }  catch (Exception e) {
                // e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void execute(T input) {
        for (Map.Entry<T, Entry> entry : getOptions().entrySet()) {
            if (Objects.equals(entry.getKey(), input)) {
                entry.getValue().run();
                return;
            }
        }
        System.out.println(input.toString() + " Choix non prix en charge !");
    }

    @Override
    public int exit() {
        return 0;
    }
}
