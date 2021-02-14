package service;

import connexionDB.ConnexionDB;
import modeles.Achat;
import modeles.Categorie;
import modeles.Facture;
import modeles.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FactureService {
    Connection connection;
    public FactureService() {
        connection =  ConnexionDB.getMysqlConnexion();
    }


    public Set<Facture> getAll() {
        String query = "SELECT * FROM Facture";
        Set<Facture> factureSet = new HashSet<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Facture facture = new Facture();
                facture.setId(resultSet.getLong("id"));
                facture.setMontantFacture(resultSet.getDouble("montantFacture"));
                facture.setDescription(resultSet.getString("description"));
                facture.setDateCreation(resultSet.getDate("dateCreation"));
                String queryNested = "SELECT * FROM Achat WHERE factureId = ?";
                PreparedStatement preparedStatementNested = connection.prepareStatement(queryNested);
                preparedStatementNested.setLong(1, resultSet.getLong("id"));
                ResultSet resultSetNested = preparedStatementNested.executeQuery();
                Set<Achat> achats = new HashSet<>();
                while (resultSetNested.next()) {
                    Achat achat = new Achat();
                    achat.setId(resultSetNested.getLong("id"));
                    achat.setPrixUnitaire(resultSetNested.getDouble("prixUnitaire"));
                    achat.setQuantite(resultSetNested.getInt("quantite"));
                    String queryNestedProduit = "SELECT * FROM Produit WHERE id = ?";
                    PreparedStatement preparedStatementNestedProduit = connection.prepareStatement(queryNestedProduit);
                    preparedStatementNestedProduit.setLong(1, resultSetNested.getLong("produitId"));
                    ResultSet resultSetNestedProduit = preparedStatementNestedProduit.executeQuery();
                    while (resultSetNestedProduit.next()) {
                        Produit produit = new Produit();
                        produit.setDesignation(resultSetNestedProduit.getString("designation"));
                        produit.setId(resultSetNestedProduit.getLong("id"));
                        produit.setPrixUnitaire(resultSetNestedProduit.getDouble("prixUnitaire"));
                        produit.setQuantite(resultSetNestedProduit.getInt("quantite"));
                        produit.setDateCreation(resultSetNestedProduit.getDate("dateCreation"));
                        String queryNestedCtagorie = "SELECT * FROM Categorie WHERE id = ?";
                        PreparedStatement preparedStatementNestedCategorie = connection.prepareStatement(queryNestedCtagorie);
                        preparedStatementNestedCategorie.setLong(1, resultSetNestedProduit.getLong("categorieId"));
                        ResultSet resultSetNestedCategorie = preparedStatementNestedCategorie.executeQuery();
                        while (resultSetNestedCategorie.next()) {
                            Categorie categorie = new Categorie();
                            categorie.setId(resultSetNestedCategorie.getLong("id"));
                            categorie.setNom(resultSetNestedCategorie.getString("nom"));
                            categorie.setDateCreation(resultSetNestedCategorie.getDate("dateCreation"));
                            produit.setCategorie(categorie);
                        }
                        achat.setProduit(produit);
                    }
                    achats.add(achat);
                }
                facture.setAchats(achats);
                factureSet.add(facture);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return factureSet;
    }
}
