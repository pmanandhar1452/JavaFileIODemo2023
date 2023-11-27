import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadCSV01 {
	
	private static int MAX_LINES = 10000;
	private static int nDataLines = 0;

	private static String [] extractYears(Scanner fin) {
		String firstLine = fin.nextLine();
		String [] firstLineColumns = firstLine.split(",");
		String [] years = new String[firstLineColumns.length - 1];
		for (int i = 1; i < firstLineColumns.length; i++)
			years[i-1] = firstLineColumns[i];
		return years;
	}
	
	private static String [] getAllLines(Scanner fin) {
		String [] lines = new String[MAX_LINES];
		while(fin.hasNext()) {
			lines[nDataLines] = fin.nextLine();
			nDataLines++;
		}
		return lines;
	}
	
	private static String [] getStates(String [] lines) {
		String [] states = new String[nDataLines];
		for(int i = 0; i < nDataLines; i++) {
			String [] split = lines[i].split(",");
			states[i] = split[0];
		}
		return states;
	}
	
	private static double [] 
	getAverageByYear(String [] years, String [] dataLines) {
		double [] average = new double[years.length];
		for(int i = 0; i < nDataLines; i++) {
			String [] split = dataLines[i].split(",");
			for(int j = 1; j < split.length; j++) {
				int data = Integer.parseInt(split[j]);
				average[j-1] += data;
			}
		}
		for(int j = 0; j < years.length; j++) {
			average[j] /= nDataLines;
		}
		return average;
	}
	
	// get the average population grouped by state for different years in
	// the dataset
	public static void main(String[] args) {
		String FILE_PATH = "/Users/prakash/Downloads/USPopulationByState2022.csv";
		try (Scanner fin = new Scanner(new File(FILE_PATH))) {
			String [] years = extractYears(fin);
			String [] dataLines = getAllLines(fin);
			String [] states = getStates(dataLines);
			double [] averages = getAverageByYear(years, dataLines);
			for(int i = 0; i < years.length; i++) 
				System.out.printf("%s : %.2f%n", years[i], averages[i]);
		} catch (FileNotFoundException e) {
			System.out.println("File " + FILE_PATH + " not found!");
		}
	}

}
