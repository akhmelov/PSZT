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

	/**
	 * Strategia przeszukiwania wszerz z preferencja dla krotkich klauzul.
	 * @return
	 */
	private boolean myrun()
	{
		Clause a, b;
		
		ArrayList<Clause> kbase = knowledgeBase.getListClauses();
		ArrayList<Clause> clauses = null;
		
		int thesisIndex = kbase.size() - 1;
		int baseEnd = thesisIndex + 1;
		boolean clauseCreated = false;
		//maksymalna dlugosc klauzuli, ktora mozemy stworzyc w danej iteracji.
		//jezeli z danego zbioru klauzul nie mozemy utworzyc juz zadnej nowej
		//klauzuli o dlugosci mniejszej niz ta, to zwiekszamy te wartosc.
		int clauseLength = 2;
		
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
				
				//Sprawdz, czy juz istnieje taka klauzula
				for (Clause omg : clauses)
				{
					if(omg.isEmpty())
					{
						kbase.add(omg);
						return true;
					}
					//Do bazy dodajemy tylko klauzule ponizej ustalonej dlugosci.
					if (omg.length() < clauseLength && !knowledgeBase.occurs(omg))
					{
						kbase.add(omg);
						clauseCreated = true;
					}
				}
			}
			//Jezeli powstala nowa klauzula a zakonczylismy obecna iteracje, to zaczynamy
			//kolejna, tym razem z rozszerzonym zakresem.
			if (clauseCreated && i+1 == baseEnd)
			{
				i = -1;
				baseEnd = kbase.size();
				clauseCreated = false;
			}
			//Jezeli nie powstala zadna nowa klauzula, to zwiekszamy limit dlugosci klauzul
			//i zaczynamy kolejna iteracje.
			else if (!clauseCreated && i+1 == baseEnd)
			{
				++clauseLength;
				i = -1;
				baseEnd = kbase.size();
			}
			//Jezeli nie udalo sie dowiesc tezy przy uzyciu klauzul o maksymalnej dlugosci
			//5, to zakoncz i zglos niepowodzenie.
			if (clauseLength > 5)
				return false;
		}
		
		return false;
	}
}
