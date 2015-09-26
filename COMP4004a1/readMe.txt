Name: Hsiao-Kang Jao
Student Number 100737894

Github link: https://github.com/h173928/COMP4004a1.git

- for each feature/requirement you have developed, the names of the corresponding test methods

Tests:

Card class for card object, tested using testCard()

Hand class that represent each player's hand that stores all info about a user:
	testHand() tests the function of splitting input string into id and cards and also test high card cases
	
	testHandToString() tests the toString() function of Hand which outputs the name hand and rank.

	testPair() tests the pair() funciton that determines if a hand is a pair hand

	testThreeOfAKind() tests the threeOfAKind() function that determines if a hand is a three of a kind

	testFourOfAKind() tests the fourOfAKind() function that determines if a hand is a four of a kind

	testFullHouse() tests the fullHouse() function that determines if a hand is a full house

	testTwoPair() tests the twoPairs() function that determines if a hand is a two pair

	testFlush() tests the flush() function that determines if a hand is a flush

	testStraign() tests the straight() function that determines if a hand is a straight

	testStraightFlush() tests the straightFlush() function that determines if a hand is a straight flush 
				or even royal flush


Game class is a the actual game, stores players and ranks them:
	
	testGame tests the addPlayer() function that adds players, sort() funciton that sorts player from largest
			hand to smallest, result() function that prints out the round's ranking
	
	testSameHands() tests the sort function for when two hands are similar ie. 2 two pair hands that both has
			a pair a 5 and 6 and need to compare the last card.

Input class prompts for input and validates them: tested by testValidation()
	

instructions:
	run SimplisticPoker.java's main

	to run Test_Suite1.java for the testGame and testSameHands, need to comment out code inside Game:game()
	and uncomment testGame and testSameHands.

