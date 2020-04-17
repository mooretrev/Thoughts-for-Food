public class Main {
	
	//controls whether the program index or starts the app
	public static void main(String[] args) {
		System.out.println("main start");
		if(args.length >= 1) {
			String action = args[0];
			System.out.println(action);
			
			switch (action) {
			case "index": {
				System.out.println("indexing");
				IndexMain.main(null);
				System.out.println("finished");
				return;
			}
			case "app":{
				ApplicationMain.main(null);
				return;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
			
		}else {
			ApplicationMain.main(null);

		}
		
	}

}
