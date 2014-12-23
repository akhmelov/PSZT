package pszt.model.clause;

import java.util.ArrayList;

/**
 * Klasa definujaca f-cje
 * 
 * @author pk - robilem tylko czesc
 *
 */
public class Function extends Term 
{

	/**
	 * Tu sa przechowywane termy, ktore sa dostarczane do f-cji jako parametry
	 */
	ArrayList<Term> lista;
	public Function()
	{
		lista = new ArrayList<Term>();
	}
	public void addNewTerm(final Term term)
	{
		lista.add(term);
	}
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
	public String toString()
	{
		if(lista.isEmpty())	//lista jest pusta, nie ma sensu wykonywac te f-cje
			return "";
		String tmp = name;
		tmp += "(";
		for (Term term : lista)
		{
			tmp += term.toString();
			tmp += ",";
		}
		if(tmp.charAt(tmp.length() - 1) == ',')
			tmp = tmp.substring(0, tmp.length() - 1);	//usuwamy przecinek, nie ma argumentow wiecej po nim
		tmp += ")";
		return tmp;
	}
}
