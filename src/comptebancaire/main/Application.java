package comptebancaire.main;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import comptebancaire.dao.CompteDao;
import comptebancaire.dao.OperationDao;
import comptebancaire.dao.TitulaireDao;
import comptebancaire.dao.TypeCompteDao;
import comptebancaire.dao.impl.CompteDaoImpl;
import comptebancaire.dao.impl.OperationDaoImpl;
import comptebancaire.dao.impl.TitulaireDaoImpl;
import comptebancaire.dao.impl.TypeCompteDaoImpl;
import comptebancaire.mapper.Requetes;
import comptebancaire.model.Compte;
import comptebancaire.model.Operation;
import comptebancaire.model.Titulaire;
import comptebancaire.model.TypeCompte;

public class Application {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		TypeCompteDao typeCompteDao = new TypeCompteDaoImpl();
		TitulaireDao titulaireDao = new TitulaireDaoImpl();
		CompteDao compteDao = new CompteDaoImpl();
		OperationDao operationDao = new OperationDaoImpl();		
		
//-----------------------------------------------------------------------------------------------	
		
		Titulaire titulaire = new Titulaire();
        titulaire.setPrenomTitulaire("charles");
        titulaire.setNomTitulaire("chrismann");
        titulaire.setAdresseTitulaire("46 grande rue");
        titulaire.setCodePostalTitulaire("78350");
		
        //Ajout d'un titulaire
		//titulaireDao.create(titulaire);
		
        
        //Suppression d'un titulaire avec mapping
		//titulaireDao.delete(titulaireDao.getByCode(14));
		
		//modification d'un titulaire with mapping
		Titulaire flora = titulaireDao.getByCode(11);
//		flora.setPrenomTitulaire("Charles");
//		titulaireDao.update(flora);
		
		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn afiche les détails de tous les titulaires :\n");
//		for (Titulaire oneTitulaire : titulaireDao.select()) {
//			System.out.println(oneTitulaire);
//		}
		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn afiche les détails du Titulaire sélectionné :\n");
//		System.out.println(titulaireDao.getByCode(Integer.parseInt(JOptionPane.showInputDialog("Saisissez un code titulaire à afficher"))));	

        
//-------------------------------------------------------------------------------------------------------------------------------------------------------	

        TypeCompte typeCompte = new TypeCompte();
		typeCompte.setCodeTypeCompte("l");
		typeCompte.setIntituleCompte("Compte Epargne");
//		
//		//typeCompteDao.create(typeCompte);
//
//		
//		TypeCompte typeCompte1 = typeCompteDao.getByCode("'i'");
//		System.out.println(typeCompte1);
//		//typeCompteDao.delete(typeCompte1);
//		typeCompte1.setIntituleCompte("Moon");
//		typeCompteDao.update(typeCompte1);
//		
//		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn afiche les détails de tous les types de compte :\n");
//		for (TypeCompte oneCompte : typeCompteDao.select()) {
//			System.out.println(oneCompte);
//		}
//		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn afiche les détails d'un type de compte sélectionné :\n");
		//System.out.println(typeCompteDao.getByCode("'" + JOptionPane.showInputDialog("Saisissez un code de type de Compte à afficher") + "'"));	

//-------------------------------------------------------------------------------------------------------------------------------------------------------	

		
		Titulaire denisCompte = titulaireDao.getByCode(15);
		TypeCompte typeCompteForDenis = typeCompteDao.getByCode("'i'");
		Compte compte45679 = new Compte();
//		compteFlora.setNumeroCompte(45679L);
//		compteFlora.setTitulaire(denisCompte);
//		compteFlora.setTypeCompte(typeCompteForDenis);
//		compteFlora.setSoldeCompte(10000F);
		//compteDao.create(compte45679);
		
//		Compte compteAsupp = compteDao.getByNum(45679L);
		//compteDao.delete(compteAsupp);

//		Compte compteAmodif = compteDao.getByNum(45678L);
//		compteAmodif.setSoldeCompte(15000F);
		
//		floraCompte.setSoldeCompte(15000F);
//		compteDao.update(compteAmodif);
		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn affiche les détails de tous les comptes :\n");
//		for (Compte oneCompte : compteDao.select()) {
//			System.out.println(oneCompte);
//		}
//		
//		System.out.println("\n\n=================================================================");
//		System.out.println("\n\nOn afiche les détails d'un compte sélectionné :\n");
//		System.out.println(compteDao.getByNum(Long.parseLong(JOptionPane.showInputDialog("Saisissez un code titulaire à afficher"))));	
		

	}

}
