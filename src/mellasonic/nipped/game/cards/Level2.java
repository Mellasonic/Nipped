/* ICS Final Project Nipped
 2022/05/16
 Time spent: 10 mins
*/

/*
 Nipped is a java game with three different levels.
 Version 1.0 - 16 May 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: Daniel Ye
 Version 1.0
 2022/05/16
 Time spent: 10 mins
 New features/processing: create level 2 template
*/

package mellasonic.nipped.game.cards;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Level 2
 */
public abstract class Level2 implements Level {
    /**
     * The current pane
     */
    private final Pane cur;
    /**
     * a list of questions
     */
    private static final List<CardTemplate> cards = Arrays.asList(
            new CardTemplate(Tools.getImage("assets/burger.png"), "Food can trigger dopamine centers in the brain similar to addictive drugs.", true),
            new CardTemplate(Tools.getImage("assets/catface.png"), "Food addicts often don’t feel guilty, and their actions usually only occur once.", false),
            new CardTemplate(Tools.getImage("assets/apple.png"), "Food addicts should focus on eating unhealthy foods.", false),
            new CardTemplate(Tools.getImage("assets/catface.png"), "Abuse of food can lead to many different effects, both physically and emotionally.", true),
            new CardTemplate(Tools.getImage("assets/burger.png"), "Food addiction is usually not an issue for teens, especially because they have so many junk food options.", false),
            new CardTemplate(Tools.getImage("assets/book.png"), "Food addicts should try to reduce sugar intake.", true),
            new CardTemplate(Tools.getImage("assets/burger.png"), "Teens eating more food than they did as children is always a sign of food addiction.", false),
            new CardTemplate(Tools.getImage("assets/catface.png"), "Food addiction tends to not have triggers, unlike other addictions.", false),
            new CardTemplate(Tools.getImage("assets/book.png"), "Teenagers are more affected by food and processed foods due to reward centers in the brain.", true),
            new CardTemplate(Tools.getImage("assets/apple.png"), "Food addicts should try to avoid seeking professional help.", false),
            new CardTemplate(Tools.getImage("assets/book.png"), "Food addiction is when food is eaten frequently and it interferes with one’s life.", true)
    );

    /**
     * Class Constructor
     */
    public Level2() {
        cur = new Pane();
        cur.setPrefSize(Main.WIDTH, Main.HEIGHT);

        ImageView bg = new ImageView(Tools.getImage("assets/livingroom.png"));
        bg.setLayoutX(0);
        bg.setLayoutY(0);
        bg.setFitWidth(Main.WIDTH);
        bg.setFitHeight(Main.HEIGHT);
        cur.getChildren().add(bg);

        StreakCounter counter = new StreakCounter();
        counter.getNode().setLayoutX(20);
        cur.getChildren().add(counter.getNode());

        cur.getChildren().add(getCard(0, counter).getNode());
    }

    /**
     * returns a card from an index
     * @param curCard the index of the card content
     * @param counter the streakcounter object
     * @return a card
     */
    public Card getCard(int curCard, StreakCounter counter) {
        CardTemplate cur = cards.get(curCard);
        return new Card(cur.getBackground(), cur.getMessage(), cur.isYes()) {
            @Override
            public void onAnswer(boolean correct) {
                if (correct) {
                    counter.setStreak(counter.getStreak() + 1);
                    if (counter.getStreak() == 5) {
                        nextLevel();
                    }
                } else {
                    counter.setStreak(0);
                }
                int nex = (int) (Math.random() * (cards.size() - 1));
                if(nex == curCard) nex = cards.size() - 1;
                changeCard(getCard(nex, counter));
            }
        };
    }

    /**
     * changes the current card to another
     * @param to the card to change to
     */
    public void changeCard(Card to){
        cur.getChildren().remove(cur.getChildren().size() - 1);
        cur.getChildren().add(to.getNode());
    }

    @Override
    public Parent getNode() {
        return cur;
    }
}
