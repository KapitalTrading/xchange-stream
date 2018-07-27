package info.bitrich.xchangestream.binance.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Nikita Belenkiy on 25/07/2018.
 */
public class BinanceExecutionReport {
        /**
         * "e": "executionReport",        // Event type
         */
        @JsonProperty("e")
        private String eventType;
        /**
         * "E": 1499405658658,            // Event time
         */
        @JsonProperty("E")
        private long eventTime;
        /**
         * "s": "ETHBTC",                 // Symbol
         */
        @JsonProperty("s")
        private String symbol;
        /**
         * "c": "mUvoqJxFIILMdfAW5iGSOW", // Client order ID
         */
        @JsonProperty("c")
        private String clOrdID;
        /**
         * "S": "BUY",                    // Side
         */
        @JsonProperty("S")
        private String side;
        /**
         * "o": "LIMIT",                  // Order type
         */
        @JsonProperty("o")
        private String orderType;
        /**
         * "f": "GTC",                    // Time in force
         */
        @JsonProperty("f")
        private String timeIfForce;
        /**
         * "q": "1.00000000",             // Order quantity
         */
        @JsonProperty("q")
        private BigDecimal orderQuantity;
        /**
         * "p": "0.10264410",             // Order price
         */
        @JsonProperty("p")
        private BigDecimal price;
        /**
         * "P": "0.00000000",             // Stop price
         */
        @JsonProperty("P")
        private BigDecimal stopPrice;
        /**
         * "F": "0.00000000",             // Iceberg quantity
         */
        @JsonProperty("F")
        private BigDecimal icebergQuantity;
        /**
         * "C": "null",                   // Original client order ID; This is the ID of the order being canceled
         */
        @JsonProperty("C")
        private String origClOrdID;
        /**
         * "x": "NEW",                    // Current execution type
         */
        @JsonProperty("x")
        private String execType;
        /**
         * "X": "NEW",                    // Current order status
         */
        @JsonProperty("X")
        private String ordStatus;
        /**
         * "r": "NONE",                   // Order reject reason; will be an error code.
         */
        @JsonProperty("r")
        private String orderRejectReason;
        /**
         * "i": 4293153,                  // Order ID
         */
        @JsonProperty("i")
        private String orderID;
        /**
         * "l": "0.00000000",             // Last executed quantity
         */
        @JsonProperty("l")
        private BigDecimal lastQty;
        /**
         * "z": "0.00000000",             // Cumulative filled quantity
         */
        @JsonProperty("z")
        private BigDecimal cumFillQty;
        /**
         * "L": "0.00000000",             // Last executed price
         */
        @JsonProperty("L")
        private BigDecimal lastPx;
        /**
         * "n": "0",                      // Commission amount
         */
        @JsonProperty("n")
        private BigDecimal commissionAmt;
        /**
         * "N": null,                     // Commission asset
         */
        @JsonProperty("N")
        private BigDecimal commissionAsset;
        /**
         * "T": 1499405658657,            // Transaction time
         */
        @JsonProperty("T")
        private long transactTime;
        /**
         * "t": -1,                       // Trade ID
         */
        @JsonProperty("t")
        private long tradeId;
        /**
         * "w": true,                     // Is the order working? Stops will have
         */
        @JsonProperty("w")
        private boolean working;
        /**
         * "m": false,                    // Is this trade the maker side?
         */
        @JsonProperty("m")
        private boolean maker;
        /**
         * "O": 1499405658657,            // Order creation time
         */
        @JsonProperty("O")
        private long orderCreationTime;
        /**
         * "Z": "0.00000000"              // Cumulative quote asset transacted quantity
         */
        @JsonProperty("Z")
        private long cumAssetQty;


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

        public String getOrderType() {
                return orderType;
        }

        public void setOrderType(String orderType) {
                this.orderType = orderType;
        }

        public String getTimeIfForce() {
                return timeIfForce;
        }

        public void setTimeIfForce(String timeIfForce) {
                this.timeIfForce = timeIfForce;
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

        public String getOrdStatus() {
                return ordStatus;
        }

        public void setOrdStatus(String ordStatus) {
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

        public long getCumAssetQty() {
                return cumAssetQty;
        }

        public void setCumAssetQty(long cumAssetQty) {
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
                sb.append(", timeIfForce='").append(timeIfForce).append('\'');
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
