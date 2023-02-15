package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import morpions.kit.test.*;
import morpions.kit.test.SpecifModeleMorpions.Etat;

public class MorpionTest {
	SpecifModeleMorpions morpions ;
	public static final int TAILLE = 3 ;
	public static final int NB_CASES = 9 ;


	@BeforeEach
	public void setUp() throws Exception
	{
		// morpions = new MorpionsReference() ;
		// morpions = new Bogue1() ;
		// morpions = new Bogue2() ;
		// morpions = new Bogue3() ;
		// morpions = new Bogue4() ;
		// morpions = new Bogue5() ;
		morpions = new MorpionsReference() ;
	}

	@Test
	public void testInit()
	{
		assertTrue(!morpions.estFinie(),"la partie n'est pas terminée");
		assertEquals(0, morpions.getVainqueur()) ;
		assertEquals(0, morpions.getNombreCoups()) ;
		testInvariant() ;
	}

	@Test
	public void testPremierCoup()
	{
		morpions.jouerCoup(1, 1) ;
		assertTrue(! morpions.estFinie(), "Partie pas finie après premier coup") ;
		assertEquals(1,morpions.getJoueur()-1);
		testInvariant() ;
	}

	private void testInvariant()
	{
		// Le nombre de coups est positif ou nul, et inférieur ou égal au nombre de cases
		assertTrue(morpions.getNombreCoups() >= 0, "Nombre de coups >= 0") ;
		assertTrue(morpions.getNombreCoups() <= NB_CASES,
				"Nombre de coups <= " + NB_CASES) ;
		// ----------------------
		// SÉQUENCE 3 À COMPLÉTER
		// ----------------------
	}
	@Test
	public void testCoupDejaJoue()
	{
		morpions.jouerCoup(1, 1);
		assertTrue(! morpions.estCoupAutorise(1,1), "La case (1,1) ne peut être jouée") ;
	}

	@Test
	public void testPartiePasFinie()
	{
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 2);
		assertTrue(!morpions.estFinie());
		
		// ----------------------
		// SÉQUENCE 4 À COMPLÉTER
		// ----------------------
		//fail("Test à compléter") ;
	}

	@Test
	public void testJoueur1gagnant()
	{
		// ----------------------
		// SÉQUENCE 5 À COMPLÉTER
		// ----------------------
		morpions.jouerCoup(1, 3);
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 3);
		morpions.jouerCoup(2, 1);
		morpions.jouerCoup(3, 3);
		assertEquals(1, morpions.getVainqueur());
		//fail("Test à écrire") ;
	}
	// Une méthode de test par méthode de la classe testée :
	@Test 
	public void testGetEtatJeu() {
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 1);
	    morpions.jouerCoup(1, 2);
		morpions.jouerCoup(2, 2);
		morpions.jouerCoup(3, 2);
		morpions.jouerCoup(2,3);
		assertEquals(Etat.J2_VAINQUEUR,morpions.getEtatJeu());
		assertNotEquals(Etat.MATCH_NUL,morpions.getEtatJeu());
		
	}
	
	// scénarios vérifiant le bon fonctionnement de getEtatJeu()
	@Test 
	public void testGetJoueur() {
		assertEquals(1,morpions.getJoueur());
		morpions.jouerCoup(1, 1);
		assertEquals(2,morpions.getJoueur());
		morpions.jouerCoup(2, 1);
		assertEquals(1,morpions.getJoueur());
	}
	// scénarios vérifiant le bon fonctionnement de getJoueur()
	@Test public void testGetVainqueur() throws Exception {
		
		assertEquals(0,morpions.getVainqueur());
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(2, 1);
	    morpions.jouerCoup(1, 2);
		morpions.jouerCoup(2, 2);
		morpions.jouerCoup(3, 2);
		morpions.jouerCoup(2,3);
		assertEquals(2,morpions.getVainqueur());
		setUp();
		morpions.jouerCoup(1, 1);
		morpions.jouerCoup(1, 2);
	    morpions.jouerCoup(2, 1);
		morpions.jouerCoup(2, 2);
		morpions.jouerCoup(3, 1);
		assertEquals(1,morpions.getVainqueur());
		setUp();
		
	}
	// scénarios vérifiant le bon fonctionnement de getVainqueur()
	// et ainsi de suite pour getNombreCoups(), …, jusqu'à jouerCoup()
	@Test public void testControle() {}
	// Scénario tentant divers coups non autorisés,
	// avec vérification systématique de estCoupAutorise() 
	@Test public void testFinPartie() {}
	// Scénarios explorant les situations de fin de partie,
	// avec vérification systématique de estFinie() et de
	// getVainqueur() :
	// * alignement horizontal (grille pleine ou non)
	// * alignement vertical (grille pleine ou non)
	// * alignement diagonal (grille pleine ou non)
	// et ainsi de suite...


}
