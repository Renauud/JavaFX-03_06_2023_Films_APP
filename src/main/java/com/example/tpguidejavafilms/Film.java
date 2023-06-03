package com.example.tpguidejavafilms;

public class Film {
    private Integer rang;
    private String Id;
    private String nom;
    private Integer annee;
    private String acteurPrincipal;

    public Film() {}

    public String getActeurPrincipal() {
        return acteurPrincipal;
    }

    public void setActeurPrincipal(String acteurPrincipal) {
        this.acteurPrincipal = acteurPrincipal;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
