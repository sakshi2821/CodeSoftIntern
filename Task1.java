package intern;

import java.util.Random;
import java.util.Scanner;


/*
 * TASk1 :DEVELOP A BASIC TEXT-BASED GAME.
 */
public class Task1 
{
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	
	public void numberGame()
	{
		System.out.println("...........Welcome to the Number Game............");
		System.out.println("--------------------------------------------------\nInstructions : \nThe system will generate the number");
		System.out.println("---------------------------------------------------");
		System.out.println("Rounds of Number Game : \nRound 1 : Easy Level (10 chances to guess the correct number.)\nRound 2 : Intermediate Level(5 chances to guess the correct number.)\nRound 3 : Advanced level(3 chances to guess the correct number.)");
		System.out.println("---------------------------------------------------");
		while(true)
		{
			System.out.println("Enter round no. which you want to start : ");
			int level = sc.nextInt();
			if(level==1)
			{
				System.out.println("Round 1 Started....");
				int numRandom = random.nextInt(0,100);
				
				int attempt = 1;
				while(attempt<=10)
				{
					System.out.println("Enter attempt "+attempt+" : ");
					int numUser = sc .nextInt();
					if(numUser == numRandom)
					{
						System.out.println("You Win....!\n");
						System.out.println("Your Score "+(11-attempt)*10+"/100");
						System.out.println("-----------------------------------------------------------------------------");
						break;
					}
					else if(attempt == 10)
					{
						System.out.println("\nYour attempt limit is complete.\nPlease try again....");
						System.out.println("------------------------------------------------------------------------------");
						break;
					}
					else if(numRandom>numUser)
					{
						System.out.println("System number is greater than "+numUser);
					}
					else if(numRandom<numUser)
					{
						System.out.println("System number is leass than "+numUser);
					}
					attempt++;
				}
			}
			else if(level==2)
			{
				System.out.println("Round 2 Started......");
				int numRandom = random.nextInt();
				
				int attempt = 1;
				while(attempt<=5)
				{
					System.out.println("Enter attempt "+attempt+" : ");
					int numUser = sc.nextInt();
					if(numUser == numRandom)
					{
						System.out.println("You Win....!\n");
						System.out.println("Your Score "+(6-attempt)*20+"/100");
						System.out.println("-----------------------------------------------------------------------------");
						break;
					}
					else if(attempt == 5)
					{
						System.out.println("\nYour attempt limit is complete.\nPlease try again....");
						System.out.println("------------------------------------------------------------------------------");
						break;
					}
					else if(numRandom>numUser)
					{
						System.out.println("System number is greater than "+numUser);
					}
					else if(numRandom<numUser)
					{
						System.out.println("System number is leass than "+numUser);
					}
					attempt++;
				}
			}
			else if(level==3)
			{
				System.out.println("Round 3 Started......");
				int numRandom = random.nextInt(0,100);
				
				int attempt = 1;
				while(attempt<=2)
				{
					System.out.println("Enter attempt "+attempt+" : ");
					int numUser = sc.nextInt();
					if(numUser == numRandom)
					{
						System.out.println("You Win....!\n");
						System.out.println("Your Score "+(3-attempt)*50+"/100");
						System.out.println("-----------------------------------------------------------------------------");
						break;
					}
					else if(attempt == 2)
					{
						System.out.println("\nYour attempt limit is complete.\nPlease try again....");
						System.out.println("------------------------------------------------------------------------------");
						break;
					}
					else if(numRandom>numUser)
					{
						System.out.println("System number is greater than "+numUser);
					}
					else if(numRandom<numUser)
					{
						System.out.println("System number is leass than "+numUser);
					}
					attempt++;
				}
			}
			else
			{
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("Thank You for Playing./nHope You enjoy it......");
				break;
			}
		}
	}
    public static void main(String[] args)
    {
		Task1 t=new Task1();
		t.numberGame();
	}
}

