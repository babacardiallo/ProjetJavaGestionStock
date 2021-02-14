package service;

import connexionDB.ConnexionDB;
import modeles.Categorie;
import modeles.Fournisseur;
import modeles.Produit;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FournisseurService {

    Connection connection;
    public FournisseurService() {
        connection =  ConnexionDB.getMysqlConnexion();
    }

    public Set<Fournisseur> getAll() {
        String query = "SELECT * FROM Fournisseur";
        Set<Fournisseur> fournisseurSet = new HashSet<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Fournisseur fournisseur = new Fournisseur();
                fournisseur.setId(resultSet.getLong("id"));
                fournisseur.setDenomination(resultSet.getString("denomination"));
                fournisseur.setAdresse(resultSet.getString("adresse"));
                fournisseur.setTelephone(resultSet.getString("telephone"));
                fournisseur.setEmail(resultSet.getString("email"));
                fournisseur.setDateCreation(resultSet.getDate("dateCreation"));
                fournisseurSet.add(fournisseur);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return fournisseurSet;
    }

    public Fournisseur save(Fournisseur fournisseur) {
        String query = "INSERT INTO Fournisseur(denomination, adresse, telephone, email, dateCreation) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, fournisseur.getDenomination());
            preparedStatement.setString(2, fournisseur.getAdresse());
            preparedStatement.setString(3, fournisseur.getTelephone());
            preparedStatement.setString(4, fournisseur.getEmail());
            preparedStatement.setDate(5, fournisseur.getDateCreation());
            preparedStatement.execute();
            ResultSet re = preparedStatement.getGeneratedKeys();
            while (re.next()) {
                fournisseur.setId((long) re.getInt(1));
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        System.out.println(fournisseur.toString());
        return fournisseur;
    }

    public Fournisseur delete(Fournisseur fournisseur) {
        String query = "DELETE FROM Fournisseur WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, fournisseur.getId());
            boolean result =  preparedStatement.execute();
            System.out.println(result);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return fournisseur;
    }

    public Fournisseur update(Fournisseur fournisseur) {
        String query = "UPDATE Fournisseur SET denomination = ?, adresse = ?, telephone = ?, email = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, fournisseur.getDenomination());
            preparedStatement.setString(2, fournisseur.getAdresse());
            preparedStatement.setString(3, fournisseur.getTelephone());
            preparedStatement.setString(4, fournisseur.getEmail());
            preparedStatement.setLong(5, fournisseur.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
        return fournisseur;
    }
}
