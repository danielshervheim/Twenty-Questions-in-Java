/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <YOURX500HERE>
	AskQuestion()
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.util.*;

public class ExistentialQuestion /* something is missing here ... */
{
	ExistentialQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// offer choices to player
		System.out.println("What do you want to know?");
		System.out.println("\t1. Does it have <x>?");
		System.out.println("\t2. Can it <x>?");
		System.out.println("\t3. Is it <x>?");
		System.out.println("\t4. Does it eat <x>?");
		System.out.println("\t5. Go back");

		/*
			Setup a new scanner to read input from the player

			If they typed in 5, then return false (this question should
			not count against the players 20).

			otherwise, prompt the user to enter an input for x and
			call the appropriate functions of the "answer" variable,
			passing in x.

			Print the result to the terminal, and return true.

			Hint: if the user typed in 3, then you will probably need to call
			answer.isX(something here);
		*/
	}
}
