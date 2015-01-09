/**
 * 
 */
package pszt.model.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

import pszt.model.clause.Clause;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
public class Algorithm3 extends Algorithm
{

	/**
	 * @param knowledgeBase
	 */
	public Algorithm3(KnowledgeBase knowledgeBase)
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

	private boolean myrun()
	{
Clause a, b;
		
		ArrayList<Clause> kbase = knowledgeBase.getListClauses();
		ArrayList<Clause> clauses = null;
		
		int thesisIndex = kbase.size() - 1;
		int baseEnd = thesisIndex + 1;
		boolean next = false;
		
		
		int aindex = 0;
		int bindex = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		
		
		while (true)
		{
			aindex = keyboard.nextInt();
			bindex = keyboard.nextInt();
			
			a = kbase.get(aindex);
			b = kbase.get(bindex);
			
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
				}
			}
		}
		
		
		//return false;
	}
}
