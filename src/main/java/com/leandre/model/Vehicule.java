package com.leandre.model;

public class Vehicule {
    protected String marque, model, annee;

    public Vehicule(String marque, String model, String annee) {
        this.marque = marque;
        this.model = model;
        this.annee = annee;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "%s: {marque: %s, model: %s, annee: %s}".formatted(this.getClass().getName(),marque, model, annee);
    }
}
