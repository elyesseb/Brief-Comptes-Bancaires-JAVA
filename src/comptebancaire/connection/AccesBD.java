package comptebancaire.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class AccesBD {


	private static String utilisateur="brief_banque";
	private static String motDePasse="comptebancaire";
	private static String pilote = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/brief_banque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


	/* 	on déclare un objet de la classe Connection de java.sql
	 * 	Il permet de gérer la connexion entre notre programme java
	 * 	et la base de données.
	 */
	private static Connection connexion=null;

	static
	{
		try
		{
			Class.forName(pilote).newInstance();
		}
		catch (Exception e)
		{

			System.out.println(e);
			JOptionPane.showMessageDialog(null,"Pilote non valide ou introuvable !","AccesBD",JOptionPane.WARNING_MESSAGE);

		}
	}
	
	/**
	 * Méthode qui retourne un objet de type Connection
	 * @return Connection
	 */
	public synchronized static Connection getConnection()
	{
		try
		{
			if (connexion==null) connexion = DriverManager.getConnection(url, utilisateur, motDePasse);


		}catch (Exception e)
			{
				System.out.println(e);
				JOptionPane.showMessageDialog(null,e.getMessage(),"Connexion à MySQL",JOptionPane.WARNING_MESSAGE);
			}

		return connexion;
	}

	/**
	 * méthode de fermeture d'un objet de type connection
	 */
	public static void fermerConnection(Connection connexion)
	{
		if (connexion!=null)
		{
			try
			{
				connexion.close();
			}

			catch(Exception e)
			{
				System.out.println("Fermeture de la Connection Impossible !");
				e.printStackTrace();
			}
		}
	}

	/**
	 * méthode de fermeture d'un objet de type connection
	 */
	public static void fermerConnection()
	{
		if (connexion!=null)
		{
			try
			{
				connexion.close();
			}

			catch(Exception e)
			{
				System.out.println("Fermeture de la Connection Impossible !");
				e.printStackTrace();
			}
		}
	}
	

	/**
	 *
	 * @param unUtilisateur String
	 */
	public static void setUtilisateur(String unUtilisateur)
	{
		utilisateur=unUtilisateur;
	}
	/**
	 *
	 * @param unMotDePasse String
	 */
	public static void setMotDePasse(String unMotDePasse)
	{
		motDePasse=unMotDePasse;
	}
	/**
	 *
	 * @return un objet connexion
	 */
	/*
	public static Connection getConnexion() {
		return connexion;
	}
	 */
	/**
	 *
	 * @return
	 */
	public static String getMotDePasse() {
		return motDePasse;
	}
	/**
	 *
	 * @return
	 */
	public static String getPilote() {
		return pilote;
	}
	/**
	 *
	 * @return
	 */
	public static String getUrl() {
		return url;
	}
	/**
	 *
	 * @return
	 */
	public static String getUtilisateur() {
		return utilisateur;
	}
	/**
	 *	méthode d'exécution d'une requête (SELECT) pour renvoyer un objet de type ResultSet
	 *	@param requete String
	 *	@return resultat ResultSet
	 */
	public static ResultSet executerQuery(String requete) throws ClassNotFoundException, SQLException

	{
		/*
		 * 	On déclare un objet de type Statement que l'on nomme instruction. Cet
		 * 	objet soumet la requête à la base de données dans MySQL.
		 * 	On déclare un objet de type ResultSet que l'on nomme resultat. cet objet
		 * 	est retourné pour encapsuler les résultats de la requête. Il va nous permettre
		 * 	de manipuler les résultats de la requête.
		 *
		 */
		Statement statement = null;
		ResultSet resultat = null;


		try {


			// gestion des curseurs pour la navigation
			/*
			 * TYPE_SROLL_SENSITIVE :
			 *
			 *
			 * TYPE_SCROLL_INSENSITIVE :
			 * Cette valeur indique que le curseur peut être déplacé dans les deux sens,
			 * mais aussi arbitrairement (de manière absolue ou relative).
			 * Le terme insensitive indique que le ResultSet est insensible aux modifications
			 * des valeurs dans la base de données. Cela définit en fait une vue statique des données
			 * contenues dans le ResultSet.
			 *
			 * CONCUR_UPDATABLE :
			 * Cette valeur indique que l'on peut modifier les données de la base via le ResultSet.
			 */

			int type = ResultSet.TYPE_SCROLL_SENSITIVE;
			int mode = ResultSet.CONCUR_UPDATABLE;

			/* 	On peut traduire Statement par ordre ou instruction.
			 * 	La méthode createStatement() nous retourne un objet de type Statement.
			 * 	Nous l'avons appelé avec la méthode getConnection() qui nous renvoie
			 * 	un objet de type Connexion.
			 * 	Dès lors, nous pouvons utiliser l'objet instruction pour interroger
			 * 	la base de données Oracle.
			 *
			 */
			statement = getConnection().createStatement(type,mode);
			/*	Pour cela, il nous suffit d'appeler la méthode executeQuery() en lui passant
			 * 	comme paramètre, la requete que nous voulons exécuter.
			 * 	L'objet resultat contient le résultat de l'exécution de la requête.
			 */

			resultat = statement.executeQuery(requete);

		}

		catch(SQLException e)
		{

			e.printStackTrace();
			System.exit(-1);
		}
		return resultat;	// retourne un ResultSet


	}

	/**
	 *	Méthode d'exécution d'une requete Update (UPDATE, INSERT, DELETE). Elle ne renvoie rien
	 *	@param requete String
	 */
	public static void executerUpdate(String requete) throws ClassNotFoundException, SQLException

	{
		Statement statement = null;
		try {

			statement = getConnection().createStatement();

			int i = statement.executeUpdate(requete);


			if (i==1) // on affiche un message d'information sur l'op�ration pour le plaisir !

			{
				JOptionPane.showMessageDialog(null, "L'op�ration a r�ussie !");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "L'op�ration a �chou� !");
			}

		}

		catch(SQLException e)
		{

			e.printStackTrace();
			System.exit(-1);
		}

	}
	
	
	/**
	 * méthode de fermeture d'un objet de type Statement
	 */

	public static void fermerStatement(Statement statement)
	{
		if (statement!=null)
		{
			try
			{
				statement.close();
			}

			catch(Exception e)
			{
				System.out.println("Fermeture du Statement Impossible !");
				e.printStackTrace();
			}
		}
	}

	/**
	 * méthode de fermeture d'un objet de type Statement
	 */

	public static void fermerResultSet(ResultSet resultSet)
	{
		if (resultSet!=null)
		{
			try
			{
				resultSet.close();
			}

			catch(Exception e)
			{
				System.out.println("Fermeture du ResultSet Impossible !");
				e.printStackTrace();
			}
		}
	}
	

	/**
	 *  test avec méthode main()
	*/
	
	public static void main(String[] args)
	{
		Connection connnect = AccesBD.getConnection();
		if (connnect!=null)
		{
			JOptionPane.showMessageDialog(null, "Ca marche");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Ca marche PAS !");
		}

	}




}