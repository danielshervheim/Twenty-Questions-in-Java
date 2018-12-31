import java.io.File;
import java.util.*;

public class TwentyQuestions
{

	// static so we can define it in main
	// and use it from playloop method
	private static Scanner console;

	public static void main(String[] args)
	{
		// open the animal folder
		File animalFolder = new File("../animals/");

		// make a new array of animals to store all the .txt
		// files in the animal folder.
		Animal[] animals = new Animal[animalFolder.listFiles().length];

		// take every .txt file and pass it into a new instance
		// of an animal to populate the array.
		for (int i = 0; i < animals.length; i++)
		{
			animals[i] = new Animal(animalFolder.listFiles()[i]);
		}

		// print out a welcome message
		System.out.println(Ansi.BACKGROUND_WHITE + Ansi.BLACK + "Welcome to 20 Questions: " + Ansi.ITALIC + "Animal Edition!" + Ansi.RESET);
		System.out.println("");

		// print out the rules
		System.out.println("Here's how the game works:");
		System.out.println("\t- I'm going to think of a random animal.");
		System.out.println("\t- You have 20 questions to try and guess it.");
		System.out.println("\t- You may only ask yes/no questions.");

		// print ready to start prompt.
		System.out.println("");
		System.out.println("Are you ready to start? (yes/no)");

		// setup the console scanner
		console = new Scanner(System.in);

		// get the players response and check it
		String response = console.nextLine();
		while (!response.equals("no") && !response.equals("yes"))
		{
			System.out.println(Ansi.ITALIC + Ansi.LOW_INTENSITY + "Please enter (yes/no)" + Ansi.RESET);
			response = console.nextLine();
		}

		if (response.equals("no"))
		{
			System.out.println("");
			System.out.println("Okay. Goodbye!");
			System.out.println("\n\n");
			return;
		}

		// else... let the games begin!

		// pick a random index from the array
		int randomIndex = new Random().nextInt(animals.length);

		// enter the play loop, with the animal array and a
		// random animal for the player to guess.
		playLoop(animals, animals[randomIndex]);
    }

    private static void playLoop(Animal[] animals, Animal answer)
    {
    	// variable to keep track of how many questions
    	// the player has left.
    	int questionsLeft = 20;

    	// setup the scanner in case it is not setup
    	if (console == null)
    	{
    		console = new Scanner (System.in);
    	}

    	System.out.println("\n\n");

		// prompt user to ask questions so long as they
		// have questions left to ask.
		while (questionsLeft > 0)
		{
			// print out the current question header
			System.out.println(Ansi.BACKGROUND_WHITE + Ansi.BLACK + "Question " + (21 - questionsLeft) + Ansi.RESET);
			if (questionsLeft < 6)
			{
				// print out a warning if the player is running out of questions.
				System.out.println(Ansi.HIGH_INTENSITY + Ansi.RED + Ansi.BLINK + "Only " + questionsLeft + " questions left!" + Ansi.RESET);
				System.out.println("");
			}

			// ask the player what they want to do
			System.out.println("What do you want to do?");
			System.out.println("\t1. " + Ansi.UNDERLINE + "Ask a relational question" + Ansi.RESET);
			System.out.println(Ansi.LOW_INTENSITY + "\t   (e.g. is it bigger than, is it faster than ...)" + Ansi.RESET);
			System.out.println("\t2. " + Ansi.UNDERLINE + "Ask an existential question" + Ansi.RESET);
			System.out.println(Ansi.LOW_INTENSITY + "\t   (e.g. does it have, can it ...)" + Ansi.RESET);
			System.out.println("\t3. " + Ansi.UNDERLINE + "Make a guess" + Ansi.RESET);
			System.out.println(Ansi.LOW_INTENSITY + "\t   (e.g. great white shark, camel ...)" + Ansi.RESET);
			System.out.println("\t4. Look up an animal in my database");
			System.out.println("\t5. Quit");

			int response;

			// try-catch to get an integer input variable
			while (true)
			{
				try
				{
					response = console.nextInt();
					if (response < 1 || response > 5)
					{
						throw new Exception();
					}

					// nextInt only reads the integer, not the newline
					// so we must read newline for scanner to coninue properly
					console.nextLine();
					break;
				}
				catch (Exception e)
				{
					System.out.println(Ansi.ITALIC + Ansi.LOW_INTENSITY + "Please enter 1, 2, 3, 4, or 5" + Ansi.RESET);
				}
			}

			System.out.println("");

			// process the response
			if (response == 5)
			{
				System.out.println("Okay. Goodbye!");
				System.out.println("\n\n");
				return;
			}
			else if (response == 4)
			{
				System.out.println("Okay, what animal do you want to lookup?");

				String query = console.nextLine();

				// look for query in the animal array
				int index = -1;
				for (int i = 0; i < animals.length; i++)
				{
					if (animals[i].getName().equals(query))
					{
						index = i;
						break;
					}
				}

				// wasn't found
				if (index < 0)
				{
					System.out.println("");
					System.out.println("Hmmm, i don't have a " + query + " in my database.");
				}
				else
				{
					System.out.println("");
					System.out.println(animals[index]);
				}
			}
			else if (response == 3)
			{
				System.out.println("Okay, what animal am I thinking of?");

				String guess = console.nextLine();

				if (answer.getName().equals(guess))
				{
					System.out.println("");
					System.out.println(Ansi.YES + " I was thinking of a " + guess + ". Nice job!");
					System.out.println("\n\n");
					return;

				}
				else
				{
					System.out.println("");
					System.out.println(Ansi.NO + " I wasn't thinking of a " + guess + ". Keep trying!");
					questionsLeft -= 1;
				}
			}
			else if (response == 2)
			{
				ExistentialQuestion q = new ExistentialQuestion(animals, answer);

				if (q.AskQuestion())
				{
					questionsLeft -= 1;
				}
			}
			else // (response == 1)
			{
				RelationalQuestion q = new RelationalQuestion(animals, answer);

				if (q.AskQuestion())
				{
					questionsLeft -= 1;
				}
			}

			System.out.println("\n\n");
		} // end of while loop

		// the player is out of questions. offer them
		// oone final chance to make a guess.
		System.out.println("You're out of questions! You can make one final guess: ");
		if (answer.getName().equals(console.nextLine()))
		{
			System.out.println(Ansi.YES + " You got it! Nice job.");
		}
		else
		{
			System.out.println(Ansi.NO + " I'm sorry, the animal I was thinking of was a " + answer.getName() + ". Better luck next time!");
		}

		System.out.println("\n\n");
    }
}
