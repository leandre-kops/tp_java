package com.leandre.model;

import java.util.ArrayList;

public class Garage {
    protected ArrayList<Vehicule> vehicules;

    public Garage() {}

    public Garage(ArrayList<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

    public ArrayList<Vehicule> getVehicules() {
        return vehicules;
    }

    public void addVehicule(Vehicule vehicule) {
        vehicules.add(vehicule);
    }

    public void removeVehicule(Vehicule vehicule) {
        vehicules.remove(vehicule);
    }

    public void printVehicules() {
        for (Vehicule vehicule : vehicules) {
            System.out.println(vehicule);
        }
    }
}
