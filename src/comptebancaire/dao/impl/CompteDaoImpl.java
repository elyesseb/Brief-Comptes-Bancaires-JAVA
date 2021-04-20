package comptebancaire.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.connection.AccesBD;
import comptebancaire.dao.CompteDao;
import comptebancaire.dao.TitulaireDao;
import comptebancaire.dao.TypeCompteDao;
import comptebancaire.mapper.Mapping;
import comptebancaire.model.Compte;
import comptebancaire.model.Titulaire;


public class CompteDaoImpl implements CompteDao {
	
	
	public CompteDaoImpl() {
		TypeCompteDao typeCompteDao = new TypeCompteDaoImpl();
		TitulaireDao compteDao = new TitulaireDaoImpl();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int update(Compte compte) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE compte SET solde_compte = ?  WHERE num_compte = ? ");
//			prepareStatement.setString(1, String.valueOf(compte.getTypeCompte().getCodeTypeCompte()));
//	    	prepareStatement.setLong(2,compte.getTitulaire().getCodeTitulaire());
	    	prepareStatement.setDouble(1,compte.getSoldeCompte());
	    	prepareStatement.setLong(2,compte.getNumeroCompte());
	    	prepareStatement.executeUpdate();
			System.out.println("Modification effectuée pour le compte : "+ compte.getNumeroCompte() + " ---> Le solde de votre compte est de ***  " + compte.getSoldeCompte()+"€  ***");

		}
		catch(SQLException e){
			System.out.println("Erreur lors de la modification !");
		}		
		return 0;
	}

	@Override
	public int delete(Compte compte) {
		PreparedStatement suppression = null;
		
		try {
			suppression = AccesBD.getConnection().prepareStatement("DELETE FROM compte WHERE num_compte=" + compte.getNumeroCompte());
			return suppression.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de la suppresion du compte");
		}
		return 0;
	}

	@Override
	public int create(Compte compte) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO compte VALUES(? , ? , ? , ?)");
	    	
	    	prepareStatement.setLong(1,compte.getNumeroCompte());
	    	prepareStatement.setString(2, compte.getTypeCompte().getCodeTypeCompte());
	    	prepareStatement.setLong(3,compte.getTitulaire().getCodeTitulaire());
	    	prepareStatement.setDouble(4,compte.getSoldeCompte());
	    	prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erreur lors de la création " + e.getMessage());
		}
			return 0;
	}

	@Override
	public ArrayList<Compte> select() {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		String requete = "SELECT * FROM compte";
		ResultSet resultat;
		try {
			resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next())
			{
				Compte compte = Mapping.mapperCompte(resultat);
				comptes.add(compte);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return comptes;
	}

	@Override
	public Compte getByNum(Long num)
	{

		Compte compte = new Compte();
		try {
			PreparedStatement preparedStatement = AccesBD.getConnection().prepareStatement("SELECT c.num_compte, t.code_titulaire, tc.code_type_compte, c.solde_compte FROM compte c\n"
					+ "JOIN titulaire t ON t.code_titulaire = c.code_titulaire\n"
					+ "JOIN typecompte tc ON tc.code_type_compte = c.code_type_compte\n"
					+ "WHERE c.num_compte = ?");
			preparedStatement.setLong(1,num);
			ResultSet resultat = preparedStatement.executeQuery();
			if(resultat.next()) {				
				compte.setNumeroCompte(resultat.getLong("num_compte"));
				compte.setSoldeCompte(resultat.getFloat("solde_compte"));
				compte.getTypeCompte().setCodeTypeCompte(resultat.getString("code_type_compte"));
				compte.getTitulaire().setCodeTitulaire(resultat.getLong("code_titulaire"));

			
			}
//			return compte;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return compte;

	}

	

}
