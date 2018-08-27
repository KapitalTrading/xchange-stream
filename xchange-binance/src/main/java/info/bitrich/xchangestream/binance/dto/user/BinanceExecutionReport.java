package info.bitrich.xchangestream.binance.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.knowm.xchange.binance.dto.trade.OrderStatus;
import org.knowm.xchange.binance.dto.trade.OrderType;

import java.math.BigDecimal;

/**
 * @author Nikita Belenkiy on 25/07/2018.
 */
public class BinanceExecutionReport {

        public static final String EVENT_TYPE = "executionReport";

        /**
         * "e": "executionReport",        // Event type
         */
        private String eventType;
        /**
         * "E": 1499405658658,            // Event time
         */
        private long eventTime;
        /**
         * "s": "ETHBTC",                 // Symbol
         */
        private String symbol;
        /**
         * "c": "mUvoqJxFIILMdfAW5iGSOW", // Client order ID
         */
        private String clOrdID;
        /**
         * "S": "BUY",                    // Side
         */
        private String side;
        /**
         * "o": "LIMIT",                  // Order type
         */
        private OrderType orderType;
        /**
         * "f": "GTC",                    // Time in force
         */
        private TimeInForce timeInForce;
        /**
         * "q": "1.00000000",             // Order quantity
         */
        private BigDecimal orderQuantity;
        /**
         * "p": "0.10264410",             // Order price
         */
        private BigDecimal price;
        /**
         * "P": "0.00000000",             // Stop price
         */
        private BigDecimal stopPrice;
        /**
         * "F": "0.00000000",             // Iceberg quantity
         */
        private BigDecimal icebergQuantity;
        /**
         * "C": "null",                   // Original client order ID; This is the ID of the order being canceled
         */
        private String origClOrdID;
        /**
         * "x": "NEW",                    // Current execution type
         */
        private String execType;
        /**
         * "X": "NEW",                    // Current order status
         */
        private OrderStatus ordStatus;
        /**
         * "r": "NONE",                   // Order reject reason; will be an error code.
         */
        private String orderRejectReason;
        /**
         * "i": 4293153,                  // Order ID
         */
        private String orderID;
        /**
         * "l": "0.00000000",             // Last executed quantity
         */
        private BigDecimal lastQty;
        /**
         * "z": "0.00000000",             // Cumulative filled quantity
         */
        private BigDecimal cumFillQty;
        /**
         * "L": "0.00000000",             // Last executed price
         */
        private BigDecimal lastPx;
        /**
         * "n": "0",                      // Commission amount
         */
        private BigDecimal commissionAmt;
        /**
         * "N": null,                     // Commission asset
         */
        private BigDecimal commissionAsset;
        /**
         * "T": 1499405658657,            // Transaction time
         */
        private long transactTime;
        /**
         * "t": -1,                       // Trade ID
         */
        private long tradeId;
        /**
         * "w": true,                     // Is the order working? Stops will have
         */
        private boolean working;
        /**
         * "m": false,                    // Is this trade the maker side?
         */
        private boolean maker;
        /**
         * "O": 1499405658657,            // Order creation time
         */
        private long orderCreationTime;
        /**
         * "Z": "0.00000000"              // Cumulative quote asset transacted quantity
         */
        private BigDecimal cumAssetQty;

