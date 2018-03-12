package com.nuance.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.nuance.handler.ReportOutputHandler;
import com.nuance.model.InputFileModel;

public class ReportRunner {

	public static void main(String[] args) {
		System.out.println("Please enter input file name with path: ");
		Scanner scanner = new Scanner(System.in);
		String inputFileName = scanner.nextLine();
		// String inputFileName =
		// "C:\\Users\\hvp91\\workspace\\Nuance_Exercise\\input\\inputtext.txt";
		scanner.close();

		try {
			String line = null;
			// Initializing file reader. Using default encoding here.
			FileReader inputFileReader = new FileReader(inputFileName);
			BufferedReader bufferedReader = new BufferedReader(inputFileReader);
			// Reading file line by line.
			while ((line = bufferedReader.readLine()) != null) {
				// Splitting a line with tab separated fields
				String[] lineTokens = line.split("\\t");
				if (lineTokens.length == 4 && lineTokens[3].length() > 1) {
					// Valid input line should have 4 fields tab separated and
					// last field should have length > 1
					String province = lineTokens[0];
					String city = lineTokens[1];
					String school = lineTokens[2];
					String grade = lineTokens[3].substring(0, 1);
					int population = Integer.parseInt(lineTokens[3].substring(1));

					// Creating data model for the line in the file.
					InputFileModel model = new InputFileModel(province, city, school, grade, population);

					// Output handler handles the model and prepares it for the
					// output.
					ReportOutputHandler.getReportOutputHandler().updateOutputReportModel(model);
				}
			}
			// closing buffered reader.
			bufferedReader.close();
			inputFileReader.close();

			// Printing output on the console.
			ReportOutputHandler.getReportOutputHandler().printReportOutput();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found : " + inputFileName);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid input file : " + inputFileName);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal error.");
		}
	}
}
