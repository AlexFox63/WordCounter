/**
 * Класс UrlParseException наследуется от класса Exception, для реализации исключения.
 */
public class UrlParseException extends Exception{
    /**
     * Конструктор по умолчанию.
     */
    public UrlParseException(){
    }
    /**
     * Конструктор, получающий сообщение и вызывающий родительский метод.
     */
    public UrlParseException(String message){
        super(message);
    }
}
