package modeles;


import java.sql.Date;

public class Produit {

    private Long id;
    private Long categorieId;
    private String designation;
    private double prixUnitaire;
    private int quantite;
    private Date dateCreation;
    private Categorie categorie;

    public Produit() {
    }

    public Produit(Long categorieId, String designation, double prixUnitaire, int quantite, Date dateCreation) {
        this.categorieId = categorieId;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.dateCreation = dateCreation;
    }

    public Produit(Long id, Long categorieId, String designation, double prixUnitaire, int quantite, Date dateCreation) {
        this.id = id;
        this.categorieId = categorieId;
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Long categorieId) {
        this.categorieId = categorieId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return  "{ ID: " + this.id + ", " +
                "designation: " + this.getDesignation() + " , " +
                "prix Unitaire: " + this.prixUnitaire + " , " +
                "quantité: " + this.getQuantite() + " , " +
                "Date creation: " + this.getDesignation() + " , " +
                "categorie: " + this.getCategorie().toString() + " }";
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
