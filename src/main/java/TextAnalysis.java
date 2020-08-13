import java.util.HashMap;
import java.util.Map;

/**
 * Класс TextAnalysis определеяет методы анализа текста: выделение слов, подсчет слов и печать на экран
 */
public class TextAnalysis {
    /**
     * Поле для хранения текстовых данных из html
     */
    private String pageText;
    /**
     * Поле, представленное в виде словаря, для хранения и подсчета слов в текстовом документе
     */
    private Map<String, Integer> wordStatMap;
    /**
     * Конструктор по умолчанию
     */
    public TextAnalysis(String pageText) {
        this.pageText = pageText;
        this.wordStatMap = new HashMap<>();
        ;
    }
    /**
     * Метод анализа текста. Разбивка текста на слова и подсчет каждого из них.
     * Деление осуществляется с помощью регулярных выражений.
     */
    public void analysisWords() {
        pageText = pageText.replaceAll("[-]", " ");
        for (String word : pageText.split(" ")) {
            word = word.replaceAll("[^a-zA-Zа-яА-Я]", "");
            word = word.toLowerCase();
            if (word.matches("^s*$") || word.matches("^\\w{1}$") || word.matches("^\\W{1}$"))
                continue;
            countWords(word);
        }
    }
    /**
     * Метод подсчета встречающихся слов.
     */
    private void countWords(String word) {
        if (!wordStatMap.containsKey(word)) {
            wordStatMap.put(word, 1);
        } else {
            int count = wordStatMap.get(word);
            wordStatMap.put(word, count + 1);
        }
    }
    /**
     * Метод для вывода в консоль содержимого словаря.
     */
    public void printTextAnalytics() {
        wordStatMap.forEach((key, value) -> System.out.println(key + " - " + value));
    }
}
