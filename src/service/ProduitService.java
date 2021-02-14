package service;

import connexionDB.ConnexionDB;
import modeles.Categorie;
import modeles.Produit;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ProduitService {

    Connection connection;
    public ProduitService() {
        connection =  ConnexionDB.getMysqlConnexion();
    }

    public Set<Produit> getAll() {
        String query = "SELECT * FROM Produit";
        Set<Produit> produitList = new HashSet<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Produit produit = new Produit();
                produit.setId(resultSet.getLong("id"));
                produit.setDesignation(resultSet.getString("designation"));
                produit.setPrixUnitaire(resultSet.getDouble("prixUnitaire"));
                produit.setQuantite(resultSet.getInt("quantite"));
                produit.setDateCreation(resultSet.getDate("dateCreation"));
                String queryNested = "SELECT * FROM Categorie WHERE id = ?";
                PreparedStatement preparedStatementNested = connection.prepareStatement(queryNested);
                preparedStatementNested.setLong(1, resultSet.getLong("categorieId"));
                ResultSet resultSetNested = preparedStatementNested.executeQuery();
                while (resultSetNested.next()) {
                    Categorie categorie = new Categorie();
                    categorie.setId(resultSetNested.getLong("id"));
                    categorie.setNom(resultSetNested.getString("nom"));
                    categorie.setDateCreation(resultSetNested.getDate("dateCreation"));
                    produit.setCategorie(categorie);
                }
                produitList.add(produit);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return produitList;
    }

    public Produit save(Produit produit) {
        String query = "INSERT INTO Produit(designation, prixUnitaire, quantite, dateCreation, categorieId) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, produit.getDesignation());
            preparedStatement.setDouble(2, produit.getPrixUnitaire());
            preparedStatement.setInt(3, produit.getQuantite());
            preparedStatement.setDate(4, produit.getDateCreation());
            preparedStatement.setLong(5, produit.getCategorieId());
            preparedStatement.execute();
            ResultSet re = preparedStatement.getGeneratedKeys();
            while (re.next()) {
                produit.setId((long) re.getInt(1));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        System.out.println(produit.toString());
        return produit;
    }


    public Produit delete(Produit produit) {
        String query = "DELETE FROM Produit WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, produit.getId());
            boolean result =  preparedStatement.execute();
            System.out.println(result);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return produit;
    }

    public Produit update(Produit produit) {
        String query = "UPDATE Produit SET designation = ?, prixUnitaire = ?, quantite = ?, categorieId = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, produit.getDesignation());
            preparedStatement.setDouble(2, produit.getPrixUnitaire());
            preparedStatement.setInt(3, produit.getQuantite());
            preparedStatement.setLong(4, produit.getCategorieId());
            preparedStatement.setLong(5, produit.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return produit;
    }
}
