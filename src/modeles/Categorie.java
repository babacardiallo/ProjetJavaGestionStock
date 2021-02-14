package modeles;

import java.sql.Date;
import java.util.List;

public class Categorie {

    private Long id;
    private String nom;
    private Date dateCreation;
    private List<Produit> produitList;

    public Categorie() {
    }

    public Categorie(String nom, Date dateCreation) {
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

    public Categorie(String nom, Date dateCreation, List<Produit> produitList) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.produitList = produitList;
    }

    public Categorie(Long id, String nom, Date dateCreation, List<Produit> produitList) {
        this.id = id;
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.produitList = produitList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }

    @Override
    public String toString() {
        return  "{ ID: " + this.id + ", " +
                        "Nom: " + this.nom + " , " +
                        "Date creation: " + this.dateCreation + " }";
    }
}
