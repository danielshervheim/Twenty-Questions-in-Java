public abstract class Question
{
	// attributes
	protected Animal[] animals;
	protected Animal answer;

	Question(Animal[] animals, Animal answer)
	{
		this.animals = animals;
		this.answer = answer;
	}

	// the method should print out the answer
	// and return true if the question should count
	// against the players 20, or false if it should not
	// (e.g. if they decide to ask a different question)
	public boolean AskQuestion()
	{
		// we cannot ask a generic question
		// we must override this method in children
		return true;
	}

	protected int getIndexByName(String name)
	{
		for (int i = 0; i < animals.length; i++)
		{
			if (animals[i].getName().equals(name))
			{
				return i;
			}
		}
		return -1;
	}
}
