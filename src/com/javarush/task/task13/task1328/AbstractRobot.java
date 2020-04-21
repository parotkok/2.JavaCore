package com.javarush.task.task13.task1328;

public class AbstractRobot implements Defensable, Attackable{
    protected String name;
    private static int hitCount;

    public String getName() {                             //геттер имя
        return name;
    }
    public BodyPart attack() {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            attackedBodyPart = BodyPart.ARM;
        } else if (hitCount == 2) {
            attackedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 3) {
            attackedBodyPart = BodyPart.LEG;
        }else if (hitCount == 4){
            attackedBodyPart = BodyPart.CHEST;
            hitCount = 0;

        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defendedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1) {
            defendedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defendedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            defendedBodyPart = BodyPart.ARM;
        } else if (hitCount == 4) {
            defendedBodyPart = BodyPart.CHEST;
            hitCount = 0;

        }
        return defendedBodyPart;
    }

}
