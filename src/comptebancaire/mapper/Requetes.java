package comptebancaire.mapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.connection.AccesBD;
import comptebancaire.model.Compte;
import comptebancaire.model.Titulaire;




public class Requetes {
	
			
	
//	public static void requetesBasiquesSansObjet() throws ClassNotFoundException, SQLException
//
//	{
//		String maRequete	= "SELECT * FROM titulaire ORDER BY nom_titulaire";
//		ResultSet resultat = AccesBD.executerQuery(maRequete);
//		System.out.println("Requete n°1 : Liste des titulaires dans la table Titulaire :\n");
//		while(resultat.next())
//		{
//			System.out.println("Titulaire : "+resultat.getInt("code_titulaire")+" "+
//										  resultat.getString("nom_titulaire")+" "+
//										  resultat.getString("prenom_titulaire")+" "+
//										  resultat.getString("adresse_titulaire")+" "+
//										  resultat.getString("code_postal_titulaire"));
//		}
//
//
//		System.out.println("\n\nRequêtes n°2 : (requéte préparees) Liste des titulaire ayant une code titulaire supérieure à 7\n");
//		PreparedStatement aPreparedStatement = AccesBD.getConnection().prepareStatement("SELECT * FROM titulaire where code_titulaire >= ?");
//
//		aPreparedStatement.setInt(1,7);
//		resultat = aPreparedStatement.executeQuery();
//		while(resultat.next())
//			{
//				System.out.println("Titulaire : "+resultat.getString("nom_titulaire")+" "+
//						  					resultat.getString("prenom_titulaire")+" "+
//						  					resultat.getString("adresse_titulaire")+" "+
//						  					resultat.getString("code_postal_titulaire"));
//			}
//
//	}

}
