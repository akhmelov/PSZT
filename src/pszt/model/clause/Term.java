package pszt.model.clause;

/**
 * Term - stala, zmienna, funkcja.
 * type == 1 stala
 * type == 2 zmienna
 * type == 3 funkcja
 */


public abstract class Term 
{
	/**
	 * Nazwa termu
	 */
	protected String name;
	/**
	 * Czy dany term jest zanegowany
	 */
	private boolean isNegative;
	protected int type;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * Zwraca zawartosc obiektu w postaci stringu
	 * 
	 */
	public Term()
	{
		type = 0;
		isNegative = false;
	}
	public abstract String toString();
	
	/**
	 * Porownanie dwoch termow.
	 * @param b
	 * @return true jesli takie same typy i nazwy.
	 */
	public boolean equals(Term b)
	{
		if (type != b.type || !name.equals(b.name))
			return false;
		return true;
	}
	/**
	 * Unifikacja pary termow.
	 * 
	 * @param b term, z ktorym ten term jest unifikowany 
	 * @param sub1 podstawienia dla tego termu
	 * @param sub2 podtawienia dla termu b
	 * @return true jesli unifikacja sie powiodla
	 */
	public abstract boolean unify(Term b, Substitution sub1, Substitution sub2);
	/**
	 * Stosuje podstawienie dla tego termu.
	 * @param sub odpowiedni zbior podstawien
	 * @return term, ktory zastepuje ten term. jesli nie ma podstawienia, to zwraca ten term.
	 */
	public abstract Term substitute(Substitution sub);
	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the isNegative
	 */
	public final boolean isNegative()
	{
		return isNegative;
	}
	/**
	 * @param isNegative the isNegative to set
	 */
	public final void setNegative(boolean isNegative)
	{
		this.isNegative = isNegative;
	}
}
