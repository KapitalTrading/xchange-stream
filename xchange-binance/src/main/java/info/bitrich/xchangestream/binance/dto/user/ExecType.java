package info.bitrich.xchangestream.binance.dto.user;

/**
 * @author Nikita Belenkiy on 27/08/2018.
 */
public enum ExecType {
    NEW,
    CANCELED,
    //            (currently unused)
    REPLACED,
    REJECTED,
    TRADE,
    EXPIRED;
}
