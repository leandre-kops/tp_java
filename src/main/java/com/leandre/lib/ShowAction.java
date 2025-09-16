package com.leandre.lib;

public class ShowAction extends Action {

    final String text;

    public ShowAction(String prompt, String text) {
        super(prompt);
        this.text = text;
    }

    @Override
    public void run() {
        System.out.println(text);
    }

    @Override
    public void execute(String params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
