# CSCI 1103 Project 4
## 20 Questions: Animal Edition
**Due**: ####

## 1. Changelog

**####**: initial release.

**####**: clarified submission guidelines.

**####**: clarified requirements.

**####**: pulled "Getting Started" section into its own pdf. Also providing students with the completed Animal.java file.

**####**: Due date extended to December 3rd, 2018

## 2. Introduction

For this project, you will be implementing the popular guessing game "20 Questions."

The game is typically played between a group of people, where one person will think of any "thing" (person, place, etc...) in their head. The rest of the group will ask up to 20 yes/no questions to try and guess the thing. If the group is able to guess within 20 questions, they win! If not, they lose.

For this assignment, you will be implementing a digital version of this game, with one twist. We are limiting the class of guessable "things" to just animals. Generally speaking, we are asking you to:

1. Parse a database of animals (provided by us) into an array of `Animal` instances (a class you will write).
2. Pick a random animal from the array
3. Allow a player to ask up to 20 yes/no `Question`'s (a class you will write) to try to guess that animal.

**A word of caution:** this will be the longest, and most involved project of the whole course. You will have around a month to finish it. We recommend you start as early as you can. **Do not** wait until the week before it is due to start!

As always, this work is to be an individual effort. You are *not permitted* to work in groups. All work done must be your own. You may not consult or discuss, beyond general terms, with anyone other than the course instructor and TAs. Obtaining or sharing solutions to any project is considered academic misconduct and will be treated as such. We have been, and will continue to run your solutions through [MOSS](http://moss.stanford.edu/) to check for blatant code copy-pasting.

## 3. Learning Objectives

This project makes use of the following java concepts you have learned, or will learn before the due date:

- **File I/O**: for handling files and folders.
- **Scanner**: for reading input from the terminal.
- **Inheritance**: for deriving more specific types of questions from a base `Question` class.

## 4. Provided Starter Code

Because this project requires more intercommunication between classes than you have seen previously, we are providing you with starter code in the Project4.zip folder. **PLEASE** use it! Inside, you will find the following files / folders.

#### a) animals

We are providing you with a database of animals to use in your program.

Each animal is represented in its own .txt file in a consistant way.

We have chosen to represent every animal by eight categories:

1. things they "have"
2. things they "can do"
3. things they "are"
4. things they "eat"
5. their weight (average, in lbs)
6. their height (average, in ft)
7. their length (average, in ft)
8. their speed (average, in mph)

**Note:** initially we are only providing five or so .txt files. This should be all you need to test the functionality of your program. We intend to provide you with a much larger database before the due date, to make the actual execution of your program more interesting. Such additions would not change the way an animal is represented, i.e. if your program can handle the initial database, then it should handle the later additions just fine.

#### b) build

This folder should be empty initially. Your compiled .class files will go here eventually.

#### c) demo

We are providing you with completed .class files (compiled from our "solution" source code), so you can see how a solution might look and work interactively.

To try our solution, type into your terminal:

```
>> cd demo
>> java TwentyQuestions
```

**Note:** the solution we provided was compiled on the Keller Hall lab machines and thus may not work on your personal machines. If you find this to be the case, please use Vole to try out the solution on a lab machine, or visit the lab in person.

#### d) src

This folder contains all the starter code you will need to work on.

#### e) readme.md

This readme file you are currently reading, in its original markdown format.

#### f) run.sh

This file automates the compiling and running of your program. You can invoke it by typing into your terminal:

```
>> ./run.sh
```

If you recieve a permissions error, you may need to update the files permission by typing into your terminal:

```
>> chmod ug+x run.sh
>> ./run.sh
```

**Note:** this script was tested on the lab machines in Keller Hall. We cannot guarantee its functionality on your own personal machines. However, unix-based machines (Linux, Mac OS) *shouldn't* have any problems running it.

If you found the script did not work, then you can compile your program by hand in the usual way as you have done previously. Internally, all the script is doing is cd'ing into your src directory, javac'ing your TwentyQuestions.java file, moving the resulting .class files into the build folder, and running your program from there.

## 5. Source Code Structure

We are providing you with the following files, some of which require modification by you:

- Animal.java
- Ansi.java
- ExistentialQuestion.java
- Question.java
- RelationalQuestion.java
- TwentyQuestions.java

Each provided .java file is extensively commented, providing directions on what has already been completed for you, and what you yourself must complete. A general program outline is provided below.

#### a) TwentyQuestions.java

This will contain your main method, and will be the driving force behind your whole project.

You will open the animal folder, and pass each .txt file into a new `Animal` class instance.

You will then pick a random animal, and enter a play loop method to allow a player to ask questions (represented by instances of `ExistentialQuestion` and `RelationalQuestion`) to try and guess that animal.

#### b) Animal.java

This class represents an animal, and contains attributes corresponding to those found in the .txt files.

Its constructor takes in a .txt file and parses it to fill the class attributes.

#### c) Question.java

This class represents a question. You *will not* be using instances of this class directly in your TwentyQuestions.java file. Rather, you will be creating other (more specific) question classes which inherit from this class and override some of its methods.

#### d) ExistentialQuestion.java

This class inherits from `Question` and overrides its `AskQuestion()` method to provide the player with some existential information about the animal they are trying to guess.

#### d) RelationalQuestion.java

This class inherits from `Question` and overrides its `AskQuestion()` method to provide the player with some relational information about the animal they are trying to guess.

#### e) Ansi.java

This class contains Ansi escape sequences which you can use to control the formatting of text printed to the terminal.

Because Ansi escape sequences are only supported on unix-based systems (Linux, MacOS), we are not requiring you to use them.

However, we do encourage it. Nice formatting greatly improves the usability of text-based programs. Our provided solution made heavy use of certain escape sequences.

## 6. Suggestions / Getting Started

This section has been pulled into its own document titled "Project4Hints.pdf".

Please see the Project 4 assignment page on canvas.

## 7. Requirements

#### a) Error Handling

All player input must be checked, and corrected where necessary.

A common input-correcting paradigm is:

```
print "enter valid input"
input = get input from user
while (input is invalid)
{
	print "input invalid - try again"
	input = get input from user
}
do something with input
```

By the time you get to "do something with input" you can be assured that the input is valid (i.e. of the right type, within the right range, or whatever you define "valid" to be), because the only way the program reaches that point is after the user is forced to enter valid input.

**Note**: since you will be using Scanner to read input, you must handle input type-checking as well.

e.g. you might ask the player to input an integer, but you  cannot assume that they have.

e.g. they may have entered "xxx". Calling `Integer.valueOf("xxx")` will result in a program crash as the valueOf method is unable to extract a meaningful integer value from "xxx").

#### b) File IO via the File class.

You must use java's File class to handle folders and files as needed.

#### c) Input via Scanner

You must use Scanner to read input from the terminal.

You **may not** use TextIO.

#### d) Inheritance

The classes `RelationalQuestion` and `ExistentialQuestion` must both inherit from `Question`, overriding only the necessary method(s).

## 8. Submitting Your Project

Please upload your work as a .zip file entitled "Project4.zip" to the assignment 4 page on canvas.

Your **Project4.zip** file should include the following files and folders:

+ animals
    - all the .txt files we provided
+ src
    - your finished .java files
+ run.sh

You do not need to include your build or demo folders as we will recompile your code when we grade it anyways, using the provided script.

As always, please be sure to comment your x500 and name at the beginning of all your .java files.

## 9. Final Thoughts

If you have any questions or concerns, or find yourself stuck, please contact us! We are here to help you.
