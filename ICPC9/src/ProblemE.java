import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ProblemE {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		boolean termMode = false;

		ArrayList<String> bagOfWords = new ArrayList<String>();
		ArrayList<String> queryList = new ArrayList<String>();

		while (kb.hasNextLine()) {
			String line = kb.nextLine();

			if (line.equals("#"))
				break;

			if (line.equals("*")) {
				termMode = true;
				continue;
			}

			if (line.equals("**")) {

				Collections.sort(bagOfWords);
				for (String query : queryList) {
					boolean success = false;
					for (String word : bagOfWords) {
						if(matchQuery(word, query)) {
							System.out.println(word);
							success = true;
							break;
						}
					}
					if(!success) {
						System.out.println("NONE");
					}
				}

				bagOfWords.clear();
				queryList.clear();
				termMode = false;
				System.out.println("$");
				continue;
			}

			if (termMode) {
				queryList.add(line);
			} else {
				bagOfWords.add(line);
			}
		}
	}

	private static boolean matchQuery(String word, String query) {
		String[] terms = query.split("\\|");
		for(int i = 0; i < terms.length; i++) {
			if(matchTerm(word, terms[i])) {
				return true;
			}
		}
		return false;
	}

	public static boolean matchTerm(String work, String term) {
		ArrayList<String> posWords = new ArrayList<String>();
		ArrayList<String> negWords = new ArrayList<String>();
		ArrayList<String> normWords = new ArrayList<String>();

		for (int i = 0; i < term.length(); i++) {
			if (term.charAt(i) == '+') {
				posWords.add(term.charAt(i + 1) + "");
				i++;
			} else if (term.charAt(i) == '-') {
				negWords.add(term.charAt(i + 1) + "");
				i++;
			} else {
				normWords.add(term.charAt(i) + "");
			}
		}
//
//		System.out.println("term: " + term);
//
//		System.out.println("pos: " + posWords);
//		System.out.println("neg: " + negWords);
//		System.out.println("norm: " + normWords);

		
		for(String q : posWords) {
			if(!work.contains(q)) {
				return false;
			}
		}
		
		for(String q : negWords) {
			if(work.contains(q)) {
				return false;
			}
		}
		
		for(String q : normWords) {
			if(work.contains(q)) {
				return true;
			}
		}
		
		return false;
	}

}
