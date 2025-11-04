import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (Dino Angelovski) 
 * @version (Version 1)
 */
public class GameWorld extends World {
    private int score = 0;          //Current score
    private final int WIN_SCORE = 15; //Score to win the game
    private int obstacleTimer = 0;  //Timer to spawn Bombs
    public GameWorld() {
        super(600, 400, 1); //World borders
        setBackground("game_background.png"); //Background image

        //Make Bear
        addObject(new Bear(), 300, 200);

        //Spawn Fish
        spawnFish();

        //Spawn Bombs
        spawnObstacles();

        //Display Score
        showScore();
    }
    public void act() {
        //Event handling:Bomb timer and spawn Bombs periodically
        obstacleTimer++;
        if (obstacleTimer % 100 == 0) {  //Spawns a Bomb every 100 frames
            spawnObstacles();
        }
    }
    public void incrementScore() {
        score++;
        showScore(); //Update score on screen
        //Event handling:Checks if player wins
        if (score >= WIN_SCORE) {
            showWinMessage();
        }
    }
    private void showScore() {
        showText("Score: " + score, 50, 20); //Show score at top left corner
    }
    public void spawnFish() {
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400); 
        addObject(new Fish(), x, y); //Spawn a fish in a random location
    }
    public void spawnObstacles() {
        int x = Greenfoot.getRandomNumber(600);
        int y = Greenfoot.getRandomNumber(400); 
        //Bombs dont spawn on top of the bear
        if (isSpotAvailable(x, y)) {
            addObject(new obstacle(), x, y); //Add Bombs to the world
        }
    }
    private boolean isSpotAvailable(int x, int y) {
        //Checks if the spot is too close to the bears position
         Actor bear = getObjects(Bear.class).get(0);
        return Math.abs(x - bear.getX()) > 50 && Math.abs(y - bear.getY()) > 50; //Ensures the distance from the bear
    }
    private void showWinMessage() {
        showText("You Win! Final Score: " + score, getWidth() / 2, getHeight() / 2);
        Greenfoot.stop(); //Event handling:Stops the game when you win
    }
    public int getScore() {
        return score;
    }
}




