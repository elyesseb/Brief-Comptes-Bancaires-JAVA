package comptebancaire.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import comptebancaire.connection.AccesBD;
import comptebancaire.dao.TitulaireDao;
import comptebancaire.mapper.Mapping;
import comptebancaire.model.Titulaire;


public class TitulaireDaoImpl implements TitulaireDao {

	@Override
	public int create(Titulaire titulaire) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO titulaire (prenom_titulaire, nom_titulaire, adresse_titulaire, code_postal_titulaire) VALUES( ? , ? , ? , ?)");
			
			prepareStatement.setString(1,titulaire.getPrenomTitulaire());
			prepareStatement.setString(2,titulaire.getNomTitulaire());
			prepareStatement.setString(3,titulaire.getAdresseTitulaire());
			prepareStatement.setString(4,titulaire.getCodePostalTitulaire());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erreur lors de la création " + e.getMessage());
		}
			return 0;
	}

	@Override
	public ArrayList<Titulaire> select() {
		ArrayList<Titulaire> titulaires = new ArrayList<Titulaire>();
		String requete = "SELECT * FROM titulaire";
		ResultSet resultat;
		try {
			resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next())
			{
				Titulaire titulaire = Mapping.mapperTitulaire(resultat);
				titulaires.add(titulaire);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return titulaires;

		
	}

	@Override
	public Titulaire getByCode(int code) {
		Titulaire titulaire = null;
		String requete = "SELECT * FROM titulaire WHERE code_titulaire = " + code;
		ResultSet resultat;
		try {
			
			resultat = AccesBD.executerQuery(requete);
			if(resultat.next())
			{
				titulaire = Mapping.mapperTitulaire(resultat);
			}
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		} 
		return titulaire;
		
	}


	@Override
	public int update(Titulaire titulaire) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE titulaire SET prenom_titulaire =?, nom_titulaire=?, adresse_titulaire=?, code_postal_titulaire=? WHERE code_titulaire= ?");
			
			prepareStatement.setString(1,titulaire.getPrenomTitulaire());
			prepareStatement.setString(2,titulaire.getNomTitulaire());
			prepareStatement.setString(3,titulaire.getAdresseTitulaire());
			prepareStatement.setString(4,titulaire.getCodePostalTitulaire());
			prepareStatement.setLong(5,titulaire.getCodeTitulaire());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erreur lors de la création " + e.getMessage());
		}
			System.out.println("Modification effectuée pour le titulaire : "+ titulaire);
			return 0;
	}


	@Override
	public int delete(Titulaire titulaire) {
		PreparedStatement suppression = null;
		
		try {
			suppression = AccesBD.getConnection().prepareStatement("DELETE FROM titulaire WHERE code_titulaire=" + titulaire.getCodeTitulaire());
			return suppression.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de la suppresion du titulaire");
		}
		return 0;
	}


}
