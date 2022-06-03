package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.game.point_and_click.locations.Drawer;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.Food;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.InteractiveHandler;

import java.util.Arrays;

/**
 * A drawer in Level 3
 */
public class L3Drawer extends Drawer {
    /**
     * Class constructor
     *
     * @param changer the screen change handler
     * @param handler the interactive consumable handler
     */
    public L3Drawer(ScreenChanger changer, InteractiveHandler handler) {
        super(changer, false);

        addObjects(Arrays.asList(
                new Food(302, 245) {
                    @Override
                    public void onConsume() {
                        handler.onConsume(this);
                    }
                },
                new Food(504, 246) {
                    @Override
                    public void onConsume() {
                        handler.onConsume(this);
                    }
                }
        ));
    }
}
