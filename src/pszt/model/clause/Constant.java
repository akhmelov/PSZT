package pszt.model.clause;

public class Constant extends Term 
{
	@Override
	public boolean unify(Term b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString()
	{
		return name;
	}

}
