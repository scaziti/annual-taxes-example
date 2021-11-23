package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.NaturalPerson;
import entities.Person;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the number of tax payers: ");
		int numOfPayers = scan.nextInt();
		
		List<Person> list = new ArrayList<>();
		
		for (int i = 1; i <= numOfPayers; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Natural Person or Legal Person (n/l): ");
			char selection = scan.next().charAt(0);
			
			if (selection == 'n') {
				
				System.out.print("Name: ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.print("Annual income: ");
				double annualIncome = scan.nextDouble();
				System.out.print("Health expenditures: ");
				double healthExpenditures = scan.nextDouble();
				
				list.add(new NaturalPerson(name, annualIncome, healthExpenditures));
			} else {
				
				System.out.print("Company name: ");
				scan.nextLine();
				String name = scan.nextLine();
				System.out.print("Annual income: ");
				double annualIncome = scan.nextDouble();
				System.out.print("Number of employees: ");
				int numberOfEmployees = scan.nextInt();
				
				list.add(new LegalPerson(name, annualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double totalAmount = 0.0;
		for (Person person : list) {
			System.out.println(person.getName() + ": " + String.format("%.2f", person.taxes()));
			totalAmount += person.taxes();
		}
		
		System.out.println();
		System.out.printf("TOTAL TAXES: %.2f", totalAmount);
		
		scan.close();
	}
}
