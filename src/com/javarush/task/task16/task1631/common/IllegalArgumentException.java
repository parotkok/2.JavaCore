package com.javarush.task.task16.task1631.common;

public class IllegalArgumentException extends Exception {
    private String messageException = "Неизвестный тип картинки";

    public IllegalArgumentException() {}

    public IllegalArgumentException(String messageException) {
        this.messageException = messageException;
    }

    @Override
    public String getMessage() {
        return messageException;
    }
}
