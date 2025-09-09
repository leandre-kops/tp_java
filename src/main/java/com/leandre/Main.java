package com.leandre;

import com.leandre.lib.Menu;
import com.leandre.lib.SubMenu;

import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        final Menu createVoiture = new SubMenu("Créer un Voiture", new HashMap<>(), 0);
        final Menu createVoitureElectrique = new SubMenu("Créer un Voiture Electrique", new HashMap<>(), 0);
        final Menu createMoto = new SubMenu("Créer une Moto", new HashMap<>(), 0);

        final Menu createSubMenu = new SubMenu("Créer un véhicule", new HashMap<>(){{
            put(1,  createVoiture);
            put(2,  createVoitureElectrique);
            put(3,  createMoto);
        }}, 0);

        final Menu menu = new Menu("Menu Principal", new HashMap<>() {{
            put(1, createSubMenu);
        }}, 0) {
            @Override
            public int exit() {
                System.out.println("Au revoir");
                System.exit(0);
                return 0;
            }
        };

        menu.run();
    }
}