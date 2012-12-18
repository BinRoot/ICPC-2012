import java.util.Scanner;

public class ProblemI {

	public static int tauntChoices = 0;

	public static String taunt() {
		tauntChoices++;
		int num = 4;
		String result = "";
		switch (((tauntChoices - 1) % num) + 1) {
		case 1:
			result =  sentence();
			break;
		case 2:
			result =  taunt() + " " + sentence();
			break;
		case 3:
			result =   noun() + "!";
			break;
		case 4:
			result =   sentence();
			break;
		}
		String capResult = result.substring(0, 1).toUpperCase() + result.substring(1);
		return capResult;
	}

	public static int sentenceChoices = 0;

	private static String sentence() {
		sentenceChoices++;
		int num = 3;
		String result = "";
		switch ((sentenceChoices - 1) % num + 1) {
		case 1:
			result =  pastrel() + " " + nounphrase();
			break;
		case 2:
			result =  presentrel() + " " + nounphrase();
			break;
		case 3:
			result = pastrel() + " " + article() + " " + noun();
			break;
		}

		String capResult = result.substring(0, 1).toUpperCase() + result.substring(1);
		return capResult;
	}

	public static int nounphraseChoices = 0;

	public static String nounphrase() {
		nounphraseChoices++;
		int num = 1;
		return article() + " " + modifiednoun();
	}

	public static int modifiednounChoices = 0;

	public static String modifiednoun() {
		modifiednounChoices++;
		int num = 2;
		switch ((modifiednounChoices - 1) % num + 1) {
		case 1:
			return noun();
		case 2:
			return modifier() + " " + noun();
		}
		return null;
	}

	public static int modifierC = 0;

	public static String modifier() {
		modifierC++;
		int num = 2;
		switch ((modifierC - 1) % num + 1) {
		case 1:
			return adjective();
		case 2:
			return adverb() + " " + adjective();
		}
		return null;
	}

	public static int presentrelC = 0;

	public static String presentrel() {
		presentrelC++;
		int num = 0;
		return "your " + presentperson() + " " + presentverb();
	}

	public static int pastrelC = 0;

	public static String pastrel() {
		pastrelC++;
		int num = 0;
		return "your " + pastperson() + " " + pastverb();
	}

	public static int presentpersonC = 0;

	public static String presentperson() {
		presentpersonC++;
		int num = 3;
		switch ((presentpersonC - 1) % num + 1) {
		case 1:
			return "steed";
		case 2:
			return "king";
		case 3:
			return "first-born";
		}
		return null;
	}

	public static int pastpersonC = 0;

	public static String pastperson() {
		pastpersonC++;
		int num = 5;
		switch ((pastpersonC - 1) % num + 1) {
		case 1:
			return "mother";
		case 2:
			return "father";
		case 3:
			return "grandmother";
		case 4:
			return "grandfather";
		case 5:
			return "godfather";
		}
		return null;
	}

	public static int nounC = 0;

	public static String noun() {
		nounC++;
		int num = 11;
		switch ((nounC - 1) % num + 1) {
		case 1:
			return "hamster";
		case 2:
			return "coconut";
		case 3:
			return "duck";
		case 4:
			return "herring";
		case 5:
			return "newt";
		case 6:
			return "peril";
		case 7:
			return "chicken";
		case 8:
			return "vole";
		case 9:
			return "parrot";
		case 10:
			return "mouse";
		case 11:
			return "twit";
		}
		return null;
	}

	public static int presentverbC = 0;

	public static String presentverb() {
		presentverbC++;
		int num = 2;
		switch ((presentverbC - 1) % num + 1) {
		case 1:
			return "is";
		case 2:
			return "masquerades as";
		}
		return null;
	}

	public static int pastverbC = 0;

	public static String pastverb() {
		pastverbC++;
		int num = 2;
		switch ((pastverbC - 1) % num + 1) {
		case 1:
			return "was";
		case 2:
			return "personified";
		}
		return null;
	}

	public static String article() {
		return "a";
	}

	public static int adjectiveC = 0;

	public static String adjective() {
		adjectiveC++;
		int num = 7;
		switch ((adjectiveC - 1) % num + 1) {
		case 1:
			return "silly";
		case 2:
			return "wicked";
		case 3:
			return "sordid";
		case 4:
			return "naughty";
		case 5:
			return "repulsive";
		case 6:
			return "malodorous";
		case 7:
			return "ill-tempered";
		}
		return null;
	}

	public static int adverbC = 0;

	public static String adverb() {
		adverbC++;
		int num = 5;
		switch ((adverbC - 1) % num + 1) {
		case 1:
			return "conspicuously";
		case 2:
			return "categorically";
		case 3:
			return "positively";
		case 4:
			return "cruelly";
		case 5:
			return "incontrovertibly";
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		while (kb.hasNextLine()) {


			String line[] = kb.nextLine().split("\\s");
			System.out.print("Knight: ");

			StringBuilder grailfinder = new StringBuilder("");

			for (int i = 0; i < line.length; i++) {
				if (line[i].trim().length() == 0) {
					continue;
				}
				if (i > 0) {
					System.out.print(" ");
				}
				System.out.print(line[i]);
				grailfinder.append(line[i]);
			}
			System.out.println();

			int numOutputs = 0;
			for (int i = 0; i < line.length; i++) {
				for (int c = 0; c < line[i].length(); c++) {
					char letter = line[i].charAt(c);
					if ((letter >= 'a' && letter <= 'z')
							|| (letter >= 'A' && letter <= 'Z')) {
						numOutputs++;
						break;
					}
				}
			}
			numOutputs = ((numOutputs - 1) / 3) + 1;
			String testString = grailfinder.toString().toLowerCase();
			if (testString.matches(".*t.*h.*e.*h.*o.*l.*y.*g.*r.*a.*i.*l.*")) {
				System.out.println("Taunter: (A childish hand gesture).");
				numOutputs -= 1;
			}
			for (int i = 0; i < numOutputs; i++) {
				if (tauntChoices == 1) {
					i++;
				}
				System.out.println("Taunter: " + taunt() + ".");
			}
			System.out.println();
		}
	}
}
