package src.day_2;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class InputReader {
	private File file;
	private String path;
	private BufferedReader br;

	InputReader(String _path) {
		this.path = _path;
		this.file = new File(path);
	}

	public List<Integer> convertFileToIntegerList() {
		List<Integer> inputList = new List<Integer>; 

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
}