package studio2;

import java.util.Scanner;

public class Ruin {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start amount");
		int startAmount = in.nextInt();
		System.out.println("Enter win chance");
		Double winChance = in.nextDouble();
		System.out.println("Enter win limit");
		int winLimit = in.nextInt();
		System.out.println("Enter total simulations needed");
		int totalSimulations = in.nextInt();
		int winTime = 0;
		int ruinTime = 0;
		int gamesPlayed = 0;
		int money = startAmount;
		double alpha = (1 - winChance) / winChance;
		double expectedRuin = (double)((Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)))/ (double)(1 - Math.pow(alpha, winLimit));
		

		for (int i = 1; i <= totalSimulations; i++) {
			gamesPlayed = 0;
			money = startAmount;
			while ((money < winLimit) && (money > 0)) {
				if ((Math.random() * 1.0) < winChance) {
					money++;
					// System.out.println("Win");
				} else {
					money--;
					// System.out.println("Lose");
				}
				gamesPlayed++;
			}

			if (money == winLimit) {
				System.out.println("Simulation " + i + ": " + gamesPlayed + " games played, WIN");
				winTime++;
			} else {
				System.out.println("Simulation " + i + ": " + gamesPlayed + " games played, LOSE");
				ruinTime++;
			}
		}
		System.out.println("In total " + totalSimulations + " simulations, you Won " + winTime + " times, and you runied " + ruinTime + " times.");
		System.out.println("Ruin Rate from Simulation: " + ( (double) ruinTime / totalSimulations) + " Expected Ruin Rate: " + expectedRuin);
		System.out.println();
		System.out.println("The start smount is: " + startAmount);
		System.out.println("The win chance is: " + winChance);
		System.out.println("The win limit is: " + winLimit);

	}

}
