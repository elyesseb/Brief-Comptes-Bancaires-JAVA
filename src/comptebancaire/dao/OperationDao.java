package comptebancaire.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.model.Operation;

public interface OperationDao {
	public void create(Operation operation);
	public ArrayList<Operation> getAllOperations();
	public Operation getByNum(int num);
}
