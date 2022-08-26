import java.io.InputStream;

public class Sokoban {
    public static void main(String [] args){
        try{
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream("Levels.txt");
            LevelLector l = new LevelLector(in);
            LevelPrinter p = new LevelPrinter(System.out);

            for( Level lev = l.readNextLevel(); lev != null; lev = l.readNextLevel()){
                p.printLevel(lev);
            }
        }catch (Exception e){
            System.err.println("Something went wrong! " + e);
        }
    }
}
