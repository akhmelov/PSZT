package pszt_wnioskowanie;

import java.util.ArrayList;

/**
 * Klauzula - alternatywa litera��w.
 * Litera�y posortowane rosn�co wed�ug text;
 */
public class Clause {

	private ArrayList<Predicate> list;
	
	public Clause()
	{
		
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
	 * @param a
	 */
	void addPredicate(Predicate a)
	{
		
	}

	/**
	 * @return the list
	 */
	public ArrayList<Predicate> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Predicate> list) {
		this.list = list;
	}
}
