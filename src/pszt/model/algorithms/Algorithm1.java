/**
 * 
 */
package pszt.model.algorithms;

import pszt.model.clause.Data;
import pszt.model.clause.KnowledgeBase;

/**
 * @author pk
 *
 */
public class Algorithm1 extends Algorithm
{

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
		// TODO operacje ktore robi dany algorytm, f-cje inne obiekty ...
		System.out.println("Uruchomiany niezaimplementawany 1-szy algorytm po implementacji tego obiektu"
				+ " prosze wywalic ta linijke model->algorithms->algorithm1->run");
		return knowledgeBase; 	//zwrazany jest wynik wykonania algorytmu czyli obiekt typu Data, to co 
		//jest obecnie to jest testowe
	}

}
