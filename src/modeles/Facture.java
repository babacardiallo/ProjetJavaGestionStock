package modeles;

import java.util.Date;
import java.util.Set;

public class Facture {
    private Long id;
    private Long fournisseurId;
    private double montantFacture;
    private String description;
    private Date dateCreation;
    private Set<Achat> achats;

    public Facture() {
    }

    public Facture(Long fournisseurId, double montant, String description, Date dateCreation) {
        this.fournisseurId = fournisseurId;
        this.montantFacture = montant;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Facture(Long id, Long fournisseurId, double montant, String description, Date dateCreation) {
        this.id = id;
        this.fournisseurId = fournisseurId;
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
    public double getMontantFacture() {
        return montantFacture;
    }

    public void setMontantFacture(double montantFacture) {
        this.montantFacture = montantFacture;
    }

    public Set<Achat> getAchats() {
        return achats;
    }

    public void setAchats(Set<Achat> achats) {
        this.achats = achats;
    }

    @Override
    public String toString() {
        String achatTream = "";
        for(Achat achat: this.achats) {
            achatTream = achatTream + achat.toString();
        }

        return  "{ ID: " + this.id + ", " +
                "montantFacture: " + this.montantFacture + " , " +
                "description: " + this.description + " , " +
                "achats: [" + achatTream + " ], " +
                "dateCreation: " + this.dateCreation + " }, ";
    }
}
