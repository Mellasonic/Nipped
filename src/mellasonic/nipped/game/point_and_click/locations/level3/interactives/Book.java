package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;

public abstract class Book extends Consumable{
    /**
     * dimensions of the book
     */
    public static int WIDTH=45, HEIGHT=39;
    public static int CAT_WIDTH=70, CAT_HEIGHT=70;
    /**
     * position of the book
     */
    private int x, y;

    /**
     * Class constructor
     *
     * @param x        x of bounding box
     * @param y        y of bounding box
     */
    public Book(int x, int y) {
        super(Tools.getImage("assets/book.png"), Tools.getImage("assets/book.png"),
                Tools.getImage("assets/readingcat.png"), x, y, WIDTH, HEIGHT);
        this.x = x;
        this.y = y;
    }

    @Override
    public void onClick(){
        super.onClick();

        // reposition and resize the sprite
        x -= (CAT_WIDTH - WIDTH) / 2;
        y -= (CAT_HEIGHT - HEIGHT);
        setPosition(x, y);
        setDimensions(CAT_WIDTH, CAT_HEIGHT);
    }
}
