import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bear extends Actor {
    public void act() {
        moveWithKeys(); //Event handling for keyboard input
        catchFish(); //Event handling for collecting Fish
        checkCollisionWithObstacle(); //Event handling for Bombs 
    }
    private void moveWithKeys() {
        //Event handling moving using arrow keys
        if (Greenfoot.isKeyDown("left")) {
            move(-5);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(5);
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - 5);
        }
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + 5);
        }
    }
    public void catchFish() {
        //Event handling detects collision with a Fish
        if (isTouching(Fish.class)) {
            removeTouching(Fish.class);
            ((GameWorld)getWorld()).incrementScore();
            ((GameWorld)getWorld()).spawnFish();
        }
    }
    private void checkCollisionWithObstacle() {
        //Event handling detect collision with Bombs
       if (isTouching(obstacle.class)) {
        Greenfoot.stop();
        getWorld().showText("Game Over! Final Score: " + ((GameWorld)getWorld()).getScore(), 300, 200);// Game ends on loss
    }
    }
    }



