import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TextGame {

	private static Scanner input;

	public static void main(String[] args) {
		

		input  = new Scanner (System.in);
		
		int xMinKey = 2; //Randomly generating x coordinate for the key
		int	xMaxKey = 4;	
		int xKey = xMinKey + (int)(Math.random() * ((xMaxKey - xMinKey) + 1));
		
		int yMinKey = 1; //Randomly generating the y coordinate for the key
		int	yMaxKey = 3;	
		int yKey = yMinKey + (int)(Math.random() * ((yMaxKey - yMinKey) + 1));
		
		int xMinFoodA = 2; //Randomly generating x coordinate for food A
		int	xMaxFoodA = 4;	
		int xFoodA = xMinFoodA + (int)(Math.random() * ((xMaxFoodA - xMinFoodA) + 1));
		
		int yMinFoodA = 1; //Randomly generating the y coordinate for food A
		int	yMaxFoodA = 3;	
		int yFoodA = yMinFoodA + (int)(Math.random() * ((yMaxFoodA - yMinFoodA) + 1));
		
		int xMinDoor1 = 2; //Randomly generating x coordinate for door 1
		int	xMaxDoor1 = 4;	
		int xDoor1 = xMinDoor1 + (int)(Math.random() * ((xMaxDoor1 - xMinDoor1) + 1));
		
		int yDoor1 = 4; //fixed row for door 1

		int TotalMoves = 0;
		int xPosition = 3; // entering maze at position 3,1
		int yPosition = 0;
		int Food = 0;
		int FoodAddA = 0; //from finding food on floor in first area
		int FoodAddB = 0; //from getting food in the container upon escaping area 1
		int FoodAddC = 0; //from getting food from the skeletons game in area 1
		int Area = 1; //start in area 1
		int RunDistance = 5; //how far to run after leaving area 1 (keep fixed at 5)
		int MedallionPieces = 0;
		int MedallionRandomX1 = 0;
		int MedallionRandomX2 = 0;
		int MedallionRandomX3 = 0;
		int MedallionRandomY1 = 0;
		int MedallionRandomY2 = 0;
		int MedallionRandomY3 = 0;
		int FoodBag = 0;
		
		String Name = null;
		String Diff = null;
		String Choice = null;
		
		//True And False Parameters
		boolean DiffChosen = false;
		boolean EnteredMaze = false;
		boolean Win = false;
		boolean Lose = false;
		boolean KeyFound = false;
		boolean FoodAFound = false;
		boolean MistakeMade = false;
		boolean Sword = false;
		boolean Magic = false;
		boolean PitDecision1 = false;
		boolean PitDecision2 = false;
		boolean SpikesPart1 = false;
		boolean SpikesPart2 = false;
		boolean SkeletonGame = false;
		boolean PitEntered = false;
		boolean Ring = false;
		boolean KnightMet = false;
		boolean Area3Entered = false;
		boolean OgreMet = false;
		boolean OgreKilled = false;
		boolean PathCleared = false;
		boolean Grass = false;
		boolean Area3Hound = true;
		boolean Bridge = false;
		boolean SandFood = false;
		boolean RockPath = false;
		boolean ZipWire = false;
		boolean DoorOpened =  false;
		boolean DoorLocked = false;
		boolean OldManGame = false;
		boolean Area4Entered = false;
		boolean FourExplained = false;
		boolean Medallion1Found = false;
		boolean Medallion2Found = false;
		boolean Medallion3Found = false;
		boolean MedallionPosition = false;
		boolean StatueFought = false;
		boolean PillarDone = false;
		boolean RewardTaken = false;
		boolean RestoreFood = false;
		boolean MedallionComplete = false;
		boolean DarkRoom = false;
		boolean TrapRoom = false;
		boolean PulleyDone = false;
		boolean PulleyIntro = false;
		boolean PulleyMedallion = false;
		boolean PulleyBeast = false;
		boolean PulleyMedallionTaken = false;
		boolean BeastSurvived = false;
		
		
		
		// ENTERING THEIR NAME
		System.out.println("Please Enter Your Name...");
		
			Name = input.nextLine();
	
		
		
		// SETTINGS ASSOCIATED WITH DIFFICULTY		
		System.out.println("Choose Difficulty ('Easy' or 'Hard')");
		
		while(DiffChosen == false){
			Diff = input.nextLine();
				if(Diff.equals("Easy")){
					Food = 20;
					FoodAddA = 6;
					FoodAddB = 15;
					FoodAddC = 8;
					DiffChosen = true;
				}
				else if(Diff.equals("Hard")){
					Food = 15;
					FoodAddA = 3;
					FoodAddB = 10;
					FoodAddC = 5;
					DiffChosen = true;
				}
				else {
					System.out.println("Invalid Difficulty Choice");
				}
		}
		
		// BEGINNING MESSAGES
		System.out.println("Welcome, " + Name + ", To The Maze.");
		System.out.println("Each Move Within The Maze Takes One Day To Complete. You Only Have " + Food + " Days Worth Of Food.");
		System.out.println("Food Can Be Found Along The Way, But Beware Of The Costs.");
		System.out.println("");
		System.out.println("Stories Tell Of A Half-Dead Hound That Roams The Maze. He Is Blind But Fast, And Could Appear At Any Moment.");
		System.out.println("");
		System.out.println("Be Warned: There Are Many Ways To Escape This Place, But All Will Involve Sacrifice...");
		System.out.println("");
		System.out.println("Type either N(orth), E(ast), S(outh) or W(est) to pick a direction to travel. Type 'I' For Your Inventory.");
		
		while (Win == false && Lose == false){
			
			System.out.println("");
			if(Area == 1 || Area == 2 || Area ==3){
				Choice = input.nextLine();
			}
			
			//testing parameters (note changing areas during the test will cause it to fail as area is reset each time...)
			//Area = 4; 
			//EnteredMaze = true; 
			//Sword = true; 
			//Magic = true; 
			//Ring = true; 
			//OgreMet = true;
			//MedallionPieces = 3;
			//MedallionComplete = true;
			//PulleyBeast = true;
			//PulleyMedallion =true;
			
			
		if(Food <= 0){
			System.out.println("You Have Run Out Of Food... GAME OVER");
			Lose = true;
		}
		
		else{
			
			if(Choice.equals("N") || Choice.equals("E") || Choice.equals("S") || Choice.equals("W")) { //Need to enter the correct instruction
				
				// WHAT HAPPENS EACH TIME A CORRECT MOVE IS SELECTED
				if(EnteredMaze == true){
					Food--;
					TotalMoves++;
				}
				if (Choice.equals("N")){
					yPosition++;
				}
				if (Choice.equals("E") && EnteredMaze == true){
					xPosition++;
				}
				if (Choice.equals("S") && EnteredMaze == true){
					yPosition--;
				}
				if (Choice.equals("W") && EnteredMaze == true){
					xPosition--;
				}
				
			if(Area == 1){
				
				int xMinHound = 1; //Randomly generating x coordinate for the hound each turn
				int	xMaxHound = 5;	
				int xHound = xMinHound + (int)(Math.random() * ((xMaxHound - xMinHound) + 1));
				
				int yMinHound = 1; //Randomly generating y coordinate for the hound each turn
				int	yMaxHound = 5;	
				int yHound = yMinHound + (int)(Math.random() * ((yMaxHound - yMinHound) + 1));
				
				// BEFORE ENTERING MAZE
				if(Choice.equals("N") && TotalMoves == 0){ 
					System.out.println("You Enter The Maze...");
					System.out.println("");
					EnteredMaze = true;
				
				}
				if ((Choice.equals("E") || Choice.equals("S") || Choice.equals("W")) && EnteredMaze == false) {
					System.out.println("The Entrance To The Maze Is To The North. There Are No Other Routes.");
				}
				
				// HOUND IS CLOSE
				if ((xHound == xPosition + 1 || xHound == xPosition - 1) && (yHound == yPosition + 1 || yHound == yPosition - 1) && TotalMoves > 1){
					System.out.println("");
					System.out.println("You Can Hear Panting... The Hound Is Near...");
				}
				
				if(xHound == xPosition && yHound == yPosition && TotalMoves > 2){
					System.out.println("The Hound Has Found You... GAME OVER");
					Lose = true;
				}
				
				else{
				
					//0 ROW, CAN NEVER BE ALLOWED IN THIS AREA
					if (yPosition == 0 && EnteredMaze == true) { 
						System.out.println("There Is A Wall Blocking Your Path...");
						yPosition++;
					}
					
					// FIRST ROW WITHIN INNER MAZE
					if (xPosition == 1 && yPosition == 1) { 
						System.out.println("There Is A Wall Blocking Your Path...");
						xPosition++;
					}
					if (xPosition == 2 && yPosition == 1) { 
						System.out.println("This Area Seems Empty...");
					}
					if (xPosition == 3 && yPosition == 1) { 
						System.out.println("The Maze Entrance Is Eerily Quiet.");
						System.out.println("In Large Golden Letters On The Floor It Says 'Welcome To Your Destiny " + Name + "'.");
						System.out.println("Was This Whole Thing Created Just For You??");
						System.out.println("");
						System.out.println("You Can Hear A Faint Panting Noise... The Hound Already Knows You're Here.");
					}
					if (xPosition == 4 && yPosition == 1) { 
						System.out.println("There Is Smoke All Around You. In The Distance You Hear A Faint Scraping Sound, Like Metal On Concrete...");
						
						if(KnightMet == true){
							System.out.println("There Is Nothing Else Of Note In This Area.");
						}
						
						boolean Answer1 = false;
						boolean Answer2 = false;
						boolean Answer3 = false;
						
						if(KnightMet == false){
								
							while(Answer1 == false){
								System.out.println("");
								System.out.println("Do You Wish To Continue Exploring This Room, Yes Or No?");
								String Knight1 = input.nextLine();
								if(Knight1.equals("No")){
									System.out.println("Fearing What Could Be Lurking Behind The Smoke You Decide To Leave This Room As Soon As Possible.");
									System.out.println("Could Be A Very Wise Choice!");
									Answer1 = true;
									Answer2 = true;
									Answer3 = true;
								}
								if(Knight1.equals("Yes")){
									System.out.println("Curiosity Gets The Better Of You. You Decide To Venture Further Into The Smoke.");
									System.out.println("");
									System.out.println("You Notice The Scraping Sound Becoming Louder. You Cant Quite Work Out If You Are Getting Closer To It...");
									System.out.println("Or Worse, If It Is Getting Closer To You.");
									Answer1 = true;
								}
								if(Answer1 == false){
									System.out.println("Invalid Choice.");
								}
							}	
								
							while(Answer2 == false){
								System.out.println("");
								System.out.println("Do You Wish To Further Explore This Room, Yes Or No?");
								String Knight2 = input.nextLine();
						
								if(Knight2.equals("No")){
									System.out.println("Fearing Your Life You Try To Make A Quick Exit From The Room...");
									System.out.println("But The Smoke Has Caused You To Lose Your Bearings!!");
									System.out.println("");
									System.out.println("You Can No Longer Tell If You Are Running Into The Smoke Or Out Of It.");
									System.out.println("The Scraping Is Getting Louder And Louder Until The Noise Is Deafening!!");
									System.out.println("");
									System.out.println("Suddenly, Out Of The Mist A Giant Sword Plummets Towards Your Head!!!");
									System.out.println("With A Flash Of Pain You Feel It Strike Your Neck...");
									System.out.println("For A Fraction Of A Second You Watch As You Seem To Fall To The Floor While Your Body Remains Standing...");
									System.out.println("");
									System.out.println("Then All Goes Black... GAME OVER");
									Answer2 = true;
									Answer3 = true;
									Lose = true;
								}
								if(Knight2.equals("Yes")) { 
									System.out.println("You Continue into The Grey Smoke, Prepared To Take On Anything You Might Find.");
									System.out.println("");
									System.out.println("The Scraping Is Becoming Louder And Louder Until The Noise is Nearly Deafening...");
									System.out.println("Suddenly When The Sound Seems Loudest It Stops, As If It's Now Right Next To You...");
									System.out.println("...");
									System.out.println("A Giant Sword, 10ft Long, Comes Swinging At You Out Of The Mist!!");
									System.out.println("You See It Just In Time To Duck Out Of The Way, And The Sword Crahses Into The Stone Floor!");
									System.out.println("The Mist Clears Slightly As If The Swing Had Pushed It Aside, And You See An Almighty Knight Standing In Front Of You...");
									Answer2 = true;
								}
								if(Answer2 == false){
									System.out.println("Invalid Choice.");
								}
							}
								
							while(Answer3 == false){
								System.out.println("");
								System.out.println("Do You Try And Fight, Yes Or No?");
								String Knight3 = input.nextLine();
								
								if(Knight3.equals("No")){
									System.out.println("You Quickly Glance Around, Trying To Work Out The Quickest Escape Route...");
									System.out.println("But In Your Hesitation The Knight Has Already Taken Another Devastating Swing At You!!");
									System.out.println("");
									System.out.println("This Time You Cannot React Fast Enough And The Blade Strikes Clean Through Your Neck.");
									System.out.println("For A Fraction Of A Second You Watch As You Seem To Fall To The Floor While Your Body Remains Standing...");
									System.out.println("");
									System.out.println("Then All Goes Black... GAME OVER");
									Answer3 = true;
									Lose = true;
								}
								if(Knight3.equals("Yes")){
									System.out.println("You Steady Yourself For The Battle Of Your Lifetime, Staring Directly Into The Knights Pitch Black Eyes...");
									System.out.println("");
									System.out.println("But The Knight Does Not Move. It's As If It Has Just Frozen...");
									System.out.println("");
									System.out.println("You Quickly Glance Away From His Eyes To Look For An Exit, But As You Do The Knight Begins To Lift His Almighty Sword Once Again!!");
									System.out.println("Like A Flash Of Light It Dawns On You...");
									System.out.println("The Knight Will Not Move When Being Looked At Dead In The Eye. That's The Reason For All The Smoke!");
									System.out.println("");
									System.out.println("With The Knight Frozen You Slowly Back Away And Leave The Room, Knowing That You Can Return Without Fear Any Time You Choose.");
									System.out.println("");
									System.out.println("While Leaving You Find 5 Extra Days Worth Of Food.");
									Food = Food + 5;
									KnightMet = true;
									Answer3 = true;
								}
								if(Answer3 == false){
									System.out.println("Invalid Choice.");
								}
							}
						}
					}

					if (xPosition == 5 && yPosition == 1) { 
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						xPosition--;
					}
					
					// SECOND ROW WITHIN INNER MAZE
					if (xPosition == 1 && yPosition == 2) { 
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						xPosition++;
					}
					if (xPosition == 2 && yPosition == 2) { 
						
						SpikesPart1 = false; // resetting so that entering the room again will trigger the sequence.
						SpikesPart2 = false;
						
						int MinLetter1 = 1;
						int	MaxLetter1 = 2;	
						int Letter1 = MinLetter1 + (int)(Math.random() * ((MaxLetter1 - MinLetter1) + 1));
						
						int MinLetter2 = 1;
						int	MaxLetter2 = 3;	
						int Letter2 = MinLetter2 + (int)(Math.random() * ((MaxLetter2 - MinLetter2) + 1));
						
						System.out.println("Reaching The Centre Of This Area You Realise Just How Lucky You Had Been...");
						System.out.println("");
						System.out.println("All Around You Are Spikes Firing Out Of The Floor And Walls, Before Quickly Disappearing Again.");
						System.out.println("You Take A Moment To Try And Figure Out Some Sort Of Pattern, But There Seems To Be None.");
						System.out.println("");
						System.out.println("You Sigh And Look Up, Praying To A Higher Power For Guidance.");
						System.out.println("In Doing So You Spot A Small Low Hanging Rock Barely Within Reach Above You Containing The Letters A And B...");
						System.out.println("It Becomes Clear You Were Meant To Make It To The Middle Of This Area, So That You Could Be Tested.");
						System.out.println("");
						System.out.println("You Need To Press The Numbers In Order, But One Mistake Will Likely Cost You Your Life.");
						System.out.println("Press A Or B To Make Your First Choice:");
						
						// First Guess
						while(SpikesPart1 == false){
							
							String Spikes1 = input.nextLine();
						
							if(Spikes1.equals("A") && Letter1 == 1){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Nothing. You Must Have Chosen Correct And Prepeare To Make Your Next Decision...");
								SpikesPart1 = true;
							}
							if(Spikes1.equals("B") && Letter1 == 1){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Like A Flash The Spikes Rocket Out Of The Ground And Walls Towards You!!");
								System.out.println("Reflexes Causes Your Eyes To Shut, And When You Open Them The Spikes Have Stopped Milimiteres From Hitting You...");
								System.out.println("You Are Extremely Lucky And The Only Casualty Has Been Your Food Supplies. You Lose 5 Days Worth Of Food.");
								Food = Food - 5;
								SpikesPart1 = true;
							}
							if(Spikes1.equals("A") && Letter1 == 2){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Like A Flash The Spikes Rocket Out Of The Ground And Walls Towards You!!");
								System.out.println("Reflexes Causes Your Eyes To Shut, And When You Open Them The Spikes Have Stopped Milimiteres From Hitting You...");
								System.out.println("You Are Extremely Lucky And The Only Casualty Has Been Your Food Supplies. You Lose 5 Days Worth Of Food.");
								Food = Food - 5;
								SpikesPart1 = true;
							}
							if(Spikes1.equals("B") && Letter1 == 2){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Nothing. You Must Have Chosen Correct And Prepeare To Make Your Next Decision...");
								SpikesPart1 = true;
							}
							else if(SpikesPart1 == false) {System.out.println("Please Choose Either 'A' Or 'B'.");}
						}
						
						System.out.println("");
						System.out.println("Press A Or B To Make Your Second Choice:");
						
						// Second Guess
						while (SpikesPart2 == false){
							
							String Spikes2 = input.nextLine();
						
							if(Spikes2.equals("A") && (Letter2 == 1 || Letter2 == 3)){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Again Nothing. You Feel You Must Have Succeeded But Was Hoping For Some Clear Sign It Was Safe.");
								System.out.println("You Tentatively Step Out Of The Centre Of The Room, Hoping You Are Free To Leave.");
								System.out.println("");
								System.out.println("All Is Clear. You Leave Praying Never To Return To This Room Again.");
								System.out.println("");
								System.out.println("West Looks Like A Dead End, It Would Be Foolish To Go This Way.");
								SpikesPart2 = true;
							}
							if(Spikes2.equals("B") && Letter2 == 1){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Before You Can React, The Spikes Fly At You Again. This Time You Are Not So Lucky...");
								System.out.println("13 Spikes Pierce Into Your Body, Shredding Organs And Bone. There Is No Surviving This.");
								System.out.println("... GAME OVER");
								Lose = true;
								SpikesPart2 = true;
							}
							if(Spikes2.equals("A") && Letter2 == 2){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Before You Can React, The Spikes Fly At You Again. This Time You Are Not So Lucky...");
								System.out.println("13 Spikes Pierce Into Your Body, Shredding Organs And Bone. There Is No Surviving This.");
								System.out.println("... GAME OVER");
								Lose = true;
								SpikesPart2 = true;
							}
							if(Spikes2.equals("B") && (Letter2 == 2 || Letter2 == 3)){
								System.out.println("There Is A Slight Delay As You Wait For Something To Happen...");
								System.out.println("");
								System.out.println("Again Nothing. You Feel You Must Have Succeeded But Was Hoping For Some Clear Sign It Was Safe.");
								System.out.println("You Tentatively Step Out Of The Centre Of The Room, Hoping You Are Free To Leave.");
								System.out.println("");
								System.out.println("All Is Clear. You Leave Praying Never To Return To This Room Again.");
								System.out.println("");
								System.out.println("West Looks Like A Dead End, It Would Be Foolish To Go This Way.");
								SpikesPart2 = true;
							}
							else if(SpikesPart2 == false) {System.out.println("Please Choose Either 'A' Or 'B'.");}
						}
					}
					
					if (xPosition == 3 && yPosition == 2) { 
						System.out.println("This Area Contains A Giant Pit In The Centre, Leading Down Into The Dark Abyss.");
						System.out.println("");
						if(PitEntered == false){
							System.out.println("Upon Closer Inspection You Can See An Incredibly Old And Rotten Staircase Spiralling Around And Down Into The Pit.");
							System.out.println("");
							System.out.println("Do You Wish To Enter The Pit, Yes or No?");
							
							PitDecision1 = true;
							
						while(PitDecision1 == true){
							
							String Pit = input.nextLine();
							
							if(Pit.equals("Yes")){
								System.out.println("You Cautiously Approach The Staircase. As You Take The First Step The Wood Creaks And Shifts Under Your Weight.");
								System.out.println("Bravely You Continue Down Into Absolute Darkness...");
								System.out.println("After Travelling A Few Hundred Metres, The Handrail You Have Been Using For Guidance Ends Suddenly.");
								System.out.println("Do You Wish To Carry On, Descending Further Into Darkness, Yes Or No?");
								
								PitDecision2 = true;
								
								while(PitDecision2 == true){
									
									String Pit2 = input.nextLine();
								
									if(Pit2.equals("Yes")){
										
										PitEntered = true;
									
										int PitMin = 1; //Randomly generating outcomes of the gamble
										int	PitMax = 4;	
										int PitChoice = PitMin + (int)(Math.random() * ((PitMax - PitMin) + 1));
										
										if(PitChoice == 1){
											System.out.println("After A Few More Steps You Feel Water Under Your Feet. Deciding Swimming Is Not The Best Idea You Turn Around To Head Back Up.");
											System.out.println("");
											System.out.println("Suddenly Something From Beneath The Water Reaches Up And Grips Your Ankle!!");
											System.out.println("You Are Slowly Dragged Into The Water, Flailing Desperately As You Try To Find Something To Grab Onto.");
											System.out.println("You Try To Hold Your Breath For As Long As Possible, But Eventually The Urge To Draw Breath Takes Over...");
											System.out.println("");
											System.out.println("...GAME OVER");
											PitDecision1 = false;
											PitDecision2 = false;
											Lose = true;
										}
										if(PitChoice == 2 || PitChoice == 3){
											System.out.println("After A Few More Steps You Feel Water Under Your Feet. Deciding Swimming Is Not The Best Idea You Turn Around To Head Back Up.");
											System.out.println("");
											System.out.println("Suddenly Something From Beneath The Water Reaches Up And Grips Your Ankle!!");
											System.out.println("You Are Slowly Dragged Into The Water, Flailing Desperately As You Try To Find Something To Grab Onto.");
											System.out.println("");
											System.out.println("Your Hand Strikes Something Solid And You Instantly Grab Onto It, Pulling HArd To Get Away From Whatever Beast Is Clutching Your Ankle...");
											System.out.println("You Got Lucky This Time, You Suffer Only Minor Wounds. But You Must Still Rest For 2 Days To Recover.");
											Food = Food - 2;
											PitDecision1 = false;
											PitDecision2 = false;
										}
										if(PitChoice == 4){
											System.out.println("Instinct Urges You To Jump Forward, A True Leap Of Faith. Knowing This Could Be The End You Take One Last Moment To Gather Your Strength.");
											System.out.println("...");
											System.out.println("With An Almighty Leap You Jump Out, Reaching For Anything To Grab...");
											System.out.println("You Feel A Rope Hit Your Arm And With Lightning Reflexes Grab Onto It And Start Pulling Yourself Up.");
											System.out.println("");
											System.out.println("You Emerge In A Hidden Area Near The Top Of The Pit. Here You Discover A Small Metal Ring That Seems To Shimmer In The Light");
											System.out.println("");
											System.out.println("You Carefully Place The Ring On Your Finger And Head Out Of The Pit");
											System.out.println("Upon Exiting However, You Realise You Must Have Dropped 3 Days Worth Of Food When You Leapt Into The Darkness");
											Food = Food - 3;
											Ring = true;
											PitDecision1 = false;
											PitDecision2 = false;
										}
									}
									if(Pit2.equals("No")){
										System.out.println("You Turn Around And Find The Handrail Again. Carefully You Make Your Way Back Up The Staircase And Out Of The Pit.");
										System.out.println("You Feel It May Be Best To Return At Another Time...");
										PitDecision1 = false;
										PitDecision2 = false;
									}
									else if(PitDecision2 == true){System.out.println("Invalid Selection. Select 'Yes' Or 'No'.");}
								}
							}
							if(Pit.equals("No")){
								System.out.println("You Think Better Of Entering A Dark Pit And Carry On Exploring, Feeling As Though This Pit Is A Good Central Point.");
								PitDecision1 = false;
							}
							else if (PitDecision1 == true) {System.out.println("Invalid Selection. Select 'Yes' Or 'No'.");}
						}
						}
					}
					if (xPosition == 4 && yPosition == 2) { 
						System.out.println("This Area Seems Empty...");
					}
					if (xPosition == 5 && yPosition == 2) { 
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						xPosition--;
					}
					
					//THIRD ROW WITHIN INNER MAZE
					if (xPosition == 1 && yPosition == 3) { 
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						xPosition++;
					}
					if (xPosition == 2 && yPosition == 3) { 
						System.out.println("This Area Seems Empty...");
					}
					if (xPosition == 3 && yPosition == 3) { 
						System.out.println("This Area Seems Empty...");
					}
					if (xPosition == 4 && yPosition == 3) { 
						
						if(SkeletonGame == false){
						
						System.out.println("Looking Around This Room You Start To Feel As Though Someone Is Watching You...");
						System.out.println("");
						System.out.println("In The Far Corner You Can Make Out A Large Round Table With A Skeleton Sat On An Old Rusty Throne Next To It.");
						System.out.println("You Approach The Throne, Hoping That Whatever Killed This Person Had Left Long Ago.");
						System.out.println("");
						System.out.println("Nearing The Table You Suddenly Jump Back...!");
						System.out.println("The Skeleton Is Not Dead!!!!");
						System.out.println("");
						System.out.println("It Stands And Slowly Motions For You To Take His Seat On The Throne, As It Does It Murmours 'Fleeing Is Not An Option'");
						System.out.println("Feeling You Have Little Choice You Take Your Seat On The Throne And Wait Further Instructions...");
						System.out.println("");
						System.out.println("The Skeleton Then Lays 3 Cards In Front Of You Labelled 1, 2 And 3, Before Laying 3 In Front Of Itself...");
						System.out.println("'Your Challenge Is To Match The Card I Pick' It Says.");
						System.out.println("'You Have 3 Attempts. Get None Right And I Take Your Life!!!'");
						System.out.println("'But Get 1 Right And I Will Only Take Your Food, Get 2 Right And I Will Give You Food...'");
						System.out.println("'Get All 3 Right, And I will Show You A Secret Passageway That Will Dramatically Reduce Your Time In This Maze!'");

						int Guesses = 1;
						int Correct = 0;
						
						while(Guesses <= 3){
							
							System.out.println("Make your Choice Now, Choose 1, 2 Or 3:");
							
							int SkelMin = 1; 
							int	SkelMax = 3;	
							int Skel = SkelMin + (int)(Math.random() * ((SkelMax - SkelMin) + 1));
							int SkelAdd1 = Skel + 1;
							String SkelChoice = String.valueOf(Skel);
							String SkelChoiceAdd = String.valueOf(SkelAdd1);
							
							String CardGuess = input.nextLine();
							
							if(CardGuess.equals("1") || CardGuess.equals("2") || CardGuess.equals("3")){
								
								Guesses++;
								
								if(CardGuess.equals(SkelChoice) || CardGuess.equals(SkelChoiceAdd)){ //This Game Was Too Hard!! Needed To Add The Extra Condition.
									System.out.println("CORRECT!! The Skeleton Lets Out A Scream Of Anger.");
									Correct++;
								}
								if(!CardGuess.equals(SkelChoice) && !CardGuess.equals(SkelChoiceAdd)){ //the exclamation point here means it does not equal!
									System.out.println("WRONG. The Skeleton Says Nothing.");
									System.out.println("");
								}
							}
							else {System.out.println("That Is Not A Choice.");}
						}
						
						System.out.println("It Then States That The Game Is Over...");
						System.out.println("You Answered " + Correct + " Correct.");
						System.out.println("");
						SkeletonGame = true;
						
						if(Correct == 0){
							System.out.println("'You Have Failed To Get Any Correct' The Skeleton Announces, Sounding Pleased.");
							System.out.println("It Pulls A Lever Next To The Table. The Table Moves, Revealing A Pool Of Boiling Lava...");
							System.out.println("At The Same Time, The Throne Is Swiftly Tilted Forward, Plunging You Headfirst Into The Pool...");
							System.out.println("You Scream In Pain, But There Is Nobody Here To Help You.");
							System.out.println("");
							System.out.println("...GAME OVER");
							Lose = true;
						}
						if(Correct == 1){
							System.out.println("Getting One Guess Correct Means That You Keep Your Life, But The Skeleton Steals Half Of Your Food.");
							Food = Math.round(Food/2);
						}
						if(Correct == 2){
							System.out.println("The Skeleton Looks Thoroughly Disappointed With The Outcome...");
							System.out.println("It Reluctantly Hands You A Small Bag Full Of Food.");
							System.out.println("It Contains " + FoodAddC + " Extra Days Worth Of Food.");
							Food = Food + FoodAddC;
						}
						if(Correct == 3){
							System.out.println("'UNBELIEVABLE!!' Shouts The Skeleton, Slamming Its Fists On The Table.");
							System.out.println("It Looks As Though It Is Going To Explode With Anger...");
							System.out.println("But It Instead Walks to The East Of The Room, And Pulls A Lever Opening A Secret Entrance In The Wall.");
							System.out.println("");
							System.out.println("He Guides You Through A Series Of Small Tunnels Before Emerging At A New Open Area.");
							System.out.println("");
							System.out.println("But As You Go To Leave The Skeleton Grabs Your Arm...");
							System.out.println("It Looks You Directly In The Eye Before Summoning A Sword As If By Magic!!");
							System.out.println("You Fear For Your Life, But The Skeleton Announces That This Sword Is Now Yours To Use As You See Fit.");
							System.out.println("He Also Provides A Small Bag Containing 3 More Days Worth Of Food Before Turning And Walking Away.");
							Food = Food + 3;
							Sword = true;
							Area = 3;
							KeyFound = false;
							
						}
						}
						else {System.out.println("All Thats Here Now Is A Table And An Old Rusty Throne. There Is Nothing More To Be Gained From This Place.");}
					}
					if (xPosition == 5 && yPosition == 3) { 
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						xPosition--;
					}
					
					//FOURTH ROW WITHIN INNER MAZE
	
					if (xPosition == xDoor1 && yPosition == yDoor1 && KeyFound == false) { 
						System.out.println("There Is A Small Door To The North Of You. You Try To Push It Open But It Wont Budge. Looks Like A Key Is Needed...");
						yPosition--;
					}
					else if(xPosition == xDoor1 && yPosition == yDoor1 && KeyFound == true) {
						System.out.println("There Is A Small Door To The North. You Try To Push It Open But It Wont Budge. Perhaps The Key You Found Can Unlock This?");
						System.out.println("");
						System.out.println("... ... ...");
						System.out.println("");
						System.out.println("Yes!! The Door Swings Open With A Loud Bang. Hopefully Nobody Heard. You Leave The Key In The Door And Move On.");
						System.out.println("");
						System.out.println("As You Slowly Walk Through The Doorway You Can Make Out A Faint Glow In The Distance Ahead.");
						System.out.println("You Feel A Sudden Rush Of Optimism, But This Is Soon Drowned Out By A Familiar Sound...");
						System.out.println("You Can Hear Panting... The Hound Is Behind You... RUN!!!!!!");
						Area = Area + 1;
						KeyFound = false;
					}
					else if(xPosition != xDoor1 && yPosition == yDoor1) {
						System.out.println("This Is A Dead End... You Travel Back The Way You Came.");
						yPosition--;
					}

					// Finding Hidden Objects
					if(xPosition == xFoodA && yPosition == yFoodA && FoodAFound == false && TotalMoves > 2 && Lose == false){
						Food = Food + FoodAddA;
						FoodAFound = true;
						System.out.println("");
						System.out.println("You Have Found Some Rotting Food On The Floor, It Should Provide " + FoodAddA + " Extra Days Worth.");
					}
					
					if(xPosition == xKey && yPosition == yKey && KeyFound == false && TotalMoves > 2 && Lose == false){
						System.out.println("");
						System.out.println("You Have Located A Small Key. Now Just To Find The Door..."); // message for finding key
						KeyFound = true;
					}
				}
			}
			
			if(Area == 2){
				
				boolean Running = true;
				
				while (Running == true){
					
					Choice = input.nextLine();
				
					if((Choice.equals("E") || Choice.equals("W")) && MistakeMade == false) {
						System.out.println("You've Run Into A Wall. You Can't Afford To Make This Mistake Again With The Hound So Close Behind!!");
						MistakeMade = true;
						Food++;
					}
					else if(Choice.equals("S")){
						System.out.println("You Turn To Face The Hound, Apparently Looking To Challenge Him To A Fight...");
						System.out.println("");
						System.out.println("The Hound Is Far Too Quick And Is Driving His Teeth Into You Before You Can Move...");
						System.out.println("...GAME OVER");
						Lose = true;
					}
					else if((Choice.equals("E") || Choice.equals("W")) && MistakeMade == true) {
						System.out.println("You've Hit A Wall Again!!");
						System.out.println("As You Turn To Recover You See The Hounds Blood Stained Teeth, Poised An Inch From Your Face...");
						System.out.println("There Is No Point Running Now, You Know Your Time Is Up.");
						System.out.println("");
						System.out.println("...GAME OVER");
						Lose = true;
					}
					if(Choice.equals("N") && RunDistance == 5){
						System.out.println("You Run Forward As Fast As Your Legs Will Carry You");
						Food++;
						RunDistance--;
					}
					if(Choice.equals("N") && RunDistance < 5 && RunDistance > 0){
						System.out.println("You Continue To Run Forward...");
						RunDistance--;
					}
					if(Choice.equals("N") && RunDistance == 0){
						Running = false;
					}
				}	
					if(Choice.equals("N") && RunDistance == 0){
						System.out.println("You Have Finally Stopped Hearing The Hounds Steps Behind You. You Are Safe!");
						System.out.println("You Ran So Fast You Have Only Consumed 1 Days Worth Of Food.");
						System.out.println("");
						System.out.println("As You Get Your Breath Back, You Look Up To Notice A Single Concrete Table In Front Of You.");
						System.out.println("Approaching The Table You Find A Letter Perched In Front Of 3 Containers. It Reads...");
						System.out.println("'I Have Been Watching Your Progress Closely " + Name + ".");
						System.out.println("You Have Done Well To Get This Far. But Now I Present You With A Choice...");
						System.out.println("In Container 1 I Have Placed A Weapon, In Container 2 Some Food.");
						System.out.println("The Final Container, However, May Contain Great Power Or Great Misery.");
						System.out.println("Choose Wisely, " + Name + ", As It May Be The Last Choice You Ever Get To Make...'");
						System.out.println("");
						System.out.println("Enter Either 1, 2 Or 3 To Make Your Choice:");
						yPosition++;	
						
					boolean ContainerChoice = false;
					
					while(ContainerChoice == false){
					
						String Decision = input.nextLine();
						
						if(Decision.equals("1")){
							System.out.println("You Have Chosen The Weapon. Opening The Container Reveals A Glorious Sword!");
							System.out.println("This Will Undoubtedly Come In Useful As The Maze Becomes More Treacherous.");
							Sword = true;
							ContainerChoice = true;
						}
						else if(Decision.equals("2")){
							System.out.println("You Have Chosen Food. Opening The Container Reveals " + FoodAddB + " Extra Days Worth Of Food!");
							System.out.println("This Should Go A Long Way In Aiding Your Escape");
							Food = Food + FoodAddB;
							ContainerChoice = true;
						}
						else if(Decision.equals("3")){
							System.out.println("You Have Chosen To Gamble...");
							int GambleMin = 1; //Randomly generating outcomes of the gamble
							int	GambleMax = 3;	
							int Gamble = GambleMin + (int)(Math.random() * ((GambleMax - GambleMin) + 1));
							
							ContainerChoice = true;
							
							if(Gamble == 1){
								System.out.println("Opening The Container Reveals A Glorious Sword AND " + FoodAddB + " Extra Days Worth Of Food!!!");
								System.out.println("With The Sword You Feel Slightly Safer, And The Food Will Go A Long Way In Helping Aid Your Escape");
								Sword = true;
								Food = Food + FoodAddB;
							}
							if(Gamble == 2){
								System.out.println("Opening The Container Reveals Another Note Resting On Top Of An Old And Dusty Book. The Note Simply Reads...");
								System.out.println("'Knowledge Is Power, " + Name + ". Use It Well'.");
								System.out.println("");
								System.out.println("You Browse Through The Book, And Once Finished You Gently Lay It Down In Stunned Silence.");
								System.out.println("");
								System.out.println("It Has Reveiled To You The Ancient Words Of Dark Magic.");
								System.out.println("");
								System.out.println("You Crouch Down For A Moment Before Rising Up And Commanding 'FULGURA TEMPESTAS!!'");
								System.out.println("Instantly A Bright Flash Blazes From Your Hands, And With A Crash Of Thunder Destroys The Concrete Table In Front Of You.");
								System.out.println("");
								System.out.println("This New Power Makes You Feel Invincible And You Prepare Yourself To Escape This Maze And Take On The World Beyond.");
								Magic = true;
							}
							if(Gamble == 3){
								System.out.println("Opening The Container Reveals... Nothing.");
								System.out.println("Your Greed Has Wasted The Opportunity To Better Your Chances Of Escape.");
							}
						}
						else if(ContainerChoice == false){System.out.println("Enter Either 1, 2 Or 3 To Make You Choice.");}
					}	
				}
				
				Area = 3;
				
			}
			
			if(Area == 3){
				
				if(Area3Entered == false){
				
					xPosition = 3;
					yPosition = 5;
					
					System.out.println("");
					System.out.println("Press Enter To Continue Into The Next Area...");
					Choice = input.nextLine();
				
					System.out.println("");
					System.out.println("You Emerge Into A Huge Bright Hall, The Ceiling Is Made Of Glass And Light Is Shining Through.");
					System.out.println("It Takes Your Eyes Time To Adapt To This New Environment, But As They Do You Suddenly Become Very Aware That This Is No Ordinary Room...");
					System.out.println("");
					System.out.println("In Front Of You In This Giant Room Is An Incredible Rain Forest, Filled With Trees Rising Up Like SkyScrapers");
					System.out.println("And Full Of Vibrant Shrubs And Vines Presenting All Sorts Of Lively Colours.");
					System.out.println("... It Could Not Be More Different From Where You Previously Were.");
					System.out.println("The Only Strange Part Is The Eerie Silence, No Bird Songs Or Animals Rustling Through The Plants.");
					System.out.println("");
					System.out.println("You Take This Opportuntiy To Catch Your Breath And Decide Where To Go Next...");
					
					if(Magic == true){
						System.out.println("Before You Can Move You Hear Panting Behind You. With Magic Flowing Through Your Veins You Feel No Fear...");
						System.out.println("Turning Quickly You Start Saying The Words, But Before You Can Finish The Hound Runs Away Scared...");
						System.out.println("It's Clear It Won't Be Bothering You Again.");
						System.out.println("");
						Area3Hound = false;
					}
					
					Area3Entered = true;
				
				}
				
					if(Area3Hound == true){				
						int xMinHound = 1; //Randomly generating x coordinate for the hound each turn
						int	xMaxHound = 6;	
						int xHound = xMinHound + (int)(Math.random() * ((xMaxHound - xMinHound) + 1));
					
						int yMinHound = 5; //Randomly generating y coordinate for the hound each turn
						int	yMaxHound = 8;	
						int yHound = yMinHound + (int)(Math.random() * ((yMaxHound - yMinHound) + 1));
					
					
						if ((xHound == xPosition + 1 || xHound == xPosition - 1) && (yHound == yPosition + 1 || yHound == yPosition - 1)){
							System.out.println("");
							System.out.println("You Can Hear Panting... The Hound Is Near...");
						}
						
						if(xHound == xPosition && yHound == yPosition){
							System.out.println("The Hound Has Found You... GAME OVER");
							Lose = true;
							xPosition = -1;
							yPosition = -1;
						}
					}
					
					//Out Of Bounds Areas
					if(yPosition == 4){
						System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
						yPosition++;
					}
					if(yPosition == 9){
						System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
						yPosition--;
					}
					if(xPosition == 0){
						System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
						xPosition++;
					}
					if(xPosition == 7){
						System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
						xPosition--;
					}
					
					//First Row
					if(xPosition == 1 && yPosition == 5){
						System.out.println("In Front Of You Is A Gigantic Tree, Far Taller Than Any Other You Have Seen In This Place.");
						System.out.println("It Seems As If There Is No Possible Way Past This, And That The Only Option Is To Turn Back.");
						System.out.println("");
						
						if(OgreMet == true && OgreKilled == false){
						System.out.println("As You Turn To Head Back You Hear The Very Unexpected Noise Of A Bird Chirping.");
						System.out.println("It Takes A Few Moments But You Realise This Is What The Ogre Meant! The Sound Must Be Coming From Outside Of This Hellish Maze!!!");
						System.out.println("");
						System.out.println("You Frantically Search Around The Area, Looking For Something That Could Possibly Help You Escape This Place...");
						System.out.println("There It Is!! On The Side Of The Tree, Hidden Behind Some Twisting Vines, Is A Small Lever. You Waste No Time In Pulling The Lever Down Hard...");
						System.out.println("You Take A Step Back And Wait For Something To Happen...");
						System.out.println("");
						System.out.println("With A Loud Creak The Trunk Parts Like A Door!! It Reveals A Carved Wooden Ladder Inside Leading Up Through The Centre Of The Tree!!");
						Area = 4;
						}
						if(OgreMet == true && OgreKilled == true){
							
							System.out.println("Do You Wish To Further Investigate The Tree, Yes Or No?");
							
							boolean TreeChoiceMade = false;
							
							while(TreeChoiceMade == false){
								
								String TreeChoice = input.nextLine();
								
								if(TreeChoice.equals("Yes")){
									
									int MinTree = 1; 
									int	Maxtree = 2;	
									int Tree = MinTree + (int)(Math.random() * ((Maxtree - MinTree) + 1));
									
									if(Tree == 1){
										System.out.println("At The Base Of The Tree You Spot A Small Engraving...");
										System.out.println("It Looks Like A Picture Of An Ogre Holding Some Object And Placing It Into The Tree.");
										System.out.println("");
										System.out.println("Recalling Your Battle With The Ogre Earlier You Remember The Odd Item You Took From It's Corpse...");
										System.out.println("Cautiously You Remove The Item From Your Bag And Look For Somewhere To Put It Into The Tree.");
										System.out.println("However, The Item Seemed To Come Alive As Soon As It Was Lifted Out Of The Bag!!");
										System.out.println("It Flies Towards The Tree And Disappears Inside Of A Well Hidden Hole Behind Some Vines...");
										System.out.println("");
										System.out.println("Suddenly, The Trunk Of The Tree Parts Like A Door Opening, Revealing A Carved Wooden Ladder Inside!!");
										System.out.println("The Ladder Leads Up Through The Centre Of The Tree And Towards The Glass Ceiling.");
										TreeChoiceMade = true;
										Area = 4;
									}
									if(Tree == 2){
										System.out.println("As You Search Around The Tree You Find Nothing.");
										System.out.println("In Your Frustration You Kick The Tree Trunk And Loudly Curse.");
										System.out.println("");
										System.out.println("A Loud Crack Sounds From Above You....!!");
										System.out.println("Looking Up You See A Huge Branch Falling Right At You... There Is No Time To React.");
										System.out.println("The Branch Crushes Down Onto You, Before Silence Falls Over The Maze...");
										System.out.println("");
										System.out.println("... GAME OVER");
										TreeChoiceMade = true;
										Lose = true;
									}
									
								}
								else if(TreeChoice.equals("No")){
									System.out.println("You Choose Not To Waste Your Time And Get Back To Looking For A Way Out Of This Horrendous Maze.");
									TreeChoiceMade = true;
								}
								else {System.out.println("Please Enter Either Yes Or No");}
							}
						}
						
					}
					if(xPosition == 2 && yPosition == 5){
						if(Choice.equals("W")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition++;
						}
						if(Choice.equals("E")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition--;
						}
						if(Choice.equals("S")){
							System.out.println("You Cannot Clear A Path That Way...");
							yPosition++;
						}
					}
					if(xPosition == 3 && yPosition == 5){
						System.out.println("Everywhere You Look Are Trees And Overgrown Plants. It Is Impossible To Tell Which Is The Best Way To Go.");
					}
					if(xPosition == 4 && yPosition == 5){
						if(ZipWire == false){
							System.out.println("There Doesn't Seem To Be Anything Interesting In This Area Other Than A Long Thick Wire Above Your Head.");
							System.out.println("It Clearly Stops In A Tree Beside You, But You Can't See The Other End As It Disappears Up Into The Trees.");
						}
						if(ZipWire == true){
							System.out.println("There Doesn't Seem To Be Anything Interesting In This Area Other Than A Long Thick Wire Above Your Head.");
							System.out.println("It Is Where The Zip Wire Ended.");
						}
					}
					if(xPosition == 5 && yPosition == 5){
						System.out.println("There is Nothing Interesting In This Area...");
					}
					if(xPosition == 6 && yPosition == 5){
						
						if(DoorOpened == true){
							System.out.println("This Is The Area Where You Solved The Door Puzzle.");
							System.out.println("The Big Steel Door Has Remained Open For You To Travel Through Freely.");
						}
						if(DoorLocked == true){
							System.out.println("This Is The Area Where You Failed To Unlock The Door.");
							System.out.println("The Door Remains Locked, You Must Find Another Way Around.");
							if(Choice.equals("E")){
								xPosition--;
							}
							if(Choice.equals("S")){
								yPosition++;
							}
						}
						
						if(DoorOpened == false && DoorLocked == false){
							
							int GameDiff = 0;
							
							if(Diff.equals("Easy")){
								GameDiff = 10;
							}
							if(Diff.equals("Hard")){
								GameDiff = 7;
							}
							
							System.out.println("You Enter This Area To See A Mysterious Door Blocking Your Path.");
							System.out.println("There Is A Gold Sign On The Front That Reads:");
							System.out.println("");
							System.out.println("It's Time To Challenge Your Mind " + Name + ".");
							System.out.println("In A Moment This Message Will Change To Reveal A 4 Number Combination Lock, That Accepts The Numbers 1 To 3.");
							System.out.println("You Must Guess The Combination To This Lock. Each Guess You Will Be Told How Many Numbers Are In The Correct Position.");
							System.out.println("You Must Solve The Lock Within " + GameDiff + " Guesses, Otherwise This Door Will Be Sealed Shut Forever.");
							System.out.println("You Will Be Rewarded With Food Upon Completion Of The Puzzle. The Quicker You Solve It, The More Food You Will Get.");
							System.out.println("When You Are Ready Press Enter To Continue...");
							
							input.nextLine();
							
							int TotalChosen = 0;
							ArrayList<Integer> Numbers = new ArrayList<Integer>();
							
							while(TotalChosen < 4){
								int MinNum = 1; 
								int	MaxNum = 3;	
								int Num = MinNum + (int)(Math.random() * ((MaxNum - MinNum) + 1));
								
								Numbers.add(Num);
								TotalChosen++;
							}
							
							boolean GameSolved = false;
							int GuessNumber = 1;
	
							
							while(GameSolved == false && GuessNumber <= GameDiff){
									
								int Number1 = 0;
								int Number2 = 0;
								int Number3 = 0;
								int Number4 = 0;
								
								System.out.println("");
								System.out.println("This Is Attempt Number " + GuessNumber + ".");
								System.out.println("Please Choose Your First Number:");
								
								boolean OneChosen = false;
								boolean TwoChosen = false;
								boolean ThreeChosen = false;
								boolean FourChosen = false;
								
								while (OneChosen == false){
									if(input.hasNextInt()){
										   Number1 = input.nextInt();
									}else{
										System.out.println("INVALID CHOICE...");
										input.next();
									}
									if(Number1 > 0 && Number1 <= 3){
										OneChosen = true;
									}
									else {
										System.out.println("Please Choose An Integer Between 1 And 3.");
									}
								}
								System.out.println("Please Choose Your Second Number:");
								while (TwoChosen == false){
									if(input.hasNextInt()){
										   Number2 = input.nextInt();
									}else{
										System.out.println("INVALID CHOICE...");
										input.next();
									}
									if(Number2 > 0 && Number2 <= 3){
										TwoChosen = true;
									}
									else {
										System.out.println("Please Choose An Integer Between 1 And 3.");
									}
								}
								System.out.println("Please Choose Your Third Number:");
								while (ThreeChosen == false){
									if(input.hasNextInt()){
										   Number3 = input.nextInt();
									}else{
										System.out.println("INVALID CHOICE...");
										input.next();
									}
									if(Number3 > 0 && Number3 <= 3){
										ThreeChosen = true;
									}
									else {
										System.out.println("Please Choose An Integer Between 1 And 3.");
									}
								}
								System.out.println("Please Choose Your Fourth Number:");
								while (FourChosen == false){
									if(input.hasNextInt()){
										   Number4 = input.nextInt();
									}else{
										System.out.println("INVALID CHOICE...");
										input.next();
									}
									if(Number4 > 0 && Number4 <= 3){
										FourChosen = true;
									}
									else {
										System.out.println("Please Choose An Integer Between 1 And 3.");
									}
								}
								
								
								int PositionCorrect = 0;
								
								if(Number1 == Numbers.get(0)){
									PositionCorrect++;
								}
								if(Number2 == Numbers.get(1)){
									PositionCorrect++;
								}
								if(Number3 == Numbers.get(2)){
									PositionCorrect++;
								}
								if(Number4 == Numbers.get(3)){
									PositionCorrect++;
									}
								
								GuessNumber++;
								
								System.out.println("You Have Chosen: [" + Number1 + "],[" + Number2 + "],[" + Number3 + "],[" + Number4 + "].");
								System.out.println("The Door Indicates That " + PositionCorrect + " Of These Are In The Correct Position.");
								
								if(PositionCorrect == 4){
									System.out.println("CONGRATULATIONS!!");
									System.out.println("You Have Solved The Puzzle. The Door Will Now Open For You And Remain Open!");
									System.out.println("Your Reward Is " + (15-GuessNumber) + " Days Worth Of Food.");
									GameSolved = true;
									DoorOpened = true;
									Food = Food + (15-GuessNumber);
								}
								if(GuessNumber > GameDiff){
									System.out.println("...");
									System.out.println("You Have Used All Of Your Guesses Without Solving The Puzzle. The Door Will Now Remain Locked.");
									System.out.println("You Must Find Another Path Around.");
									DoorLocked = true;
								}
								
							}
						}

					}
					
					//Second Row
					if(xPosition == 1 && yPosition == 6){
						
						if(OldManGame ==  true){
							System.out.println("This Is Where The Old Man Had You Trapped In A Cage.");
							System.out.println("Luckily, It Seems Trapping You Once Is Enough For Him And He Is Nowhere To Be Seen.");
						}
						
						if(OldManGame == false){
							
							int DaysGuessDiff = 0;
							int CageDiff = 0;
							
							if(Diff.equals("Easy")){
								DaysGuessDiff = 5;
								CageDiff = 3;
							}
							if(Diff.equals("Hard")){
								DaysGuessDiff = 3;
								CageDiff = 2;
							}
							
							System.out.println("Entering This Part Of The Rainforest You Feel Suddenly Very Uneasy, As If Something Is Watching You...");
							System.out.println("You Slowly Walk Forwards, Looking Left And Right To Ensure Nothing Can Sneak Up On You...");
							System.out.println("As You Step Forward You Feel Something Snag On Your Foot... It's A Trip Wire!!!");
							System.out.println("");
							System.out.println("Before You Know It A Wooden Cage Falls From The Trees Above You, Trapping You Inside!");
							System.out.println("An Old Man Approaches, Grinning That Has Successfully Caught His Target.");
							System.out.println("He Says If You Can Answer A Very Simple Question Then He Will Release You, Otherwise You Must Face His Challenge...");
							System.out.println("'The Question', He Says, 'Is...'");
							System.out.println("'Within " + DaysGuessDiff + " Either Side, How Many Days Have You Been Trapped In This Maze?'");
							System.out.println("Enter Your Answer...");
							
							boolean DaysChoice = false;
							int DaysGuess = 0;
							
							while (DaysChoice == false){
								if(input.hasNextInt()){
									   DaysGuess = input.nextInt();
									   DaysChoice = true;
								}else{
									System.out.println("Please Choose The Number Of Days You Think You Have Been In This Maze");
									input.next();
								}
							}
							
							if(DaysGuess >= TotalMoves - DaysGuessDiff && DaysGuess <= TotalMoves + DaysGuessDiff){
								System.out.println("'You Are Correct!!' The Man Shouts.");
								System.out.println("'I Can Reveal That You Have Been In this Maze For " + TotalMoves + " Days. You Are Free To Leave.'");
								System.out.println("");
								System.out.println("The Cage Lifts Up And You Feel You Need To Leave This Area As Soon As Possible.");
								OldManGame = true;
							}
							if(DaysGuess < TotalMoves - DaysGuessDiff || DaysGuess > TotalMoves + DaysGuessDiff){
								System.out.println("'WRONG!!!' The Old Man Shouts. 'The Correct Answer Was " + TotalMoves + "Now You Must Face My Challenge...'");
								System.out.println("He Hands You A Sheet Of Paper Before Scurrying Back Off Into The Trees.");
								System.out.println("");
								System.out.println("The Note Says That On The Door To The Cage Is An Automatic Lock With Four Buttons Labelled A, B, C And D.");
								System.out.println("Each Morning You Will Be Allowed One Attempt To Escape. You Must Press The Buttons In The Correct Order, Otherwise The Lock Shuts Down Until The Next Day.");
								System.out.println("Each Button Needs To Be Presses Exactly Once.");
								System.out.println("The Catch Is That If You Do Not Escape Within " + CageDiff + " Days Then The Lock Will Change It's Combination And You Have To Start Over!");
								System.out.println("");
								System.out.println("You Check Your Food Supplies To See That You Have " + Food + " Days Worth Of Food Remaining. You Need To Escape Before It Runs Out.");
								System.out.println("");
								
								boolean DaysGame = true;
								int TotalDaysInGame = 0;
								int DaysUntilChange = 0;
								int FirstCombo = 0;
								int SecondCombo = 0;
								int ThirdCombo = 0;
								int FourthCombo = 0;
								
								while(DaysGame == true && Food > 0){
									
									TotalDaysInGame++;
									System.out.println("This Is Day Number " + TotalDaysInGame + " In The Cage. You Have " + Food + " Days Worth Of Food Remaining.");
									System.out.println("");
									
									boolean OneCorrect = false;
									boolean TwoCorrect = false;
									boolean ThreeCorrect = false;
									
									if(DaysUntilChange == 0){
										
										System.out.println("A New Combination Has Been Set!!");
										
										boolean ComboChosen = false;
										while(ComboChosen == false){
											int MinCombo = 1; 
											int	MaxCombo = 4;	
											FirstCombo = MinCombo + (int)(Math.random() * ((MaxCombo - MinCombo) + 1));
											SecondCombo = MinCombo + (int)(Math.random() * ((MaxCombo - MinCombo) + 1));
											ThirdCombo = MinCombo + (int)(Math.random() * ((MaxCombo - MinCombo) + 1));
											FourthCombo = MinCombo + (int)(Math.random() * ((MaxCombo - MinCombo) + 1));
											
											if(FirstCombo != SecondCombo && FirstCombo != ThirdCombo && FirstCombo != FourthCombo
													&& SecondCombo != ThirdCombo && SecondCombo != FourthCombo && ThirdCombo != FourthCombo){
												ComboChosen = true;
												DaysUntilChange = CageDiff;
											}
										}
										}
										
										System.out.println("Pick Your First Choice Now...");
											
										boolean ChoiceOneMade = false;
										String ChoiceOne = null;
											
										while(ChoiceOneMade == false){
											ChoiceOne = input.nextLine();
											
											if(ChoiceOne.equals("A") || ChoiceOne.equals("B") || ChoiceOne.equals("C") || ChoiceOne.equals("D")){
												ChoiceOneMade = true;
											}
											else {
												System.out.println("Please Choose Either A, B, C Or D.");
											}
										}
											
										if((ChoiceOne.equals("A") && FirstCombo == 1) || (ChoiceOne.equals("B") && FirstCombo == 2) || 
												(ChoiceOne.equals("C") && FirstCombo == 3) || (ChoiceOne.equals("D") && FirstCombo == 4)){
											System.out.println("You Have Correctly Chosen The First Button. 3 More To Go...");
											OneCorrect = true;
										}
										else {
											System.out.println("You Have Chosen Incorrectly. You Must Start Again Tomorrow.");
											DaysUntilChange--;
											Food--;
										}
										
										if(OneCorrect == true){
											System.out.println("Make Your Second Choice Now...");
											boolean ChoiceTwoMade = false;
											String ChoiceTwo = null;
											
											while(ChoiceTwoMade == false){
												ChoiceTwo = input.nextLine();
												
												if(ChoiceTwo.equals("A") || ChoiceTwo.equals("B") || ChoiceTwo.equals("C") || ChoiceTwo.equals("D")){
													ChoiceTwoMade = true;
												}
												else {
													System.out.println("Please Choose Either A, B, C Or D.");
												}
											}
												
											if((ChoiceTwo.equals("A") && SecondCombo == 1) || (ChoiceTwo.equals("B") && SecondCombo == 2) || 
													(ChoiceTwo.equals("C") && SecondCombo == 3) || (ChoiceTwo.equals("D") && SecondCombo == 4)){
												System.out.println("You Have Correctly Chosen The Second Button. 2 More To Go...");
												TwoCorrect = true;
											}
											else {
												System.out.println("You Have Chosen Incorrectly. You Must Start Again Tomorrow.");
												DaysUntilChange--;
												Food--;
											}
										}
										
										if(OneCorrect == true && TwoCorrect == true){
											System.out.println("Make Your Third Choice Now...");
											boolean ChoiceThreeMade = false;
											String ChoiceThree = null;
											
											while(ChoiceThreeMade == false){
												ChoiceThree = input.nextLine();
												
												if(ChoiceThree.equals("A") || ChoiceThree.equals("B") || ChoiceThree.equals("C") || ChoiceThree.equals("D")){
													ChoiceThreeMade = true;
												}
												else {
													System.out.println("Please Choose Either A, B, C Or D.");
												}
											}
												
											if((ChoiceThree.equals("A") && ThirdCombo == 1) || (ChoiceThree.equals("B") && ThirdCombo == 2) || 
													(ChoiceThree.equals("C") && ThirdCombo == 3) || (ChoiceThree.equals("D") && ThirdCombo == 4)){
												System.out.println("You Have Correctly Chosen The Third Button. Only 1 More To Go...");
												ThreeCorrect = true;
											}
											else {
												System.out.println("You Have Chosen Incorrectly. You Must Start Again Tomorrow.");
												DaysUntilChange--;
												Food--;
											}
										}
										
										if(OneCorrect == true && TwoCorrect == true && ThreeCorrect){
											System.out.println("Make Your Last Choice Now...");
											boolean ChoiceFourMade = false;
											String ChoiceFour = null;
											
											while(ChoiceFourMade == false){
												ChoiceFour = input.nextLine();
												
												if(ChoiceFour.equals("A") || ChoiceFour.equals("B") || ChoiceFour.equals("C") || ChoiceFour.equals("D")){
													ChoiceFourMade = true;
												}
												else {
													System.out.println("Please Choose Either A, B, C Or D.");
												}
											}
												
											if((ChoiceFour.equals("A") && FourthCombo == 1) || (ChoiceFour.equals("B") && FourthCombo == 2) || 
													(ChoiceFour.equals("C") && FourthCombo == 3) || (ChoiceFour.equals("D") && FourthCombo == 4)){
												System.out.println("You Have Correctly Chosen The Last Button!!");
												System.out.println("The Door Of The Cage Swings Open Allowing You To Leave!");
												System.out.println("You Quickly Exit The Cage And Leave This Area...");
												TotalMoves = TotalMoves + TotalDaysInGame;
												DaysGame = false;
												OldManGame = true;
											}
											else {
												System.out.println("You Have Chosen Incorrectly. You Must Start Again Tomorrow.");
												DaysUntilChange--;
												Food--;
											}
										}	
								}
								if(Food <= 0){
									System.out.println("Luck Has Not Been On Your Side. You Have No Food Remaining...");
									System.out.println("You Will Die In This Cage Tonight.");
									System.out.println("");
								}
							}
						}
						
					}
					if(xPosition == 2 && yPosition == 6){
						if(Choice.equals("S")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							yPosition++;
						}
						else if(PathCleared == false){
							if(Sword == false){
								if(Choice.equals("E")){
									System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
									xPosition--;
								}
								if(Choice.equals("W")){
									System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
									xPosition++;
								}
							}
							if(Sword == true){
								System.out.println("The Path This Way Is Blocked By The Forest...");
								System.out.println("However, It Looks As Though A Path Could Be Cleared By Using Your Sword.");
								System.out.println("Do You Wish To Cut A Path Through The Forest, Yes Or No?");
								
								boolean PathDecisionMade = false;
								
								while(PathDecisionMade == false){
									
									String PathChoice = input.nextLine();
									
									if(PathChoice.equals("Yes")){
										System.out.println("You Clear A Path With Your Sword!");
										System.out.println("However, In Doing So Your Sword Has Become Blunted And Broken...");
										System.out.println("Not Needing The Extra Weight You Throw The Sword Deep Into The Forest Where It Won't Be Found Again.");
										PathDecisionMade = true;
										Sword = false;
										PathCleared = true;
									}
									else if(PathChoice.equals("No")){
										System.out.println("You Decide Not To Clear The Path, Fearing What Might Lie On The Other Side!");
										PathDecisionMade = true;
										if(Choice.equals("E")){
											xPosition--;
										}
										if(Choice.equals("W")){
											xPosition++;
										}
									}
									else System.out.println("Please Choose Either Yes Or No.");
								}
							}
						}
						else if(PathCleared == true){
							System.out.println("You Travel Through The Path You Had Cleared With Your Sword.");
						}
					}
					if(xPosition == 3 && yPosition == 6){
						System.out.println("There is Nothing Interesting In This Area...");
					}
					if(xPosition == 4 && yPosition == 6){
						if(Choice.equals("N")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							yPosition--;
						}
						if(Choice.equals("E")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition--;
						}
						if(Choice.equals("W")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition++;
						}
					}
					if(xPosition == 5 && yPosition == 6){
						
						if(Grass == false){
							System.out.println("In Front Of You Is Lush Green Grass. It Looks Like A Perfect Place To Take A Break And To Check Your Supplies.");
							System.out.println("Taking Your First Step Onto The Grass, Something Feels Very Strange...");
							System.out.println("");
							System.out.println("Your Foot Sank Deep Into The Grass!! You Struggle To Try And Pull It Out But The More You Move The Tighter The Grip On Your Foot Becomes!");
							System.out.println("Even Worse, You Are Being Pulled Down Into The Earth. You Need To Think Fast To Get Out Of Here!!!");
							System.out.println("");
							System.out.println("Panicking, You Reach Out For Something To Grab Onto. But There Is Nothing Within Reach...");
							System.out.println("However, You Spot A Low Hanging Branch Above You. You Know You Only Have One Attempt To Choose Something To Save You...");
							
							if(Sword == false && Ring == false && Magic == false && Food <=5){
								System.out.println("Unfortunately, You Have No Items Available To Use.");
								System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
								System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
								System.out.println("");
								System.out.println("... GAME OVER");
								Lose = true;
							}
							else System.out.println("Please Choose An Item From Your Inventory:");
							
						}
						if(Grass == true){
							System.out.println("You Have Foolishly Walked Back Into The Grass Area, Stumbling As Your Foot Is Gripped!!");
							System.out.println("You Instinctively Put Your Arms Out To Break Your Fall, But They Are Immediately Dragged Down Into The Earth...");
							System.out.println("You Cannot Move Your Arms, There Is No Way Out Now.");
							System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do.");
							System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
							System.out.println("");
							System.out.println("... GAME OVER");
							Lose = true;
						}
						
						boolean GrassChoiceMade = false;
						
						while(GrassChoiceMade == false && Lose == false){
							
							String GrassChoice = input.nextLine();
							
							if(GrassChoice.equals("Glorious Sword") || GrassChoice.equals("Sword") || GrassChoice.equals("sword")){
								if(Sword == true){
									System.out.println("You Take Your Sword And Hook The Handle Around The Branch, Holding Onto The Blade To Stop Yourself From Sinking Further.");
									System.out.println("It Takes All Your Strength And Will Power, But You Pull As Hard As You Can, Praying The Branch Does Not Snap...");
									System.out.println("");
									System.out.println("The Blade Rips Into Your Hands Causing Blood To Rush Down Your Arms, But You Make It Out Alive!");
									System.out.println("Unfortunately, Your Wounds Mean You Can No Longer Wield The Blade And So You Decide To Save Weight And Throw The Sword Into The Grass.");
									System.out.println("This Was Too Close. You Need To Make Sure Not To Return To This Place Again.");
									GrassChoiceMade = true;
									if(Ring == false){
										System.out.println("As You Leave You Spot A Small Silver Ring On The FLoor. It Must Have Fallen From The Tree As Your Released The Branch.");
										System.out.println("You Pick It Up And Place It On Your Finger.");
										Ring = true;
									}
								}
								if(Sword == false){
									System.out.println("You Feel Around For A Sword, But You Do Not Have One!!!");
									System.out.println("There Is No More Time To Look For Anything Else...");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
								Sword = false;
							}
							else if(GrassChoice.equals("Magic") || GrassChoice.equals("Book Of Magic") || GrassChoice.equals("magic")){
								if(Magic == true){
									System.out.println("You Decide To Use The Magic You Have Learned, Hoping It Will In Some Way Save You.");
									System.out.println("You Shout The Words And Fire A Bolt Of Lightning At The Branch...");
									System.out.println("");
									System.out.println("The Branch Turns To Ash. Panicking You Fire Lightning All Around You But Its No Use.");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
								if(Magic == false){
									System.out.println("You Do Not Have Magic Powers!!!");
									System.out.println("There Is No More Time To Look For Anything Else...");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
							}
							else if(GrassChoice.equals("Ring") || GrassChoice.equals("Shimmering Metal Ring") || GrassChoice.equals("ring")){
								if(Ring == true){
									System.out.println("You Reach For The Shimmering Ring You Found.");
									System.out.println("You Place It On Your Finger For The First Time, Praying That Something Happens...");
									System.out.println("...Nothing Happens.");
									System.out.println("");
									System.out.println("Not Knowing What Else You Can Do With A Ring You Throw It At The Branch.");
									System.out.println("It Strikes The Branch, But Nothing Happens...");
									System.out.println("There Is No More Time To Look For Anything Else...");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
								if(Ring == false){
									System.out.println("You Do Not Have A Ring!!!");
									System.out.println("There Is No More Time To Look For Anything Else...");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
							}
							else if(GrassChoice.equals("Food") || GrassChoice.equals("food")){
								System.out.println("You Decide To Throw Some Food Out Onto The Grass, Not Really Knowing How It Can Help...");
								
								int MinFoodThrow = 1; 
								int	MaxFoodThrow = 2;	
								int FoodThrow = MinFoodThrow + (int)(Math.random() * ((MaxFoodThrow - MinFoodThrow) + 1));
								
								if(FoodThrow == 1){
									System.out.println("You Wait And Hope For Something To Happen, All The While Being Pulled Further Into The Earth.");
									System.out.println("...Nothing.");
									System.out.println("The Grass Pulls You Deeper And Deeper Into The Dirt, There Is Nothing You Can Do Now.");
									System.out.println("Eventually, You Are Entirely Submerged, Buried Alive Until You Suffocate.");
									System.out.println("");
									System.out.println("... GAME OVER");
									Lose = true;
									GrassChoiceMade = true;
								}
								if(FoodThrow == 2){
									System.out.println("You Wait And Hope For Something To Happen, All The While Being Pulled Further Into The Earth.");
									System.out.println("...");
									System.out.println("There Is A Rustling In A Bush Nearby, And Then You See A Large Cat Cautiously Move Out Towards The Food.");
									System.out.println("The Cat Looks Incredibly Thin, Clearly Not Eating Enough To Survive For Much Longer.");
									System.out.println("");
									System.out.println("It Moves Towards The Food, But As It Gets Near The Grass Grips Its Legs Just As It Had Done To You!!");
									System.out.println("The Cat Struggles, Thrashing Around Trying To Get Free.");
									System.out.println("You Can't Help But Feel For The Poor Creature, But Quickly Your Guilt Subsides...");
									System.out.println("You Feel The Grip On Your Leg Loosen!! The Cats Movement Must Be Causing The Grass To Change It's Focus!!");
									System.out.println("");
									System.out.println("Wasting No Time You Pull Yourself From The Grass And Get As Far Away As Possible...");
									System.out.println("This Was Too Close. You Need To Make Sure Not To Return To This Place Again.");
									System.out.println("You Have Lost 3 Days Worth Of Food.");
									GrassChoiceMade = true;
									Food = Food - 3;
								}
							}
							else if(GrassChoice.equals("I")){
								if(Sword == true)		{System.out.println("* Glorious Sword");}
								if(Magic == true)		{System.out.println("* Book Of Magic");}
								if(Ring == true)		{System.out.println("* Shimmering Metal Ring");}
								
								System.out.println("* You Have " + Food + " Days Worth Of Food Remaining");
								
								if(KeyFound == false && Sword == false && Magic == false && Ring == false){
									System.out.println("");
									System.out.println("There Are No Other Items In Your Inventory.");
								}
							}
							else System.out.println("Invalid Choice. Please Choose An Item From Your Inventory.");
						}
						Grass = true;
					}
					if(xPosition == 6 && yPosition == 6){
						System.out.println("As You Carry On Through The Rainforest You Spot A White Arrow Drawn Into Some Of The Trees.");
						System.out.println("It Looks As If They Are Pointing The Way Towards Something...");
						System.out.println("Do You Wish To Follow The Arrows, Yes Or No?");
						
						boolean ArrowChoice = false;
						
						while(ArrowChoice == false){
							
							String ArrowDecision = input.nextLine();
							
							if(ArrowDecision.equals("No")){
								System.out.println("You Decide Not To Trust Anything In This Maze And Carry On The Way You Were Going.");
								ArrowChoice = true;
							}
							else if(ArrowDecision.equals("Yes")){
								System.out.println("You Choose To Follow These Arrows To See Where They Lead To...");
								System.out.println("They Lead Deep Into The Trees And Well Out Of Sight. Finally You Reach An Old And Rusted Sign.");
								System.out.println("");
								System.out.println("It Reads... 'Beware Of The Old Man To The Far West. To Avoid His Trap You Must Know For How Long You Have Been In This Place.'");
								System.out.println("'Currently, You Have Been Stuck Here For A Total Of >>>" + TotalMoves + "<<< Days. Remember To Keep Count!!'");
								System.out.println("");
								System.out.println("You Leave The Area The Way You Came, And Feel It Would Be Wise To Take On Board What You Have Been Told.");
								ArrowChoice = true;
							}
							else {
								System.out.println("Please Choose Either Yes Or No.");
							}
						}
						
					}
					
					//Third Row
					if(xPosition == 1 && yPosition == 7){
						System.out.println("As You Are Travelling You Notice You Are Sweating From The Heat.");
						System.out.println("You Look Up At The Glass Roof That Is Causing This Place To Act Like A Giant Greenhouse.");
						System.out.println("You Scan The Roof Looking For Any Sign Of Life Outside, But As You Do You Notice Something Odd...");
						System.out.println("");
						System.out.println("There Seems To Be Some Sort Of Walkway Leading Across The Room Just Under Inside The Glass.");
						System.out.println("You See That There Is A Door To The North Of The Walkway, That Could Be The Way Out!");
						System.out.println("You Then Look For The Other End Of The Walkway, But It Heads Off Too Far South For You To See.");
						System.out.println("Maybe There Is A Way To Get Up There...");
						Bridge = false;
					}
					if(xPosition == 2 && yPosition == 7){
						if(Choice.equals("N")){
							System.out.println("You Cannot Clear A Path That Way...");
							yPosition--;
						}
						else {
							System.out.println("You Are Standing At The Edge Of The Lake.");
							System.out.println("As You Look Out Over The Glistening Water You Can See That It Stops Abruptly To The North At A Cliff Face.");
							System.out.println("Under Your Feet Is Warm Golden Sand. It Feels Like A Small Slice Of Paradise In This Hellish Place.");
							System.out.println("");
							
							if(SandFood == false){
								
								int SandDiff = 0;
								
								if(Diff.equals("Easy")){
									SandDiff = 6;
								}
								if(Diff.equals("Hard")){
									SandDiff = 4;
								}
								
								System.out.println("You Spot Some Food Half Buried In The Sand. Eagerly, You Pick It Up And Place It In Your Bag.");
								Food++;
								System.out.println("");
								System.out.println("It Seems Likely That The Deeper You Dig The More Food You Will Find.");
								System.out.println("Do You Wish To Dig For More Food, Yes Or No?");
								
								boolean SandChoiceMade = false;
								
								while(SandChoiceMade == false){
									String SandFoodChoice = input.nextLine();
									
									if(SandFoodChoice.equals("No")){
										SandChoiceMade = true;
										System.out.println("You Feel You Have Enough Food, There Is No Point Wasting Time.");
									}
									else if(SandFoodChoice.equals("Yes")){
										SandFood = true;
										SandChoiceMade = true;
										System.out.println("You Place Your Bag Down And Begin Looking For A Place To Dig First.");
										
										boolean SandFoodGame = true;
										
										int MinSandGame = 1; 
										int	MaxSandgame = SandDiff;	
										int SandGame = MinSandGame + (int)(Math.random() * ((MaxSandgame - MinSandGame) + 1));
										
										int TotalDigs = 0;
	
										while(SandFoodGame == true){
											
											System.out.println("Choose Either To Dig Or Leave.");
											String DigOrLeave = input.nextLine();
											
											if(DigOrLeave.equals("Dig")){
												TotalDigs++;
													if(TotalDigs < SandGame){
														System.out.println("You Find " + (int) Math.pow(TotalDigs, 2) + " More Pieces Of Food.");
														Food = (int) (Food + Math.pow(TotalDigs, 2));
													}
													if(TotalDigs >= SandGame){
														System.out.println("You Find Nothing While Digging. As You Turn Around To Leave You Also Spot A Wild Cat Rummaging Through Your Bag!");
														System.out.println("You Quickly Run Over And Chase It Off But It Has Already Managed To Eat Half Of Your Food!");
														Food = Math.round(Food/2);
														SandFoodGame = false;
													}
											}
											else if(DigOrLeave.equals("Leave")){
												System.out.println("You Have Decided That You Have Been Digging Long Enough.");
												System.out.println("As You Turn To Leave You See A Wild Cat Moving Towards Your Bag!");
												System.out.println("You Quickly Chase It Off Before It Can Steal Any Of Your Food!");
												SandFoodGame = false;
											}
											else {
												System.out.println("Please Choose To Either Dig Or Leave.");
											}
										}
										
									}
									else {
										System.out.println("Please Choose Either Yes Or No.");
									}
								}	
							}
							if(SandFood = true){
								System.out.println("You See No Point Digging For Food Again.");
							}
						}
					}
					if(xPosition == 3 && yPosition == 7){
						
						if(OgreMet == true && OgreKilled == false){
							System.out.println("The Ogre Is Sitting Next To The Lake Staring At It's New Ring. It Seems To Be Happy.");
							System.out.println("You Remember The Ogres Warning That If It Sees You Again It Will Not Hesitate To Kill You.");
							System.out.println("With this In Mind You Turn Back The Way You Came From. You Need To Find Another Route Around.");
							
							if(Choice.equals("N")){
								yPosition--;
							}
							if(Choice.equals("E")){
								xPosition--;
							}
							if(Choice.equals("S")){
								yPosition++;
							}
						}
						if(OgreMet == true && OgreKilled == true){
							System.out.println("The Body Of The Ogre Is Floating In The Lake. it Didn't Stand A Chance Against Your Magic.");
						}
						if(OgreMet == false){
							OgreMet = true;
							System.out.println("You Are Standing On A Man-Made Beach At The Edge Of A Lake. The Sun Is Reflecting Off The Dark Blue Water.");
							System.out.println("Just As You Are Feeling At Peace, There Is A Thunderous Roar!!!");
							System.out.println("You Turn Just In Time To See A Giant Ogre Rampaging Towards You, Yelling Something About Death And Destruction....");
							System.out.println("");
							System.out.println("You Have Little Time To Decide What To Do. You Can Stand And Fight, Or Run For Your Life...");
							System.out.println("Please Choose To Either Fight Or Run...");
							
							boolean FightOrRunChoice = false;
							while(FightOrRunChoice == false){
								String FightOrRun = input.nextLine();
								if(FightOrRun.equals("Fight")){
									FightOrRunChoice = true;
									System.out.println("You Have Chosen To Fight The Almighty Beast. You Now Need To Choose A Weapon, And Fast!");
									System.out.println("Your Choices Are As Follows...");
									System.out.println("");
									System.out.println("* Fists");
									if(Sword == true){
										System.out.println("* Sword");
									}
									if(Magic == true){
										System.out.println("* Magic");
									}
									
									System.out.println("");
									System.out.println("Make Your Choice Now...");
									
									boolean WeaponChoice = false;
									while(WeaponChoice == false){
										String Weapon = input.nextLine();
										
										if(Weapon.equals("Fists")){
											System.out.println("You Have Chosen To Fight The Ogre With Your Fists...");
											System.out.println("It Is Charging At You Now, You Decide Your Only Hope Is To Run Directly At It Too!");
											System.out.println("");
											System.out.println("You Both Meet, You Dodge The Ogres Attempt To Bundle You Over And Begin Punching At It's Side...");
											System.out.println("But The Ogre Does Not Flinch, Or Even Move... It Is Just Watching You Trying To Attack It!");
											System.out.println("It Begins To Laugh At You, Clearly Amused At Your Feeble Attempts.");
											System.out.println("");
											System.out.println("Eventually The Laughter Stops, And It Says 'This Is How To Punch...'");
											System.out.println("And With That It Clenches It's Fist And With One Swing Shatters All Of Your Bones...");
											System.out.println("...GAME OVER");
											Lose = true;
											WeaponChoice = true;
										}
										else if(Weapon.equals("Sword") && Sword == true){
											System.out.println("You Draw Your Sword And Wait For The Ogre To Reach You...");
											System.out.println("As It Approaches You Bring The Sword Back, Ready To Swing At The Beasts Legs To Bring It Down...");
											System.out.println("It Is Close Now, You Are Ready...");
											System.out.println("");
											System.out.println("You Swing As Hard As You Can! The Blade Crahses Into The Ogres Legs, Just As You Had Planned!!");
											System.out.println("But The Ogre's Skin Is Thicker And Stronger Than Armor!");
											System.out.println("Your Blade Shatters Upon Impact And You Are Now Left With No Defenses...");
											System.out.println("");
											System.out.println("The Ogre Takes No Pity And With One Almighty Punch Shatters All Your Bones...");
											System.out.println("...GAME OVER");
											Lose = true;
											WeaponChoice = true;
										}
										else if(Weapon.equals("Sword") && Sword == false){
											System.out.println("You Do Not Own A Sword...");
											System.out.println("There Is No More Time. The Ogre Charges Into You, Sending You Flying Into The Lake...");
											System.out.println("Unfortunately, Under The Water Are Jagged Rocks!!");
											System.out.println("They Rip Through Your Body, Blood Pours Into The Water In A Mist Of Red...");
											System.out.println("...GAME OVER");
											Lose = true;
											WeaponChoice = true;
										}
										else if(Weapon.equals("Magic") && Magic == true){
											System.out.println("You Decide To Use The Best Weapon At Your Disposal... Your Magic.");
											System.out.println("Before The Ogre Can Get Near Enough To Attack, You Send A Blast Of Lightning Streaming Towards It!!!");
											System.out.println("It Thunders Out Of Your Hands, Tears Through The Air, And Connects With Your Target...");
											System.out.println("There Is A Huge Explosion That Sends The Ogre Hurtling Through The Air!");
											System.out.println("");
											System.out.println("It Plummets Into The Lake With An Enormous Splash... You Wait For Signs Of Movement...");
											System.out.println("");
											System.out.println("After A While You Feel Confident The Ogre Is Dead And You Go Over To Check.");
											System.out.println("It's Lifeless Corpse Floats Facedown In The Water. It Is No Threat To You Anymore.");
											System.out.println("You Spot A Small Satchel On His Back, Inside Is A Strange Object. You Remove The Object And Place It In Your Bag...");
											System.out.println("It May Come In Useful Later.");
											OgreKilled = true;
											WeaponChoice = true;
										}
										else if(Weapon.equals("Magic") && Magic == false){
											System.out.println("You Have No Magical Powers...");
											System.out.println("There Is No More Time. The Ogre Charges Into You, Sending You Flying Into The Lake...");
											System.out.println("Unfortunately, Under The Water Are Jagged Rocks!!");
											System.out.println("They Rip Through Your Body, Blood Pours Into The Water In A Mist Of Red...");
											System.out.println("...GAME OVER");
											Lose = true;
											WeaponChoice = true;
										}
										else {
											System.out.println("Please Choose One Of The Following Options:");
											System.out.println("");
											System.out.println("* Fists");
											if(Sword == true){
												System.out.println("* Sword");
											}
											if(Magic == true){
												System.out.println("* Magic");
											}
										}
									}
								}
								else if(FightOrRun.equals("Run")){
									FightOrRunChoice = true;
									System.out.println("You Decide You Are No Match For This Giant Creature And Try To Run Away...");
									System.out.println("But As You Turn To Run You Trip Over A Small Ants Nest In The Sand!");
									System.out.println("The Ogre Comes Charging Up To You, Screaming At You... There Is No Time To Run Anymore.");
									System.out.println("");
									System.out.println("The Ogre Stops, Towering High Above You... You Close Your Eyes And Wait For Death...");
									System.out.println("But Death Doesn't Come. Instead The Ogre Picks You Up And Throws You To The Side Before Checking On The Ants!!");
									System.out.println("It Clearly Feels These Animals Are It's Friends, And Is Distraught That You Have Brought Death And Destruction To Their Home...");
									System.out.println("");
									System.out.println("It Turns To You With Tearful Eyes... 'YOU MONSTER!!' It Shouts. 'You've Killed My Firends! Now You Must Pay The Price!!!'");
									System.out.println("");
									
									boolean RingGiven = false;
									
									if(Ring == true){
										System.out.println("As The Ogre Approaches You It Spots The Shimmering Ring On Your Finger...");
										System.out.println("It Is Captivated By The Tiny Ring, And Demands You hand Ot Over...");
										System.out.println("Do You Want To Hand Over The Ring, Yes Or No?");
										
										boolean RingChoice = false;
										while(RingChoice == false){
											String GiveRing = input.nextLine();
											if(GiveRing.equals("No")){
												System.out.println("You Decide Not To Hand Over The Ring To The Ogre, Feeling It May Be Of More Use To You Later.");
												System.out.println("The Ogre Does Not Respond Well...");
												System.out.println("It Says it Will Just Kill You And Take The Ring From You Instead!!");
												System.out.println("And With That It Swings It's Giant Fist Crashing Into Your Body, Shattering Your Bones...");
												System.out.println("...GAME OVER");
												Lose = true;
												RingChoice = true;
											}
											else if(GiveRing.equals("Yes")){
												System.out.println("Slowly, You Take Off The Ring And Offer It To The Ogre, Hoping It Will Spare Your Life In Return.");
												System.out.println("The Ogre Quickly Snatches The Ring From You, And Sits On The Sand Staring At It.");
												System.out.println("After A While, It Thanks You And Offers Some Words Of Advice...");
												System.out.println("");
												System.out.println("'If You Want Your Freedom Then Listen For The Birds, They Will Show You The Way.'");
												System.out.println("'But If I See You Again, I Will Not Hesitate To Kill You...'");
												System.out.println("");
												System.out.println("You Slowly Back Away From The Ogre, Back The Way You Came, Knowing That It Will Now Be Of No Harm To You.");
												RingChoice = true;
												Ring = false;
												RingGiven = true;
												if(Choice.equals("N")){
													yPosition--;
												}
												if(Choice.equals("E")){
													xPosition--;
												}
												if(Choice.equals("S")){
													yPosition++;
												}
											}
											else {
												System.out.println("Please Choose Either Yes Or No.");
											}
										}
									}
									if(Ring == false && RingGiven == false) {
										System.out.println("");
										System.out.println("Press Enter To Continue");
										input.nextLine();
										System.out.println("The Ogre Walks Up To You, Both Anger And Sadness In It's Eyes.");
										System.out.println("'Im Going To Give You One Chance To Earn Your Freedom. Find Me More Friends Or I Will Kill You!!!'");
										System.out.println("");
										System.out.println("This Is The Strangest Request You Have Ever Heard, But You Have No Doubt The Ogre Is Serious...");
										System.out.println("From What You Can See There Are 3 Possible Places To Look...");
										System.out.println("The Trees, The Water Or The Sand.");
										System.out.println("Make Your Choice...");
										
										boolean FriendChoice = false;
										boolean FriendFound = false;
										String FriendLocation = null;
										int MinFriend = 1; 
										int	MaxFriend = 3;	
										int Friend = MinFriend + (int)(Math.random() * ((MaxFriend - MinFriend) + 1));
										
										while(FriendChoice == false){
											FriendLocation = input.nextLine();
											if(FriendLocation.equals("Trees") || FriendLocation.equals("Water") || FriendLocation.equals("Sand")){
												FriendChoice = true;
											}
											else {
												System.out.println("Please Choose Either Trees, Water Or Sand");
											}
										}
										if(FriendLocation.equals("Trees") && Friend == 1){
											System.out.println("You Search The Trees Looking For Some Form Of Life That The Ogre Can Call Friend.");
											System.out.println("After Failing For A Few Minutes You Finally Spot Something That Might Work!");
											System.out.println("You Call The Ogre Over And Show It Your Find... Beatles!");
											System.out.println("");
											System.out.println("At First The Ogre Looks Unhappy, But Eventually A Smile Crosses It's Face.");
											FriendFound = true;
										}
										else if(FriendLocation.equals("Water") && Friend == 2){
											System.out.println("You Search The Lake For Signs Of Life. But You Quickly Realise There Are No Fish Here.");
											System.out.println("Things Do Not Seem Good...");
											System.out.println("Just As You Are Giving Up Hope You Spot A Small Crab Scuttling Along Just Under The Water.");
											System.out.println("You Call The Ogre Over And Show It Your Find...");
											System.out.println("");
											System.out.println("At First The Ogre Looks Unhappy, But Eventually A Smile Crosses It's Face.");
											FriendFound = true;
										}
										else if(FriendLocation.equals("Sand") && Friend == 3){
											System.out.println("You Frantically Search Through The Sand For Any Signs Of Life... It Doesnt Look Hopeful.");
											System.out.println("Just As You Are Giving Up Hope You Spot Something Out Of The Corner Of Your Eye...");
											System.out.println("It's A Tiny Lizard!");
											System.out.println("You Call The Ogre Over And Show It Your Find...");
											System.out.println("");
											System.out.println("At First The Ogre Looks Unhappy, But Eventually A Smile Crosses It's Face.");
											FriendFound = true;
										}
										else {
											System.out.println("You Search The Area As Thoroughly As You Can But You Can't See Any Signs Of Life...");
											System.out.println("Eventually, The Ogre Loses Patience And Without Warning Swings It's Giant Fists Into Your Body...");
											System.out.println("Your Bones Are Shattered And You Know This Is The End.");
											System.out.println("You Stare At The Glistening Water, Until Your Vision Turns To Black And Your World Ceases To Exist...");
											System.out.println("...GAME OVER");
											Lose = true;
										}
										
										if(FriendFound == true){
											System.out.println("'THANKYOU!' The Ogre Announces, Playing With It's New Friend...");
											System.out.println("'You Are Free To Leave... But First I Wish To Give You Some Advice...'");
											System.out.println("'If You Want Your Freedom Then Listen For The Birds, They Will Show You The Way.'");
											System.out.println("'But If I See You Again, I Will Not Hesitate To Kill You...'");
											System.out.println("");
											System.out.println("You Slowly Back Away From The Ogre, Back The way You Came, Knowing That It Will Now Be Of No Harm To You.");
											if(Choice.equals("N")){
												yPosition--;
											}
											if(Choice.equals("E")){
												xPosition--;
											}
											if(Choice.equals("S")){
												yPosition++;
											}
										}
									}
								}
								else {
									System.out.println("Please Choose To Either Fight Or Run.");
								}
							}
						}
						
					}
					if(xPosition == 4 && yPosition == 7){
						if(Choice.equals("S")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							yPosition++;
						}
						if(Choice.equals("E")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition--;
						}
					}
					if(xPosition == 5 && yPosition == 7){
						if(Choice.equals("N")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							yPosition--;
						}
						if(Choice.equals("W")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							xPosition++;
						}
						if(Choice.equals("S")){
							System.out.println("You Try To Travel Into The Forest But Eventually Your Path Is Blocked. You Return The Way You Came.");
							yPosition++;
						}
					}
					if(xPosition == 6 && yPosition == 7){
						
						if(RockPath == true){
							System.out.println("You Now Know The Way Through This Rocky Area. The Path Is Easy To Follow.");
						}
						if(RockPath == false){
							System.out.println("You Are Walking Along A Slight Slope, Moving Just Above The Tree Line.");
							System.out.println("To Your East Is A Rocky Hill, Too Steep To Climb.");
							System.out.println("You Come To A Point Where You Are Surrounded On Both Your Left And Right By Rocks.");
							System.out.println("");
							System.out.println("Suddenly You Hear An Almighty Crash...!");
							System.out.println("The Rocks Have Tumbled Off Of The Hillside And Are Now Blocking Your Path Forward...");
							System.out.println("");
							
							if(Magic == true){
								System.out.println("Luckily You Have Just The Tool To Clear They Way...");
								System.out.println("You Shout 'FULGURA TEMPESTAS!' And Fire A Bolt Of Lightning At The Rocks, Causing Them To Disintegrate In Front Of You.");
								System.out.println("The Path Is Now Free To Travel Through");
								RockPath = true;
							}
							if(Magic == false){
								System.out.println("As The Dust Clears You Look For A Way Over This Now Treacherous Terrain.");
								System.out.println("You Can See Four Possible Routes To Choose From, But Each Looks Incredibly Unstable...");
								System.out.println("You Need To Select Wisely One Of The Four Routes.");
								System.out.println("");
								System.out.println("Enter 1, 2, 3 Or 4 To Make Your Decision.");
								
								boolean RoutesPicked = false;
								int RockRoute = 0;
								int RockRoute2 = 0;
								while (RoutesPicked == false){
									
									int MinRockRoute = 1; 
									int	MaxRockRoute = 4;	
									RockRoute = MinRockRoute + (int)(Math.random() * ((MaxRockRoute - MinRockRoute) + 1));
									
									int MinRockRoute2 = 1; 
									int	MaxRockRoute2 = 4;	
									RockRoute2 = MinRockRoute2 + (int)(Math.random() * ((MaxRockRoute2 - MinRockRoute2) + 1));
									
									if(RockRoute != RockRoute2){
										RoutesPicked = true;
									}
								}	
									
								boolean RockChoiceMade = false;
								boolean RockChance = false;
								while(RockChoiceMade == false){
									
									int RouteChosen = 0;
									
									if(input.hasNextInt()){
										RouteChosen = input.nextInt();
										
										if(RouteChosen < 1 || RouteChosen > 4){
											System.out.println("Choose Either 1, 2, 3 Or 4.");
										}

										else if(RouteChosen == RockRoute){
											System.out.println("You Successfully Manage To Get Past The Rocks!");
											System.out.println("You Now Know That This Route Is Safe Should You Wish To Travel Through Here Again.");
											RockChoiceMade = true;
											RockPath = true;
										}
										else if(RouteChosen == RockRoute2){
											System.out.println("You Carefully Step Over The Rocks, Making Sure Your Foot Is Stable Before Moving Onto The Next Step.");
											System.out.println("You Are Nearly Across, When You Accidentally Clip The Side Of A Loose Rock With Your Arm...");
											System.out.println("");
											System.out.println("Thats All It Took To Dislodge The Large Rocks Above, And They Come Crashing Down...");
											System.out.println("You Try To Move Quickly But Before Long You Are Crushed Under The Falling Stones, Never To Be Seen Again.");
											System.out.println("");
											System.out.println("...GAME OVER");
											Lose = true;
											RockChoiceMade = true;
										}
										else if(RouteChosen != RockRoute && RouteChosen != RockRoute2 && RockChance == false){
											System.out.println("You Carefully Step Over The Rocks, Making Sure Your Foot Is Stable Before Moving Onto The Next Step.");
											System.out.println("You Are Nearly Across, When You Accidentally Clip The Side Of A Loose Rock With Your Arm...");
											System.out.println("");
											System.out.println("Thats All It Took To Dislodge The Large Rocks Above, And They Come Crashing Down...");
											System.out.println("Luckily You Are Able To Quickly Turn And Run Back The Way You Came.");
											System.out.println("You Need To Make A Better Choice Next Time!!");
											RockChance = true;
										}
										else if(RouteChosen != RockRoute && RouteChosen != RockRoute2 && RockChance == true){
											System.out.println("This Time You Walk Incredibly Slowly, Making Sure You Are Completely Aware Of Your Surroundings.");
											System.out.println("You Are Within A Few Steps Of Making It Across, And For The First Time You Start To Relax...");
											System.out.println("");
											System.out.println("As You Take Your Last Step You Feel A Rush Of Pain Through Your Back And Shoulder...");
											System.out.println("You Turn Your Neck To See What The Problem Is, And The Your Face Turns White In Shock...");
											System.out.println("When Running From The Falling Rocks In The Last Route, The Adrenaline Must Have Covered Up The Pain Of A Large Sharp Rock Tearing Into Your Shoulder!");
											System.out.println("You Have Already Lost An Incredible Amount Of Blood, You Need To Wait A While To Recover...");
											
											int MinRecovery = 3; 
											int	MaxRecovery = 8;	
											int Recovery = MinRecovery + (int)(Math.random() * ((MaxRecovery - MinRecovery) + 1));
											
											System.out.println("You Sit Down And Wait For Your Wound To Heal...");
											System.out.println("It Takes " + Recovery + " Days To Heal But You Now Feel Ready To Continue Your Journey.");
											Food = Food - Recovery;
											TotalMoves = TotalMoves + Recovery;
											RockChoiceMade = true;
										}
									}else{
										System.out.println("Choose Either 1, 2, 3 Or 4.");
										input.next();
										}		
								}
							}
						}
					}
					
					//Fourth Row
					if(xPosition == 1 && yPosition == 8){
						if(Bridge == false && Choice.equals("W")){
							System.out.println("There Is A Steep Cliff Blocking Your Path...");
							xPosition++;
						}
						else if(Choice.equals("N")){
							Bridge = true;
							System.out.println("There is Nothing Interesting In This Area...");
						}
						else {
							System.out.println("There is Nothing Interesting In This Area...");
						}
					}
					if((xPosition == 2 && yPosition == 8 && Bridge == true) || (xPosition == 3 && yPosition == 8 && Bridge == true)){
						if(Choice.equals("E") || Choice.equals("W")){
							//Bridge = true;
							int BridgeLength = 8;
							if(Bridge == true){
								System.out.println("You Find Yourself At A Long Rope Bridge Over A Large Lake. Next To The Entrance There Is A Sign That Reads:");
								System.out.println("'Before You Is The Guardian Bridge. It Tests The Courage Of All Who Cross It...'");
								System.out.println("'Three Of The Slats On This Brdge Are Rotten, But It Is Impossible To Know Which Ones They Are...'");
								System.out.println("'You Must Navigate Over By Either Jumping Or Stepping...'");
								System.out.println("'Jumping Will Get You Across Faster But Will Guarantee A Rotten Slat Breaks...'");
								System.out.println("'Stepping Will Allow You One Chance To Step On A Rotten Slat...'");
								System.out.println("'Only The Brave And Wise Will Succeed!!'");
								System.out.println("");
								System.out.println("Do You Wish To Try And Cross The Bridge, Yes Or No?");
								
								boolean BridgeChoiceMade = false;
								
								while(BridgeChoiceMade == false){
									String CrossBridge = input.nextLine();
									
									if(CrossBridge.equals("No")){
										System.out.println("You Decide Not To Cross The Bridge And Turn Back.");
										if(Choice.equals("E")){
											xPosition--;
											Bridge = false;
											BridgeChoiceMade = true;
										}
										if(Choice.equals("W")){
											xPosition++;
											Bridge = false;
											BridgeChoiceMade = true;
										}
									}
									if(CrossBridge.equals("Yes")){
										BridgeChoiceMade = true;
										System.out.println("You Decide To Try And Cross The Guardian Bridge...");
										
										int Slat1 = 0;
										int Slat2 = 0;
										int Slat3 = 0;
										boolean SlatsChosen = false;
										
										while(SlatsChosen == false){
											int MinSlat1 = 1; 
											int	MaxSlat1 = BridgeLength;	
											Slat1 = MinSlat1 + (int)(Math.random() * ((MaxSlat1 - MinSlat1) + 1));
											
											int MinSlat2 = 1; 
											int	MaxSlat2 = BridgeLength;	
											Slat2 = MinSlat2 + (int)(Math.random() * ((MaxSlat2 - MinSlat2) + 1));
											
											int MinSlat3 = 1; 
											int	MaxSlat3 = BridgeLength;	
											Slat3 = MinSlat3 + (int)(Math.random() * ((MaxSlat3 - MinSlat3) + 1));
											
											if(Diff.equals("Easy")){
												Slat3 = 0;
											}
											
											if(Slat1 != Slat2 && Slat1 != Slat3 && Slat2 != Slat3){
												SlatsChosen = true;
											}
										}
										
										boolean BridgeGame = true;
										int CurrentSlat = 0;
										
										System.out.println("Choose Either Step Or Jump To Make Your Way Across The Bridge.");
										
										boolean ChanceUsed = false;
										
										while(BridgeGame == true){
											
											String StepOrJump = input.nextLine();
											
											if(CurrentSlat > BridgeLength){
												System.out.println("You Have Made It Across The Bridge Safely!!");
												System.out.println("As You Looks Back To See What You Have Just Crossed, You Notice That The Slats All Move Around And Fix Themselves...");
												System.out.println("Clearly There Is No Use Remembering The Pattern.");
												BridgeGame = false;
												if(Choice.equals("E")){
													xPosition = 4;
													yPosition = 8;
												}
												if(Choice.equals("W")){
													xPosition = 1;
													yPosition = 8;
												}
											}
											
											else if(StepOrJump.equals("Step")){
												CurrentSlat = CurrentSlat + 1;
												if((CurrentSlat == Slat1 || CurrentSlat == Slat2 || CurrentSlat == Slat3) && ChanceUsed == false){
													System.out.println("The Wood Creaks Loudly Underneath You...");
													System.out.println("Suddenly The Slat You're On Begins To Give Way!!");
													System.out.println("Luckily There Is Enough Time To Decide Your Next Move...");
													ChanceUsed = true;
												}
												else if((CurrentSlat == Slat1 || CurrentSlat == Slat2 || CurrentSlat == Slat3) && ChanceUsed == true){
													System.out.println("The Wood Creaks Loudly Underneath You...");
													System.out.println("There Is No Time To React Before It Gives Way. You Plummet Down Towards The Lake");
													System.out.println("And Crash Into The Water, Not Realising That Below The Surface Are Jagged Rocks!!");
													System.out.println("They Tear Through Your Body, Turning The Pool Into A Rest Mist Of Blood.");
													System.out.println("...GAME OVER");
													Lose = true;
													BridgeGame = false;
												}
												else {
													System.out.println("The Slat You're On Seems Stable. You Are Safe To Make Your Next Move...");
												}
											}
											else if(StepOrJump.equals("Jump")){
												if(CurrentSlat == Slat1 || CurrentSlat == Slat2 || CurrentSlat == Slat3){
													System.out.println("You Land Heavily On The Slat And It Immediately Gives Way Beneath You...");
													System.out.println("You Fall Towards The Lake, Not Realising That Below The Surface Are Jagged Rocks!!");
													System.out.println("They Tear Through Your Body, Turning The Water Into A Rest Mist Of Blood.");
													System.out.println("...GAME OVER");
													Lose = true;
													BridgeGame = false;
												}
												else {
													System.out.println("The Slat You're On Seems Stable. You Are Safe To Make Your Next Move...");
													CurrentSlat = CurrentSlat + 2;
												}
											}
											else {
												System.out.println("Please Choose Either Step Or Jump.");
											}
											
										}
										
										
									}
									if(BridgeChoiceMade == false){
										System.out.println("Please Choose Either Yes Or No.");
									}
								}
							}
						}
					}
					if((xPosition == 2 && yPosition == 8 && Bridge == false) || (xPosition == 3 && yPosition == 8 && Bridge == false)){
						System.out.println("You Continue Into The Lake. You Can No Longer Reach The Bottom.");
						System.out.println("Above You Is A Glowing Bridge. The Slats On The Bridge Appear To Be Rotten, It's Impossible To Tell Which Are Safe.");
						System.out.println("To The Immediate North Is A Steep Cliff, With Thick Forest On Top.");
						System.out.println("The Only Way To Go Is Back South.");
					}
					if(xPosition == 4 && yPosition == 8){
						if(Bridge == false && Choice.equals("E")){
							System.out.println("There Is A Steep Cliff Blocking Your Path...");
							xPosition--;
						}
						if(Choice.equals("W")){
							Bridge = true;
						}
						if(Choice.equals("N") || Choice.equals("S") || Choice.equals("W")){
							System.out.println("You Are Up High Here, But Looking Down At Your Surroundings There Is Little You Can See Through The Tree Tops.");
							System.out.println("What You Do Know If That You Are At The Edge Of A Cliff Overlooking A Large Lake.");
							System.out.println("To Your West There Is A Bridge Crossing Over The Lake To The Cliff On The Other Side.");
							System.out.println("You Can Make Out Something To The South West Though...");
							System.out.println("");
							
							if(OgreMet == false){
								System.out.println("You Can See A Giant Ogre Trudging Around One Corner Of The Lake!");
								System.out.println("It Looks At Least 10ft Tall And Incredibly Powerful, But It Is Not Clear If It Is Friend Or Foe..");
								System.out.println("Unfortunately, In Order To Find Out You Will Need To Travel A Long Way Around To Get Down To The Lake.");
							}
							if(OgreMet == true && OgreKilled == false){
								System.out.println("It's The Ogre You met Earlier, Wandering Around The Corner Of The Lake.");
							}
							if(OgreKilled == true){
								System.out.println("It's The Corpse Of The Ogre You Killed Earlier, Floating In The Water.");
							}
						}
					}
					if(xPosition == 5 && yPosition == 8){
						
						if(ZipWire == false){
							System.out.println("There Doesn't Seem To Be Much In This Area At First Glance.");
							System.out.println("But On The Floor You Notice A Slightly Worn Path...");
							System.out.println("Intrigued, You Follow The Path. It Leads You Up To A Wooden Structure That Looks A Little Like A Viewing Platform.");
							System.out.println("");
							System.out.println("You Climb The 8ft Ladder Up Onto The Platform And Realise That It's Actually A Stand For A ZipWire!");
							System.out.println("It's Impossible To See Where The Wire Ends Up As It Disappears Into The Trees.");
							System.out.println("You Notice There Is No Mechanism For Bringing The Rail Back Up To The Top, Meaning That This Can Only Be Used Once.");
							System.out.println("");
							System.out.println("Do You Want To Use It Now, Yes Or No?");
							
							boolean ZipChoiceMade = false;
							while (ZipChoiceMade == false){
								String ZipChoice = input.nextLine();
								
								if(ZipChoice.equals("No")){
									System.out.println("You Decide Not To Use It Now.");
									ZipChoiceMade = true;
								}
								else if(ZipChoice.equals("Yes")){
									System.out.println("You Decide To Use The Zip Wire!!");
									System.out.println("");
									System.out.println("You Take A Tight Grip Of The Metal Hand Rail And Launch Yourself Forwards...");
									System.out.println("Gliding Through The Trees At Some Speed You Struggle To See, But Your Grip Does Not Loosen.");
									System.out.println("You Can't Help Thinking That This Is The Most Fun You've Had In A Long Time!!");
									System.out.println("");
									System.out.println("You Arrive At The Bottom With A Crash, And Rest While Your Pulse Returns To Normal.");
									ZipWire = true;
									ZipChoiceMade = true;
									xPosition = 4;
									yPosition = 5;
								}
								else {
									System.out.println("Please Choose Either Yes Or No.");
								}
							}
						}
						if(ZipWire == true){
							System.out.println("You Have Already Used The Zip Wire Here. There Is Nothing Else Of Interest In This Area.");
						}
						Bridge = false;
					}
					if(xPosition == 6 && yPosition == 8){
						System.out.println("There is Nothing Interesting In This Area...");
					}
				
				}
			
				if(Area == 4){
					
					//these are to remove any default changes made to the x and y positions
					if (Choice.equals("N")){
						yPosition--;
					}
					if (Choice.equals("E") && EnteredMaze == true){
						xPosition--;
					}
					if (Choice.equals("S") && EnteredMaze == true){
						yPosition++;
					}
					if (Choice.equals("W") && EnteredMaze == true){
						xPosition++;
					}
					
					//setting how much food can be carried. updates each time a medallion piece is found
					int MaxFood = 0;
					if(Diff.equals("Easy")){
						MaxFood = 15 + FoodBag - MedallionPieces;
					}
					if(Diff.equals("Hard")){
						MaxFood = 10 + FoodBag - MedallionPieces;
					}
					
					if(Food > MaxFood){
						Food = MaxFood;
					}
					
					//randomising location where food can be found each time.
					int MinFoodRandomX = 1; 
					int	MaxFoodRandomX = 5;	
					int FoodRandomX1 = MinFoodRandomX + (int)(Math.random() * ((MaxFoodRandomX - MinFoodRandomX) + 1));
					int FoodRandomX2 = MinFoodRandomX + (int)(Math.random() * ((MaxFoodRandomX - MinFoodRandomX) + 1));
					int FoodRandomX3 = MinFoodRandomX + (int)(Math.random() * ((MaxFoodRandomX - MinFoodRandomX) + 1));
					
					int MinFoodRandomY = 10; 
					int	MaxFoodRandomY = 13;	
					int FoodRandomY1 = MinFoodRandomY + (int)(Math.random() * ((MaxFoodRandomY - MinFoodRandomY) + 1));
					int FoodRandomY2 = MinFoodRandomY + (int)(Math.random() * ((MaxFoodRandomY - MinFoodRandomY) + 1));	
					int FoodRandomY3 = MinFoodRandomY + (int)(Math.random() * ((MaxFoodRandomY - MinFoodRandomY) + 1));	
					
					//randomising location where medallion pieces can be found
					while(MedallionPosition == false){
						int MinMedallionRandomX = 1; 
						int	MaxMedallionRandomX = 5;	
						MedallionRandomX1 = MinMedallionRandomX + (int)(Math.random() * ((MaxMedallionRandomX - MinMedallionRandomX) + 1));
						MedallionRandomX2 = MinMedallionRandomX + (int)(Math.random() * ((MaxMedallionRandomX - MinMedallionRandomX) + 1));
						MedallionRandomX3 = MinMedallionRandomX + (int)(Math.random() * ((MaxMedallionRandomX - MinMedallionRandomX) + 1));
						
						int MinMedallionRandomY = 10; 
						int	MaxMedallionRandomY = 13;	
						MedallionRandomY1 = MinMedallionRandomY + (int)(Math.random() * ((MaxMedallionRandomY - MinMedallionRandomY) + 1));
						MedallionRandomY2 = MinMedallionRandomY + (int)(Math.random() * ((MaxMedallionRandomY - MinMedallionRandomY) + 1));	
						MedallionRandomY3 = MinMedallionRandomY + (int)(Math.random() * ((MaxMedallionRandomY - MinMedallionRandomY) + 1));	
						
						String Medallion1 = (MedallionRandomX1 + "," + MedallionRandomY1);
						String Medallion2 = (MedallionRandomX2 + "," + MedallionRandomY2);
						String Medallion3 = (MedallionRandomX3 + "," + MedallionRandomY3);
						
						if((Medallion1 != Medallion2) && (Medallion1 != Medallion3) && (Medallion2 != Medallion3)){
							if(Medallion1 == "4,12" || Medallion2 == "4,12" || Medallion3 == "4,12"){
							}
							else {
								MedallionPosition = true;
							}
						}
					}
					
					//checking coordinates to see if food or medallion piece needs to be given
					if((xPosition == FoodRandomX1 && yPosition == FoodRandomY1) || (xPosition == FoodRandomX2 && yPosition == FoodRandomY2) || (xPosition == FoodRandomX3 && yPosition == FoodRandomY3)){
						System.out.println("You Find A Hidden Stash Of Food. You Take As Much As You Can Carry, Meaning You Now Have " + MaxFood + " Days Worth Of Food.");
						System.out.println("");
						Food = MaxFood;
					}
					
					if(xPosition == MedallionRandomX1 && yPosition == MedallionRandomY1 && Medallion1Found == false){
						System.out.println("You Have Found A Piece Of The Medallion! To Make Room For It You Can Now Carry One Days Worth Of Food Less Than Before.");
						MedallionPieces++;
						System.out.println(">>>You Now Have " + MedallionPieces + " Medallion Pieces!<<<");
						Medallion1Found = true;
					}
					if(xPosition == MedallionRandomX2 && yPosition == MedallionRandomY2 && Medallion2Found == false){
						System.out.println("You Have Found A Piece Of The Medallion! To Make Room For It You Can Now Carry One Days Worth Of Food Less Than Before.");
						MedallionPieces++;
						System.out.println(">>>You Now Have " + MedallionPieces + " Medallion Pieces!<<<");
						Medallion2Found = true;
					}
					if(xPosition == MedallionRandomX3 && yPosition == MedallionRandomY3 && Medallion3Found == false){
						System.out.println("You Have Found A Piece Of The Medallion! To Make Room For It You Can Now Carry One Days Worth Of Food Less Than Before.");
						MedallionPieces++;
						System.out.println(">>>You Now Have " + MedallionPieces + " Medallion Pieces!<<<");
						Medallion3Found = true;
					}
					if(MedallionPieces == 3 && MedallionComplete == false){
						System.out.println("You Have Found All Of The Medallion Pieces!!");
						System.out.println("You Carefully Line Them Up And Connect Them. As Soon As you Do The Medallion Starts To Emit A Faint Glow...");
						System.out.println("All That's Left To Do Now Is To Find The Golden Door...");
						System.out.println("");
						MedallionComplete = true;
					}
					
					//countdown when running out of food
					if(Food == 3){
						System.out.println("You Only Have 3 Days Worth Of Food Left!");
						System.out.println("");
					}
					if(Food == 2){
						System.out.println("You Only Have 2 Days Worth Of Food Left!");
						System.out.println("");
					}
					if(Food == 1){
						System.out.println("You Only Have 1 Days Worth Of Food Left!");
						System.out.println("");
					}
					if(Food == 0){
						System.out.println("YOU HAVE NO FOOD LEFT. YOU MUST FIND SOME IN THIS AREA!!");
						System.out.println("");
					}
					
					
					//this is used to make sure each choice goes somewhere or needs to be made again.
					boolean GoodChoice = false;
	
					//first time 4 is entered
					if(Area4Entered == false){
						System.out.println("...Press Enter To Continue...");
						input.nextLine();
						System.out.println("You Walk Into The Tree And Begin Climbing The Wooden Ladder. It Is Steep, But You Are Strong Enough To Pull Yourself Up To The Top.");
						System.out.println("You Emerge Onto A Small Walkway, High Above The Rainforest. From Here You Can See Everywhere You Have Been In This Forest, And Also Dangers You Somehow Managed To Avoid...");
						System.out.println("You Can Hear The Birds Chirping Through A Small Hole In The Glass Roof, But All You Can See Outside Is Blue Sky...");
						System.out.println("It's Enough To Give You Hope.");
						System.out.println("");
						System.out.println("You Don't Spend Too Long Admiring The View As You Have More Pressing Matters To Deal With, Like Getting The Hell Out Of Here!!");
						System.out.println("You Sprint As Fast As You Can Along The Walkway, Reaching A Door At The North End. You Pray To God That The Door Is Unlocked...");
						System.out.println("");
						System.out.println("Yes! Finally Some Luck!! You Burst Through The Door And Find Yourself On A Large Open Roof Top... You're Finally Out In The Real World!!");
						System.out.println("But It Is Immediately Clear You Are Not Yet Free...");
						System.out.println("... Press Enter To Continue...");
						input.nextLine();
						xPosition = 1;
						yPosition = 10;
						Area4Entered = true;
					}
					
					// first row
					if(xPosition == 1 && yPosition == 10){
						
						//first time 4 is entered
						if(FourExplained == false){
							System.out.println("You Can Hardly Believe What You Are Seeing...");
							System.out.println("In Front Of You Is A Bewildering Setup Of Long Tunnels And Low Bridges Spiralling Off In Completely Random Directions.");
							System.out.println("The Rooftop Is Completely Covered In Them! It Is Going To Be Nearly Impossible To Keep Track Of Where You Are Or Where You Are Going!");
							System.out.println("You're Only Choice Is To Guess And Hope...");
							System.out.println("");
							System.out.println("There Is A Notice Next To You In This Section. It Seems To Contain A Hint:");
							System.out.println("'Unite The Pieces " + Name + ", And Find The Golden Door... This Will Be Your Salvation.'");
							System.out.println("");
							System.out.println("Glistening In A Shallow Pool Of Water At Your Feet You See The Image Of A Medallion, Beautifully Crafted To Show A Large Golden Door.");
							System.out.println("It Is Clear That The Medallion Is Made Up Of 3 Parts. Apparently Finding These Parts Is What You Need To Do...");
							System.out.println("");
							System.out.println("...Press Enter To Continue...");
							input.nextLine();
							System.out.println("Stepping Over The Water You Notice Something Unexpected...");
							System.out.println("From A Different Angle It No Longer Looks Like A Medallion, But Instead Like A Flame...");
							System.out.println("");
							System.out.println("Suddenly, As If Perfectly Timed, You Here A Whistling Sound...");
							System.out.println("A Fiery Arrow Strikes Your Backpack, Setting It Alight!! Reacting On Instinct You Throw The Bag Into The Water To Extinguish The Flames!");
							System.out.println("");
							System.out.println("The Bag Is Badly Burnt And Broken. You Have No Choice But To Throw It Away.");
							System.out.println("You Can Now Only Carry Food In Your Pockets. This Means A Maximum Of " + MaxFood + " Days Worth Of Food!");
							System.out.println("There Is A Bowl Of Food Deliberately Left To The Side, It Gives You A Chance At Least. You Stock Up With All you Can Carry.");
							System.out.println("Unfortunately, This Also Means You Must Leave Any Discovered Items Behind.");
							if(Magic == true){
								System.out.println("However, Your Magic Is Within You And Will Never Be Left Behind.");
							}
							System.out.println("Choose A Direction To Travel...");
							Sword = false;
							Ring = false;
							KeyFound = false;
							FourExplained = true;
							Food = MaxFood;
						}
						
						else {
							System.out.println("You Are Back In The Area Where You Entered The Rooftop. Your Items And Bag Are Still On The Floor.");
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 2;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 2 && yPosition == 10){
						System.out.println("You Have Walked Into A Dead End!! You Feel Distraught As It Means the Food Used To Get Here Has Been Wasted.");
						System.out.println("");
						if(StatueFought == false){
							System.out.println("Then, In The Corner Of The Area, Against A Large Statue Of A Three Headed Beast, You Spot A Small Carrier Bag!");
							System.out.println("Never Before Have You Been So Excited To See A Bag! With It You Can Carry More Food...");
							System.out.println("You Approach The Statue And Reach Out To Grab The Bag Before It Blows Away, But As You Do You Hear A Growl...");
							System.out.println("");
							System.out.println("A Voice Begins To Bellow Out From Within The Statue. It Says:");
							System.out.println("'You Must Duel The Three Heads If You Wish To Take The Bag...'");
							
							boolean StatueBattle = true;
							boolean BagTaken = false;
							
							while(StatueBattle == true){
								if(Magic == true){
									System.out.println("Before The Statue Can Finish You Mutter The Magic Words, Firing A Quick Bolt Of Lightning At It...");
									System.out.println("Its Enough To Disintegrate The Statue Completely, Leaving You Free To Pick Up The Bag...");
									System.out.println("Nothing Can Challenge You When You Have This Power Flowing In Your Veins!");
									StatueFought = true;
									StatueBattle = false;
									BagTaken = true;
								}
								else {
									System.out.println("In Each Round, One Of The Three Heads Will Shoot Out A Ball Of Fire.");
									System.out.println("Before The Round, You Must Choose A Platform To Stand On Infront Of The Head That You Won't Shoot Fire.");
									System.out.println("There Will Be 4 Rounds In Total.");
									System.out.println("");
									System.out.println("This Is A Game Of Luck, Pray Your Luck Does Not Run Out...");
									
									boolean BagGame = false;
									int RoundsSurvived = 0;
									
									while(BagGame == false){
	
										int Platform = 0;

										int MinFire = 1; 
										int	MaxFire = 3;	
										int Fire = MinFire + (int)(Math.random() * ((MaxFire - MinFire) + 1));
										
										boolean BagChoice = false;
										while(BagChoice == false){
											System.out.println("Choose To Stand In Front Of Statue Head 1, 2 Or 3...");
											
											boolean IntegerChosen = false;
											while(IntegerChosen == false){
												if(input.hasNextInt()){
													   Platform = input.nextInt();
													   IntegerChosen = true;
													}else{
														System.out.println("Please Choose Either 1, 2 Or 3.");
													   input.next();
													}
											}
											if(Platform == 1 || Platform == 2 || Platform == 3){
												BagChoice = true;
											}
											else {
												System.out.println("Invalid Choice.");
											}
										}
										if(Platform == Fire){
											System.out.println("");
											System.out.println("You Have Chosen Wrong!!");
											System.out.println("");
											System.out.println("The Ball Of Fire Roars Out Of The Statue Head In Front Of You...");
											System.out.println("But You Manage To Duck In Time To Avoid Certain Death!!!");
											System.out.println("");
											System.out.println("The Statue Lets Out A Roar Of Anger... And Then Aims A Head At The Bag...");
											System.out.println("And With A Quick Blaze Of Fire The Bag Is Destroyed, But At Least You Can Leave With Your Life.");
											System.out.println("");
											BagGame = true;
											StatueBattle = false;
											StatueFought = true;
										}
										else {
											System.out.println("");
											System.out.println("You Wait To See What Happens...");
											System.out.println("To You Relief You Have Chosen Correctly! The Ball Of Fire Soars Just Past Your Head.");
											RoundsSurvived++;
											System.out.println("You Have " + (4 - RoundsSurvived) + " Rounds Left To Survive!");
										}
										if(RoundsSurvived == 4){
											System.out.println("");
											System.out.println("You Are Able To Freely Go And Collect The Bag!!");
											BagTaken = true;
											StatueBattle = false;
											BagGame = true;
											StatueFought = true;
											}
										}
										if(Diff.equals("Easy") && BagTaken == true ){
											FoodBag = 6;
											System.out.println("You Can Now Carry An Extra " + FoodBag + " Days Worth Of Food.");
										}
										if(Diff.equals("Hard") && BagTaken == true){
											FoodBag = 4;
											System.out.println("You Can Now Carry An Extra " + FoodBag + " Days Worth Of Food.");
										}	
								}
							}
						}
						else if(StatueFought == true){
							System.out.println("This Is Where You Battled The 3 Headed Statue.");
						}
						
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 3;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E") || Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 3 && yPosition == 10){
						System.out.println("This Area Seems Empty. There Is Nothing To Be Done Here.");
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 1;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 5;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 4 && yPosition == 10){
						
						if(PulleyBeast == false){
							System.out.println("Entering This Area You Take An Immediate Step Backwards And Try To Be As Silent As Possible...");
							System.out.println("In The Corner Of The Area Is A Large Cage, And Inside It Is A Sleeping Beast!!");
							System.out.println("");
							System.out.println("The Beast Looks Like A Large Bear Crossed With A Wolf, And Must Be At Least 15ft Tall With Pitch Black Fur.");
							System.out.println("Luckily, You Can Navigate This Area Slowly And Quietly Without Waking It Up...");
						}
						else if(PulleyBeast == true && BeastSurvived == false){
							System.out.println("Entering This Area You Immediately Feel Uneasy...");
							System.out.println("In The Corner Is A Large Metal Cage, With Thick Steel Bars Designed To Keep Something Large Inside.");
							System.out.println("Some Of The Bars Have Been Bent Out Of Place Leaving A Large Gap In The Cage...");
							System.out.println("");
							System.out.println("You Frantically Look Around, Trying To Find Any Clues About Where Whatever Had Been Caged May Have Gone So You Can Avoid It...");
							System.out.println("...But You Never Thought To Look Up...");
							System.out.println("");
							System.out.println("Press Enter To Continue...");
							input.nextLine();
							
							System.out.println("You Stop, Listening Now For Any Signs Of Movement...");
							System.out.println("You Can Make Out Some Noise. Concentrating, You Try To Figure Out What It Is...");
							System.out.println("Suddenly You Realise The Source Of the Noise, And A Deep Chill Courses Through Your Body...");
							System.out.println("You Can Hear Deep Breathing Coming From Directly Above You, And You Can Feel The Warm Breath On The Top Of Your Head...");
							System.out.println("");
							System.out.println("Slowly, You Raise Your Head And Look Up, But You Immediately Wish You Hadn't.");
							System.out.println("Staring Straight Back At You Are The Giant Yellow Eyes Of A Monster Who Is Hanging From The Beams Above!!");
							System.out.println("It Looks Like A Cross Between A Bear And A Wolf, With Pitch Black Fur, And At least 15ft Tall...");
							System.out.println("");
							System.out.println("You Need To Act Quickly, Deciding Whether To Stand Your Ground Or Try To Run...");
							System.out.println("Do You Want To Stand Or Run??");
							
							boolean StandRunMade = false;
							while(StandRunMade == false){
								String StandRun = input.nextLine();
								if(StandRun.equals("Stand")){
									StandRunMade = true;
									int MinStand = 1; 
									int	MaxStand = 2;	
									int Stand = MinStand + (int)(Math.random() * ((MaxStand - MinStand) + 1));
									
									System.out.println("You Realise There Is Very Little Chance Of Being Able To Outrun This Beast, Leaving Only The Option To Stand Your Ground.");
									System.out.println("");
									System.out.println("As You Wait There The Beast Comes Down From The Beams And Stands Up Tall Directly In Front Of You...");
									System.out.println("It Can See The Fear In Your Eyes...");
									System.out.println("");
									System.out.println("It Comes Right Up To You, Teeth Baring And Growling. You Can Smell It's Rancid Breath...");
									
									if(Stand == 1){
										System.out.println("");
										System.out.println("It Pauses For A Moment, But Senses There Is More To You Than Just A Scared And Weary Human.");
										System.out.println("Fearing An Unknown Threat The Beast Pounces, Leaving You Little Time To Try And Stop It From tearing You To Shreds!");
										System.out.println("You Struggle And Try To Escape, But Within Moments It Is All Over. There Was Nothing You Could Do...");
										System.out.println("...GAME OVER");
										Lose = true;
										
									}
									else if(Stand == 2){
										System.out.println("The Beast Continues To Look Deep Into Your Eyes, It Is Trying To Figure Out If You Are A Threat...");
										System.out.println("...");
										System.out.println("After What Seemed Like An Eternity, It Stops Growling And Instead Sniffs Your Pockets.");
										System.out.println("Realising It Wants Your Food, You Slowly Take Out 2 Days Worth And Place It On The Floor In Front Of The Animal...");
										System.out.println("It Then Takes The Food, And Turns And Slowly Walks Away. You Take This As Your Chance To Leave...");
										BeastSurvived = true; 
										Food = Food - 2;
									}
									
								}
								else if(StandRun.equals("Run")){
									StandRunMade = true;
									int MinRun = 1; 
									int	MaxRun = 3;	
									int Run = MinRun + (int)(Math.random() * ((MaxRun - MinRun) + 1));
									
									if(Run == 1 || Run == 2){
										System.out.println("");
										System.out.println("Not Wanting To Wait Around To Be Killed You Turn And Run From The Beast...");
										System.out.println("But It Is Far Too Quick For You. Within Moments It Has Caught Up And Is Tearing Through Your Flesh.");
										System.out.println("");
										System.out.println("The Pain Doesn't Last long, It Is Over Quickly...");
										System.out.println("...GAME OVER");
										Lose = true;
									}
									else if(Run == 3){
										System.out.println("You Know You Need To Run Before Being Killed, But There Is No Way You Can Outpace This Creature...");
										System.out.println("Your Only Chance Is To Hope That The Beast Is Not As Agile As You.");
										System.out.println("");
										System.out.println("You Turn To Run, But Quickly Change Direction. As You Do The Beast Leaps Over You, Clearly Not Expecting The Sudden Turn...");
										System.out.println("You Sprint Staright Towards A Wall... You Can Hear The Animal Getting Near Behind You...");
										System.out.println("Just Before The Wall You Turn Again And Dive Out Of The Way... The Beast Is Not So Quick To React...");
										System.out.println("It Crashes Into The Wall, And Falls To The Floor With A Pained Cry.");
										System.out.println("");
										System.out.println("Realising It Can't Outsmart You The Beast Limps Off Into The Corner Of The Area, Never Taking It's Eyes Off You.");
										System.out.println("You Have Survived, And Can Now Freely Leave This Area...");
										BeastSurvived = true;
									}
								}
								else {
									System.out.println("Invalid Choice. Please Choose To Either 'Stand' Or 'Run'.");
								}
							}
						}
						else if(PulleyBeast == true && BeastSurvived == true){
							System.out.println("The Beast Is Still In This Area, But It No Longer Considers You A Target.");
							System.out.println("You Are Safe To Walk Through, Just Dont Make Any Sudden Moves.");
						}
						
						while(GoodChoice == false && Lose == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 5;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 5;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 1;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 5 && yPosition == 10){
						System.out.println("You Have Come To A Dead End. The Only Way Back Out Of Here is To Go East.");
						System.out.println("In The Centre Of This Section Is A Tall Metal Ladder, Leading Up Onto A Small Platform.");
						System.out.println("Do You Wish To Climb Up To The Platform, Yes Or No?");
						
						boolean TowerChoiceMade = false;
						while(TowerChoiceMade == false){
							String TowerChoice = input.nextLine();
							if(TowerChoice.equals("Yes")){
								System.out.println("You Decide To Climb Up.");
								System.out.println("As You Climb Up The Ladder And Onto The Platform You Realise You Can See Clearly Some Of The Paths Around You.");
								System.out.println("It Is Also Clear That You Are In The Far Southeast Of The Rooftop.");
								System.out.println("");
								System.out.println("You Take Note Of Some Of The Paths And Conlcude That It Your Next Few Choices Should Probably Be East, North, North, West.");
								System.out.println("From There You Are Near the Centre Of The Maze, And Hopefully You Can Find The Golden Door Nearby.");
								System.out.println("Better Still, There Is A Stash Of Food Up On This Platform. You Fill Your Pockets Until They Are Full And Carry On.");
								System.out.println("");
								System.out.println("You Now Have " + MaxFood + " Days Worth Of Food!");
								TowerChoiceMade = true;
								Food = MaxFood;
							}
							else if(TowerChoice.equals("No")){
								System.out.println("You Decide Not To Climb Up To The Platform.");
								TowerChoiceMade = true;
							}
							else {
								System.out.println("Please Choose Either Yes Or No.");
							}
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					// second row
					else if(xPosition == 1 && yPosition == 11){
							System.out.println("You Enter A Pitch Black Room. The Door Slams Shut Behind You...");
							System.out.println("");
							
							
							if(DarkRoom == true){
								System.out.println("You Need To Solve The Grid Puzzle Once Again...");
								System.out.println("At Least This Time You Know What To Expect.");
							}
							if(DarkRoom == false){
								System.out.println("Suddenly, The Floor Begins To Light Up. Piece By Piece It Seems To Be Revealing Some Sort Of Grid...");
								System.out.println("Eventually, The FLoor Is Completely Covered In A Huge 10x10 Grid Made Up Of Light Blue Neon Lights.");
								System.out.println("You Have No Idea What To Make Of This And So Stand Completely Still....");
								System.out.println("");
								System.out.println("Eventually, Some Writing Lights Up On The Far Wall Ahead Of You. It Reads:");
								System.out.println("'A Countdown Will Shortly Begin. You Must Stand In The Correct Position In Order To Stop The Grid From Fading Entirely, Leaving You In Total Darkness...'");
								System.out.println("'Starting From 100, A Random Number Between 1 And 8 Will Be Removed. You Must Guess What The New Number Will Be And Stand In The Correct Position.'");
								System.out.println("'If You Are Correct, The Lights Will Come On And You Will Be Free To Leave...'");
								System.out.println("'But If You Are Wrong, Then The Countdown Continues And Another Random Number Will Be Taken Away.'");
								System.out.println("'Should The Countdown Reach Zero, You Will Be Offered To The Eternal Darkness...'");
								System.out.println("");
								DarkRoom = true;
							}
							
							int GridAnswer = 100;
							boolean Grid90 = false;
							boolean Grid80 = false;
							boolean Grid70 = false;
							boolean Grid60 = false;
							boolean Grid50 = false;
							boolean Grid40 = false;
							boolean Grid30 = false;
							boolean Grid20 = false;
							boolean Grid10 = false;
							
							boolean GridGame = true;
							while(GridGame == true){
								System.out.println("Select The Position On The Grid You Wish To Stand...");
								boolean IntegerChosen = false;
								int GridChoice = 0;
								while(IntegerChosen == false){
									if(input.hasNextInt()){
										   GridChoice = input.nextInt();
										   if(GridChoice > 0 && GridChoice <= 100){
											   IntegerChosen = true;
										   }
										   else {
											   System.out.println("The Number Must Be Between 1 And 100.");
										   }
										}else{
											System.out.println("Please Choose An Integer.");
										   input.next();
										}
								}

								int MinGridChange = 1; 
								int	MaxGridChange = 8;	
								int GridChange = MinGridChange + (int)(Math.random() * ((MaxGridChange - MinGridChange) + 1));
								
								GridAnswer = GridAnswer - GridChange;
								
								
								if(GridChoice == GridAnswer){
									System.out.println("Correct!! You Chose The Right Grid To Stand On...");
									System.out.println("");
									System.out.println("The Lights Switch On In The Room, And All Doors Leading Out Swing Open.");
									System.out.println("You Are Free To Leave.");
									GridGame = false;
								}
								
								else {
									
									System.out.println("WRONG!! The Number Had Been Reduced By " + GridChange);
									System.out.println("");
									
									if(Grid90 == false && GridAnswer <= 90){
										System.out.println(">>>The Countdown Has Now Passed 90<<<");
										System.out.println("");
										Grid90 = true;
									}
									if(Grid80 == false && GridAnswer <= 80){
										System.out.println(">>>The Countdown Has Now Passed 80<<<");
										System.out.println("");
										Grid80 = true;
									}
									if(Grid70 == false && GridAnswer <= 70){
										System.out.println(">>>The Countdown Has Now Passed 70<<<");
										System.out.println("");
										Grid70 = true;
									}
									if(Grid60 == false && GridAnswer <= 60){
										System.out.println(">>>The Countdown Has Now Passed 60<<<");
										System.out.println("");
										Grid60 = true;
									}
									if(Grid50 == false && GridAnswer <= 50){
										System.out.println(">>>The Countdown Has Now Passed 50<<<");
										System.out.println("");
										Grid50 = true;
									}
									if(Grid40 == false && GridAnswer <= 40){
										System.out.println(">>>The Countdown Has Now Passed 40<<<");
										System.out.println("");
										Grid40 = true;
									}
									if(Grid30 == false && GridAnswer <= 30){
										System.out.println(">>>The Countdown Has Now Passed 30<<<");
										System.out.println("");
										Grid30 = true;
									}
									if(Grid20 == false && GridAnswer <= 20){
										System.out.println(">>>The Countdown Has Now Passed 20<<<");
										System.out.println("");
										Grid20 = true;
									}
									if(Grid10 == false && GridAnswer <= 10){
										System.out.println(">>>The Countdown Has Now Passed 10<<<");
										System.out.println("");
										Grid10 = true;
									}
									
									if(GridAnswer <= 0){
										System.out.println("The Countdown Has Reached Zero!!");
										System.out.println("All The Lights Turn Out, Leaving You Immersed In Complete Darkness.");
										System.out.println("");
										System.out.println("You Fumble Around The Edge Of Walls, But All The Doors Are Locked Shut.");
										System.out.println("You Are Left To Starve In This Place...");
										Food = 0;
										GridGame = false;
									}
								}
							}
							
							
						while(GoodChoice == false && Food > 0){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 1;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 3;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 3;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 2 && yPosition == 11){
						System.out.println("This Area Seems Empty. There Is Nothing To Be Done Here.");
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 2;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 1;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 3 && yPosition == 11){
						System.out.println("This Area Seems Empty. There Is Nothing To Be Done Here.");
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 1;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 2;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E") || Choice.equals("S")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 4 && yPosition == 11){
						
						int MaxWrong = 0;
						
						if(Diff.equals("Easy")){
							MaxWrong = 5;
						}
						if(Diff.equals("Hard")){
							MaxWrong = 4;
						}
						
						System.out.println("You Have Come Across A Door Blocking The Way.");
						System.out.println("This Door Seems To Have An Unusual Locking System. It Requires You To Guess Whether The Next Number Will Be Higher Or Lower Than The Previous One.");
						System.out.println("All Numbers Will Be Between 1 And 100. Getting The Answer Correct Will Light Up A Bulb.");
						System.out.println("You Need To Light Up All 10 Bulbs In Order To Open The Door, But Get An Answer Wrong And 2 Bulbs Will Go Out.");
						System.out.println("Get It Wrong " + MaxWrong + " Times And You Must Sacrifice A Days Worth Of Food To Start Over. Your First Number Is 1...");
						System.out.println("");
						
						boolean HighLowGame = false;
						
						int PreviousNumber = 0;
						int CurrentNumber = 1;
						int BulbsLit = 0;
						int WrongAnswers = 0;
						
						while(HighLowGame == false){
							
							if(BulbsLit < 0){
								BulbsLit = 0;
							}
							
							System.out.println("");
							System.out.println("You Have " + Food + " Days Worth Of Food Remaining.");
							System.out.println("");
							PreviousNumber = CurrentNumber;
							
							int MinCurrentNum = 1; 
							int	MaxCurrentNum = 100;	
							CurrentNumber = MinCurrentNum + (int)(Math.random() * ((MaxCurrentNum - MinCurrentNum) + 1));
							
							boolean ChoiceMade = false;
							while(ChoiceMade == false){
								System.out.println("Please Choose Whether You Think The Next Will Be Higher Than " + PreviousNumber + ".");
								String HighLowGuess = input.nextLine();
								
								if(((HighLowGuess.equals("Higher") || HighLowGuess.equals("H")) && CurrentNumber > PreviousNumber) || ((HighLowGuess.equals("Lower") || HighLowGuess.equals("L")) && CurrentNumber < PreviousNumber)){
									System.out.println("");
									System.out.println("CORRECT!");
									System.out.println("The Number Was " + CurrentNumber + ".");
									System.out.println("A Bulb Lights Up:");
									BulbsLit++;
									ChoiceMade = true;
								}
								else if(((HighLowGuess.equals("Higher") || HighLowGuess.equals("H")) && CurrentNumber <= PreviousNumber) || ((HighLowGuess.equals("Lower") || HighLowGuess.equals("L")) && CurrentNumber >= PreviousNumber)) {
									System.out.println("");
									System.out.println("WRONG.");
									System.out.println("The Number Was " + CurrentNumber + ".");
									System.out.println("Two Bulbs Go Out...");
									BulbsLit = BulbsLit - 2;
									WrongAnswers++;
									ChoiceMade = true;
								}
								else {
									System.out.println("You Need To Enter Either Higher Or Lower (H Or L).");
									System.out.println("");
								}
							}

							if(WrongAnswers == MaxWrong){
								System.out.println("You Have Used All " + MaxWrong + " Chances!!");
								System.out.println("All The Bulbs Go Out, A Day Of Food Must Be Sacrificed, And You Must Start Over...");
								Food--;
								BulbsLit = 0;
								WrongAnswers = 0;
							}
							System.out.println("");
							if(BulbsLit <= 0){
								System.out.println("[ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 1){
								System.out.println("[*] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 2){
								System.out.println("[*] [*] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 3){
								System.out.println("[*] [*] [*] [ ] [ ] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 4){
								System.out.println("[*] [*] [*] [*] [ ] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 5){
								System.out.println("[*] [*] [*] [*] [*] [ ] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 6){
								System.out.println("[*] [*] [*] [*] [*] [*] [ ] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 7){
								System.out.println("[*] [*] [*] [*] [*] [*] [*] [ ] [ ] [ ]");
							}
							else if(BulbsLit == 8){
								System.out.println("[*] [*] [*] [*] [*] [*] [*] [*] [ ] [ ]");
							}
							else if(BulbsLit == 9){
								System.out.println("[*] [*] [*] [*] [*] [*] [*] [*] [*] [ ]");
							}
							else if(BulbsLit == 10){
								System.out.println("[*] [*] [*] [*] [*] [*] [*] [*] [*] [*]");
							}
							
							if(BulbsLit == 10){
								System.out.println("");
								System.out.println("Congratulations, All The Bulbs Are Lit!");
								System.out.println("The Door Swings Open And You Run Through. It Shuts And Locks Again Behind You.");
								System.out.println("");
								System.out.println("Choose A Direction To Travel...");
								HighLowGame = true;
							}
							if(Food == 0){
								System.out.println("You Have Run Out Of Food... GAME OVER");
								HighLowGame = true;
								Lose = true;
							}
						}
						
						
						
						while(GoodChoice == false && Lose == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 5;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 3;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 5 && yPosition == 11){
						System.out.println("In Front Of You Is A Large Pool Of Some Sort Of Liquid. It Shines In The Light And Looks Far Thicker Than Water.");
						System.out.println("Reaching Down And Touching It Confirms What You Thought, It's Thick And Slimy. Falling In Would Not Be Wise.");
						System.out.println("");
						System.out.println("There Are Platforms Spread Out Over The Pool, They Can Be Used To Get Across... But You Suspect It Is Not That Simple.");
						System.out.println("The Platforms Are Arranged In A 1-2-3-2-1 Pattern, You Will Need To Pick Which Ones To Jump On In Order To Get Across.");
						
						int MinPlatform2A = 1; 
						int	MaxPlatform2A = 2;	
						int Platform2A = MinPlatform2A + (int)(Math.random() * ((MaxPlatform2A - MinPlatform2A) + 1));
						
						int MinPlatform3 = 1; 
						int	MaxPlatform3 = 3;	
						int Platform3 = MinPlatform3 + (int)(Math.random() * ((MaxPlatform3 - MinPlatform3) + 1));
						
						int MinPlatform2B = 1; 
						int	MaxPlatform2B = 2;	
						int Platform2B = MinPlatform2B + (int)(Math.random() * ((MaxPlatform2B - MinPlatform2B) + 1));
						
						int FailsAllowed = 0;
						
						if(Diff.equals("Easy")){
							FailsAllowed = 2;
						}
						if(Diff.equals("Hard")){
							FailsAllowed = 1;
						}
						
						boolean PlatformGame = true;
						
						while(PlatformGame == true){
							
							boolean InGame = true;
							
							while(InGame == true){
								
								int FirstPlatform = 0;
								boolean OnePassed = false;
								int SecondPlatform = 0;
								boolean TwoPassed = false;
								int ThirdPlatform = 0;
								boolean ThreePassed = false;
								
								System.out.println("");
								System.out.println("You Step Out Confidently Onto The First Platform. It Is Your Only Choice So It Must Be Safe...");
								System.out.println("");
								System.out.println("It Is. Now You Need To Select Either Platform 1 Or 2 To Jump To...");
								
								boolean FirstChoiceMade = false;
								while(FirstChoiceMade == false){
									FirstPlatform = input.nextInt();
									if(FirstPlatform == 1 || FirstPlatform == 2){
										FirstChoiceMade = true;
									}
									else {
										System.out.println("Please Choose Either 1 Or 2.");
									}
								}
								
								System.out.println("");
								System.out.println("You Have Chosen To Jump Onto Platform Number " + FirstPlatform + "...");
								System.out.println("");
								
								if(FirstPlatform == Platform2A){
									System.out.println("It's Safe!!");
									OnePassed = true;
								}
								else{
									System.out.println("You Land Heavily On The Platform. As You Attempt To Stand Up It Gives Way Underneath You!!!");
									System.out.println("You Fall Into The Pool Of Thick, Slimy Liquid!");
									System.out.println("");
									if(FailsAllowed > 0){
										System.out.println("You Drag Yourself Through The Slime And Towards The Ladder Near The Start. It Takes A Huge Amount Of Energy Away From You.");
										System.out.println("And Now You Have To Start Over, But At Least You Still Have Your Life!!");
									}
									if(FailsAllowed == 0){
										System.out.println("You Try To Move Towards The Ladder At The Start Again, But Your Energy Is Completely Gone...");
										System.out.println("You Cannot Get Your Legs To Move, And Your Arms Are Not Strong Enough To Do All The Work...");
										System.out.println("");
										System.out.println("Eventually You Accept Your Fate And Let Yourself Be Consumed By The Grim Liquid...");
										System.out.println("...GAME OVER");
										PlatformGame = false;
										Lose = true;
									}
									FailsAllowed--;
									InGame = false;
								}
								
								if(OnePassed == true){
									System.out.println("You Now Need To Attempt To Jump To The Next Platform. This Time You Must Pick Either 1, 2 Or 3...");
									
									boolean SecondChoiceMade = false;
									while(SecondChoiceMade == false){
										SecondPlatform = input.nextInt();
										if(SecondPlatform == 1 || SecondPlatform == 2 || SecondPlatform == 3){
											SecondChoiceMade = true;
										}
										else {
											System.out.println("Please Choose Either 1, 2 Or 3.");
										}
									}
									
									System.out.println("");
									System.out.println("You Have Chosen To Jump Onto Platform Number " + SecondPlatform + "...");
									System.out.println("");
									
									if(SecondPlatform == Platform3){
										System.out.println("It's Safe!!");
										TwoPassed = true;
									}
									else{
										System.out.println("You Land Heavily On The Platform. As You Attempt To Stand Up It Gives Way Underneath You!!!");
										System.out.println("You Fall Into The Pool Of Thick, Slimy Liquid!");
										System.out.println("");
										if(FailsAllowed > 0){
											System.out.println("You Drag Yourself Through The Slime And Towards The Ladder Near The Start. It Takes A Huge Amount Of Energy Away From You.");
											System.out.println("And Now You Have To Start Over, But At Least You Still Have Your Life!!");
										}
										if(FailsAllowed == 0){
											System.out.println("You Try To Move Towards The Ladder At The Start Again, But Your Energy Is Completely Gone...");
											System.out.println("You Cannot Get Your Legs To Move, And Your Arms Are Not Strong Enough To Do All The Work...");
											System.out.println("");
											System.out.println("Eventually You Accept Your Fate And Let Yourself Be Consumed By The Grim Liquid...");
											System.out.println("...GAME OVER");
											PlatformGame = false;
											Lose = true;
										}
										FailsAllowed--;
										InGame = false;
									}
								}
								
								if(TwoPassed == true){
									System.out.println("");
									System.out.println("You Now Need To Jump Onto The Third Set Of Platforms. Select Either 1 Or 2.");
									
									boolean ThirdChoiceMade = false;
									while(ThirdChoiceMade == false){
										ThirdPlatform = input.nextInt();
										if(ThirdPlatform == 1 || ThirdPlatform == 2){
											ThirdChoiceMade = true;
										}
										else {
											System.out.println("Please Choose Either 1 Or 2.");
										}
									}
									
									System.out.println("");
									System.out.println("You Have Chosen To Jump Onto Platform Number " + ThirdPlatform + "...");
									System.out.println("");
									
									if(ThirdPlatform == Platform2B){
										System.out.println("It's Safe!!");
										ThreePassed = true;
									}
									else{
										System.out.println("You Land Heavily On The Platform. As You Attempt To Stand Up It Gives Way Underneath You!!!");
										System.out.println("You Fall Into The Pool Of Thick, Slimy Liquid!");
										System.out.println("");
										if(FailsAllowed > 0){
											System.out.println("You Drag Yourself Through The Slime And Towards The Ladder Near The Start. It Takes A Huge Amount Of Energy Away From You.");
											System.out.println("And Now You Have To Start Over, But At Least You Still Have Your Life!!");
										}
										if(FailsAllowed == 0){
											System.out.println("You Try To Move Towards The Ladder At The Start Again, But Your Energy Is Completely Gone...");
											System.out.println("You Cannot Get Your Legs To Move, And Your Arms Are Not Strong Enough To Do All The Work...");
											System.out.println("");
											System.out.println("Eventually You Accept Your Fate And Let Yourself Be Consumed By The Grim Liquid...");
											System.out.println("...GAME OVER");
											PlatformGame = false;
											Lose = true;
										}
										FailsAllowed--;
										InGame = false;
									}
									
								}
								
								if(ThreePassed == true){
									System.out.println("");
									System.out.println("Gathering Your Remaining Energy, You Make The Final Jump Onto The Last Platform Before Moving Safely Onto The Other Side.");
									System.out.println("As You Do You Hear A Small Buzzing And A Loud Click, You Guess That The Safe Platforms Have Changed...");
									System.out.println("");
									InGame = false;
									PlatformGame = false;
								}
								
							}
							
						}
						
						
						while(GoodChoice == false && Lose == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 5;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 4;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					// third row
					else if(xPosition == 1 && yPosition == 12){
						
						if(PulleyDone == true){
							System.out.println("You Are In The Area Where You Pulled One Of The Ropes In The Pulley System.");
							System.out.println("There Is Nothing More To Do Here.");
						}
						else if(PulleyDone == false && Magic == true){
							System.out.println("Approaching This Area, You Can Immediately See A Pulley System Set Up.");
							System.out.println("There Are 3 Ropes Connected Up To The System, Marked 'Left', 'Middle' And 'Right'.");
							System.out.println("");
							System.out.println("A Beam Across The Top Of The Pulley System Simply Reads: 'Pull One... If You Dare'.");
							System.out.println("");
							System.out.println("You Try To Approach The System To Further Inspect It, But You Feel Something Inside You Forcing You To Stay Clear...");
							System.out.println("It Feels As If The Magic In You Is Warning You To Avoid Pulling A Rope At All Costs!");
							System.out.println("Trusting This Power, You Decide To Just Walk Away. There Is No Reason To Risk Unleashing Something Terrifying.");
						}
						else if(PulleyDone == false && Magic == false){
							
							if(PulleyIntro == false){
								System.out.println("Approaching This Area, You Can Immediately See A Pulley System Set Up.");
								System.out.println("There Are 3 Ropes Connected Up To The System, Marked 'Left', 'Middle' And 'Right'.");
								System.out.println("");
								System.out.println("A Beam Across The Top Of The Pulley System Simply Reads: 'Pull One... If You Dare'.");
								PulleyIntro = true;
							}
							else {
								System.out.println("You Are Back In The Area With The Pulley System.");
							}
							System.out.println("Do You Wish To Pull One Of The Ropes, Yes Or No?");
							
							boolean PulleyGame = false;
							boolean PulleyChoice = false;
							while(PulleyChoice == false){
								String PulleyDecision = input.nextLine();
								if(PulleyDecision.equals("Yes")){
									PulleyChoice = true;
									PulleyGame = true;
								}
								else if(PulleyDecision.equals("No")){
									PulleyChoice = true;
									System.out.println("");
									System.out.println("You Decide Not To Tempt Fate By Doing Something Where You Have No Idea Of The Outcome.");
									System.out.println("You Can Always Come Back To It Later.");
								}
								else {
									System.out.println("Invalid Choice. Please Choose Either 'Yes' Or 'No'.");
								}
							}
							
							if(PulleyGame == true){
								System.out.println("");
								System.out.println("You Have Decided To Pull One Of The Ropes, But What Each Does Is Impossible To Know.");
								System.out.println("Most Of The Pulley System Is Hidden Behind A Wall And So It's Not Even Clear Pulling One Wil Do Anything At All.");
								System.out.println("The Only Decision To Make Now Is Which One To Pull... Left, Middle Or Right.");
								
								boolean PulleyPositionChoice = false;
								while(PulleyPositionChoice == false){
									String PulleyPosition = input.nextLine();
									if(PulleyPosition.equals("Left") || PulleyPosition.equals("Middle") || PulleyPosition.equals("Right")){
										PulleyPositionChoice = true;
										
										int MinRope = 1; 
										int	MaxRope = 3;	
										int Rope = MinRope + (int)(Math.random() * ((MaxRope - MinRope) + 1));
										
										if(Rope == 1){
											PulleyMedallion = true;
										}
										else if(Rope == 2){
											PulleyBeast = true;
										}
										else if(Rope == 3){
											PulleyMedallion = true;
											PulleyBeast = true;
										}
										System.out.println("");
										System.out.println("Pulling The Rope Down Hard You Feel The System Kick Into Life...");
										System.out.println("You Can Hear Cogs Turning And Metal Clanging, But Still Nothing Is Happening Around You.");
										System.out.println("");
										System.out.println("After Waiting A While You Give Up And Decide To Just Carry On...");
										System.out.println("But Yout Can't Help Wondering What Exactly Pulling That Rope Has Done.");
										System.out.println("");
										System.out.println("Choose Either N, E, S or W to Travel");
										PulleyDone = true;
									}
									else {
										System.out.println("Invalid Choice. Please Choose Either 'Left', 'Middle' Or 'Right'.");
									}
								}
								
							}
							
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 2;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								xPosition = 1;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 2 && yPosition == 12){
						
						int FlameGuess = 0;
						int ArrowGuess = 0;
						
						int MinFlame = 10; 
						int	MaxFlame = 20;	
						int Flame = MinFlame + (int)(Math.random() * ((MaxFlame - MinFlame) + 1));
						
						int MinArrow= 10; 
						int	MaxArrow = 30;	
						int Arrow = MinArrow + (int)(Math.random() * ((MaxArrow - MinArrow) + 1));
						
						if(TrapRoom == false){
							System.out.println("As You Enter A Small Dark Room The Door Slams Shut Behind You!");
							System.out.println("You Are Left In Darkness, Until Finally A Light Turns On And You Can See All Around You...");
							System.out.println("");
							System.out.println("This Area Is A Deathtrap!!!");
							System.out.println("On Every Wall And All Over The Floor There Are Flames, Spikes, Trapdoors, Arrows, Beartraps And All Sorts Of Horrific Things Randomly Setting Off And Resetting Themselves!!");
							System.out.println("");
							System.out.println("There Doesnt Seem To Be Any Way Through, And There Is Certainly No Way Out.");
							System.out.println("You Notice That All Of The Dangers In This Room Are On A Loop. If You Look Hard Enough You Might Be Able To Find A Way Through.");
							System.out.println("...");
							System.out.println("There Is A Route That Requires You To Only Dodge The Flames And Arrows. You Need To Count The Seconds Between Each Cycle To Get Out Of Here Safely...");
						}
						else if(TrapRoom == true){
							System.out.println("You Are Back In The Room Full Of Traps. You Try To Look For The Route Through The Flames And Arrows That You Took Last Time...");
							System.out.println("It's No Longer There!! The Timings Must Have Been Changed!!");
							System.out.println("");
							System.out.println("You Need To Start Over From Scratch...");
						}
						System.out.println("");
						System.out.println("First For The Flames. They Seem To Repeat Somewhere Between Every 10 And 20 Seconds, But You Are Not 100% Certain...");
						System.out.println("");
						System.out.println("When You Are Ready To Begin The Count Press Enter, You Must Then Count The Seconds Until The Next Message Appears...");
						input.nextLine();
						System.out.println("START--->>>");
						       
						try {
				            TimeUnit.SECONDS.sleep(Flame);
				        }
				        catch (InterruptedException ex)
				        {
				        }
						        
				        System.out.println("<<<---STOP.");
				        System.out.println("Thats The Cycle Of Flames Complete.");
				        System.out.println("");
				        System.out.println("Please Enter How Many Seconds You Think The Cycle Lasted For.");
				        
				        boolean FlameChoice = false;
				        while (FlameChoice == false){
							if(input.hasNextInt()){
								   FlameGuess = input.nextInt();
								   FlameChoice = true;
							}else{
								System.out.println("Please Enter How Many Seconds You Think The Cycle Lasted For.");
								input.next();
							}
						}
				        
				        System.out.println("Now For The Arrows...");
				        System.out.println("These Are Harder To Tell As Multiple Arrows Are Firing, But The Process Seems To Repeat Somewhere Between Every 10 And 30 Seconds...");
				        
						System.out.println("Again, When You Are Ready To Begin The Count Press Enter, You Must Then Count The Seconds Until The Next Message Appears...");
						input.nextLine();
						input.nextLine();
						System.out.println("START--->>>");
						
						try {
				            TimeUnit.SECONDS.sleep(Arrow);
				        }
				        catch (InterruptedException ex)
				        {
				        }
						
				        System.out.println("<<<---STOP.");
				        System.out.println("Thats The Cycle Of Arrows Completed Now Too.");
				        System.out.println("");
				        System.out.println("Please Enter How Many Seconds You Think This Cycle Lasted For.");
				        
				        boolean ArrowChoice = false;
				        while (ArrowChoice == false){
							if(input.hasNextInt()){
								   ArrowGuess = input.nextInt();
								   ArrowChoice = true;
							}else{
								System.out.println("Please Enter How Many Seconds You Think This Cycle Lasted For.");
								input.next();
							}
						}
				        
				        System.out.println("");
				        System.out.println("Now All That's Left To Do Is Hope That You Are Correct...");
				        System.out.println("In Your Head You Keep Repeating: 'Flames " + FlameGuess + ", Arrows " + ArrowGuess + "' Over And Over Again To Yourself.");
				        System.out.println("");
				        System.out.println("When You Feel Ready, Press Enter To Continue...");
				        input.nextLine();
				        input.nextLine();
				        System.out.println("You Dive Into The Centre Of The Room, Dodging And Weaving And All The Time Trying To Keep On Counting The Seconds In Your Head...");
				        System.out.println("...");
				        				        
				        if((FlameGuess == Flame + 1 || FlameGuess == Flame - 1 || FlameGuess == Flame) && (ArrowGuess == Arrow + 1 || ArrowGuess == Arrow - 1 || ArrowGuess == Arrow)){
				        	System.out.println("After A Few Close Calls You Finally Make It To The Safety On The Other Side!!");
				        	System.out.println("You Look Back A What You Have Just Got Through And Pray That You Never Need To Do It Again!!");
				        	TrapRoom = true;
				        }
				        else{
				        	System.out.println("You Nearly Get Hit, And Again, And Again!!");
				        	System.out.println("It Shouldn't Be This Close, Your Count Must Have Been Wrong!");
				        	System.out.println("");
				        	System.out.println("It's Too Late To Escape, The Flames Engulf Your Body While The Arrows Tear Through Your Flesh....");
				        	System.out.println("Your Time Is Done...");
				        	System.out.println("...GAME OVER");
				        	Lose = true;
				        }
						   
						
						while(GoodChoice == false && Lose == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 2;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 1;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("S")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 3 && yPosition == 12){
						System.out.println("There Is A Small Channel Of Water Leading In From The Northeast Side Of This Area.");
						System.out.println("");
						
						if(PillarDone == true && RewardTaken == false){
							System.out.println("This Must Be Where The Water From The Lightning Pillar Went!!");
							System.out.println("You Look Closer At The Water And See That It Is Glowing Slightly With The Power Of The Lightning Trapped Within It.");
							System.out.println("The Channel Of Water Is Being Blocked From Reaching The Hole By A Small Plank Of Wood. You Lift The Wood Out Of The Way And Watch To See What Happens...");
							System.out.println("");
							System.out.println("There Is A Slight Rumble As Something Appears To Be Moving From Under Your Feet. You Take A Step Back And The Floor Begins To Part!!");
							System.out.println("Out Of The Floor Rises Something You Did Not Expect To See...");
							System.out.println("");
							
							int MinReward = 1; 
							int	MaxReward = 3;	
							int Reward = MinReward + (int)(Math.random() * ((MaxReward - MinReward) + 1));
							
							if(Reward == 1){
								System.out.println("It Is A Small Pile Of Food. Just Enough To Fill Your Pockets Once...");
								Food = MaxFood;
								RewardTaken = true;
							}
							if(Reward == 2){
								System.out.println("It Is A Large Pile Of Food, With A Note Beside It...");
								System.out.println("It Says That This Food Pile Will Always Be Here, And It Will Always Be Full!!!");
								System.out.println("Now, You Just Need To Try And Remember How To Get Back Here When Your Food Runs Low...");
								RestoreFood = true;
								RewardTaken = true;
							}
							if(Reward == 3){
								System.out.println("Out Of The Ground, Rising On A Golden Platform, Is A Completed Medallion!!!");
								System.out.println("It Is On A White Gold Chain And So Can Be Worn Around Your Neck Without Taking Up Valuable Food Space.");
								System.out.println("However, Just In Case Something Happens You Decide To Keep Any Pieces You Have Already Found.");
								System.out.println("");
								System.out.println("Now You Just Need To Find The Golden Door And Escape From This Place Once And For All!!");
								RewardTaken = true;
								MedallionComplete = true;
							}
							if(RestoreFood == true){
								System.out.println("You Take As Much As You Can From The Pile Of Food...");
								System.out.println("Your Food Has Been Restored To Maximum!");
								Food = MaxFood;
							}
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 2;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 4 && yPosition == 12){ //WINNING POINT
						System.out.println("");
						System.out.println("You Have Made It The Golden Door!!");
						System.out.println("It's Huge, With Intricate Carvings Of Each Of The Challenges You Have Faced To Get Here, And Also Some You Did Not See.");
						System.out.println("The Light Reflects Off The Glorious Door, Causing It To Seem Like Something Out Of A Dream.");
						System.out.println("A Beautifully Crafted Sign On The Door Reads The Words You Have Been Waiting For Since You Entered This Maze " + TotalMoves + " Days Ago.");
						System.out.println(TotalMoves + " Days!!! You Cannot Believe How Long You Have Been Stuck In This Hell Hole!!");
						System.out.println("");
						System.out.println("Press Enter To Try And Open The Door...");
						input.nextLine();
						System.out.println("It Is Clear Where The Medallion Is Meant To Be Placed. You Reach Into Your Bag To Pull It Out...");
						
						if(MedallionComplete == true){
							System.out.println("You Take The Medallion In Both Hands And Carefully Put It Into The Correct Position On The Door, Waiting For Something To Happen...");
							System.out.println("...");
							System.out.println("Suddenly, You Hear Cogs Turning Inside The Door... It Slowly Begins To Open!!!");
							System.out.println("This Is It! You Are Finally Going To Be Free!!!");
							System.out.println("...");
							System.out.println("You Stride Out Of The Door, Emerging Into A Valley Covered In Long Grass And Flowers, With Hills That Roll Off Into The Distance Towards The Setting Sun.");
							System.out.println("You Wait A Moment, Taking In The Beauty Of The World You Live In.");
							System.out.println("As You Take One Last look Back, A Figure Appears In The Golden Doorway. You Can't Make Out Who Or What It Is But It Leaves You With Some Advice...");
							System.out.println("");
							System.out.println("'Remember The Lessons You Have Learned Today " + Name + ". Carry Them With You Always'.");
							System.out.println("");
							System.out.println("And With That You Turn And Walk Away, Never To Return.");
							Win = true;
						}
						else {
							System.out.println("But You Do Not Have A Completed Medallion!!!");
							System.out.println("Not Only That, But There Are No More Pieces To Be Found In This Area!!");
							System.out.println("");
							System.out.println("You Cannot Turn Back As The Tunnel Is Blocked, There Are No Other Routes To Go...");
							System.out.println("You Have Come So Far And Gotten So Close, But With No Food Source You Are Doomed To Die In Front Of This Magnificent Door.");
							System.out.println("");
							System.out.println("There Is Nothing To Do But Wait For Death...");
							System.out.println("...GAME OVER");
							Lose = true;
							
						}	
					}
					
					else if(xPosition == 5 && yPosition == 12){
						System.out.println("This Area Seems Empty. There Is Nothing To Be Done Here.");
						while(GoodChoice == false && Win == false){
							Choice = input.nextLine();
							if(Choice.equals("S")){
								xPosition = 5;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 4;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E") || Choice.equals("N")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					// fourth row
					else if(xPosition == 1 && yPosition == 13){
						System.out.println("You Have Reached A Dead End! The Only Way To Travel Is East Out Of This Area.");
						System.out.println("However, In The Corner Of This Section There I A Lookout Tower. Maybe From Up There You Can Get Your Bearings Again.");
						System.out.println("Do You Wish To Climb Up The Tower, Yes Or No?");
						
						boolean TowerChoiceMade = false;
						while(TowerChoiceMade == false){
							String TowerChoice = input.nextLine();
							if(TowerChoice.equals("Yes")){
								System.out.println("You Decide To Climb Up The Tower.");
								System.out.println("As You Climb Up The Ladder And Onto The Platform You Com Face To Face With A Rotting Corpse!");
								System.out.println("The Corpse Has Clearly Been Here For Some Time, Likely The Last Person to Get Trapped In This Maze.");
								System.out.println("");
								System.out.println("The Corpse Seems To Have Scratched Something Into The Wood Of The Platform...");
								System.out.println("'Its Not Real, Its Just An Illusion...'");
								System.out.println("");
								System.out.println("Confused, You Decide To Take A Quick Look Out Over The Rooftop And Get Down From This Platform Before You Suffer The Same Fate.");
								System.out.println("It Is Clear That You Are Currently In The Far Northwest. And You Can See The Shining Golden Door!");
								System.out.println("You Note that To Get There From Here You Need To Take The East Path, Then North, North Again, And Finally East.");
								TowerChoiceMade = true;
							}
							else if(TowerChoice.equals("No")){
								System.out.println("You Decide Not To Climb The Tower. Knowing This Place There Is Likely Something Dangerous Waiting For You At The Top...");
								TowerChoiceMade = true;
							}
							else {
								System.out.println("Please Choose Either Yes Or No.");
							}
						}
						
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 2 && yPosition == 13){
						
						if(PulleyMedallion == false){
							System.out.println("This Area Is A Dead End With Nothing Other Than A Fire Hanging High In The Centre To Light The Room. The Only Way Out Is To Go East.");
						}
						else if(PulleyMedallion == true && PulleyMedallionTaken == false){
							System.out.println("This Area Is A Dead End. The Only Way Out Is To Go East.");
							System.out.println("However, There Is Something Interesting In The Centre Of The Room...");
							System.out.println("There Is A Low Hanging Metal Basket With A Fire Inside Lighting Up The Room.");
							System.out.println("");
							System.out.println("Approaching The Fire You See Something Glistening Inside...");
							System.out.println("Its The Completed Medallion!!!!");
							System.out.println("");
							System.out.println("You Need To Decide Whether To Try And Grab The Medallion And Face Heavy Burns And A Long Recovery Time, Or Look For The Broken Pieces Elsewhere...");
							System.out.println("Want Do You Want To Do, Grab Or Leave?");
							
							boolean GrabLeaveMade = false;
							while(GrabLeaveMade == false){
								String GrabLeave = input.nextLine();
								if(GrabLeave.equals("Grab") && Food > 5){
									System.out.println("");
									System.out.println("You Decide Getting The Medallion Is Worth Risking The Burns You May Face.");
									System.out.println("It Takes A While For You To Build Up The Courage To Reach Into The Blazing Fire To Grab The Medallion...");
									System.out.println("But In The End You Just Take A Deep Breath And Go For It...");
									System.out.println("");
									System.out.println("With A Scream Of Pain As Your Hand Blisters And Burns You Reach In And Remove The Medallion, Instantly Dropping It To The Ground.");
									System.out.println("Your Hand Is Severely Burnt, It Will Likely Take At Least 4 Days To Recover Enough To Carry On...");
									System.out.println("On The Plus Side, The Medallion Is On A Chain So Can Be Worn Around Your Neck Without Taking Up Valuable Food Space.");
									System.out.println("");
									System.out.println("Despite This, You Decide To Keep Any Broken Pieces You Come Across, Just To Be Sure...");
									System.out.println("But You Now Have The Completed Medallion And Can Begin Getting Out Of Here!!!");
									GrabLeaveMade = true;
									MedallionComplete = true;
									Food = Food - 4;
									PulleyMedallionTaken = true;
								}
								else if(GrabLeave.equals("Grab") && Food <= 5){
									System.out.println("");
									System.out.println("You Decide Getting The Medallion Is Worth Risking The Burns You May Face...");
									System.out.println("But You Also Realise You Do Not Have Enough Food To Last Through The Recovery Time.");
									System.out.println("You Need To Find More Food And Then Return If You Wish To Get The Completed Medallion Here...");
									GrabLeaveMade = true;
								}
								else if(GrabLeave.equals("Leave")){
									System.out.println("");
									System.out.println("You Decide Not To Waste Time Having To Recover From Severe Burns. It Will Be Quicker To Just Find The Pieces Somewhere Else.");
									GrabLeaveMade = true;
								}
								else {
									System.out.println("Invalid Choice. Please Choose To Either 'Grab' Or 'Leave' The Medallion.");
								}
							}
							
						}
						else if(PulleyMedallion == true && PulleyMedallionTaken == true){
							System.out.println("This Is The Area With The Low Hanging Fire That Contained The Completed Medallion.");
							System.out.println("There Is Nothing More Of Use In This Area.");
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("E")){
								xPosition = 3;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("N") || Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 3 && yPosition == 13){
						
						boolean TunnelWon = false;
						
						System.out.println("You Stumble Into A Vast Area With Nothing Here But The Path You Came In From The North, And A Tunnel Over To The East.");
						System.out.println("You Approach The Tunnel Entrance, And As You Get Nearer You Can See Something Shimmering Through The Other End...");
						System.out.println("It Is Bright And Golden And Reflecting The Sun... Could This Be The Path To The Golden Door You Have Been Searching For!?");
						System.out.println("");
						System.out.println("You Know That You Have " + MedallionPieces + " Medallion Pieces.");
						
						if(MedallionPieces == 3){
							System.out.println("That Is Enough To Open The Door And Finally Escape This Place, You Just Need To Get Through This Tunnel!");
						}
						else {
							System.out.println("You Also Know That Is Not Enough To Open The Golden Door...");
							System.out.println("But This Maze Is A Devious Place. Whose To Say The Missing Pieces Aren't Waiting Just Through This Tunnel.");
							System.out.println("The Question Is... Is It Worth Getting Trapped On The Other Side??");
						}
						System.out.println("");
						System.out.println("Do You Want To Go Through The Tunnel, Yes Or No?");
						
						boolean TunnelMade = false;
						boolean game = false;
						while(TunnelMade == false){
							String TunnelChoice = input.nextLine();
							if(TunnelChoice.equals("Yes")){
								TunnelMade = true;
								System.out.println("");
								System.out.println("You Have Decided To Enter The Tunnel In Order To Reach The Golden Door.");
								System.out.println("You Slowly Walk Forward, Inspecting All Around You In Search Of The Inevitable Danger That's Coming Your Way.");
								System.out.println("");
								System.out.println("Not Far Into The Tunnel, Scrathed Into The Wall On Your Left Is A Message...");
								System.out.println("It Appears To Have Been Carved By A Knife Or Sword, Probably By The Last Person To Make It This Far.");
								System.out.println("The Message Is A Warning, It Says:");
								System.out.println("");
								System.out.println("'Beware Of The Rising Walls, They Will Block Your Path To Freedom If You Do Not Act Fast Enough.");
								System.out.println("Walk Through The Tunnel Slowly, When A Wall Begins To Rise From The Ground You Must Leap Forward To Avoid Being Trapped Forever.");
								System.out.println("I Do Not Know How Many Walls There Are, But I Know There Is No Returning Once You Go Begin...'");
								System.out.println("");
								System.out.println("Knowing This Information, And That You Currently Have "+ MedallionPieces + " Medallion Pieces,  Are You Sure You Wish To Continue, Yes Or No?");
								
								boolean TunnelMade2 = false;
								while(TunnelMade2 == false){
									String TunnelChoice2 = input.nextLine();
									if(TunnelChoice2.equals("Yes")){
										game = true;
										TunnelMade2 = true;
										System.out.println("You Have Chosen To Take On The Tunnel...");
										System.out.println("");
										System.out.println("Walking Into The Unknown There Is A Sudden Crash As A Wall Rises Up Behind You, Blocking Any Chance Of Going Back.");
										System.out.println("");
										System.out.println("Once You Have Started, You Must Wait For A Wall To Rise And Press Enter As Quickly As Possible.");
										System.out.println("If Your Reactions Are Too Slow Then The Wall Will Have Gotten Too High To Get Over And You Will Be Trapped...");
										System.out.println("Good Luck.");
										System.out.println("");
									}
									else if(TunnelChoice2.equals("No")){
										System.out.println("You Have Chosen Not To Take On The Tunnel Just Yet. You Travel North, Back The Way You Came.");
										TunnelMade2 = true;
									}
									else {
										System.out.println("Invalid Choice, Please Choose Either 'Yes' Or 'No'.");
									}
								}
							}
							else if(TunnelChoice.equals("No")){
								TunnelMade = true;
							}
							else {
								System.out.println("Invalid Choice. Please Choose Either 'Yes' Or 'No'.");
							}
						}
						
				    	int Walls = 0;
				    	long Time = 0;
				    	int WallsBeaten = 0;
				    	
				    	if(Diff.equals("Easy")){
				    		Walls = 4;
				    		Time = 550;
				    	}
				    	if(Diff.equals("Hard")){
				    		Walls = 6;
				    		Time = 500;
				    	}

					    while(game == true){
					    	
					    	boolean Valid = true;

					    	System.out.println("");
							System.out.println("Press Enter To Start Walking Slowly Forward...");
							input.nextLine();
							long tm = 0;
							String gap = "";
							double t =  Math.random();
							double g =  Math.random();
							double time = (int) (t*1500);
							int spaces = (int) (g*135);
							for (int x=0;x<=spaces;x++){
								gap = gap+" ";
							}
							if (time <100){
								time = time + 100;
							} 
							try {
								Thread.sleep((long) (time*10));
							} catch (InterruptedException e) {
								
							}
							if (Diff.equals("Easy")){
								gap = "";
							}
							System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
							System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
							System.out.println(gap+"!!!!!!!!!!!!--PRESS ENTER NOW--!!!!!!!!!!!!!!!");
							System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
							System.out.println(gap+"::::::::::::::::::::::::::::::::::::::::::::::");
							 tm = System.currentTimeMillis();
							    try {
								    String input = "";
								    System.out.print("");
								    InputStreamReader isr = new InputStreamReader(System.in);
								    BufferedReader br = new BufferedReader(isr);
								    try {

								      input = br.readLine();

								    } catch (IOException ioe) {
								    }
								    System.out.println(input);
							    }
							    finally {
							        tm = System.currentTimeMillis()-tm;
							        if (tm < 50){
							        System.out.println("You Had Jumped Before Any Sign Of A Wall Moving!! That Is A Risky Tactic That Could Easily Get You Killed!");
							        Valid = false;
							        } else {
							        	System.out.println("You Reacted In "+tm+"ms...");
							        }
							    
							        
							        if(tm <= Time && Valid == true && Walls > 0){
							        	System.out.println("You Made It Over The Wall!!");
							        	WallsBeaten++;
							        	Walls--;
							        	System.out.println("");
							        	System.out.println("You Have Now Made It Over " + WallsBeaten + " Wall(s).");
							        	
							        }
							        else if(tm > Time && Valid == true && Walls > 0){
							        	System.out.println("You Were Not Quick Enough!!!");
							        	System.out.println("The Wall Shoots Up In Front Of You, Stopping Too High For You To Climb...");
							        	System.out.println("You Can't Turn Back, And You Can No Longer Progress... You Are Doomed To Starve To Death In This Dark And Cold Place.");
							        	System.out.println("...GAME OVER");
							        	game = false;
							        	Lose = true;
							        }
							        else if(Walls == 0){
							        	System.out.println("");
							        	System.out.println("You Are Nearing The End Of The Tunnel, Surely There Can't Be Any More Walls Now...");
							        	System.out.println("You Walk Slowly, Your Senses Are Heightened, You Are So Close You Can See The Golden Door Just A Few Metres Ahead...");
							        	System.out.println("");
							        	System.out.println("After What Seems Like Eternity, You Reach Out And Touch The Door, You Made It!!!!!!!");
							        	game = false;
							        	TunnelWon = true;
							        }
							        
							    }
							    
						    }

						while(GoodChoice == false && Lose == false){
							
							if(TunnelWon == true){
								Choice = "E";
							}
							else {
								Choice = "N";
							}
							
							if(Choice.equals("N")){
								xPosition = 5;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 12;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S") || Choice.equals("W")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 4 && yPosition == 13){
						
						if(PillarDone == false){
							System.out.println("Entering This Section You Can See A Tall Pillar, Maybe 20ft High, Rising Up Out Of A Deep Pool Of Water.");
							System.out.println("All Around You Is A Solid Wall, With The Only Gaps Being The Bridges And Tunnels Leading Off To Other Areas.");
							System.out.println("Searching Around The Pillar, You Notice A Small Symbol That Looks Like A Lightning Bolt.");
							System.out.println("");
							
							if(Magic == true){
								System.out.println("You Can't Help But Feel As Though You Are Meant To Use Your Magic On This Pillar, But Why?");
								System.out.println("Do You Want To Fire A Bolt Of Lighnting At The Pillar, Yes Or No?");
								
								boolean PillarChoiceMade = false;
								while(PillarChoiceMade == false){
									String PillarChoice = input.nextLine();
									System.out.println("");
									
									if(PillarChoice.equals("No")){
										System.out.println("You Decide Using Your Magic Here Is Not Worth It.");
										PillarChoiceMade = true;
									}
									else if(PillarChoice.equals("Yes")){
										System.out.println("You Decide To Shoot The Pillar With Your Magic...");
										System.out.println("As you Do The Pillar Does Not Disintegrate As You Expected, But It Appears To Absorb The Lightning!");
										System.out.println("");
										System.out.println("You See The Pool Of Water Begin To Spark With The Electricity Absorbed By The Pillar...");
										System.out.println("It Travels Deep Into The Pool, And Then Along A Small Channel Of Water That You Nod Not Spotted Before...");
										System.out.println("It Then Disappears Through A Small Gap In The Southwest Wall Surrounding This Area.");
										System.out.println("");
										System.out.println("And With That, Nothing More Happens...");
										PillarChoiceMade = true;
										PillarDone = true;
									}
									else {
										System.out.println("Please Choose Either Yes Or No.");
									}
								}	
							}
							if(Magic == false){
								System.out.println("You Suspect That The Symbol Means Something, But You Don't Know What.");
								System.out.println("It Is Best To Just Move On.");
							}
						}
						else{
							System.out.println("This Is The Area Where You Struck The Pillar With Lightning.");
							System.out.println("There Is Nothing More You Can Do Here.");
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 5;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 4;
								yPosition = 11;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 1;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
					
					else if(xPosition == 5 && yPosition == 13){
						
						System.out.println("As You Enter This Area You See Something That Looks Totally Out Of Place..");
						System.out.println("There Is A Large Stone Wall In The Centre With A 5x5 Grid And Some Instructions Written Underneath...");
						System.out.println("");
						System.out.println(	"  				   A   B   C   D   E \n"
										+ 	"				1 [~] [~] [~] [~] [~] \n"
										+ 	"				2 [~] [~] [~] [~] [~] \n"
										+ 	"				3 [~] [~] [~] [~] [~] \n"
										+ 	"				4 [~] [~] [~] [~] [~] \n"
										+ 	"				5 [~] [~] [~] [~] [~]");
						System.out.println("");
						System.out.println("You Have 3 Lives. You Must Select Where You Wish To Hide Them.");
						System.out.println("Your Task Is To Find Your Opponents 5 Lives Before They Find Yours.");
						System.out.println("Your Only Advantage Is That Your opponent Cannot See Where They Have Already Chosen.");
						System.out.println("Each Life You Lose Will Cost You Two Days Worth Of Food... But Beat The Game And Your Food Will Be Fully Restored.");
						System.out.println("Do You Want To Play The Game, Yes Or No?");
						
						boolean BattleChoiceMade = false;
						while(BattleChoiceMade == false){
							String BattleChoice = input.nextLine();
							
							if(BattleChoice.equals("Yes")){
								BattleChoiceMade = true;
								String Position1 = null;
								String Position2 = null;
								String Position3 = null;
								
								boolean PositionOneChosen = false;
								while(PositionOneChosen == false){
									System.out.println("");
									System.out.println("Choose Your First Position (For Example 'A1')");
									Position1 = input.nextLine();
									if(Position1.equals("A1") || Position1.equals("A2") || Position1.equals("A3") || Position1.equals("A4") || Position1.equals("A5") || 
											Position1.equals("B1") || Position1.equals("B2") || Position1.equals("B3") || Position1.equals("B4") || Position1.equals("B5") || 
											Position1.equals("C1") || Position1.equals("C2") || Position1.equals("C3") || Position1.equals("C4") || Position1.equals("C5") || 
											Position1.equals("D1") || Position1.equals("D2") || Position1.equals("D3") || Position1.equals("D4") || Position1.equals("D5") || 
											Position1.equals("E1") || Position1.equals("E2") || Position1.equals("E3") || Position1.equals("E4") || Position1.equals("E5")){
										System.out.println("You Have Chosen Position " + Position1);
										PositionOneChosen = true;
									}
									else {
										System.out.println("Invalid Choice. Please Try Again.");
									}
								}
								
								boolean PositionTwoChosen = false;
								while(PositionTwoChosen == false){
									System.out.println("");
									System.out.println("Choose Your Second Position.");
									Position2 = input.nextLine();
									if(Position2.equals(Position1)){
										System.out.println("You Have Already Chosen That Position. Please Choose Another.");
									}
									else if(Position2.equals("A1") || Position2.equals("A2") || Position2.equals("A3") || Position2.equals("A4") || Position2.equals("A5") || 
											Position2.equals("B1") || Position2.equals("B2") || Position2.equals("B3") || Position2.equals("B4") || Position2.equals("B5") || 
											Position2.equals("C1") || Position2.equals("C2") || Position2.equals("C3") || Position2.equals("C4") || Position2.equals("C5") || 
											Position2.equals("D1") || Position2.equals("D2") || Position2.equals("D3") || Position2.equals("D4") || Position2.equals("D5") || 
											Position2.equals("E1") || Position2.equals("E2") || Position2.equals("E3") || Position2.equals("E4") || Position2.equals("E5")){
										System.out.println("You Have Chosen Position " + Position2);
										PositionTwoChosen = true;
									}
									else {
										System.out.println("Invalid Choice. Please Try Again.");
									}
								}
								
								boolean PositionThreeChosen = false;
								while(PositionThreeChosen == false){
									System.out.println("");
									System.out.println("Choose Your Last Position.");
									Position3 = input.nextLine();
									if(Position3.equals(Position1) || Position3.equals(Position2)){
										System.out.println("You Have Already Chosen That Position. Please Choose Another.");
									}
									else if(Position3.equals("A1") || Position3.equals("A2") || Position3.equals("A3") || Position3.equals("A4") || Position3.equals("A5") || 
											Position3.equals("B1") || Position3.equals("B2") || Position3.equals("B3") || Position3.equals("B4") || Position3.equals("B5") || 
											Position3.equals("C1") || Position3.equals("C2") || Position3.equals("C3") || Position3.equals("C4") || Position3.equals("C5") || 
											Position3.equals("D1") || Position3.equals("D2") || Position3.equals("D3") || Position3.equals("D4") || Position3.equals("D5") || 
											Position3.equals("E1") || Position3.equals("E2") || Position3.equals("E3") || Position3.equals("E4") || Position3.equals("E5")){
										System.out.println("You Have Chosen Position " + Position3);
										PositionThreeChosen = true;
									}
									else {
										System.out.println("Invalid Choice. Please Try Again.");
									}
								}
								
								String Target1 = null;
								String Target2 = null;
								String Target3 = null;
								String Target4 = null;
								String Target5 = null;
								boolean Tgt1 = false;
								boolean Tgt2 = false;
								boolean Tgt3 = false;
								boolean Tgt4 = false;
								boolean Tgt5 = false;
								
								while(Tgt5 == false){
									
									String TargetxString = null;
									int MinTarget = 1; 
									int	Maxtarget = 5;	
									int Targetx = MinTarget + (int)(Math.random() * ((Maxtarget - MinTarget) + 1));
									int Targety = MinTarget + (int)(Math.random() * ((Maxtarget - MinTarget) + 1));
									
									if(Targetx == 1){
										TargetxString = "A";
									}
									else if(Targetx == 2){
										TargetxString = "B";
									}
									else if(Targetx == 3){
										TargetxString = "C";
									}
									else if(Targetx == 4){
										TargetxString = "D";
									}
									else if(Targetx == 5){
										TargetxString = "E";
									}
									
									if(Tgt1 == false){
										Target1 = TargetxString + Targety;
										Tgt1 = true;
									}
									else if(Tgt2 == false){
										Target2 = TargetxString + Targety;
										if(!Target2.equals(Target1)){
											Tgt2 = true;
										}
									}
									else if(Tgt3 == false){
										Target3 = TargetxString + Targety;
										if(!Target3.equals(Target1) && !Target3.equals(Target2)){
											Tgt3 = true;
										}
									}
									else if(Tgt4 == false){
										Target4 = TargetxString + Targety;
										if(!Target4.equals(Target1) && !Target4.equals(Target2) && !Target4.equals(Target3)){
											Tgt4 = true;
										}
									}
									else if(Tgt5 == false){
										Target5 = TargetxString + Targety;
										if(!Target5.equals(Target1) && !Target5.equals(Target2) && !Target5.equals(Target3) && !Target5.equals(Target4)){
											Tgt5 = true;
										}
									}
									
								}
								
								System.out.println("");
								System.out.println("It Will Be Your Turn To Strike First...");
								
								String A1 = "~";	String A2 = "~";	String A3 = "~";	String A4 = "~";	String A5 = "~";
								String B1 = "~";	String B2 = "~";	String B3 = "~";	String B4 = "~";	String B5 = "~";
								String C1 = "~";	String C2 = "~";	String C3 = "~";	String C4 = "~";	String C5 = "~";
								String D1 = "~";	String D2 = "~";	String D3 = "~";	String D4 = "~";	String D5 = "~";
								String E1 = "~";	String E2 = "~";	String E3 = "~";	String E4 = "~";	String E5 = "~";
								
								boolean Target1Hit = false;
								boolean Target2Hit = false;
								boolean Target3Hit = false;
								boolean Target4Hit = false;
								boolean Target5Hit = false;
								boolean Defense1Hit = false;
								boolean Defense2Hit = false;
								boolean Defense3Hit = false;
								
								boolean FoodWarning = false;
								
								int YourLives = 3;
								int OpponentLives = 5;
								boolean InBattle = true;
								while(InBattle == true){
									String AttackChoice = null;
									boolean PositionAttack = false;
									while(PositionAttack == false){
										System.out.println("");
										System.out.println("NEW ROUND...");
										System.out.println("The Game Now Looks As Follows:");
										System.out.println("");
										System.out.println(	"  			   A   B   C   D   E \n"
														+ 	"			1 ["+A1+"] ["+B1+"] ["+C1+"] ["+D1+"] ["+E1+"] \n"
														+ 	"Your Lives: " + YourLives + "		2 ["+A2+"] ["+B2+"] ["+C2+"] ["+D2+"] ["+E2+"] \n"
														+ 	"			3 ["+A3+"] ["+B3+"] ["+C3+"] ["+D3+"] ["+E3+"] \n"
														+ 	"Their Lives: " + OpponentLives + "		4 ["+A4+"] ["+B4+"] ["+C4+"] ["+D4+"] ["+E4+"] \n"
														+ 	"			5 ["+A5+"] ["+B5+"] ["+C5+"] ["+D5+"] ["+E5+"]");
										System.out.println("");
										System.out.println("Select A Position To Attack...");
										AttackChoice = input.nextLine();
										if(AttackChoice.equals("A1") || AttackChoice.equals("A2") || AttackChoice.equals("A3") || AttackChoice.equals("A4") || AttackChoice.equals("A5") || 
												AttackChoice.equals("B1") || AttackChoice.equals("B2") || AttackChoice.equals("B3") || AttackChoice.equals("B4") || AttackChoice.equals("B5") || 
												AttackChoice.equals("C1") || AttackChoice.equals("C2") || AttackChoice.equals("C3") || AttackChoice.equals("C4") || AttackChoice.equals("C5") || 
												AttackChoice.equals("D1") || AttackChoice.equals("D2") || AttackChoice.equals("D3") || AttackChoice.equals("D4") || AttackChoice.equals("D5") || 
												AttackChoice.equals("E1") || AttackChoice.equals("E2") || AttackChoice.equals("E3") || AttackChoice.equals("E4") || AttackChoice.equals("E5")){
											PositionAttack = true;
										}
										else {
											System.out.println("Invalid Choice. Please Try Again.");
										}
									}
									if(AttackChoice.equals(Target1)){
										if(Target1Hit == false){
											System.out.println("Its A Hit!! You Have Destroyed One Of Your Opponents Lives.");
											OpponentLives--;
											System.out.println("They Now Have " + OpponentLives + " Lives Remaining.");
											Target1Hit = true;
										}
										else if(Target1Hit == true){
											System.out.println("You Had Already Hit That Target!!");
										}
									}
									else if(AttackChoice.equals(Target2)){
										if(Target2Hit == false){
											System.out.println("Its A Hit!! You Have Destroyed One Of Your Opponents Lives.");
											OpponentLives--;
											System.out.println("They Now Have " + OpponentLives + " Lives Remaining.");
											Target2Hit = true;
										}
										else if(Target2Hit == true){
											System.out.println("You Had Already Hit That Target!!");
										}
									}
									else if(AttackChoice.equals(Target3)){
										if(Target3Hit == false){
											System.out.println("Its A Hit!! You Have Destroyed One Of Your Opponents Lives.");
											OpponentLives--;
											System.out.println("They Now Have " + OpponentLives + " Lives Remaining.");
											Target3Hit = true;
										}
										else if(Target3Hit == true){
											System.out.println("You Had Already Hit That Target!!");
										}
									}
									else if(AttackChoice.equals(Target4)){
										if(Target4Hit == false){
											System.out.println("Its A Hit!! You Have Destroyed One Of Your Opponents Lives.");
											OpponentLives--;
											System.out.println("They Now Have " + OpponentLives + " Lives Remaining.");
											Target4Hit = true;
										}
										else if(Target4Hit == true){
											System.out.println("You Had Already Hit That Target!!");
										}
									}
									else if(AttackChoice.equals(Target5)){
										if(Target5Hit == false){
											System.out.println("Its A Hit!! You Have Destroyed One Of Your Opponents Lives.");
											OpponentLives--;
											System.out.println("They Now Have " + OpponentLives + " Lives Remaining.");
											Target5Hit = true;
										}
										else if(Target5Hit == true){
											System.out.println("You Had Already Hit That Target!!");
										}
									}
									else {
										System.out.println("It's A Miss...");
									}
									
									if(OpponentLives == 0){
										System.out.println("You Have Destroyed All Of Your opponents Lives!! You Have Won The Game!");
										System.out.println("Your Food Will Now Be Fully Restored To " + MaxFood + " Days Worth Of Food.");
										System.out.println("");
										System.out.println("You May Now Choose A Direction To Travel.");
										InBattle = false;
										Food = MaxFood;
									}
									
									if(OpponentLives > 0){
										System.out.println("");
										System.out.println("It Is Now Your opponents Move:");
										
										String DefensexString = null;
										int MinDefense = 1; 
										int	MaxDefense = 5;	
										int DefenseX = MinDefense + (int)(Math.random() * ((MaxDefense - MinDefense) + 1));
										int DefenseY = MinDefense + (int)(Math.random() * ((MaxDefense - MinDefense) + 1));
										
										if(DefenseX == 1){
											DefensexString = "A";
										}
										else if(DefenseX == 2){
											DefensexString = "B";
										}
										else if(DefenseX == 3){
											DefensexString = "C";
										}
										else if(DefenseX == 4){
											DefensexString = "D";
										}
										else if(DefenseX == 5){
											DefensexString = "E";
										}
										
										String Defense = DefensexString + DefenseY;
										
										System.out.println("They Have Selected To Attack Position " + Defense + "...");
										
										if(Defense.equals(Position1)){
											if(Defense1Hit == false){
												System.out.println("They Have Hit The Target. One Of Your Lives Has Been Destroyed!!!");
												YourLives--;
												System.out.println("Two Days Worth Of Food Have Been Removed.");
												Defense1Hit = true;
												Food = Food - 2;
												if(Food <= 0 && FoodWarning == true){
													System.out.println("You Have Run Out Of Food And Lost Another Life...");
													System.out.println("Since You Can No Longer Pay The Price, You Must Pay With You Life!!");
													InBattle = false;
												}
												if(Food <= 0 && FoodWarning == false){
													System.out.println("");
													System.out.println("You Have Run Out Of Food. You Must Now Win This Game Without Losing Anymore Lives!!!");
													FoodWarning = true;
												}
											}
											else if(Defense1Hit = true){
												System.out.println("But They Have Already Destroyed That Target. You Don't Lose Any Extra Lives.");
											}
										}
										else if(Defense.equals(Position2)){
											if(Defense2Hit == false){
												System.out.println("They Have Hit The Target. One Of Your Lives Has Been Destroyed!!!");
												YourLives--;
												System.out.println("Two Days Worth Of Food Have Been Removed.");
												Defense2Hit = true;
												Food = Food - 2;
												if(Food <= 0 && FoodWarning == false){
													System.out.println("");
													System.out.println("You Have Run Out Of Food. You Must Now Win This Game Without Losing Anymore Lives!!!");
													FoodWarning = true;
												}
												if(Food <= 0 && FoodWarning == true){
													System.out.println("You Have Run Out Of Food And Lost Another Life...");
													System.out.println("Since You Can No Longer Pay The Price, You Must Pay With You Life!!");
													InBattle = false;
												}
											}
											else if(Defense2Hit = true){
												System.out.println("But They Have Already Destroyed That Target. You Don't Lose Any Extra Lives.");
											}
										}
										else if(Defense.equals(Position3)){
											if(Defense3Hit == false){
												System.out.println("They Have Hit The Target. One Of Your Lives Has Been Destroyed!!!");
												YourLives--;
												System.out.println("Two Days Worth Of Food Have Been Removed.");
												Defense3Hit = true;
												Food = Food - 2;
												if(Food <= 0 && FoodWarning == false){
													System.out.println("");
													System.out.println("You Have Run Out Of Food. You Must Now Win This Game Without Losing Anymore Lives!!!");
													FoodWarning = true;
												}
												if(Food <= 0 && FoodWarning == true){
													System.out.println("You Have Run Out Of Food And Lost Another Life...");
													System.out.println("Since You Can No Longer Pay The Price, You Must Pay With You Life!!");
													InBattle = false;
												}
											}
											else if(Defense3Hit = true){
												System.out.println("But They Have Already Destroyed That Target. You Don't Lose Any Extra Lives.");
											}
										}
										else {
											System.out.println("They Have Missed Their Target!!");
										}
									}	
	
	
									if(YourLives == 0){
										System.out.println("");
										System.out.println("You Have Lost All Of Your Lives. You Lose The Game, And So The Reward Is Not Yours. You May Play Again Next Time You Enter this Place.");
										InBattle = false;
									}
									
									
									//A Row For Grid Picture
									if(AttackChoice.equals("A1")){
										if(Target1.equals("A1") || Target2.equals("A1") || Target3.equals("A1") || Target4.equals("A1") || Target5.equals("A1")){
											A1 = "#";
										}
										else {
											A1 = " ";
										}
									}
									else if(AttackChoice.equals("A2")){
										if(Target1.equals("A2") || Target2.equals("A2") || Target3.equals("A2") || Target4.equals("A2") || Target5.equals("A2")){
											A2 = "#";
										}
										else {
											A2 = " ";
										}
									}
									else if(AttackChoice.equals("A3")){
										if(Target1.equals("A3") || Target2.equals("A3") || Target3.equals("A3") || Target4.equals("A3") || Target5.equals("A3")){
											A3 = "#";
										}
										else {
											A3 = " ";
										}
									}
									else if(AttackChoice.equals("A4")){
										if(Target1.equals("A4") || Target2.equals("A4") || Target3.equals("A4") || Target4.equals("A4") || Target5.equals("A4")){
											A4 = "#";
										}
										else {
											A4 = " ";
										}
									}
									else if(AttackChoice.equals("A5")){
										if(Target1.equals("A5") || Target2.equals("A5") || Target3.equals("A5") || Target4.equals("A5") || Target5.equals("A5")){
											A5 = "#";
										}
										else {
											A5 = " ";
										}
									}
									
									//B Row For Grid Picture
									else if(AttackChoice.equals("B1")){
										if(Target1.equals("B1") || Target2.equals("B1") || Target3.equals("B1") || Target4.equals("B1") || Target5.equals("B1")){
											B1 = "#";
										}
										else {
											B1 = " ";
										}
									}
									else if(AttackChoice.equals("B2")){
										if(Target1.equals("B2") || Target2.equals("B2") || Target3.equals("B2") || Target4.equals("B2") || Target5.equals("B2")){
											B2 = "#";
										}
										else {
											B2 = " ";
										}
									}
									else if(AttackChoice.equals("B3")){
										if(Target1.equals("B3") || Target2.equals("B3") || Target3.equals("B3") || Target4.equals("B3") || Target5.equals("B3")){
											B3 = "#";
										}
										else {
											B3 = " ";
										}
									}
									else if(AttackChoice.equals("B4")){
										if(Target1.equals("B4") || Target2.equals("B4") || Target3.equals("B4") || Target4.equals("B4") || Target5.equals("B4")){
											B4 = "#";
										}
										else {
											B4 = " ";
										}
									}
									else if(AttackChoice.equals("B5")){
										if(Target1.equals("B5") || Target2.equals("B5") || Target3.equals("B5") || Target4.equals("B5") || Target5.equals("B5")){
											B5 = "#";
										}
										else {
											B5 = " ";
										}
									}
									//C Row For Grid Picture
									else if(AttackChoice.equals("C1")){
										if(Target1.equals("C1") || Target2.equals("C1") || Target3.equals("C1") || Target4.equals("C1") || Target5.equals("C1")){
											C1 = "#";
										}
										else {
											C1 = " ";
										}
									}
									else if(AttackChoice.equals("C2")){
										if(Target1.equals("C2") || Target2.equals("C2") || Target3.equals("C2") || Target4.equals("C2") || Target5.equals("C2")){
											C2 = "#";
										}
										else {
											C2 = " ";
										}
									}
									else if(AttackChoice.equals("C3")){
										if(Target1.equals("C3") || Target2.equals("C3") || Target3.equals("C3") || Target4.equals("C3") || Target5.equals("C3")){
											C3 = "#";
										}
										else {
											C3 = " ";
										}
									}
									else if(AttackChoice.equals("C4")){
										if(Target1.equals("C4") || Target2.equals("C4") || Target3.equals("C4") || Target4.equals("C4") || Target5.equals("C4")){
											C4 = "#";
										}
										else {
											C4 = " ";
										}
									}
									else if(AttackChoice.equals("C5")){
										if(Target1.equals("C5") || Target2.equals("C5") || Target3.equals("C5") || Target4.equals("C5") || Target5.equals("C5")){
											C5 = "#";
										}
										else {
											C5 = " ";
										}
									}
									//D Row For Grid Picture
									else if(AttackChoice.equals("D1")){
										if(Target1.equals("D1") || Target2.equals("D1") || Target3.equals("D1") || Target4.equals("D1") || Target5.equals("D1")){
											D1 = "#";
										}
										else {
											D1 = " ";
										}
									}
									else if(AttackChoice.equals("D2")){
										if(Target1.equals("D2") || Target2.equals("D2") || Target3.equals("D2") || Target4.equals("D2") || Target5.equals("D2")){
											D2 = "#";
										}
										else {
											D2 = " ";
										}
									}
									else if(AttackChoice.equals("D3")){
										if(Target1.equals("D3") || Target2.equals("D3") || Target3.equals("D3") || Target4.equals("D3") || Target5.equals("D3")){
											D3 = "#";
										}
										else {
											D3 = " ";
										}
									}
									else if(AttackChoice.equals("D4")){
										if(Target1.equals("D4") || Target2.equals("D4") || Target3.equals("D4") || Target4.equals("D4") || Target5.equals("D4")){
											D4 = "#";
										}
										else {
											D4 = " ";
										}
									}
									else if(AttackChoice.equals("D5")){
										if(Target1.equals("D5") || Target2.equals("D5") || Target3.equals("D5") || Target4.equals("D5") || Target5.equals("D5")){
											D5 = "#";
										}
										else {
											D5 = " ";
										}
									}
									//E Row For Grid Picture
									else if(AttackChoice.equals("E1")){
										if(Target1.equals("E1") || Target2.equals("E1") || Target3.equals("E1") || Target4.equals("E1") || Target5.equals("E1")){
											E1 = "#";
										}
										else {
											E1 = " ";
										}
									}
									else if(AttackChoice.equals("E2")){
										if(Target1.equals("E2") || Target2.equals("E2") || Target3.equals("E2") || Target4.equals("E2") || Target5.equals("E2")){
											E2 = "#";
										}
										else {
											E2 = " ";
										}
									}
									else if(AttackChoice.equals("E3")){
										if(Target1.equals("E3") || Target2.equals("E3") || Target3.equals("E3") || Target4.equals("E3") || Target5.equals("E3")){
											E3 = "#";
										}
										else {
											E3 = " ";
										}
									}
									else if(AttackChoice.equals("E4")){
										if(Target1.equals("E4") || Target2.equals("E4") || Target3.equals("E4") || Target4.equals("E4") || Target5.equals("E4")){
											E4 = "#";
										}
										else {
											E4 = " ";
										}
									}
									else if(AttackChoice.equals("E5")){
										if(Target1.equals("E5") || Target2.equals("E5") || Target3.equals("E5") || Target4.equals("E5") || Target5.equals("E5")){
											E5 = "#";
										}
										else {
											E5 = " ";
										}
									}
								}
							}
							else if(BattleChoice.equals("No")){
								System.out.println("You Decide Not To Battle. You Think You Have Enough Food To Last.");
								BattleChoiceMade = true;
							}
							else {
								System.out.println("Please Choose Either Yes Or No.");
							}
						}
						
						while(GoodChoice == false){
							Choice = input.nextLine();
							if(Choice.equals("N")){
								xPosition = 3;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("E")){
								xPosition = 3;
								yPosition = 10;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("W")){
								xPosition = 4;
								yPosition = 13;
								GoodChoice = true;
								TotalMoves++;
							}
							else if(Choice.equals("S")){
								System.out.println("There Is No Path That Way! Choose Again!");
							}
							else {
								System.out.println("Please Choose Either N, E, S or W to Travel. You Have No Inventory.");
							}
						}	
					}
				}
			}
			
			
			
			else if(Choice.equals("I")){
				if(KeyFound == true)	{System.out.println("* Small Key");}
				if(Sword == true)		{System.out.println("* Glorious Sword");}
				if(Magic == true)		{System.out.println("* Book Of Magic");}
				if(Ring == true)		{System.out.println("* Shimmering Metal Ring");}
				
				System.out.println("* You Have " + Food + " Days Worth Of Food Remaining");
				
				if(KeyFound == false && Sword == false && Magic == false && Ring == false){
					System.out.println("");
					System.out.println("There Are No Other Items In Your Inventory.");
				}
				if(Area == 4){
					Choice = input.nextLine();
				}
			}
			
			else {
				System.out.println("Please Choose Either N, E, S or W to Travel, Or I For Your Inventory"); //message if wrong instruction
				if(Area == 4){
					Choice = input.nextLine();
				}
			}	
		}

		}
		
		if (Win == true){
			System.out.println("");
			System.out.println("-------------------------------------------------------------------");
			System.out.println("CONGRATULATIONS!! You Have Escaped The Maze And Earnt Your Freedom.");

		}	
	}
}



