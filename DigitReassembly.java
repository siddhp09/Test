package schoolProjects;

import java.util.Scanner;

public class DigitReassembly {
	// 1325678905 2
	// 54981230845791 5
	// 4837261529387456 3
	// 385018427388713440 4
	// 623387770165388734 1

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String input, number;
		int length, index = 0;
		long sum = 0;
		for (int x = 0; x < 5; x++) {
			System.out.println("Enter an positive integer less than 10^50 and a positive integer length:");
			input = scn.nextLine();

			length = Integer.parseInt(input.substring(input.indexOf(" ") + 1, input.length()));
			number = input.substring(0, input.indexOf(" "));

			if (number.length() < 51 && !(number.charAt(0) == '-') && length > 0) {
				while (number.substring(index, input.indexOf(" ")).length() >= length) {
					long d = Long.parseLong(number.substring(index, index + length));
					sum += d;
					index++;
				}

				System.out.println(sum);
				index = 0;
				sum = 0;
			} else {
				System.out.println("Error! Enter an positive integer less than 10^50 and a positive integer length.");
			}

		}
		scn.close();
	}

}
