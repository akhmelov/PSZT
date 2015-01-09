/**
 * 
 */
package pszt.model.algorithms;

import java.util.ArrayList;

import pszt.model.clause.Clause;
import pszt.model.clause.Data;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
public class Algorithm2 extends Algorithm
{

	/**
	 * @param knowledgeBase
	 */
	public Algorithm2(KnowledgeBase knowledgeBase)
	{
		super(knowledgeBase);
		// TODO tu sa inicjalizowane parametry do dzialania tego algorytmu
		//oraz obiekty wlasne na ktorych lub w ktorych beda wykonywane operacje obliczeniawe
	}

	/* (non-Javadoc)
	 * @see pszt.model.algorithms.Algorithm#run()
	 */
	@Override
	public KnowledgeBase run()
	{
		myrun();
		
		
		return knowledgeBase; 	//zwrazany jest wynik wykonania algorytmu czyli obiekt typu Data, to co 
		//jest obecnie to jest testowe
	}

	/**
	 * Strategia liniowa.
	 * @return
	 */
	private boolean myrun()
	{
		Clause a, b;
		
		ArrayList<Clause> kbase = knowledgeBase.getListClauses();
		ArrayList<Clause> clauses = null;
		
		int thesisIndex = kbase.size() - 1;
		int baseEnd = thesisIndex + 1;
		boolean next = false;
		
		
		//Wybierz klauzule robocza.
		a = kbase.get(thesisIndex);
		//Zestaw ja z kazda z bazy wiedzy.
		for (int i = 0; i < baseEnd; ++i)
		{
			b = kbase.get(i);
			clauses = a.resolution(b);
			
			//sprawdz, czy juz istnieje taka klauzula
			for (Clause omg : clauses)
			{
				if(omg.isEmpty())
				{
					kbase.add(omg);
					return true;
				}
				if (!knowledgeBase.occurs(omg))
				{
					kbase.add(omg);
					next = true;
				}
			}
			if (next)
			{
				++baseEnd;
				a = kbase.get(baseEnd - 1); 
				i = -1;
				next = false;
			}
		}
		
		
		return false;
	}
}
