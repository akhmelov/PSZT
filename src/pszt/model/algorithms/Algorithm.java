/**
 * 
 */
package pszt.model.algorithms;

import pszt.model.clause.Data;
import pszt.model.clause.KnowledgeBase;

/**
 * Defuniuje podstawowy interfajs algorytmow wnioskujacych
 * 
 * @author pk
 *
 */
public abstract class Algorithm
{
	/**
	 * Tu jest przechowywana baza wiedzy dostarczona do obliczenia
	 */
	protected KnowledgeBase knowledgeBase;
	/**
	 *	Inicjalizuje algorytm przez strategie
	 */
	public Algorithm(final KnowledgeBase knowledgeBase)
	{
		this.knowledgeBase = knowledgeBase;
	}
	
	/**
	 * Tu sa wykonywane operacje, ktore wykonuje dany algorytm, dane wejsciowe z konstruktora
	 * 
	 * @return Zwracany wynik dzialania algorytmu
	 */
	public abstract KnowledgeBase run();
	/**
	 * @return the knowledgeBase
	 */
	public final KnowledgeBase getKnowledgeBase()
	{
		return knowledgeBase;
	}
	/**
	 * @param knowledgeBase the knowledgeBase to set
	 */
	public final void setKnowledgeBase(KnowledgeBase knowledgeBase)
	{
		this.knowledgeBase = knowledgeBase;
	}
}
