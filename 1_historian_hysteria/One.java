import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class One {
	static private String pathname = "example.txt";
	static private List<Integer> leftList = new ArrayList<Integer>();
	static private List<Integer> rightList = new LinkedList<Integer>();

	public static void main(String [] args) {
		if (args.length == 1) {
			pathname = args[0];
		} else {
			System.out.println("INFO - Please provide input file! Now using example input (example.txt)");
		}

		if (convertFileToLists(pathname) != 0)
			return;
		
		sortLists();
		Integer distance = getDistance();
		System.out.println("ANSWER: " + distance);
	}

	static private int convertFileToLists(String path) {
		File file;
		String str;
		BufferedReader br;

		file = new File(path);

		try {
			br = new BufferedReader(new FileReader(file));
			while((str = br.readLine()) != null) {
				inputStringToLists(str);
			}
			br.close();
		} catch (FileNotFoundException error) {
			System.out.println("ERROR - invalid file name: " + pathname);
			error.printStackTrace();
			return -1;
		} catch (IOException error) {
			error.printStackTrace();
			return -2;
		} catch (NumberFormatException error) {
			error.printStackTrace();
			return -3;
		}
		return (0);
	}

	static private void inputStringToLists(String str) {
		String[] parts = str.split("   ");
//		System.out.println("Input String: " + str);
//		System.out.println("Devided into: " + parts[0] + ", " + parts[1]);
		leftList.add(Integer.parseInt(parts[0]));
		rightList.add(Integer.parseInt(parts[1]));
	}

	static private void sortLists() {
		Collections.sort(leftList);
		Collections.sort(rightList);
	}

	static private Integer getDistance() {
		Integer totalDistance = 0;

		for (int i = 0; i < leftList.size(); i++) {
			totalDistance += getDiff(i);
		}
		return totalDistance;
	}

	static private Integer getDiff(int i) {
		Integer diff = 0;
		Integer left = leftList.get(i);
		Integer right = rightList.get(i);
		
		if (left > right) {
			diff = left - right;
		} else if (right > left) {
			diff = right - left;
		}
		return diff;
	}
}
