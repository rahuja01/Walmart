package com.ticketmgr.rohit.TicketMgrWalRA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicketMgrWalRaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TicketMgrWalRaApplication.class, args);

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of seats available ");

		String numOfSeats = scanner.nextLine();


		while (true) {
			System.out.println("Enter 0 to view total available seats, 1 to hold seats and 2 to allocate seats or 3 to Quit ");
			String option = scanner.nextLine();
			int selectedOption = -1;

			try {
				selectedOption = Integer.parseInt(option);
				if (selectedOption < 0 || selectedOption > 3) {
					System.out.println("Incorrect Value entered");
					continue;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (selectedOption == 1) {

			} else if (selectedOption == 2) {
				//holdSeats();
			} else if (selectedOption == 3) {
				//reserveSeats();
			} else {
				break;
			}
		}

		scanner.close();




	}

}
