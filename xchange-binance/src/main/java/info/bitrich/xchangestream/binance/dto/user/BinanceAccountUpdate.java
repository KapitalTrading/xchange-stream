package info.bitrich.xchangestream.binance.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * {
 * "e": "outboundAccountInfo",   // Event type
 * "E": 1499405658849,           // Event time
 * "t": 0,                       // Taker commission rate (bips)
 * "b": 0,                       // Buyer commission rate (bips)
 * "s": 0,                       // Seller commission rate (bips)
 * "T": true,                    // Can trade?
 * "W": true,                    // Can withdraw?
 * "D": true,                    // Can deposit?
 * "u": 1499405658848,           // Time of last account update
 * "B": [                        // Balances array
 * {
 * "a": "LTC",               // Asset
 * "f": "17366.18538083",    // Free amount
 * "l": "0.00000000"         // Locked amount
 * },
 * {
 * "a": "BTC",
 * "f": "10537.85314051",
 * "l": "2.19464093"
 * },
 * {
 * "a": "ETH",
 * "f": "17902.35190619",
 * "l": "0.00000000"
 * },
 * {
 * "a": "BNC",
 * "f": "1114503.29769312",
 * "l": "0.00000000"
 * },
 * {
 * "a": "NEO",
 * "f": "0.00000000",
 * "l": "0.00000000"
 * }
 * ]
 * }
 *
 * @author Nikita Belenkiy on 25/07/2018.
 */
public class BinanceAccountUpdate {

    public static final String EVENT_TYPE = "outboundAccountInfo";
    /**
     * "e": "outboundAccountInfo",        // Event type
     */
    @JsonProperty("e")
    private String eventType;
    /**
     * "E": 1499405658658,            // Event time
     */
    @JsonProperty("E")
    private long eventTime;

    /**
     * "t": 0,                       // Taker commission rate (bips)
     */
    @JsonProperty("t")
    private long takerCommissionRate;
    /**
     * "m": 0,                       // Maker commission rate (bips)
     */
    @JsonProperty("m")
    private long makerCommissionRate;
    /**
     * "s": 0,                       // Seller commission rate (bips)
     */
    @JsonProperty("s")
    private long sellerCommissionRate;
    /**
     * "T": true,                    // Can trade?
     */
    @JsonProperty("T")
    private boolean canTrade;
    /**
     * "W": true,                    // Can withdraw?
     */
    @JsonProperty("W")
    private boolean canWithdraw;

    /**
     * "D": true,                    // Can deposit?
     */
    @JsonProperty("D")
    private boolean canDeposit;

    /**
     * "u": 1499405658848,           // Time of last account update
     */
    @JsonProperty("u")
    private boolean lastAccountUpdate;

    @JsonProperty("B")
    private List<Balance> balances;

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public long getTakerCommissionRate() {
        return takerCommissionRate;
    }

    public void setTakerCommissionRate(long takerCommissionRate) {
        this.takerCommissionRate = takerCommissionRate;
    }

    public long getMakerCommissionRate() {
        return makerCommissionRate;
    }

    public void setMakerCommissionRate(long makerCommissionRate) {
        this.makerCommissionRate = makerCommissionRate;
    }

    public long getSellerCommissionRate() {
        return sellerCommissionRate;
    }

    public void setSellerCommissionRate(long sellerCommissionRate) {
        this.sellerCommissionRate = sellerCommissionRate;
    }

    public boolean isCanTrade() {
        return canTrade;
    }

    public void setCanTrade(boolean canTrade) {
        this.canTrade = canTrade;
    }

    public boolean isCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public boolean isCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public boolean isLastAccountUpdate() {
        return lastAccountUpdate;
    }

    public void setLastAccountUpdate(boolean lastAccountUpdate) {
        this.lastAccountUpdate = lastAccountUpdate;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BinanceAccountUpdate{");
        sb.append("eventType='").append(eventType).append('\'');
        sb.append(", eventTime=").append(eventTime);
        sb.append(", takerCommissionRate=").append(takerCommissionRate);
        sb.append(", makerCommissionRate=").append(makerCommissionRate);
        sb.append(", sellerCommissionRate=").append(sellerCommissionRate);
        sb.append(", canTrade=").append(canTrade);
        sb.append(", canWithdraw=").append(canWithdraw);
        sb.append(", canDeposit=").append(canDeposit);
        sb.append(", lastAccountUpdate=").append(lastAccountUpdate);
        sb.append(", balances=").append(balances);
        sb.append('}');
        return sb.toString();
    }

    public static class Balance {
        /**
         * "a": "LTC",               // Asset
         */
        @JsonProperty("a")
        private String asset;
        /**
         * "f": "17366.18538083",    // Free amount
         */
        @JsonProperty("f")
        private BigDecimal freeAmount;
        /**
         * "l": "0.00000000"         // Locked amount
         */
        @JsonProperty("l")
        private BigDecimal lockedAmount;

        public String getAsset() {
            return asset;
        }

        public void setAsset(String asset) {
            this.asset = asset;
        }

        public BigDecimal getFreeAmount() {
            return freeAmount;
        }

        public void setFreeAmount(BigDecimal freeAmount) {
            this.freeAmount = freeAmount;
        }

        public BigDecimal getLockedAmount() {
            return lockedAmount;
        }

        public void setLockedAmount(BigDecimal lockedAmount) {
            this.lockedAmount = lockedAmount;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Balance{");
            sb.append("asset='").append(asset).append('\'');
            sb.append(", freeAmount=").append(freeAmount);
            sb.append(", lockedAmount=").append(lockedAmount);
            sb.append('}');
            return sb.toString();
        }
    }
}
