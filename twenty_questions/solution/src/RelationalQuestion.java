import java.util.*;

public class RelationalQuestion extends Question
{
	RelationalQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// new scanner for reading input
		Scanner console = new Scanner(System.in);

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

		int response;

		// try-catch to get an integer input variable
		while (true)
		{
			try
			{
				response = console.nextInt();
				if (response < 1 || response > 9)
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

		// parse the response
		if (response == 9)
		{
			return false;
		}

		System.out.println("");
		if (response < 5)
		{
			// animal-animal comparison
			System.out.println("What other animal do you want to compare it to?");

			int compareIndex = getIndexByName(console.nextLine());

			while (compareIndex < 0)
			{
				System.out.println(Ansi.ITALIC + Ansi.LOW_INTENSITY + "Hmmm, i don't have that in my database. Try again." + Ansi.RESET);
				compareIndex = getIndexByName(console.nextLine());
			}

			System.out.println("");
			if (response == 1)
			{
				if (answer.getWeight() > animals[compareIndex].getWeight())
				{
					System.out.println(Ansi.YES + " It is heaver than a " + animals[compareIndex].getName() + ".");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not heaver than a " + animals[compareIndex].getName() + ".");
				}
			}
			else if (response == 2)
			{
				if (answer.getHeight() > animals[compareIndex].getHeight())
				{
					System.out.println(Ansi.YES + " It is taller than a " + animals[compareIndex].getName() + ".");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not taller than a " + animals[compareIndex].getName() + ".");
				}
			}
			else if (response == 3)
			{
				if (answer.getLength() > animals[compareIndex].getLength())
				{
					System.out.println(Ansi.YES + " It is longer than a " + animals[compareIndex].getName() + ".");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not longer than a " + animals[compareIndex].getName() + ".");
				}
			}
			else  // response == 4
			{
				if (answer.getSpeed() > animals[compareIndex].getSpeed())
				{
					System.out.println(Ansi.YES + " It is faster than a " + animals[compareIndex].getName() + ".");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not faster than a " + animals[compareIndex].getName() + ".");
				}
			} // end of parsing 1-4
		}
		else
		{
			// animal-data comparison
			System.out.println("Please enter a number for <x>");

			// get x;
			while (!console.hasNextInt())
			{
				console.nextLine();
				System.out.println(Ansi.ITALIC + Ansi.LOW_INTENSITY + "Please enter a number for <x>" + Ansi.RESET);
			}
			int x = console.nextInt();

			System.out.println("");
			if (response == 5)
			{
				if (answer.getWeight() > x)
				{
					System.out.println(Ansi.YES + " It is heaver than " + x + " lbs.");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not heaver than " + x + " lbs.");
				}
			}
			else if (response == 6)
			{
				if (answer.getHeight() > x)
				{
					System.out.println(Ansi.YES + " It is taller than " + x + " ft.");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not taller than " + x + " ft.");
				}
			}
			else if (response == 7)
			{
				if (answer.getLength() > x)
				{
					System.out.println(Ansi.YES + " It is longer than " + x + " ft.");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not longer than " + x + " ft.");
				}
			}
			else  // response == 8
			{
				if (answer.getSpeed() > x)
				{
					System.out.println(Ansi.YES + " It is faster than " + x + " mph.");
				}
				else
				{
					System.out.println(Ansi.NO + " It is not faster than " + x + " mph.");
				}
			} // end of parsing 5-8
		} // end of parsing

		// the question was answered, thus it should count against
		// the players total
		return true;
	}
}
