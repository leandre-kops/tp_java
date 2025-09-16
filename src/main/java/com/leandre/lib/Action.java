package com.leandre.lib;

import java.util.Scanner;

public abstract class Action extends Entry<String> {
    static final Scanner sc = new Scanner(System.in);

    protected final String prompt;

    public Action(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public String read() {
        return sc.nextLine();
    }

    @Override
    public void show() {
        System.out.print(prompt + " : ");
    }

    @Override
    public void run() {
        this.show();
        String input;
        input = this.read();
        this.execute(input);
    }
}
