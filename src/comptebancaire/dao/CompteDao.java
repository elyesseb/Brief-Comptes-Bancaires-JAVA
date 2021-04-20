package comptebancaire.dao;

import java.util.ArrayList;

import comptebancaire.model.Compte;


public interface CompteDao {
	int update(Compte compte);
	int delete(Compte compte);
	int create(Compte compte);
	ArrayList<Compte> select();
	public Compte getByNum(Long num);
}
