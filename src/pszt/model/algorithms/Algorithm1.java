/**
 * 
 */
package pszt.model.algorithms;

import java.util.ArrayList;

import pszt.model.clause.Clause;
import pszt.model.clause.KnowledgeBase;
import pszt.model.clause.Substitution;

/**
 * @author pk
 *
 */
public class Algorithm1 extends Algorithm
{

	Substitution sub1, sub2;
	
	
	/**
	 * @param knowledgeBase
	 */
	public Algorithm1(KnowledgeBase knowledgeBase)
	{
		super(knowledgeBase);
		// TODO tu sa inicjalizowane parametry do dzialania tego algorytmu
		//oraz obiekty wlasne na ktorych lub w ktorych beda wykonywane operacje obliczeniawe
	}

	@Override
	public KnowledgeBase run()
	{
		
		myrun();
		
		return knowledgeBase; 	//zwracany jest wynik wykonania algorytmu czyli obiekt typu Data, to co 
		//jest obecnie to jest testowe
	}

	
	/**
	 * Strategia wszerz.
	 * @return
	 */
	private boolean myrun()
	{
		Clause a, b;
		
		ArrayList<Clause> kbase = knowledgeBase.getListClauses();
		ArrayList<Clause> clauses = null;
		
		int thesisIndex = kbase.size() - 1;
		int baseEnd = thesisIndex + 1;
		boolean finished = true;
		
		//Wybierz 2 klauzule
		for (int i = 0; i < baseEnd; ++i)
		{
			for (int j = i+1; j < baseEnd; ++j)
			{
				a = kbase.get(i);
				b = kbase.get(j);
				
				clauses = a.resolution(b);
				if (clauses == null)
					return true;
				
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
						finished = false;
					}
				}
			}
			if (i+1 == baseEnd && !finished)
			{
				i = -1;
				baseEnd = kbase.size();
				finished = true;
			}
		}
		
		
		
		return false;
	}
	
	
	private void test()
	{
		
	}
	
}
