package pszt_wnioskowanie;

import java.util.ArrayList;

public class Function extends Term {

	String text;
	ArrayList<Term> lista;
	
	@Override
	public boolean unify(Term b) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean equals(Term b)
	{
		return false;
	}

	@Override
	public String getSymbol() {
		return text;
	}
}
