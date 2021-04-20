package comptebancaire.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import comptebancaire.model.Compte;
import comptebancaire.model.Operation;
import comptebancaire.model.Titulaire;
import comptebancaire.model.TypeCompte;


public class Mapping {
	public static Titulaire mapperTitulaire(ResultSet resultat) throws SQLException
	{
		Titulaire titulaire = new Titulaire();
		titulaire.setCodeTitulaire(resultat.getLong("code_titulaire"));
		titulaire.setPrenomTitulaire(resultat.getString("prenom_titulaire"));
		titulaire.setNomTitulaire(resultat.getString("nom_titulaire"));
		titulaire.setAdresseTitulaire(resultat.getString("adresse_titulaire"));
		titulaire.setCodePostalTitulaire(resultat.getString("code_postal_titulaire"));
		return titulaire;
	
	}
	
	public static Compte mapperCompte(ResultSet resultat) throws SQLException
	{
		
		Compte compte = new Compte();
		compte.setNumeroCompte(resultat.getLong("num_compte"));
		compte.getTypeCompte().setCodeTypeCompte(resultat.getString("code_type_compte"));
		compte.getTitulaire().setCodeTitulaire(resultat.getLong("code_titulaire"));
		compte.setSoldeCompte(resultat.getFloat("solde_compte"));
		return compte;
	
	}
	
	public static TypeCompte mapperTypeCompte(ResultSet resultat) throws SQLException
	{
		
		TypeCompte typeCompte = new TypeCompte();
		typeCompte.setCodeTypeCompte(resultat.getString("code_type_compte"));
		typeCompte.setIntituleCompte(resultat.getString("intitule_compte"));
		return typeCompte;
	
	}
	
	public static Operation mapperOperation(ResultSet resultat) throws SQLException
	{
		
		Operation operation = new Operation();
		operation.setNumOperation(resultat.getLong("num_operation"));
		operation.getCompte().setNumeroCompte(resultat.getLong("num_compte"));
		operation.setDateOperation(resultat.getDate("date_operation"));
		operation.setLibOperation(resultat.getString("lib_operation"));
		operation.setMontant(resultat.getDouble("montant"));
		operation.setTypeOperation(resultat.getString("type_operation"));
		return operation;
	
	}
	
}
