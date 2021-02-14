package service;

import connexionDB.ConnexionDB;
import modeles.Categorie;

import java.sql.*;
import java.util.*;

public class CategorieService {

    Connection connection;
    public CategorieService() {
        connection =  ConnexionDB.getMysqlConnexion();
    }

    public Set<Categorie> getAll() {
        String query = "SELECT * FROM Categorie";
        Set<Categorie> categorieList = new HashSet<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Categorie categorie = new Categorie();
                categorie.setId(resultSet.getLong("id"));
                categorie.setNom(resultSet.getString("nom"));
                categorie.setDateCreation(resultSet.getDate("dateCreation"));
                categorieList.add(categorie);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return categorieList;
    }

    public Categorie save(Categorie categorie) {
        String query = "INSERT INTO Categorie(nom, dateCreation) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, categorie.getNom());
            preparedStatement.setDate(2, categorie.getDateCreation());
            preparedStatement.execute();
            ResultSet re = preparedStatement.getGeneratedKeys();
            while (re.next()) {
               categorie.setId((long) re.getInt(1));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        System.out.println(categorie.toString());
        return categorie;
    }


    public Categorie delete(Categorie categorie) {
        String query = "DELETE FROM Categorie WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, categorie.getId());
            boolean result =  preparedStatement.execute();
            System.out.println(result);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return categorie;
    }

    public Categorie update(Categorie categorie) {
        String query = "UPDATE Categorie SET nom = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categorie.getNom());
            preparedStatement.setLong(2, categorie.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return categorie;
    }


}
