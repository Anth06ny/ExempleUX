package com.exempleux.bean;

public class Eleve {

    private String nom;
    private String prenom;
    private int enseignantId;

    public Eleve() {

    }


    public Eleve(final String prenom, final String nom) {
        super();

        this.nom = nom;
        this.prenom = prenom;
        this.enseignantId = enseignantId;
    }



    /* -------------------------
    // getter/setter
    //------------------------- */

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getEnseignantId() {
        return enseignantId;
    }

    public void setEnseignantId(int enseignantId) {
        this.enseignantId = enseignantId;
    }
}
