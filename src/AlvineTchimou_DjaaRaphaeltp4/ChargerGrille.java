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
	public Map<Integer,MotsCroisesBis> grillesDisponibles()throws SQLException {

		// Création d'un objet Statement
		Statement stmt = connexion.createStatement();
		// Exécution de la requête de
		ResultSet result = stmt.executeQuery("SELECT num_grille,nom_grille,largeur,hauteur,controle FROM TP5_GRILLE");
		// Boucle sur les résultats de la requête
		while (result.next()) {
			// Récupération des informations 
			//String desgrille =result.getString("nom_grille")+ " "+"("+result.getInt("hauteur")+"x"+ result.getInt("largeur")+")";
			// Ajout dans listgrille
			listgrille.put(result.getInt("num_grille"),new MotsCroisesBis(result.getInt("hauteur"),result.getInt("largeur")));
		}
		// Fermeture de la requête
		result.close();
		stmt.close();
		return listgrille;
	}




	public MotsCroisesBis extraireGrille(int numGrille) throws SQLException {
		Statement stmt = connexion.createStatement();
		MotsCroisesBis motsCroises = grillesDisponibles().get(numGrille);
		ResultSet res = stmt.executeQuery("SELECT num_mot,definition,horizontal,ligne,colonne,solution FROM TP5_MOT WHERE num_grille = " + numGrille);
		while(res.next()) {
			String definition = res.getString("definition");
			boolean horizontal = res.getBoolean("horizontal");
			int ligne = res.getInt("ligne");
			int colonne = res.getInt("colonne");
			String solution = res.getString("solution");
			motsCroises.setDefinition(ligne, colonne, horizontal, definition);
			for(int i =0;i<solution.length();i++) {
				if(horizontal) {
					motsCroises.setSolution(ligne, colonne+i, solution.toUpperCase().charAt(i));
				}
				else {
					motsCroises.setSolution(ligne+i, colonne, solution.toUpperCase().charAt(i));
				}
			}
		}
		return motsCroises;



	}





}
