/* ICS Final Project Nipped
 2022/06/06
 Time spent: 20 min
*/

/*
 Nipped is a java game with three different levels.
 Version 1.1 - 6 June 2022
 Authors: Daniel Ye, James Huynh, Eric Jin
*/

/*
 Modification Authors: James Huynh, Eric Jin
 Version 1.1
 2022/06/06
 Time spent: 20 min
 New features/processing: create book
*/

package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import mellasonic.nipped.Tools;

public abstract class Book extends Consumable{
    /**
     * dimensions of the book
     */
    public static int WIDTH=45, HEIGHT=39;
    public static int CAT_WIDTH=60, CAT_HEIGHT=80;
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
        y -= (CAT_HEIGHT - HEIGHT - 10);
        setPosition(x, y);
        setDimensions(CAT_WIDTH, CAT_HEIGHT);
    }
}
