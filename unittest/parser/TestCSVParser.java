package parser;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCSVParser {
	
	@Test
	void test() {
		try {
			CSVParser csvParser = new CSVParser(new FileReader("test data/testCSVParser.csv"));
			
			ArrayList<String> row1 = new ArrayList<String>();
			row1.add("col 1");
			row1.add("col 2");
			row1.add("col 3");
						
			ArrayList<String> res1 = csvParser.readLine();
			
			assertEquals(row1, res1);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test2() {
		try {
			CSVParser csvParser = new CSVParser(new FileReader("test data/testCSVParser.csv"));
			
			ArrayList<String> row2 = new ArrayList<String>(); 
			row2.add("425 32");
			row2.add("[892783, 3091, 02934]");
			row2.add("Here the real test. I want, money\nI need money.");
			
			csvParser.readLine();
			ArrayList<String> res2 = csvParser.readLine();
	
			assertEquals(row2, res2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	void test3() {
		try {
			CSVParser csvParser = new CSVParser(new FileReader("test data/testCSVParser.csv"));
			
			ArrayList<String> row3 = new ArrayList<String>(); 
			row3.add("here, here");
			row3.add("321");
			row3.add("[134, 341]");
			ArrayList<String> row4 = new ArrayList<String>();

			csvParser.readLine();
			csvParser.readLine();
			ArrayList<String> res3 = csvParser.readLine();

			assertEquals(row3, res3);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void test4() {
		try {
			CSVParser csvParser = new CSVParser(new FileReader("test data/testCSVParser2.csv"));
			
			ArrayList<String> row4 = new ArrayList<String>();
			row4.add("test");
			row4.add("here,\nhere");
			row4.add("134");
			
			ArrayList<String> res4 = csvParser.readLine();
			
			assertEquals(row4, res4);

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
