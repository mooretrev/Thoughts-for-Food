import java.io.FileReader;

import com.opencsv.CSVReader;

import index.IndexRecipes;

public class Main {
	
	//controls whether the program index or starts the app

	public static void main(String[] args) {
		System.out.println("main start");
		
		if(args.length > 1) {
			String action = args[0];
			
			switch (action) {
			case "index": {
				System.out.println("indexing");
				IndexMain.main();
				System.out.println("finished");

				break;
			}
			case "app":{
				ApplicationMain.main();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
			
		}else {
			ApplicationMain.main();

		}
		
	}

}
