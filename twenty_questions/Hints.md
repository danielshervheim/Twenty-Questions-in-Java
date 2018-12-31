# Project 4

This document serves two purposes.

1. It outlines what (and in certain cases, how) we expect you to implement your additions to the provided starter code.
2. It gives you a logical ordering to start your implementation in.

Before you begin working on the project, we would recommend you first

1. Read the project 4 pdf carefully
2. Try out the provided demo files
3. Read through this document carefully as well

Once you have read this document through once, then you may read it again from the beginning, working on the corresponding .java files as you go.

*Note that this document was compiled based on the provided comments in the starter code. We have expanded the comments to include more examples, and documentation where relevant. It also pulls in the information from the "Suggestions / Getting Started" section of the project 4 pdf.*

## 1) TwentyQuestions.java

### main()

Please familiarize yourself with the methods available to you from Java's [File](https://docs.oracle.com/javase/7/docs/api/java/io/File.html) class.

Some of them you may find useful are:

```java

// the constructor
File myFolder = new File("path/to/folder");

// returns an array of File objects, corresponding to the files contained within the folder "myFolder"
myFolder.listFiles();

```
#### step 1

Create a new `File` instance called "animalFolder" and pass the directory "../animals" to it's constructor.

*Note that the file TwentyQuestions.java resides in the "src" directory. To access the "animals" directory you must travel up one directory from "src". This is done the same way as cd'ing in the terminal, with the "../" notation.*

Create a new array of `File`'s, and call it "animalTxtFiles". Set it equal to `animalFolder.listFiles();`.

#### step 2

Declare a new array of `Animal`'s called "animalList".

Find the number of .txt files in the "animals" directory, and initialize "animalList" to a new Animal array of that same length.

*Note that this is almost the same process as declaring and initializing the `Rational2` array in the final step of lab 9.*

At this point, you have an array capable of holding `Animal` instances, but it doesn't hold anything yet...

#### step 3

Create a loop, to loop through every array position.

Within the loop, set each position (i.e. "animalList[i]") to a new `Animal` instance.

*Note that this is almost the same as the loop from the final step of lab 9.*

When you call the constructor after the "new" keyword, pass in a corresponding .txt file from the "animalTxtFiles" array. e.g.

```java
animalList[i] = new Animal(animalTxtFiles[i]);
```

*Note that every position in the animalList array should now contain an `Animal` instance, each corresponding to a different .txt file from the "animals" directory.*

#### step 4

Print out a welcome message for the player, and perhaps explain the rules a bit.

See the provided "demo" directory for an example of such a message.

#### step 5

Generate a random index to pick a random `Animal` instance from the "animalList" array. You may do this however you like, here are two options.

##### option 1)

Paste the "randomInt" method from previous projects/labs into your TwentyQuestions.java file.

*Note that you must paste it within the class curly brackets, but not within the main() curly brackets. Because it is a method, it may not be defined inside another method.*

You can then generate a random index by calling

```java
int randomIndex = randomInt(0, animalList.length - 1);
```
##### option 2)

Use an instance of java's built in `Random` class.

In this case, you must tell the compiler that you will be using the `Random` class. You do this by adding an import statement before your class decleration line. e.g.

```java
import java.util.Random;

public class TwentyQuestions {
```

You may then declare a new instance of `Random` and get a random integer from it within your main method. e.g.

```java
Random r = new Random();
int randomIndex = r.nextInt(animalList.length);
```

#### step 6

Create a new `Animal` instance called "answer" and set it equal to `animalList[randomIndex]`. This animal will be the one the player is trying to guess, i.e. the "answer".

#### step 7

Pass the animalList array, and the answer into the "playLoop" method.

### playLoop(Animal[] animalList, Animal answer)

#### step 1

Create a new integer variable called "questionsLeft". Set it equal to 20.

#### step 2

Enter a loop, and keep looping until `(questionsLeft == 0)`.

Each iteration, do the following:

##### a)

Print out a message telling the player how many questions they have left.

##### b)

Print out a list of choices the player can make:

1. ask a relational question
2. ask an existential question
3. make a guess
4. lookup an animal in the database (this is a free move, i.e. should not count against the players 20 question limit)
5. quit

##### c)

Setup a new `Scanner` instance to read from System.in.

Prompt the player for input (and keep reprompting them until they enter 1, 2, 3, 4, or 5).

##### d)

Perform the following actions based on the players input:

1. Create a new instance of `RelationalQuestion`. You will have to pass the "animalList" array and the "answer" into the instance's constructor. You must then call its "AskQuestion()" method.
2. Create a new instance of `ExistentialQuestion`. You will have to pass the "animalList" array and the "answer" into the instance's constructor. You must then call its "AskQuestion()" method.
3. Prompt the user to enter the name of an animal. If `answer.getName().equals(usersGuess)` then print out a win message and return.
4. Prompt the user to enter the name of an animal. Search your animalList array for an animal with the same name, and if you find one, then print it out. Else, tell the player that the animal does not exist in the database.
5. Print a goodbye message and return.

*Note that you have not yet implemented the "AskQuestion()" method for 1 or 2. Don't worry about that for now.*

