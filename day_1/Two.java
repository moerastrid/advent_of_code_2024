import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Two {
	static private String pathname = "example.txt";
	static private List<Long> leftList = new ArrayList<Long>();
	static private List<Long> rightList = new LinkedList<Long>();

	public static void main(String [] args) {
		if (args.length == 1) {
			pathname = args[0];
		} else {
			System.out.println("INFO - Please provide input file! Now using example input (example.txt)");
		}

		if (convertFileToLists(pathname) != 0)
			return;
		
		sortLists();

		Long score = getScore();
		System.out.println("ANSWER: " + score);
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
		leftList.add(Long.parseLong(parts[0]));
		rightList.add(Long.parseLong(parts[1]));
	}

	static private void sortLists() {
		Collections.sort(leftList);
		Collections.sort(rightList);

		System.out.println("Left  list: " + leftList);
		System.out.println("Right list: " + rightList);
	}

	static private Long getScore() {
		int i;
		int j;
		Long finalScore = (long) 0;

		i = 0;
		while (i < leftList.size()) {
			System.out.println("\nLeft #" + i + ": " + leftList.get(i));
			j = 0;
			Long count = (long) 0;
			Long score = (long) 0;
			while (j < rightList.size()) {
				System.out.println("Right #" + j + ": " + rightList.get(j));
				if (leftList.get(i) > rightList.get(j)) {
					System.out.println("left > right");
				} else if (leftList.get(i).equals(rightList.get(j))) {
					System.out.println("SAAAMEE!!!");
					count++;			
				} else {
					System.out.println("left < right");
					if (count != 0) {
						score = leftList.get(i) * count;
						System.out.println("l: " + leftList.get(i) + " score: " + score + " count: " + count);
						finalScore += score;
					}
					j = rightList.size();
				}
				j++;
			}
			i++;
		}
		return finalScore;
	}
}
