public class Game {
    Level current;
    LevelLector lector;

    public Game(LevelLector l){
        lector = l;
        nextLevel();
    }

    public Level level(){
        return current;
    }

    public boolean nextLevel(){
        current = lector.readNextLevel();
        return current != null;
    }
}
