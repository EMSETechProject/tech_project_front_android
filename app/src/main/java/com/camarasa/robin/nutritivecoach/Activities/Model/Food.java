package com.camarasa.robin.nutritivecoach.Activities.Model;

/**
 * Created by robin on 17/12/17.
 */

public class Food {
    private String intitule;
    private Float energie;
    private Float eau;
    private Float proteines;
    private Float glucides;
    private Float lipides;
    private Float sucres;
    private Float fibres;
    private Float sel;

    public Food() {
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Float getEnergie() {
        return energie;
    }

    public void setEnergie(Float energie) {
        this.energie = energie;
    }

    public Float getEau() {
        return eau;
    }

    public void setEau(Float eau) {
        this.eau = eau;
    }

    public Float getProteines() {
        return proteines;
    }

    public void setProteines(Float proteines) {
        this.proteines = proteines;
    }

    public Float getGlucides() {
        return glucides;
    }

    public void setGlucides(Float glucides) {
        this.glucides = glucides;
    }

    public Float getLipides() {
        return lipides;
    }

    public void setLipides(Float lipides) {
        this.lipides = lipides;
    }

    public Float getSucres() {
        return sucres;
    }

    public void setSucres(Float sucres) {
        this.sucres = sucres;
    }

    public Float getFibres() {
        return fibres;
    }

    public void setFibres(Float fibres) {
        this.fibres = fibres;
    }

    public Float getSel() {
        return sel;
    }

    public void setSel(Float sel) {
        this.sel = sel;
    }

    public String toString() {
        return ("Pour 100 g de " + intitule + " :\n\n" +
                "Energie :\t\t\t\t" + energie + " Kcal\n" +
                "Eau :\t\t\t\t\t\t" + eau + " g\n" +
                "Proteines :\t\t" + proteines + " g\n" +
                "Glucides :\t\t\t" + glucides + " g\n" +
                "Lipides :\t\t\t\t" + lipides + " g\n" +
                "Sucres :\t\t\t\t" + sucres + " g\n" +
                "Fibres :\t\t\t\t\t" + fibres + " g\n" +
                "Sel :\t\t\t\t\t\t\t" + sel + " g\n");
    }
}
