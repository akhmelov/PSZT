package pszt_wnioskowanie;

public class Variable extends Term {

	private String text;
	
	@Override
	public boolean unify(Term b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSymbol() {
		return text;
	}

}
