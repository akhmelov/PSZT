package pszt_wnioskowanie;

import java.util.ArrayList;

/**
 * Klauzula - alternatywa litera³ów.
 * Litera³y posortowane rosn¹co wed³ug text;
 */
public class Clause {

	private ArrayList<Predicate> list;
	
	public Clause()
	{
		
	}
	
	/*
	 * Porównuje dwie klauzule - jeœli predykaty w obu s¹ takie same to true.
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
