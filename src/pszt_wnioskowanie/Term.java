package pszt_wnioskowanie;

/**
 * Term - sta�a, zmienna, funkcja.
 * type == 1 sta�a
 * type == 2 zmienna
 * type == 3 funkcja
 */


public abstract class Term {
	
	
	public abstract String getSymbol();
	/**
	 * Unifikacja pary term�w.
	 * 
	 * @param b
	 * @return true je�li unifikacja si� powiod�a
	 */
	public abstract boolean unify(Term b);
	{/*
		if (type == 2)
		{
			//podstaw zmienne
		}
		if (b.type == 2)
		{
			//b.podstaw zmienne
		}
		
		if (type == 2 && b.type == 2)
		{
			if (this.equals(b))
			{
				return true;
			}
		}
		
		//Je�eli termy s� takimi samymi funkcjami, to unifikuj ich argumenty
		if (type == 3 && b.type == 3)
		{
			if (this.equals(b))
			{
				
			}
			else
				return false;
		}
		else if (type != 2)
		{
			b.unify(this);
		}
		else if (this.occursCheck(symbol, b))
			return false;
		else
		{
			//unifikuj i dodaj do par� do zbioru podstawie�
		}
		
		return false;*/
	}
	
	/**
	 * Sprawdza, czy zmienna x wyst�puje w t
	 * 
	 * @return
	 */
	private boolean occursCheck(String x, Term t)
	{
		//for each variable y in t check if it equals x
		return false;
	}
}
