package test;

import fenetres.Principale;
import modeles.Facture;
import service.FactureService;

import java.util.Set;

public class ProjetGestionStock {

    public static void main(String[] args) {
        FactureService factureService = new FactureService();
        Set<Facture> factures = factureService.getAll();
        for (Facture facture: factures) {
            System.out.println(facture.toString());
        }
    }
}
