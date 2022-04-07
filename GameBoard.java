import java.util.HashMap;
import java.util.List;

import java.util.Queue;

public class GameBoard {
    private Dice dice;;
    private Queue<User> users;
    private List<Jumper> snakes;
    private List<Jumper> ladders;
    private HashMap<String, Integer> currenPosition;
    int boardSize;

    GameBoard(int boardSize, Dice dice,Queue<User> users,List<Jumper> snakes , List<Jumper> ladders,HashMap<String, Integer> currenPosition)
    {
        this.boardSize = boardSize;;
        this.dice = dice;
        this.currenPosition = currenPosition;
        this.ladders = ladders;
        this.snakes = snakes;
        this.users = users;

    } 
    void StartGame()
    {
        while(users.size() > 1)
        {
               User user = users.poll();
               int position = currenPosition.get(user.getUserName());
               int diceValue = dice.rollDice();
               System.out.println(user.getUserName() + " Dice Value: " + diceValue);
               int nextCell = position + diceValue;
               if(nextCell>boardSize)
               {
                   users.offer(user);
               }     
               else if(nextCell == boardSize)
               {
                   System.out.println(user.getUserName()+"Won");
               }
               else
               {
                   int[] nextPosition = new int[1];
                   boolean b[] = new boolean[1];
                   nextPosition[0] = nextCell;
                   snakes.forEach(snake->{
                       if(snake.startPoint == nextCell)
                       {
                           nextPosition[0] = snake.startPoint;
                       }
                });
                if(nextPosition[0] != nextCell)
                {
                    System.out.println(user.getUserName()+"Bitten by Snake");
                }
                ladders.forEach(ladder->{
                    if(ladder.startPoint == nextCell)
                    {
                        nextPosition[0] = nextCell;
                        b[0] = true;
                    }

                });
                if(nextPosition[0] != nextCell && b[0] == true)
                {
                    System.out.println(user.getUserName(    )+"Climbed up hte ladder");
                }
                if(nextPosition[0] == boardSize)
                {
                    System.out.println(user.getUserName()+"Won");
                }
                else{
                    currenPosition.put(user.getUserName(), nextPosition[0]);
                    System.out.println(user.getUserName()+"is at position "+nextPosition[0]);
                    users.offer(user);
                }
               }

        }
    }

}
