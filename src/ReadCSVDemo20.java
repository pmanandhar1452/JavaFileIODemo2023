import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadCSVDemo20 {

	private static String [] getYears(Scanner s) {
		String firstLine = s.nextLine();
		String [] splitLine = firstLine.split(",");
		String [] years = new String[splitLine.length - 1];
		for(int i = 0; i < years.length; i++) 
			years[i] = splitLine[i+1];
		return years;
	}
	
	private static double [] computeAverage(Scanner s, String [] years) {
		double [] averages = new double[years.length];
		
		String line = s.nextLine();
		String [] splitLine = line.split(",");
		String [] data = new String[splitLine.length - 1];
		int nDataLines = 0;
		for(int i = 0; i < years.length; i++) {
			averages[i] += Integer.parseInt(data[i+1]);
			nDataLines++;
		}
		for(int i = 0; i < years.length; i++)
			averages[i] /= nDataLines;
		return averages;
	}
	
	public static void main(String[] args) {
		String FILE_PATH = "data/USPopulationByState2022.csv";
		try (Scanner fin = new Scanner(new File(FILE_PATH))) {
			String [] years = getYears(fin);
			
			
		} catch (FileNotFoundException ex) {
			System.out.printf("File %s not found!%n", FILE_PATH);
			System.exit(0);
		}
		
	}

}
