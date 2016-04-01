import java.util.*;
import java.io.*;
public class StoreCredit {
	public static final String inputName = "A-large-practice.in.txt";
	public static final String outputName = "large-output.txt";
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> problems = new ArrayList<ArrayList<Integer>>();
		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(inputName));
			int cases = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < cases; i++) {
				int credit = Integer.parseInt(br.readLine());
				ArrayList<Integer> items = new ArrayList<Integer>();
				br.readLine(); //ignore line with # of items
				String[] itemStrings = br.readLine().split(" ");
				for (String p : itemStrings) {
					items.add(Integer.parseInt(p));
				}
				items.add(credit); //stuff credit in as last element of items list
				problems.add(items);
			}
			br.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		ArrayList<int[]> solutions = new ArrayList<int[]>();
		for (ArrayList<Integer> problem : problems) {
			solutions.add(findItems(problem));
		}
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputName));
			for (int i = 0; i < solutions.size(); i++) {
				bw.write("Case #" + (i+1) + ": ");
				bw.write(solutions.get(i)[0] + " " + solutions.get(i)[1]);
				bw.newLine();
			}
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static int[] findItems(ArrayList<Integer> items) {
		//brute force -- try every pair
		int credit = items.get(items.size() - 1);
		for (int i = 0; i < items.size() - 1; i++) {
			for (int j = 0; j < items.size() - 1; j++) {
				if (i == j) continue;
				if (items.get(i) + items.get(j) == credit) {
					return new int[]{i+1, j+1};
				}
			}
		}
		return null; //wont get here
	}
}