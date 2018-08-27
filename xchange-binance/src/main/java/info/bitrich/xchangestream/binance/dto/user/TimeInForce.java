package info.bitrich.xchangestream.binance.dto.user;

/**
 * @author Nikita Belenkiy on 27/08/2018.
 */
public enum TimeInForce {
    /**
     * good till cancel
     */
    GTC,
    /**
     * immediate or cancel
     */
    IOC,
    /**
     * fill or kill
     */
    FOK
}
