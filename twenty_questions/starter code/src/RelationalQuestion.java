/*
	Provided code by Dan Shervheim
	UMN 1103 TA Fall 2018

	Additions made by student: <YOURX500HERE>
	AskQuestion()
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.util.*;

public class RelationalQuestion /* something is missing here ... */
{
	RelationalQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// offer the player choices
		System.out.println("What do you want to know?");
		System.out.println("\t1. Is it heavier than another animal?");
		System.out.println("\t2. Is it taller than another animal?");
		System.out.println("\t3. Is it longer than another animal?");
		System.out.println("\t4. Is it faster than another animal?");
		System.out.println("\t5. Is it heavier than <x> lbs");
		System.out.println("\t6. Is it taller than <x> feet");
		System.out.println("\t7. Is it longer than <x> feet");
		System.out.println("\t8. Is it faster than <x> mph?");
		System.out.println("\t9. Go back");

		/*
			Setup a new scanner to read input from the player

			If they typed in 9, then return false (this question should
			not count against the players 20).
			
			If they entered 1-4 then prompt the user to input the name of
			another animal to compare, and find its index using the "getIndexByName()"
			method inherited from Question.java.

			If they entered 5-8, prompt them to enter a value for x.

			Then call the appropriate functions of the "answer" variable,
			passing in x or the other animal as needed.

			Do the proper comparison relative to the inputs 1-8, and
			print the result to the terminal. Then return true.
		*/
	}
}
