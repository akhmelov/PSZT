package pszt.model;

import javax.management.InvalidAttributeValueException;

import pszt.model.algorithms.Algorithm1;
import pszt.model.algorithms.Algorithm2;
import pszt.model.algorithms.Algorithm3;
import pszt.model.clause.KnowledgeBase;
import pszt.model.inputData.ParseFile;


/**
 * @author pk
 *
 *Model MVC
 *
 */
public class Model
{ 
	
	/**
	 * Przechowuje wiedze ktora jest brana z pliku wejsciowego
	 */
	private KnowledgeBase knowledgeBase;
	/**
	 *Konstruktor odpala model 
	 */
	public Model()
	{
		knowledgeBase = null;
	}
	
	/**
	 * Prasuje wybrany plik i tworzy bazeWiedzy do dalszej czesci przekazywania
	 * 
	 * @param path droga do pliku ktory bedzie prasowany
	 */
	public void runParsingFile(final String path)
	{
			ParseFile parseFile = new ParseFile(path);
			try
			{
				knowledgeBase = parseFile.run();
			}
			catch (InvalidAttributeValueException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/**
	 * Uruchamia algorytm
	 * 
	 * @param knowledgeBase	wiedza na ktorej bedzie dzialal algorytm
	 * @return zwraca wynik dzialania
	 */
	public KnowledgeBase runAlgorithm1(final KnowledgeBase knowledgeBase)
	{
		Algorithm1 algorithm1 = new Algorithm1(knowledgeBase);
		return algorithm1.run();
	}

	/**
	 * Uruchamia algorytm
	 * 
	 * @param knowledgeBase	wiedza na ktorej bedzie dzialal algorytm
	 * @return zwraca wynik dzialania
	 */
	public KnowledgeBase runAlgorithm2(final KnowledgeBase knowledgeBase)
	{
		Algorithm2 algorithm2 = new Algorithm2(knowledgeBase);
		return algorithm2.run();
	}
	/**
	 * Uruchamia algorytm
	 * 
	 * @param knowledgeBase	wiedza na ktorej bedzie dzialal algorytm
	 * @return zwraca wynik dzialania
	 */
	public KnowledgeBase runAlgorithm3(final KnowledgeBase knowledgeBase)
	{
		Algorithm3 algorithm3 = new Algorithm3(knowledgeBase);
		return algorithm3.run();
	}
	/**
	 * @return the knowledgeBase
	 */
	public final KnowledgeBase getKnowledgeBase()
	{
		return knowledgeBase;
	}
	
	
}
