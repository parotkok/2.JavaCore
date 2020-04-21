package com.javarush.task.task13.task1328;

public final class BodyPart {
    final static BodyPart LEG = new BodyPart("нога");        // объекты BodyPart: нога рука голова
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");
    final static BodyPart CHEST = new BodyPart("грудь");
    private String bodyPart;                                 //переменная

    private BodyPart(String bodyPart) {                      //коструктор: создает объект, задает переменную
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {                               //переопределение toString
        return this.bodyPart;
    }
}
