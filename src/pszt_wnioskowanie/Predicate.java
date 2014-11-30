package pszt_wnioskowanie;

import java.util.ArrayList;

/**
 * 
 */
public class Predicate {

	String text;
	boolean isNegative;
	ArrayList <Term> list;
	
	/**
	 * 
	 * @param b
	 * @return true jeœli taka sama nazwa.
	 */
	public boolean equals(Predicate b)
	{
		if (text.equals(b.getText()))
			return true;
		return false;
	}

	/**
	 * 
	 * @param b
	 * @return true jeœli taka sama nazwa i taki sam znak przed predykatem.
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
	public String getText() {
		return text;
	}


	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
