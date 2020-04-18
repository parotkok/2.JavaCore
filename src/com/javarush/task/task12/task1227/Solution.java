package com.javarush.task.task12.task1227;
/*
Fly, Run, Swim для классов Duck, Penguin, Toad
Добавь интерфейсы классам Duck(утка), Penguin(пингвин), Toad(жаба)
*/

public class Solution {
    public static void main(String[] args) {
    }
    public interface CanFly {
        void fly();
    }
    public interface CanRun {
        void run();
    }
    public interface CanSwim {
        void swim();
    }
    public class Duck implements CanFly, CanRun, CanSwim{
        @Override
        public void fly() {
        }
        @Override
        public void run() {
        }
        @Override
        public void swim() {
        }
    }
    public class Penguin implements CanSwim, CanRun{
        @Override
        public void run() {
        }
        @Override
        public void swim() {
        }
    }
    public class Toad implements CanSwim{
        @Override
        public void swim() {
        }
    }
}
