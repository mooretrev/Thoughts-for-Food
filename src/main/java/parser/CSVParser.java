package parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVParser {
	
	private BufferedReader file;
	
	public CSVParser(FileReader file) {
		this.file = new BufferedReader(file);
	}
	
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
				case '\r':
					break;
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
			line.add(col);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return line;
		
	}
	
	public void close() {
		try {
			this.file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
