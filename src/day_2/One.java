package src.day_2;

public class One {
	static private String path = "example.txt";
	// private InputReader inputReader = new InputReader(path);

	public static void main(String[] args) {

		if (args.length == 1) {
			path = args[0];
		} else {
			System.out.println("INFO - Please provide input file! Now using example input (example.txt)");
		}

		InputReader inputReader = new InputReader(path);
	}
}
