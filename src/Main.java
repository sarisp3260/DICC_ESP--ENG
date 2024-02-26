import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dictionary = createDictionary();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        int difficulty = scanner.nextInt();

        int wordCount;
        switch (difficulty) {
            case 1:
                wordCount = 3;
                break;
            case 2:
                wordCount = 5;
                break;
            case 3:
                wordCount = 7;
                break;
            default:
                System.out.println("Invalid difficulty level. Setting to medium.");
                wordCount = 5;
        }

        String[] selectedWords = selectWords(dictionary, wordCount);

        int correctAnswers = 0;
        int incorrectAnswers = 0;

        System.out.println("Please translate the following words into English:");

        for (String word : selectedWords) {
            System.out.print(word + ": ");
            String userTranslation = scanner.next().trim().toLowerCase();
            String correctTranslation = dictionary.get(word).toLowerCase();

            if (userTranslation.equals(correctTranslation)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect. The correct translation is: " + correctTranslation);
                incorrectAnswers++;
            }
        }

        System.out.println("\n--- Results ---");
        System.out.println("Correct answers: " + correctAnswers);
        System.out.println("Incorrect answers: " + incorrectAnswers);
    }

    private static Map<String, String> createDictionary() {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("televisión", "television");
        dictionary.put("teléfono", "phone");
        dictionary.put("ventana", "window");
        dictionary.put("ropa", "clothes");
        dictionary.put("bosque", "forest");
        dictionary.put("jardín", "garden");
        dictionary.put("reloj", "clock");
        dictionary.put("bolsa", "bag");
        dictionary.put("guitarra", "guitar");
        dictionary.put("música", "music");
        dictionary.put("fiesta", "party");
        dictionary.put("nube", "cloud");
        dictionary.put("playa", "beach");
        dictionary.put("montaña", "mountain");
        dictionary.put("libertad", "freedom");
        dictionary.put("avión", "airplane");
        return dictionary;
    }

    private static String[] selectWords(Map<String, String> dictionary, int count) {
        List<String> allWords = new ArrayList<>(dictionary.keySet());
        Collections.shuffle(allWords);
        return allWords.subList(0, count).toArray(new String[0]);
    }
}
