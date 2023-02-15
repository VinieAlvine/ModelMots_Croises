package DjaaRaphael.TchimouAlvinetp2;

public class CaseMC {
	private char solution;
	private char proposition;
	private String definitionHorizontale;
	private String definitionVerticale;
	private boolean estCaseNoire;

	public CaseMC() {
		this.solution = ' ';
		this.proposition = ' ';
		this.definitionHorizontale = "";
		this.definitionVerticale = "";
		this.estCaseNoire = false;
	}

	public char getSolution() {
		return solution;
	}

	public void setSolution(char solution) {
		this.solution = solution;
	}

	public char getProposition() {
		return proposition;
	}

	public void setProposition(char proposition) {
		this.proposition = proposition;
	}

	public String getDefinitionHorizontale() {
		return definitionHorizontale;
	}

	public void setDefinitionHorizontale(String definitionHorizontale) {
		this.definitionHorizontale = definitionHorizontale;
	}

	public String getDefinitionVerticale() {
		return definitionVerticale;
	}

	public void setDefinitionVerticale(String definitionVerticale) {
		this.definitionVerticale = definitionVerticale;
	}

	public boolean estCaseNoire() {
		return estCaseNoire;
	}

	public void setCaseNoire(boolean estCaseNoire) {
		this.estCaseNoire = estCaseNoire;
	}
}









