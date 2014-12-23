package pszt.model.clause;

import java.util.ArrayList;

/**
 * 
 */
public class Predicate 
{

	String name;
	boolean isNegative;
	ArrayList <Term> list;

	/**
	 * Tworzy predykat
	 * 
	 * @param name nazwa predykatu
	 * @param isNegative	czy jest zanegowany ten predykat
	 */
	public Predicate(final String name, final boolean isNegative)
	{
		this.name = name;
		this.isNegative = isNegative;
		list = new ArrayList<Term>();
	}
	
	/**
	 * Konstruktor tworzy predykat ktory trzeba recznie ustawic
	 */
	public Predicate()
	{
		list = new ArrayList<Term>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String tmp = "";
		if(isNegative)
		{
			tmp += "!";
		}
		tmp += name;
		tmp += "(";
		for (Term term : list)
		{
			tmp += term.toString();
			tmp += ",";
		}
		if(tmp.charAt(tmp.length() - 1) == ',')
			tmp = tmp.substring(0, tmp.length() - 1); //usuwamy ostatni przecinek, poniewaz po nim nie ma argumentow
		tmp += ")";
		return tmp;
	}
	/**
	 * Dodaje term do predykatu
	 * 
	 * @param term term do dodania
	 */
	public void addNewTerm(final Term term)
	{
		list.add(term);
	}
	/**
	 * 
	 * @param b
	 * @return true je�li taka sama nazwa.
	 */
	public boolean equals(Predicate b)
	{
		if (name.equals(b.getName()))
			return true;
		return false;
	}

	/**
	 * 
	 * @param b
	 * @return true je�li taka sama nazwa i taki sam znak przed predykatem.
	 */
	public boolean preciseEquals(Predicate b)
	{
		if (this.equals(b))
		{
			if (isNegative == b.isNegative())
				return true;
		}
		return false;
	}

	/**
	 * @return the text
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param text the text to set
	 */
	public void setName(String text) {
		this.name = text;
	}


	/**
	 * @return the isNegative
	 */
	public boolean isNegative() {
		return isNegative;
	}


	/**
	 * @param isNegative the isNegative to set
	 */
	public void setNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}


	/**
	 * @return the list
	 */
	public ArrayList<Term> getList() {
		return list;
	}


	/**
	 * @param list the list to set
	 */
	public void setList(ArrayList<Term> list) {
		this.list = list;
	}
}
