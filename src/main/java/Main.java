import java.io.*;
import java.util.Scanner;
/**
 * Класс Main является главным классом программы.
 */
public class Main {
    /**
     * Метод main - точка входа в программу.
     */
    public static void main(String[] args) {
        boolean correct = false;
        String url = "";
        /*
          Обработка корректного написания url адреса.
         */
        while (!correct){
            try {
                Scanner in = new Scanner(System.in);
                System.out.print("Введите url-адрес страницы: ");
                url = in.next();
                if (!url.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
                    throw new UrlParseException("Неверный url адрес!");
                }
                correct = true;
            }
            catch (UrlParseException e) {
                System.out.println("Вы ввели некорректный адрес. Попробуйте снова.");
            }
        }
        /*
          Считывание html и анализ текстового файла с последующим выводом в консоль.
         */
        try {
            HtmlProcessing htmlProcessing = new HtmlProcessing(url);

            FileProcessing fileProcessing = new FileProcessing("website.html");
            fileProcessing.writeToFile(String.valueOf(htmlProcessing.getPageDoc()));

            htmlProcessing.delTagFromHtml("script");

            TextAnalysis textAnalysis = new TextAnalysis(fileProcessing.getTextFromDoc(htmlProcessing.getPageDoc()));
            textAnalysis.analysisWords();
            textAnalysis.printTextAnalytics();
        } catch (IOException ioException) {
            System.out.println("Возникла внутренняя ошибка программы. Попробуйте запустить программу заново.");
        }
    }
}
