package comptebancaire.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.connection.AccesBD;
import comptebancaire.dao.TypeCompteDao;
import comptebancaire.mapper.Mapping;
import comptebancaire.model.Titulaire;
import comptebancaire.model.TypeCompte;

public class TypeCompteDaoImpl implements TypeCompteDao {

	@Override
	public int create(TypeCompte typeCompte) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO brief_banque.typecompte (code_type_compte, intitule_compte) VALUES(? , ?)");
			
			prepareStatement.setString(1,typeCompte.getCodeTypeCompte());
			prepareStatement.setString(2,typeCompte.getIntituleCompte());
			return prepareStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("erreur lors de la création " + e.getMessage());
		}
		return 0;
	}
	@Override
	public int update(TypeCompte typeCompte) {
		try {
			PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("UPDATE brief_banque.typecompte SET intitule_compte = ? WHERE code_type_compte = ?");
			
			prepareStatement.setString(1,typeCompte.getIntituleCompte());
			prepareStatement.setString(2,typeCompte.getCodeTypeCompte());
			System.out.println("Modification effectuée pour le type de compte : "+ typeCompte);
			return prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("erreur lors de la création " + e.getMessage());
		}
			return 0;
	}
	@Override
	public int delete(TypeCompte typeCompte) {
		PreparedStatement suppression = null;
		
		try {
			suppression = AccesBD.getConnection().prepareStatement("DELETE FROM typecompte WHERE code_type_compte = ?");
			suppression.setString(1, typeCompte.getCodeTypeCompte());
			suppression.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Erreur lors de la suppresion du type de compte");
		}
		return 0;
	}
	
	@Override
	public ArrayList<TypeCompte> select() {
		ArrayList<TypeCompte> typeComptes = new ArrayList<TypeCompte>();
		String requete = "SELECT * FROM typeCompte";
		ResultSet resultat;
		try {
			resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next())
			{
				TypeCompte typeCompte = Mapping.mapperTypeCompte(resultat);
				typeComptes.add(typeCompte);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return typeComptes;
	}
	@Override
	public TypeCompte getByCode(String code) {
		TypeCompte typeCompte = null;
		String requete = "SELECT * FROM brief_banque.typecompte WHERE code_type_compte = " + code;
		ResultSet resultat;
		try {
		
			resultat = AccesBD.executerQuery(requete);
			if(resultat.next())
			{
				typeCompte = Mapping.mapperTypeCompte(resultat);
			}
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		} 
		return typeCompte;
	};
}
