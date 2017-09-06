package chapter3;

import java.util.Scanner;

public class AdditionQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x = (int) (Math.random()*20);
		int y = (int) (Math.random()*20);
//		What is x + y ?
		System.out.println("What is " + x + " + " + y + " ?");
//		get answer from user
		int answer = input.nextInt();
//		x + y = answer ?
		System.out.println(x + " + " + y + " = " + answer + " is " +(x+y==answer));
		input.close();
	}

}
