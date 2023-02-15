package AlvineTchimou_DjaaRaphaeltp4;
import java.sql.*;
import java.util.*;
import DjaaRaphael.TchimouAlvinetp2.*;




public class ChargerGrille {
	HashMap listgrille= new HashMap();
	private Connection connexion ;

	public ChargerGrille()
	{
		try { connexion = connecterBD() ; }
		catch (SQLException e) { e.printStackTrace(); }
	}
	public static Connection connecterBD() throws SQLException{

		Connection connect ;

		connect = DriverManager.getConnection("jdbc:mysql://mysqln.istic.univ-rennes1.fr/base_bousse?useSSL=false","user_ctchimou","Sweetie1912");


		return connect ;
	}
	// Retourne la liste des grilles disponibles dans la B.D.
	// Chaque grille est décrite par la concaténation des valeurs
	// respectives des colonnes nom_grille, hauteur et largeur.
	// L’élément de liste ainsi obtenu est indexé par le numéro de
	// la grille (colonne num_grille).
	// Ainsi "Français débutants (7x6)" devrait être associé à la clé 10 
	public Map<Integer, String> grillesDisponibles()throws SQLException {

		// Création d'un objet Statement
		Statement stmt = connexion.createStatement();
		// Exécution de la requête de
		ResultSet result = stmt.executeQuery("SELECT num_grille,nom_grille,largeur,hauteur,controle FROM TP5_GRILLE");
		// Boucle sur les résultats de la requête
		while (result.next()) {
			// Récupération des informations 
			String desgrille =result.getString("nom_grille")+ " "+"("+result.getInt("hauteur")+"x"+ result.getInt("largeur")+")";
			// Ajout dans listgrille
			listgrille.put(result.getInt("num_grille"),desgrille);
		}
		// Fermeture de la requête
		result.close();
		stmt.close();
		return listgrille;
	}


	public MotsCroises extraireGrille(int numGrille) throws SQLException {
		Statement stmt = connexion.createStatement();
		ResultSet result = stmt.executeQuery("SELECT largeur,hauteur,controle FROM TP5_GRILLE WHERE num_grille="+ numGrille);
		 if (result.next()) {
			    int hauteur = result.getInt("hauteur");
			    int largeur = result.getInt("largeur");
			    MotsCroises motsCroises = new MotsCroises(hauteur,largeur);
			    return motsCroises;
			  } else {
			    return null;
			  }
		 
		}
	


}