        public BinanceExecutionReport(@JsonProperty("e")String eventType, @JsonProperty("E") long eventTime,
                                      @JsonProperty("s") String symbol, @JsonProperty("c") String clOrdID,
                                      @JsonProperty("S") String side,
                                      @JsonProperty("o") OrderType orderType, @JsonProperty("f") TimeInForce timeInForce,
                                      @JsonProperty("q") BigDecimal orderQuantity, @JsonProperty("p") BigDecimal price,
                                      @JsonProperty("P") BigDecimal stopPrice, @JsonProperty("F") BigDecimal icebergQuantity,
                                      @JsonProperty("C") String origClOrdID, @JsonProperty("x") String execType,
                                      @JsonProperty("X") OrderStatus ordStatus, @JsonProperty("r") String orderRejectReason,
                                      @JsonProperty("i") String orderID, @JsonProperty("l") BigDecimal lastQty,
                                      @JsonProperty("z") BigDecimal cumFillQty, @JsonProperty("L") BigDecimal lastPx,
                                      @JsonProperty("n") BigDecimal commissionAmt,
                                      @JsonProperty("N") BigDecimal commissionAsset, @JsonProperty("T") long transactTime,
                                      @JsonProperty("t") long tradeId, @JsonProperty("w") boolean working,
                                      @JsonProperty("m") boolean maker, @JsonProperty("O") long orderCreationTime,
                                      @JsonProperty("Z") BigDecimal cumAssetQty) {

                this.eventType = eventType;
                this.eventTime = eventTime;
                this.symbol = symbol;
                this.clOrdID = "null".equals(clOrdID)?null:clOrdID;
                this.side = side;
                this.orderType = orderType;
                this.timeInForce = timeInForce;
                this.orderQuantity = orderQuantity;
                this.price = price;
                this.stopPrice = stopPrice;
                this.icebergQuantity = icebergQuantity;
                this.origClOrdID = origClOrdID;
                this.execType = execType;
                this.ordStatus = ordStatus;
                this.orderRejectReason = orderRejectReason;
                this.orderID = orderID;
                this.lastQty = lastQty;
                this.cumFillQty = cumFillQty;
                this.lastPx = lastPx;
                this.commissionAmt = commissionAmt;
                this.commissionAsset = commissionAsset;
                this.transactTime = transactTime;
                this.tradeId = tradeId;
                this.working = working;
                this.maker = maker;
                this.orderCreationTime = orderCreationTime;
                this.cumAssetQty = cumAssetQty;
        }

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

        public String getSymbol() {
                return symbol;
        }

        public void setSymbol(String symbol) {
                this.symbol = symbol;
        }

        public String getClOrdID() {
                return clOrdID;
        }

        public void setClOrdID(String clOrdID) {
                this.clOrdID = clOrdID;
        }

        public String getSide() {
                return side;
        }

        public void setSide(String side) {
                this.side = side;
        }

        public OrderType getOrderType() {
                return orderType;
        }

        public void setOrderType(OrderType orderType) {
                this.orderType = orderType;
        }

        public TimeInForce getTimeInForce() {
                return timeInForce;
        }

        public void setTimeInForce(TimeInForce timeInForce) {
                this.timeInForce = timeInForce;
        }

        public BigDecimal getOrderQuantity() {
                return orderQuantity;
        }

