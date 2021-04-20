package comptebancaire.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import comptebancaire.model.Titulaire;

public interface TitulaireDao {
	int update(Titulaire titulaire);
	int delete(Titulaire titulaire);
	int create(Titulaire titulaire);
	ArrayList<Titulaire> select();
	Titulaire getByCode(int code);
}
