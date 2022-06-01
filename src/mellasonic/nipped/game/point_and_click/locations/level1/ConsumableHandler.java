package mellasonic.nipped.game.point_and_click.locations.level1;

/**
 * a handler for consumable objects
 */
public interface ConsumableHandler {
    /**
     * Called when a consumable is consumed in level 1
     * @param consumed the consumed consumable
     */
    void onConsume(Consumable consumed);
}