        public void setOrderQuantity(BigDecimal orderQuantity) {
                this.orderQuantity = orderQuantity;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public void setPrice(BigDecimal price) {
                this.price = price;
        }

        public BigDecimal getStopPrice() {
                return stopPrice;
        }

        public void setStopPrice(BigDecimal stopPrice) {
                this.stopPrice = stopPrice;
        }

        public BigDecimal getIcebergQuantity() {
                return icebergQuantity;
        }

        public void setIcebergQuantity(BigDecimal icebergQuantity) {
                this.icebergQuantity = icebergQuantity;
        }

        public String getOrigClOrdID() {
                return origClOrdID;
        }

        public void setOrigClOrdID(String origClOrdID) {
                this.origClOrdID = origClOrdID;
        }

        public String getExecType() {
                return execType;
        }

        public void setExecType(String execType) {
                this.execType = execType;
        }

        public OrderStatus getOrdStatus() {
                return ordStatus;
        }

        public void setOrdStatus(OrderStatus ordStatus) {
                this.ordStatus = ordStatus;
        }

        public String getOrderRejectReason() {
                return orderRejectReason;
        }

        public void setOrderRejectReason(String orderRejectReason) {
                this.orderRejectReason = orderRejectReason;
        }

        public String getOrderID() {
                return orderID;
        }

        public void setOrderID(String orderID) {
                this.orderID = orderID;
        }

        public BigDecimal getLastQty() {
                return lastQty;
        }

        public void setLastQty(BigDecimal lastQty) {
                this.lastQty = lastQty;
        }

        public BigDecimal getCumFillQty() {
                return cumFillQty;
        }

        public void setCumFillQty(BigDecimal cumFillQty) {
                this.cumFillQty = cumFillQty;
        }

        public BigDecimal getLastPx() {
                return lastPx;
        }

        public void setLastPx(BigDecimal lastPx) {
                this.lastPx = lastPx;
        }

        public BigDecimal getCommissionAmt() {
                return commissionAmt;
        }

        public void setCommissionAmt(BigDecimal commissionAmt) {
                this.commissionAmt = commissionAmt;
        }

        public BigDecimal getCommissionAsset() {
                return commissionAsset;
        }

        public void setCommissionAsset(BigDecimal commissionAsset) {
                this.commissionAsset = commissionAsset;
        }

        public long getTransactTime() {
                return transactTime;
        }

        public void setTransactTime(long transactTime) {
                this.transactTime = transactTime;
        }

        public long getTradeId() {
                return tradeId;
        }

        public void setTradeId(long tradeId) {
                this.tradeId = tradeId;
        }

        public boolean isWorking() {
                return working;
        }

        public void setWorking(boolean working) {
                this.working = working;
        }

        public boolean isMaker() {
                return maker;
        }

        public void setMaker(boolean maker) {
                this.maker = maker;
        }

        public long getOrderCreationTime() {
                return orderCreationTime;
        }

        public void setOrderCreationTime(long orderCreationTime) {
                this.orderCreationTime = orderCreationTime;
        }

        public BigDecimal getCumAssetQty() {
                return cumAssetQty;
        }

        public void setCumAssetQty(BigDecimal cumAssetQty) {
                this.cumAssetQty = cumAssetQty;
        }

        @Override
        public String toString() {
                final StringBuilder sb = new StringBuilder("BinanceExecutionReport{");
                sb.append("eventType='").append(eventType).append('\'');
                sb.append(", eventTime=").append(eventTime);
                sb.append(", symbol='").append(symbol).append('\'');
                sb.append(", clOrdID='").append(clOrdID).append('\'');
                sb.append(", side='").append(side).append('\'');
                sb.append(", orderType='").append(orderType).append('\'');
                sb.append(", timeInForce='").append(timeInForce).append('\'');
                sb.append(", orderQuantity=").append(orderQuantity);
                sb.append(", price=").append(price);
                sb.append(", stopPrice=").append(stopPrice);
                sb.append(", icebergQuantity=").append(icebergQuantity);
                sb.append(", origClOrdID='").append(origClOrdID).append('\'');
                sb.append(", execType='").append(execType).append('\'');
                sb.append(", ordStatus='").append(ordStatus).append('\'');
                sb.append(", orderRejectReason='").append(orderRejectReason).append('\'');
                sb.append(", orderID='").append(orderID).append('\'');
                sb.append(", lastQty=").append(lastQty);
                sb.append(", cumFillQty=").append(cumFillQty);
                sb.append(", lastPx=").append(lastPx);
                sb.append(", commissionAmt=").append(commissionAmt);
                sb.append(", commissionAsset=").append(commissionAsset);
                sb.append(", transactTime=").append(transactTime);
                sb.append(", tradeId=").append(tradeId);
                sb.append(", working=").append(working);
                sb.append(", maker=").append(maker);
                sb.append(", orderCreationTime=").append(orderCreationTime);
                sb.append(", cumAssetQty=").append(cumAssetQty);
                sb.append('}');
                return sb.toString();
        }
}
