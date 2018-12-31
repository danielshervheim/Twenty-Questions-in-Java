import java.util.*;

public class ExistentialQuestion extends Question
{
	ExistentialQuestion(Animal[] animals, Animal answer)
	{
		super(animals, answer);
	}

	public boolean AskQuestion()
	{
		// new scanner for reading input
		Scanner console = new Scanner(System.in);

		// offer choices to player
		System.out.println("What do you want to know?");
		System.out.println("\t1. Does it have <x>?");
		System.out.println("\t2. Can it <x>?");
		System.out.println("\t3. Is it <x>?");
		System.out.println("\t4. Does it eat <x>?");
		System.out.println("\t5. Go back");

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

		// parse the response
		if (response == 5)
		{
			return false;
		}

		System.out.println("");
		System.out.println("Please enter a string for <x>");
		String x = console.nextLine();

		System.out.println("");
		if (response == 1)
		{
			if (answer.hasX(x))
			{
				System.out.println(Ansi.YES + " This animal has " + x + ".");
			}
			else
			{
				System.out.println(Ansi.NO + " This animal does not have " + x + ".");
			}
		}
		else if (response == 2)
		{
			if (answer.canX(x))
			{
				System.out.println(Ansi.YES + " This animal can " + x + ".");
			}
			else
			{
				System.out.println(Ansi.NO + " This animal can not " + x + ".");
			}
		}
		else if (response == 3)
		{
			if (answer.isX(x))
			{
				System.out.println(Ansi.YES + " This animal is " + x + ".");
			}
			else
			{
				System.out.println(Ansi.NO + " This animal is not " + x + ".");
			}
		}
		else  // (reponse == 4)
		{
			if (answer.eatsX(x))
			{
				System.out.println(Ansi.YES + " This animal eats " + x + ".");
			}
			else
			{
				System.out.println(Ansi.NO + " This animal does not eat " + x + ".");
			}
		}

		// the question was answered, thus it should count against
		// the players total
		return true;
	}
}
