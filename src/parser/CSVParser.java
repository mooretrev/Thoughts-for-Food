package parser;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
	
	private FileReader file;
	
	public CSVParser(FileReader file) {
		this.file = file;
	}

//	public ArrayList<ArrayList<String>> readFile(){
//		ArrayList<ArrayList<String>> parsedFile = new ArrayList<ArrayList<String>>();
//		int ch = 0;
//		
//		try {
//			while((ch=file.read()) != -1) {
//				parsedFile.add(readLine());
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return parsedFile;		
//	}
//	
	public ArrayList<String> readLine(){
		Boolean openQuote = false;
		Boolean openBracket = false;
		
		ArrayList<String> line = new ArrayList<String>();
		
		int ch = 0;
		char _char = ' ';
		String col = "";
		
		try {
			while((ch=file.read()) != -1) {
				_char = (char) ch;
				System.out.print(_char);
				
				switch (_char) {
				case '\"': {
					openQuote = !openQuote;
					break;
				}
				case '[': {
					openBracket = true;
					col += _char;
					break;
				}
				case ']':{
					openBracket = false;
					col += _char;
					break;
				}
				case ',':{					
					if(openBracket || openQuote) {
						col += _char;
					}else {
						line.add(col);
						col = "";
					}
					break;
				}
				case '\n':{
					if(openBracket || openQuote) {
						col += _char;
					}else {
						line.add(col);
						col = "";
						return line;
					}
					break;
				}
				default:
					col += _char;
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return line;
		
	}
	
	public void close() {
		try {
			this.file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
