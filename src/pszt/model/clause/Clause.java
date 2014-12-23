package pszt.model.clause;

import java.util.ArrayList;

/**
 * Klauzula - alternatywa litera��w.
 * Litera�y posortowane rosn�co wed�ug text;
 */
public class Clause {

	/**
	 * Czy klauzura jest zanegowana
	 */
	private boolean isNegative;
	/**
	 * Lista predykatow zawartych w tej klauzurze
	 */
	private ArrayList<Predicate> list;
	
	public Clause()
	{
		list = new ArrayList<Predicate>();
		isNegative = false;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String tmp = "";
		if(isNegative)
			tmp += "!(";
		for (Predicate predicate : list)
		{
			tmp += predicate.toString();
			tmp += " V ";
		}
		tmp = tmp.substring(0, tmp.length() - 3);	//usuwamy ostatnie " V " 
		if(isNegative)
			tmp += ")";
		return tmp;
	}
	/*
	 * Por�wnuje dwie klauzule - je�li predykaty w obu s� takie same to true.
	 */
	public boolean equals(Clause b)
	{
		for (Predicate a : list)
		{
			int index = list.indexOf(a);
		}
		return false;
	}
	
	/**
	 * Dodawanie predykatu do listy
	 * @param a dodawany predykat
	 */
	public void addPredicate(Predicate a)
	{
		list.add(a);
	}

	/**
	 * @return the list
	 */
	public ArrayList<Predicate> getList() 
	{
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Predicate> list) {
		this.list = list;
	}


	/**
	 * @return the isNegative
	 */
	public final boolean isNegative()
	{
		return isNegative;
	}


	/**
	 * @param isNegative the isNegative to set
	 */
	public final void setNegative(boolean isNegative)
	{
		this.isNegative = isNegative;
	}
}
