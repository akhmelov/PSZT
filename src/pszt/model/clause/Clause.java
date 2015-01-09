package pszt.model.clause;

import java.util.ArrayList;

/**
 * Klauzula - alternatywa literalow.
 * Litera�y posortowane rosnaco wedlug text;
 */
public class Clause {

	/**
	 * Czy klauzula jest zanegowana
	 */
	private boolean isNegative;
	/**
	 * Lista predykatow zawartych w tej klauzuli
	 */
	private ArrayList<Predicate> list;
	
	/**
	 * Jedna z klauzul z ktorych nastopilo powstanie tej
	 */
	private Clause leftNodeTree;
	/**
	 * Jedna z klauzul z ktorych nastopilo powstanie tej
	 */
	private Clause rightNodeTree;
	
	public Clause()
	{
		list = new ArrayList<Predicate>();
		isNegative = false;
	}
	
	/**
	 * @return czy jest pusty ten obiekt
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
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
		if(tmp.length() > 3)
			tmp = tmp.substring(0, tmp.length() - 3);	//usuwamy ostatnie " V " 
		if(isNegative)
			tmp += ")";
		return tmp;
	}
	/**
	 * TODO przydaloby sie cos lepszego
	 * @param b
	 * @return true jesli tyle samo predykatow, takie same predykaty, takie same termy w predykatach
	 */
	public boolean equals(Clause b)
	{
		if (list.size() != b.list.size())
			return false;
		for (int i = 0; i < list.size(); ++i)
		{
			Predicate x = list.get(i);
			Predicate y = b.list.get(i);
			if (!x.termEquals(y))
				return false;
		}
		return true;
	}
	
	/**
	 * Tworzy nowe klauzule przez rezolucje i zaprzeczenie z klauzula b.
	 * @param c klauzula
	 * @return Lista zawierajaca pusta klauzule, jezeli dwie klauzule koncza dowod. 
	 * Lista nowych klauzul, ktore udalo sie stworzyc. Jesli sie nie udalo, 
	 * to jest pusta.
	 */
	public ArrayList<Clause> resolution(Clause c)
	{
		//lista klauzul do zwrocenia
		ArrayList<Clause> retList = new ArrayList<Clause>();
		//podstawienia termow
		//sub1 dla predykatu a
		Substitution sub1 = new Substitution();
		//sub2 dla predykatu b
		Substitution sub2 = new Substitution();
		
		for (int i = 0; i < list.size(); ++i)
		{
			Predicate a = list.get(i);
			for (int j = 0; j < c.list.size(); ++j)
			{
				Predicate b = c.list.get(j);
				
				//Sprawdz, czy mozna zastosowac rezolucje dla predykatow a i b.
				//Je�eli tak, to stworz nowa klauzule i dodaj ja do listy.
				//Je�eli nie, to szukaj dalej.
				if (a.equals(b) && !a.preciseEquals(b) && a.unifiable(b, sub1, sub2))
				{
					Clause n = new Clause();
					n.leftNodeTree = this;
					n.rightNodeTree = c; //pamietamy klazule z ktory wyprowadzamy obecna
					//Jezeli klauzule skladaja sie z jednego elementu (tego samego predykatu) i sa
					//unifikowalne to konczy to dowod.
					if (list.size() == 1 && c.list.size() == 1)
					{
						retList.add(n);
						return retList;
					}
					//Dodaj predykaty z tej klauzuli
					for (int k = 0; k < list.size(); ++k)
					{
						Predicate p = list.get(k);
						//Nie dodawaj predykatu a.
						if (k != i)
							n.addPredicate(p.applySubstitution(sub1));
					}
					//Dodaj predykaty z klauzuli c
					for (int k = 0; k < c.list.size(); ++k)
					{
						Predicate p = c.list.get(k);
						//Nie dodawaj predykatu b.
						if (k != j)
							n.addPredicate(p.applySubstitution(sub2));
					}
					retList.add(n);
					sub1.clear();
					sub2.clear();
				}
			}
		}
		return retList; 
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


	public Clause getLeftNodeTree() {
		return leftNodeTree;
	}


	public void setLeftNodeTree(Clause leftNodeTree) {
		this.leftNodeTree = leftNodeTree;
	}


	public Clause getRightNodeTree() {
		return rightNodeTree;
	}


	public void setRightNodeTree(Clause rightNodeTree) {
		this.rightNodeTree = rightNodeTree;
	}
}
