package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

import javafx.scene.image.Image;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.overlays.DiaryOverlay;

public abstract class Diary extends Consumable{
    /**
     * the dimensions of the checklist
     */
    public static final int WIDTH=30, HEIGHT=26;
    /**
     * the screen changer
     */
    private final ScreenChanger changer;
    /**
     * the current screen
     */
    private final Location cur;

    /**
     * Class constructor
     *
     * @param x        x of bounding box
     * @param y        y of bounding box
     * @param changer  the screen changer
     * @param cur      the current location
     */
    public Diary(int x, int y, ScreenChanger changer, Location cur) {
        super(Tools.getImage("assets/diary.png"), Tools.getImage("assets/diary.png"),
                Tools.getImage("assets/diary.png"), x, y, WIDTH, HEIGHT);
        this.changer = changer;
        this.cur = cur;
    }

    @Override
    public void onClick() {
        super.onClick();
        changer.screenChange(new DiaryOverlay(cur, changer));
    }
}