"AskQuestion()" will return a boolean (true if that question should count against the users alloted 20, or false if it shouldn't).

If the user picked 1 or 2 and "AskQuestion()" returned true then decrement questionsLeft by 1.

Else if the user picked 3, then decrement questionsLeft by 1.

Else, do not decrement questionsLeft (option 4, looking up an animal in the database is a "free move").

#### step 3

If the loop finishes, then the player was not able to guess the animal within 20 questions (else the method would have returned when they did so).

Offer the player one final chance to enter an animals name, and compare it to the answer (similar to option 3 in the loop).

If they guessed, then print out a win message. Else, print out a message telling them what the answer was.

Finally, return.

## 2) Animal.java

We are providing this class to you completed.

You should study it, and understand how it works, but you do not need to modify it.

## 3) Question.java

For this file, all you have to do is finish the "getIndexByName()" method. The rest has been completed for you.

### step 1

Setup a loop to inspect each position in the "animals" array.

*Note that this will be the "animalList" array passed in from TwentyQuestions.java.*

### step 2

For each `Animal` instance in the array, check if that animals name is the same as the "name" parameter passed into the method.

If it is, then immediately return the index of that animal. If not, then continue on to the next position in the array.

### step 3

If you reach the end of the loop (i.e. you didn't find an animal with the input parameter name), then return -1.

## 4) RelationalQuestion.java

This file will inherit from the `Question` class, and override its constructor and AskQuestion() method.

This class deals with relational qualities of animals (height, weight, speed, length).

### step 1

Something is missing in the class decleration. Fix it, so that the class properly inherits from `Question`.

### step 2

Print out a list of choices that the player can make.

*Note that this step has already been done for you in the starter code.*

### step 3

Declare a new `Scanner` instance to read from System.in.

Prompt the player for input, and do not continue until you are sure it is valid (an integer in the range of 1-9).

### step 4

Perform the following actions based on the players input:

#### 9

Immediately return false. (This question should not count against the player's alloted 20).

#### 5-8

Prompt the player to enter a value for x. Ensure that it is a valid input (i.e. a number).

Use the class attribute "answer" and call its appropriate method (getHeight, getWeight, etc) based on the player's input.

Compare the answer, with x, and print out the result of the comparison.

e.g. if the player entered "7" for a choice, and then "40" for x, you would need to print out a message telling the player whether or not the animal the computer is thinking of is longer than 40 feet.

#### 1-4

Rather than prompting the player to enter a value for x, prompt them to enter the name of an animal.

Use the inherited method "getIndexByName()" to find the index corresponding to the animal whose name the player just entered.

If the player enters the name of an animal not in the database, then you have three choices.

1. Print a message telling the player that there is no such animal in the database, and immediately return false (the player hasn't learned anything, so it should not count against their alloted 20 questions).
2. Print out a message telling the player that there is no such animal in the database, and offer them a chance to try again with a different name.
3. Offer them a choice between 1 and 2.

How you choose to implement this is up to you, but keep in mind that if the player did not learn anything from the question, then you must return false. If the player did learn something, then you must return true.

Once the animal whose name the player entered is found, call its appropriate methods, along with the "answer" variables appropriate methods and print out the comparison.

e.g. if the player entered "2" for the choice and "giraffe" for the name, then you would need to print out a message telling the player whether or not the animal the computer is thinking of is taller than a giraffe.

In all cases (1-8) you will need to use the provided getter methods of the `Animal` class, so please familiarize yourself with them if you haven't already.

If the player succesfully learned something, then return true (since the question should count against their alloted 20).

## 5) ExistentialQuestion.java

This file will inherit from the `Question` class, and override its constructor and AskQuestion() method.

This class deals with existential qualities of animals (has, can, is, eats).

It is almost identical to the `RelationalQuestion` class, except it deals with existential qualities of animals.

Follow the steps for implementing RelationalQuestion.java, making adjustments where needed.

e.g. rather than calling the getters for "height, width, length, or speed" for your comparison, you will be calling the methods "hasX, canX, isX, and eatsX" from the `Animal` class.

## 6) Ansi.java

This file is provided as is. You do not need to modify it or use it, but we strongly suggest that you do. Nice formatting makes text-based programs much easier to use.

Ansi escape sequences are strings which, when printed to the terminal, will control the formatting of all text printed after them. e.g.

```java
System.out.println(Ansi.RED + "Warning!" + Ansi.RESET);
```

will print out "Warning!" in a red font. Note that because the sequences affect all text printed out after them, you must explicitly print out Ansi.RESET to reset the styles back to normal.

Also note that these member variables are static. That means you do not have to create instances of Ansi to access them. e.g.

```java
// not necessary!!!
Ansi a = new Ansi();
System.out.println(a.ITALIC + "italic message" + a.RESET);

// this will work fine
System.out.println(Ansi.ITALIC + "italic message" + Ansi.RESET);
```

Also, note that these escape sequences only work on Unix machines (Linux, MacOS) so they may/may not have any affect on windows command lines.

Finally, you may define your own styles as combinations of sequences. We have provided 2 additions below (printing out YES and NO in green and red fonts). You may find these useful in the `Existential`/`RelationalQuestion` classes.
