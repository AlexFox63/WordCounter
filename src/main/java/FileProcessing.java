import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс FileProcessing определеяет методы работы текстовым документом.
 */
public class FileProcessing {
    /**
     * Поле для работы с файловой системой.
     */
    private FileWriter fileWriter;
    /**
     * Поле, определяющее название файла.
     */
    private String fileName;
    /**
     * Метод создания файла для записи html страницы.
     */
    public FileProcessing(String fileName) throws IOException {
        this.fileName = fileName;
        fileWriter = new FileWriter(fileName, false);
    }
    /**
     * Метод получения объекта FileWriter.
     */
    public FileWriter getFileWriter() {
        return fileWriter;
    }
    /**
     * Метод записи в файл.
     */
    public void writeToFile(String data) throws IOException {
        fileWriter.write(data);
        fileWriter.flush();
    }
    /**
     * Метод получения текста, который виден пользователю, из html документа.
     */
    public String getTextFromDoc(Document doc) {
        Elements elements = doc.getAllElements();
        StringBuilder clearText = new StringBuilder();
        for (Element element : elements) {
            if (!element.ownText().matches("<.+?>") && !element.ownText().matches("^s*$")) {
                clearText.append(element.ownText()).append(' ');
            }
        }
        return clearText.toString();
    }
}
