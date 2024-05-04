package intern;

import java.util.Scanner;

public class Task2 
{
     Scanner sc=new Scanner(System.in);
     public void gradeCalculator()
     {
    	 double marksSum=0;
    	 System.out.println("Enter no. of Subjects : ");
    	 int totalSub = sc.nextInt();
    	 System.out.println("\nEnter marks of each Subjects out of 100 : ");
    	 for(int i=1;i<=totalSub;i++)
    	 {
    		 System.out.println("Subject "+i+" :");
    		 int marks=sc.nextInt();
    		 marksSum=marksSum + marks;
    	 }
    	 System.out.println("\nTotal Marks : "+marksSum);
    	 double per = marksSum/totalSub;
    	 System.out.println("Percentage : "+per);
    	 System.out.println("Grade : ");
    	 if(per<=100 && per>80)
    	 {
    		 System.out.println("A");
    	 }
    	 else if(per<=80 && per>60)
    	 {
    		 System.out.println("B");
    	 }
    	 else if(per<=60 && per>40)
    	 {
    		 System.out.println("C");
    	 }
    	 else if(per<=40 && per>=35)
    	 {
    		 System.out.println("D");
    	 }
    	 else
    	 {
    		 System.out.println("Fail");
    	 }
     }
     public static void main(String[] args)
     {
    	 Task2 a=new Task2();
    	 a.gradeCalculator();
		
	 }
}
