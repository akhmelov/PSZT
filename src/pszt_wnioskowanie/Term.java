package pszt_wnioskowanie;

/**
 * Term - sta³a, zmienna, funkcja.
 * type == 1 sta³a
 * type == 2 zmienna
 * type == 3 funkcja
 */


public abstract class Term {
	
	
	public abstract String getSymbol();
	/**
	 * Unifikacja pary termów.
	 * 
	 * @param b
	 * @return true jeœli unifikacja siê powiod³a
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
		
		//Je¿eli termy s¹ takimi samymi funkcjami, to unifikuj ich argumenty
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
			//unifikuj i dodaj do parê do zbioru podstawieñ
		}
		
		return false;*/
	}
	
	/**
	 * Sprawdza, czy zmienna x wystêpuje w t
	 * 
	 * @return
	 */
	private boolean occursCheck(String x, Term t)
	{
		//for each variable y in t check if it equals x
		return false;
	}
}
