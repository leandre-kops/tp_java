package com.leandre;

public class VoitureElectrique extends Vehicule implements Electrique {
    public VoitureElectrique(String marque, String model, String annee) {
        super(marque, model, annee);
    }

    @Override
    public void recharger() {

    }
}
