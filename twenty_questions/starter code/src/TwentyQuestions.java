/*
	Provided code by Dan Shervheim

	Additions made by student: <YOURX500HERE>
	main(String[] args)
	playLoop(Animal[] animals, Animal answer)
	<ADD ANY OTHER METHODS YOU WRITE HERE>
*/

import java.io.File;
import java.util.*;

public class TwentyQuestions
{
	public static void main(String[] args)
	{

		/*
			Please familiarize yourself with the methods
			available to you from Java's File class.
			https://docs.oracle.com/javase/7/docs/api/java/io/File.html

			Some of them you may find useful are:
			
			the constructor:
			File fileVar = new File("filepath");
			
			fileVar.listFiles();
			returns an array of File objects within the folder
			represented by "fileVar".
		*/

		/*
			Step 1: open the animal folder "../animals"
			note that we are in the src folder, so the "../"
			first takes us back to the project4 directory, and then
			into the "animals" folder
		*/
		
		/*
			Step 2: make a new array of Animal objects to represent all
			of the .txt files we will read in. This is done similar to how you
			created an array of Rational2's in lab 9.

			Note that you CANNOT make any assumptions about the length of the
			array. I.e., you cannot assume there will only be "x" number of animals.
			You must figure out a way to get the number of .txt files in the "../animals"
			and make the array that length.
		*/

		/*
			Step 3: use a loop to initialize every array position to a new
			instance of the Animal class. Pass in a .txt file to the Animal
			constructor as you do.

			Note, it does not matter which order the .txt files end up in the
			array, so long as every .txt file corresponds to exactly one position
			in the array.
		*/

		/*
			Step 4: Print out some kind of welcome message and perhaps
			explain the rules a bit.
		*/

		/*
			Step 5: Either paste in the randomInt method from previous labs,
			or use Java's Random class to generate a random index for your
			animal array.

			Create a new Animal variable and set it equal to the array element
			at the aformentioned random index. This will be the "answer" that
			players are trying to guess.
		*/

		/*
			Step 6: Pass the animal array, and the answer into the playLoop method.
		*/

		playLoop(/* your animal array here*/, /* your answer variable here */);
    }

    private static void playLoop(Animal[] animals, Animal answer)
    {

    	/*
			Step 1: Setup a counter variable to keep track of the number of questions
			the player has left
    	*/

		/*
			Step 2: Enter a loop which will run until the player is out of questions...
			Do the following every time the loop runs:

			a) Print out a message telling the player how many questions they have left

			b) Print out a list of choices that the player can make:

				1. ask a relational question
				2. ask an existential question
				3. make a guess
				4. lookup an animal in the database (this is a free move, i.e. should not count
				   against the players 20 question limit)
				5. quit

			c) Use a scanner to get input from the user on what they want to do.

				if 1) Create a new instance of RelationalQuestion and call its AskQuestion() method.

				if 2) Create a new instance of ExistentialQuestion and call its AskQuestion() method.

				if 3) Prompt the user to input the name of an animal. If it is the same as the
				answer variables name, then print out a win message. otherwise, print out a "keep
				guessing" message.

				if 4) Prompt the user to input the name of an animal. Look in the animal array
				to see if that animal exists in the array, and if it does, then print it out by
				calling its toString() method.

				if 5) Print a goodbye message and exit.

			d) Decrement the number of questions left, if needed.

		*/

		/*
			Step 3: If the player reaches the end of the loop it means they
			were not able to guess the animal within 20 questions, so give them
			one final attempt to make a guess. Prompt them to enter the name of an
			animal. If it is correct, print out a win message. Otherwise, tell them
			the answer and exit.
		*/
    }
}
