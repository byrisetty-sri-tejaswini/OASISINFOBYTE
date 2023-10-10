import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class RandomNumber{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Random random=new Random();
		int attempts=5;	
		int r=1;
		while(r<3){	
			int RandomNum=random.nextInt(101);
			System.out.println("Round "+r);
		for(int i=0;i<attempts;i++)
		{

			System.out.println("Enter you guess");
			int UserNumber=sc.nextInt();
			if(UserNumber==RandomNum)
			{
				System.out.println("Your guess is correct");
				if(i==0){
					System.out.println("You scored 20 Points");
					System.out.println("Excellent!");
					break;
				}
				else if(i==1){
					System.out.println("You scored 16 Points");
					System.out.println("Well Done!");			
					break;
				}
				else if(i==2){
					System.out.println("You scored 12 Points");
					System.out.println("Good");
					break;
				}
				else if(i==3){
					System.out.println("You scored 8 Points");
					System.out.println("Nice");
					break;
				}
				else{
					System.out.println("You scored 4 Points");
					System.out.println("Not Bad");

				}	
				break;		
			}
			else if(UserNumber>RandomNum)
			{
				System.out.println("The guess is high");
			}
			else
			{
				System.out.println("The guess is low");
			}
		}
		System.out.println("Your Score is 0");
		System.out.println("Try Again");
	
		r++;
	}
	}
}
		










