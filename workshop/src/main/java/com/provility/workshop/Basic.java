package com.provility.workshop;

public class Basic{

    public static void main(String arg[]){

        Bag bag = new Bag(2,10);

        while(bag.canNext()) {
            System.out.println(bag.to);

        }
    }
    static class Bag{
        int from;
        int to;

        Bag(int x, int y){
            this.from = x;
            this.to = y;
        }

        boolean canNext() {
            return this.from < this.to;
        }

    }
}

