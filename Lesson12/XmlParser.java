package Lesson121;

public interface XmlParser<T> {
    T parse(String file) throws Exception;
}
