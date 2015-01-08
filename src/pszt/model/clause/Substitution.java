package pszt.model.clause;

import java.util.ArrayList;


public class Substitution {

	private ArrayList<Term> list;
	
	public Substitution()
	{
		list = new ArrayList<Term>();
	}
	
	public void clear()
	{
		list.clear();
	}
	
	/**
	 * dodaj podstawienie b za a.
	 * @param a zastepowany term
	 * @param b nowy term
	 */
	public void add(Term a, Term b)
	{
		list.add(a);
		list.add(b);
	}
	
	/**
	 * Podstawia za term a term, ktorym zostal zastapiony. 
	 * Jezeli nie ma podstawienia dla termu a, to zwraca a.
	 * @param a
	 * @return podstawienie dla a jezeli istnieje, jesli nie to a
	 */
	public Term substitute(Term a)
	{
		for (int i = 0; i < list.size(); ++i)
		{
			if (list.get(i).equals(a) && i+1 < list.size())
				return list.get(i+1);
		}
		return a;
	}
}
