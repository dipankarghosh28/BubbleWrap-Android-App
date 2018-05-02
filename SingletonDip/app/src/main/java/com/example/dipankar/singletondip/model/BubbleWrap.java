package com.example.dipankar.singletondip.model;

public class BubbleWrap {
    private static final int ADD_MORE_BUBBLES = 10;
    private int numBubbles;
    private static BubbleWrap instance;
    private BubbleWrap()
    {
        // not letting anyone else instantiate
    }
    public static BubbleWrap getInstance(){
        if(instance == null){
            instance = new BubbleWrap();
        }
        return instance;
    }

    /*
    Normal object Code
     */

    public int getNumBubbles() {
        return numBubbles;
    }
    public void addMoreBubbles(){
        numBubbles += ADD_MORE_BUBBLES;
    }

    public void popBubble() {
        numBubbles--;
        //model
    }

}
