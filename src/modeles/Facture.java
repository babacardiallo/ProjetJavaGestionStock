package modeles;

import java.util.Date;

public class Facture {
    private Long id;
    private Long fournisseurId;
    private Long productId;
    private int quantite;
    private double montantFacture;
    private String description;
    private Date dateCreation;

    public Facture(Long fournisseurId, Long productId, int quantite, double montant, String description, Date dateCreation) {
        this.fournisseurId = fournisseurId;
        this.productId = productId;
        this.quantite = quantite;
        this.montantFacture = montant;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Facture(Long id, Long fournisseurId, Long productId, int quantite, double montant, String description, Date dateCreation) {
        this.id = id;
        this.fournisseurId = fournisseurId;
        this.productId = productId;
        this.quantite = quantite;
        this.montantFacture = montant;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montantFacture;
    }

    public void setMontant(double montant) {
        this.montantFacture = montant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
