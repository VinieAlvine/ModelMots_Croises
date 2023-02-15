package DjaaRaphael.TchimouAlvinetp2;
public class Grille <E> {
	// Variables d’instance
		private int hauteur ;// hauteur = nombre de lignes 
		private int largeur; // largeur = nombre de colonnes
		E[][]tab;// tab = tableau de chaînes de caractères à deux dimensions,
		// avec taille = hauteur x largeur
		// Constructeur permettant d’obtenir une grille
		// dotée d’un tableau de dimensions conformes aux valeurs
		// respectives de hauteur et de largeur, dont tous les
		// éléments contiennent la valeur null.
		// Précondition : hauteur ≥ 0 et largeur ≥ 0
		public Grille (int hauteur, int largeur) {
			if(hauteur<0) {
				throw new IllegalArgumentException("Hauteur incorrecte : " + hauteur) ;}
			else {
				this.hauteur=hauteur;
			}
			if(largeur<0) {
				throw new IllegalArgumentException("largeur incorrecte : " + largeur) ;}
			else {
				this.largeur=largeur;
			}
			
			this.tab=(E[][])new Object[hauteur][largeur];
			
		}
		
		// Accesseurs (getters)
		public int getHauteur() {
			return this.hauteur;
			}
		public int getLargeur() {
			
			return this.largeur;
			}
		
		// Validité des coordonnées
		// Resultat : vrai si et seulement si lig (resp. col)
		// est compris entre 1 et getHauteur() (resp. getlargeur())
		public boolean coordCorrectes(int lig, int col) {
			if((lig>=1 && lig<=getHauteur()) && (col>=1 && col <=getLargeur())) {
				return true;
				}
			return false;
			}
		// Valeur de la cellule ayant pour coordonnées (lig, col)
		// Précondition : coordCorrectes(lig, col)
		public E getCellule(int lig, int col) {
			if(!coordCorrectes(lig,col)) {
				throw new IllegalArgumentException("la valeur n'existe pas ") ;
			}
			return tab[lig-1][col-1] ; }
		// Modification de la cellule de coordonnées (lig, col)
		// Précondition : coordCorrectes(lig, col)
		public void setCellule(int lig, int col, E ch) {
			if(!coordCorrectes(lig,col)) {
				throw new IllegalArgumentException("la valeur n'existe pas ") ;
				}
			tab[lig-1][col-1]=ch;
		}
		// Texte sur “hauteur” lignes, colonnes séparées par des |
		// (voir exemple plus loin)
		@Override
		public String toString() {
			String val="";
			for(int i=0;i<tab.length;i++) {
				for (int j=0;j<tab[i].length;j++) {
					val= val + tab[i][j] +"|";
					System.out.println();
				}
				//System.out.println();
			}
			
			return val;
			
			}
		

		public static void main(String[] args) {
			Grille maGrille = new Grille(3,5) ;
			for (int l=1; l<=maGrille.getHauteur(); l++)
			{
			String texteLigne = Integer.toString(l);
			for (int c=1; c<=maGrille.getLargeur(); c++)
			{
			maGrille.setCellule
			(l, c, texteLigne + ',' + Integer.toString(c));
			}
			}
			System.out.println(maGrille.toString()) ;

		}

}
