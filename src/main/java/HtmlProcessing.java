import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Класс HtmlProcessing определеяет методы работы с веб страницей и html документом.
 */
public class HtmlProcessing {
    /**
     * Поле для хранения url ссылки.
     */
    private String url;
    /**
     * Поле для хранения html страницы.
     */
    private Document pageDoc;
    /**
     * Конструктор по умолчанию, который вызывает метод getHtml, для подключения и загрузки html страницы.
     */
    public HtmlProcessing(String url) throws IOException {
        this.url = url;
        this.pageDoc = getHtml(url);
    }
    /**
     * Метод для получения поля url.
     */
    public String getUrl() {
        return url;
    }
    /**
     * Метод для задания поля url.
     */
    public void setUrl(String url) {
        this.url = url;
    }
    /**
     * Метод для получения поля pageDoc.
     */
    public Document getPageDoc() {
        return pageDoc;
    }
    /**
     * Метод для получения поля html странички с помощью библиотеки Jsoup.
     */
    private Document getHtml(String url) throws IOException {
        return Jsoup.connect(url).get();
    }
    /**
     * Метод удаления ненужных тегов из html документа.
     */
    public void delTagFromHtml(String tagName) {
        pageDoc.select(tagName).remove();
    }

}
