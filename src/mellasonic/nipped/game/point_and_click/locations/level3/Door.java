package mellasonic.nipped.game.point_and_click.locations.level3;

import mellasonic.nipped.Main;
import mellasonic.nipped.Tools;
import mellasonic.nipped.game.point_and_click.interactives.Button;
import mellasonic.nipped.game.point_and_click.interactives.Direction;
import mellasonic.nipped.game.point_and_click.interactives.Invisible;
import mellasonic.nipped.game.point_and_click.locations.Location;
import mellasonic.nipped.game.point_and_click.locations.ScreenChanger;
import mellasonic.nipped.game.point_and_click.locations.level3.interactives.CatExercise;

import java.util.Arrays;

public abstract class Door extends Location {
    /**
     * whether or not the door is open
     */
    private boolean open;
    /**
     * the living room
     */
    private Location living;

    /**
     * Class constructor
     *
     * @param changer    the screen changer
     */
    public Door(ScreenChanger changer) {
        super(Tools.getImage("assets/doorclose.png"), changer);

        // add the invisible collider and left button
        addObjects(Arrays.asList(
                new Invisible(368, 142, 137, 250, false) {
                    @Override
                    public void onClick() {
                        // open the door
                        open();

                        // add the catexercise object when the door is opened
                        addObjects(Arrays.asList(
                                new CatExercise(368, 142, 137, 250) {
                                    @Override
                                    public void onClick() {
                                        onExercise();
                                    }
                                }
                        ));

                        // remove the invisible object
                        removeObject(this);
                    }
                },
                new Button(Direction.L, 20, Main.HEIGHT / 2 - Button.HEIGHT / 2){
                    @Override
                    public void onClick() {
                        assert living != null;
                        changer.screenChange(living);
                    }
                }
        ));
    }

    /**
     * called when the cat starts exercising
     */
    public abstract void onExercise();

    /**
     * opens the door
     */
    private void open(){
        this.open = true;
        setBackground(Tools.getImage("assets/dooropen.png"));
    }

    /**
     * sets the living room
     * @param living the living room
     */
    public void setLiving(Location living) {
        this.living = living;
    }
}
