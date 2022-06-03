package mellasonic.nipped.game.point_and_click.locations.level3.interactives;

public interface InteractiveHandler {
    /**
     * called when an interactive object is consumed
     * @param object the consumed object
     */
    void onConsume(Interactive object);
}
