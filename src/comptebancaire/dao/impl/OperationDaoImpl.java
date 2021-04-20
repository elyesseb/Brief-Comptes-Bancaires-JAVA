package comptebancaire.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.connection.AccesBD;
import comptebancaire.dao.OperationDao;
import comptebancaire.mapper.Mapping;
import comptebancaire.model.Operation;
import comptebancaire.model.Titulaire;

public class OperationDaoImpl implements OperationDao {

	@Override
	public ArrayList<Operation> getAllOperations() {
		ArrayList<Operation> operations = new ArrayList<Operation>();
		String requete = "SELECT * FROM operations";
		ResultSet resultat;
		try {
			resultat = AccesBD.executerQuery(requete);
			
			while(resultat.next())
			{
				Operation operation = Mapping.mapperOperation(resultat);
				operations.add(operation);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return operations;
	}

	@Override
	public void create(Operation operation) {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = AccesBD.getConnection().prepareStatement("INSERT INTO operations (num_compte, date_operation, lib_operation, montant, type_operation) VALUES( ?, ?, ?, ?, ?)");
			prepareStatement.setLong(1,operation.getCompte().getNumeroCompte());
			prepareStatement.setDate(2, (operation.getDateOperation()));
			prepareStatement.setString(3, operation.getLibOperation());
			prepareStatement.setDouble(4, operation.getMontant());
			prepareStatement.setString(5, operation.getTypeOperation());
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
	}

	@Override
	public Operation getByNum(int num) {
			Operation operation = null;
			String requete = "SELECT * FROM operations WHERE num_operation = " + num;
			ResultSet resultat;
			try {
				
				resultat = AccesBD.executerQuery(requete);
				if(resultat.next())
				{
					operation = Mapping.mapperOperation(resultat);
				}
			} catch (ClassNotFoundException| SQLException e) {
				e.printStackTrace();
			} 
			return operation;
	}


}
