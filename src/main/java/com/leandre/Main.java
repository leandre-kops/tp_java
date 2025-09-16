package com.leandre;

import com.leandre.lib.*;
import com.leandre.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        final Garage garage = new Garage();

        final Menu createSubMenu = getCreateSubMenu(garage);
        final Menu showSubMenu = getShowSubMenu(garage);

        final Menu menu = new Menu("Menu Principal", new HashMap<>() {{
            put(1, createSubMenu);
            put(2, showSubMenu);
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

    static protected Menu getCreateSubMenu(Garage garage) {
        final String[] marque = new String[1];
        final String[] model = new String[1];
        final String[] annee = new String[1];

        final Action typeMarqueAction = new Action("Saisissez la marque") {
            @Override
            public void execute(String params) {
                marque[0] = params;
            }
        };
        final Action typeModelAction = new Action("Saisissez la model") {
            @Override
            public void execute(String params) {
                model[0] = params;
            }
        };
        // final actions
        final Action typeAnneeActionAndCreateVoiture = new Action("Saisissez le annee") {
            @Override
            public void execute(String params) {
                annee[0] = params;
                garage.addVehicule(new Voiture(marque[0], model[0], annee[0]));
            }
        };
        final Action typeAnneeActionAndCreateVoitureElectrique = new Action("Saisissez le annee") {
            @Override
            public void execute(String params) {
                annee[0] = params;
                garage.addVehicule(new VoitureElectrique(marque[0], model[0], annee[0]));
            }
        };
        final Action typeAnneeActionAndCreateMoto = new Action("Saisissez le annee") {
            @Override
            public void execute(String params) {
                annee[0] = params;
                garage.addVehicule(new Moto(marque[0], model[0], annee[0]));
            }
        };

        final SubMenu createVoiture = new SubMenu("Créer un Voiture", new HashMap<>() {{
            put("1", typeMarqueAction);
            put("2", typeModelAction);
            put("3", typeAnneeActionAndCreateVoiture);
        }}, "0");
        final SubMenu createVoitureElectrique = new SubMenu("Créer un Voiture Electrique", new HashMap<>(){{
            put("1", typeMarqueAction);
            put("2", typeModelAction);
            put("3", typeAnneeActionAndCreateVoitureElectrique);
        }}, "0");
        final SubMenu createMoto = new SubMenu("Créer une Moto", new HashMap<>(){{
            put("1", typeMarqueAction);
            put("2", typeModelAction);
            put("3", typeAnneeActionAndCreateMoto);
        }}, "0");

        return new Menu("Créer un véhicule", new HashMap<>() {{
            put(1, createVoiture);
            put(2, createVoitureElectrique);
            put(3, createMoto);
        }}, 0);
    }

    static protected Menu getShowSubMenu(Garage garage) {
        final DynamicMenu showVoiture = new DynamicMenu("Voir Voiture", 0) {
            @Override
            public HashMap<Integer, Entry> getOptions() {
                final HashMap<Integer, Entry> options = new HashMap<>();
                final List<Vehicule> voitures = garage.getVehicules().stream()
                        .filter(Voiture.class::isInstance)
                        .map(Voiture.class::cast)
                        .collect(Collectors.toList());

                for (int i = 0; i < voitures.size() ; i++) {
                    final Vehicule vehicule = garage.getVehicules().get(i);
                    options.put(i+1, new ShowAction(vehicule.getModel(), vehicule.toString()));
                }
                return options;
            }
        };

        final DynamicMenu showMoto = new DynamicMenu("Voir Moto", 0) {
            @Override
            public HashMap<Integer, Entry> getOptions() {
                final HashMap<Integer, Entry> options = new HashMap<>();
                final List<Vehicule> voitures = garage.getVehicules().stream()
                        .filter(Moto.class::isInstance)
                        .map(Moto.class::cast)
                        .collect(Collectors.toList());

                for (int i = 0; i < voitures.size() ; i++) {
                    final Vehicule vehicule = garage.getVehicules().get(i);
                    options.put(i+1, new ShowAction(vehicule.getModel(), vehicule.toString()));
                }
                return options;
            }
        };

        final DynamicMenu showVoitureElectrique = new DynamicMenu("Voir Voiture Electrique", 0) {
            @Override
            public HashMap<Integer, Entry> getOptions() {
                final HashMap<Integer, Entry> options = new HashMap<>();
                final List<Vehicule> voitures = garage.getVehicules().stream()
                        .filter(VoitureElectrique.class::isInstance)
                        .map(VoitureElectrique.class::cast)
                        .collect(Collectors.toList());

                for (int i = 0; i < voitures.size() ; i++) {
                    final Vehicule vehicule = garage.getVehicules().get(i);
                    options.put(i+1, new ShowAction(vehicule.getModel(), vehicule.toString()));
                }
                return options;
            }
        };

        final DynamicMenu showAll = new DynamicMenu("Voir tout", 0) {
            @Override
            public HashMap<Integer, Entry> getOptions() {
                final HashMap<Integer, Entry> options = new HashMap<>();
                final List<Vehicule> voitures = garage.getVehicules();

                for (int i = 0; i < voitures.size() ; i++) {
                    final Vehicule vehicule = garage.getVehicules().get(i);
                    options.put(i+1, new ShowAction(vehicule.getModel(), vehicule.toString()));
                }
                return options;
            }
        };

        return new Menu("Voir un véhicule", new HashMap<>() {{
            put(1, showVoiture);
            put(2, showVoitureElectrique);
            put(3, showMoto);
            put(4, showAll);
        }}, 0);
    }
}