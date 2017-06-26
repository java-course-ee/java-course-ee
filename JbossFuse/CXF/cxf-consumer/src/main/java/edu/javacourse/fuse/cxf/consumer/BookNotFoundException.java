package edu.javacourse.fuse.cxf.consumer;

/**
 * @author Artem Pronchakov pronchakov.artem@ocrv.ru
 */
public class BookNotFoundException extends Exception {

    public BookNotFoundException(String message) {
        super(message);
    }
}
