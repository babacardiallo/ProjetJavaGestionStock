package modeles;

import java.util.Date;

public class Fournisseur {

    private Long id;
    private String denomination;
    private String adresse;
    private String telephone;
    private String email;
    private Date dateCreation;

    public Fournisseur(String denomination, String adresse, String telephone, String email, Date dateCreation) {
        this.denomination = denomination;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateCreation = dateCreation;
    }

    public Fournisseur(Long id, String denomination, String adresse, String telephone, String email, Date dateCreation) {
        this.id = id;
        this.denomination = denomination;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
