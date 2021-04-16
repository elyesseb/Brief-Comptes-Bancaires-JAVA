package comptebancaire.dao;

import comptebancaire.connection.AccesBD;
import comptebancaire.model.Titulaire;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TitulaireDaoImpl implements TitulaireDao{

	public void ajouterTitulaire(Titulaire titulaire) throws SQLException {
		PreparedStatement prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO `titulaire` VALUES( ? , ? , ? , ? , ?)");
		prepareStatement.setInt(1,titulaire.getCodeTitulaire());
		prepareStatement.setString(2,titulaire.getPrenomTitulaire());
		prepareStatement.setString(3,titulaire.getNomTitulaire());
		prepareStatement.setString(4,titulaire.getAdresseTitulaire());
		prepareStatement.setString(5,titulaire.getCodePostalTitulaire());
		prepareStatement.executeUpdate();
		
	}
	
	public void supprimerTitulaire(Titulaire titulaire) throws SQLException {
		PreparedStatement statement = null;
		try {
			statement = AccesBD.getConnection().prepareStatement("DELETE FROM `titulaire` ");
		}
		catch(SQLException e) {
			System.out.println("erreur lors de la suppression du titulaire");
		}
	}
}
