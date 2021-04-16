package comptebancaire.transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import comptebancaire.connection.AccesBD;
import comptebancaire.model.Titulaire;

public class Requetes {
//	public static void requetesBasiquesSansObjet() throws ClassNotFoundException, SQLException
//
//	{
//		String maRequete	= "SELECT * FROM titulaire ORDER BY code_titulaire";
//		ResultSet resultat = AccesBD.executerQuery(maRequete);
//		System.out.println("Requete n�1 : Liste des titulaires dans la table titulaire :\n");
//		while(resultat.next())
//		{
//			System.out.println("Titulaire : "+resultat.getInt("code_titulaire")+" "+
//										  resultat.getString("prenom_titulaire")+" "+
//										  resultat.getString("nom_titulaire")+" "+
//										  resultat.getString("adresse_titulaire")+" "+
//										  resultat.getString("code_postal_titulaire"));
//		}
//
//
//		System.out.println("\n\nRequ�tes n�2 : (requ�te pr�par�es) Liste des avions ayant une capacit� sup�rieure � 300 passagers\n");
//		PreparedStatement aPreparedStatement = AccesBD.getConnection().prepareStatement("SELECT * FROM titulaire where code_titulaire >= ?");
//
//		aPreparedStatement.setInt(1, 7);
//		resultat = aPreparedStatement.executeQuery();
//		while(resultat.next())
//			{
//			System.out.println("Titulaire : "+resultat.getInt("code_titulaire")+" "+
//					  resultat.getString("prenom_titulaire")+" "+
//					  resultat.getString("nom_titulaire")+" "+
//					  resultat.getString("adresse_titulaire")+" "+
//					  resultat.getString("code_postal_titulaire"));
//			}
//
//	}
//	
//	public static void ajouterTitulaire(Titulaire titulaire) throws SQLException
//	{
//		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO `titulaire` VALUES( ? , ? , ? , ? , ?)");
//		prepareStatement.setInt(1,titulaire.getCodeTitulaire());
//		prepareStatement.setString(2,titulaire.getPrenomTitulaire());
//		prepareStatement.setString(3,titulaire.getNomTitulaire());
//		prepareStatement.setString(4,titulaire.getAdresseTitulaire());
//		prepareStatement.setString(5,titulaire.getCodePostalTitulaire());
//		prepareStatement.executeUpdate();
//		
//	}
//	
//	public static void lireDetailsTitulaire(Titulaire titulaire) throws SQLException{
//		PreparedStatement lireDetailsTitulaire = AccesBD.getConnection().prepareStatement("SELECT * FROM `titulaire` WHERE code_titulaire = ?");
//		lireDetailsTitulaire.setInt(1,titulaire.getCodeTitulaire());
//		ResultSet resultat = lireDetailsTitulaire.executeQuery();
//		while(resultat.next())
//			{
//			System.out.println("Titulaire : "+resultat.getInt("code_titulaire")+" "+
//					  resultat.getString("prenom_titulaire")+" "+
//					  resultat.getString("nom_titulaire")+" "+
//					  resultat.getString("adresse_titulaire")+" "+
//					  resultat.getString("code_postal_titulaire"));
//			}
//	}
}
