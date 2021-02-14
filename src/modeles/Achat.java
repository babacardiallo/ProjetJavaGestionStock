package modeles;

public class Achat {
    private Long id;
    private Long factureId;
    private Long produitId;
    private double prixUnitaire;
    private int quantite;
    private Produit produit;

    public Achat() {
    }

    public Achat(Long id, Long factureId, Long produitId, double prixUnitaire, int quantite) {
        this.id = id;
        this.factureId = factureId;
        this.produitId = produitId;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFactureId() {
        return factureId;
    }

    public void setFactureId(Long factureId) {
        this.factureId = factureId;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return  "{ ID: " + this.id + ", " +
                "prixUnitaire: " + this.prixUnitaire + " , " +
                "quantite: " + this.quantite + " , " +
                "produit: " + this.getProduit().toString() + " }, ";
    }
}
