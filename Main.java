import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args)
    {
        User neelesh = new User(1,"Neelesh");
        User priyansh = new User(2,"Priyansh");
        Queue<User> users = new LinkedList<User>();
        users.add(priyansh);
        users.add(neelesh);
        Dice dice = new Dice(1);
        Jumper snake1 = new Jumper(99,2);
        Jumper snake2 = new Jumper(70,50);
        List<Jumper> snakes = new ArrayList<Jumper>();
        snakes.add(snake1);
        snakes.add(snake2);    
        Jumper ladder1 = new Jumper(10,90);
        Jumper ladder2 = new Jumper(22,66);
        List<Jumper> ladders = new ArrayList<Jumper>();
        ladders.add(ladder1);
        ladders.add(ladder2);

        HashMap<String, Integer> currenPosition = new HashMap<String, Integer>();
        currenPosition.put("Neelesh",0);
        currenPosition.put("Priyansh",0);
        int boardSize = 100;
        GameBoard game = new GameBoard(boardSize ,dice, users,snakes,ladders,currenPosition);
        game.StartGame();
    }
    
}
