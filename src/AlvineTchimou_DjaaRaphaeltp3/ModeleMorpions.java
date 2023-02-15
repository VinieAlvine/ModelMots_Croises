package AlvineTchimou_DjaaRaphaeltp3;
import DjaaRaphael.TchimouAlvinetp2.Grille;
import morpions.kit.test.*;


public  class ModeleMorpions implements SpecifModeleMorpions {
	Grille<Integer> grille;
	private final int JOUEUR1 = 1;
	private final int JOUEUR2 = 2;
	private int nombreCoups = 0;

	/* getEtatJeu() : état actuel du jeu
	 * @return une des valeurs du type énuméré SpecifMorpions.Etat
	 */
	@Override
	public Etat getEtatJeu() {
		if(getVainqueur()==1)return Etat.J1_VAINQUEUR;
		if(getVainqueur()==2)return Etat.J2_VAINQUEUR;
		if(getVainqueur()==0)return Etat.MATCH_NUL;
		if(getNombreCoups()%2==0) {
			return Etat.J1_JOUE;
		}
		return Etat.J2_JOUE;
	}
	/* getJoueur() : numéro du joueur courant
	 * @return numéro du prochain joueur (1 ou 2), ou 0 si le jeu est fini
	 */
	@Override
	public int getJoueur() {
		if(getEtatJeu()==Etat.J1_JOUE)return JOUEUR1;
		if(getEtatJeu()==Etat.J2_JOUE)return JOUEUR2;
		return 0;
	}
	/* getVainqueur() : numéro du vainqueur
	 * @return numéro du vainqueur (1 ou 2), ou 0 s'il n'y a pas, ou pas encore, de vainqueur
	 */
	@Override
	public int getVainqueur() {
		// Vérifier les lignes
		for (int i = 0; i < TAILLE; i++) {
			int produit = 1;
			for (int j = 0; j < TAILLE; j++) {
				produit *= grille.getCellule(i,j);
			}
			if (produit == 1) {
				return JOUEUR1;
			} else if (produit == (int) Math.pow(JOUEUR2, TAILLE)) {
				return JOUEUR2;
			}
		}

		// Vérifier les colonnes
		for (int j = 0; j <TAILLE; j++) {
			int produit = 1;
			for (int i = 0; i < TAILLE; i++) {
				produit *= grille.getCellule(i,j);
			}
			if (produit == 1) {
				return JOUEUR1;
			} else if (produit == (int) Math.pow(JOUEUR2,TAILLE)) {
				return JOUEUR2;
			}
		}

		// Vérifier la diagonale principale
		int produit1 = 1;
		for (int i = 0; i < TAILLE; i++) {
			produit1 *= grille.getCellule(i,i);
		}
		if (produit1 == 1) {
			return JOUEUR1;
		} else if (produit1 == (int) Math.pow(JOUEUR2, TAILLE)) {
			return JOUEUR2;
		}
		// Vérifier la diagonale secondaire
		int produit2 = 1;
		for (int i = 0; i < TAILLE; i++) {
			produit2 *= grille.getCellule(i, TAILLE - i - 1);
		}
		if (produit2 == 1) {
			return JOUEUR1;
		} else if (produit2 == (int) Math.pow(JOUEUR2, TAILLE)) {
			return JOUEUR2;
		}

		return 0;

	}
	/* getNombreCoups() : nombre de coups joués
	 * @return nombre de coups joués
	 */
	@Override
	public int getNombreCoups() {
		
		return nombreCoups ;
	}
	/* estFinie() : détermine si la partie est terminée ou non
	 * @return vrai si et seulement si getEtatJeu() est dans {MATCH_NUL, J1_VAINQUEUR, J2_VAINQUEUR}
	 */
	@Override
	public boolean estFinie() {
		return(getEtatJeu()==Etat.MATCH_NUL||getEtatJeu()==Etat.J1_VAINQUEUR||getEtatJeu()==Etat.J2_VAINQUEUR);
		 
	}
	
	/* estCoupAutorise() : valide le coup (ligne, colonne) sans le jouer
	 * @param ligne : numéro de ligne
	 * @param colonne : numéro de colonne
	 * @return true si le coup est autorisé, false sinon
	 */
	@Override
	public boolean estCoupAutorise(int ligne, int colonne) {
		
		return grille.getCellule(ligne, colonne)==0;
	}
	//-----------------------------------------------------------------------------------------------------------
	/* jouerCoup() : joue le coup (ligne, colonne)
	 * @param ligne : numéro de ligne
	 * @param colonne : numéro de colonne
	 * @pre ! this.estFinie() ;
	 * @pre this.estCoupAutorise(ligne, colonne)
	 */
	@Override
	public void jouerCoup(int ligne, int colonne) {
		// TODO Auto-generated method stub
		if(this.estFinie()||!this.estCoupAutorise(ligne, colonne)) {
			throw new IllegalStateException("Impossible de jouer dans cette case.");
		}
		grille.setCellule(ligne, colonne,getJoueur());
		nombreCoups++;

	}






}
