package pszt.model.clause;

import java.util.ArrayList;

/**
 * Baza wiedzy w postaci koniunkcji klauzul.
 * Zawiera w sobie zbior klauzur zdefiniowanych oraz teze do udowodnienia
 * 
 */
public class KnowledgeBase extends Data
{
	/**
	 * Zawiera wiedze dostepna, sa to te klauzury ktore mamy podane w tresci
	 */
	private ArrayList<Clause> listClauses;
	/**
	 * Teza do udowodnienia, to co mamy udowodnic
	 */
	private Clause thesis;
	
	public KnowledgeBase()
	{
		listClauses = new ArrayList<Clause>();	
	}
	
	/**
	 * Dodaje nowa klauzule do zbioru, do znioru tez ktore mamy jako znane, czyli podane w tresci zadania
	 * 
	 * @param clause klauzula do dodania
	 */
	public void addNewClause(final Clause clause)
	{
		listClauses.add(clause);
	}
	
	/**
	 * Sprawdza, czy klauzula c juz wystepuje w bazie
	 * @param c
	 * @return
	 */
	public boolean occurs(Clause b)
	{
		for (Clause a : listClauses)
		{
			if (a.equals(b))
				return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String tmp = "";
		for (Clause clause : listClauses)
		{
			tmp += clause.toString();
			tmp += "\n";
		}
		tmp += "Thesis: " + thesis.toString();
		return tmp;
	}
	/**
	 * @return the listClauses
	 */
	public final ArrayList<Clause> getListClauses()
	{
		return listClauses;
	}

	/**
	 * @param listClauses the listClauses to set
	 */
	public final void setListClauses(ArrayList<Clause> listClauses)
	{
		this.listClauses = listClauses;
	}

	/**
	 * @return the thesis
	 */
	public final Clause getThesis()
	{
		return thesis;
	}

	/**
	 * @param thesis the thesis to set
	 */
	public final void setThesis(Clause thesis)
	{
		this.thesis = thesis;
	}
}
