package info.bitrich.xchangestream.binance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import info.bitrich.xchangestream.binance.dto.user.BinanceAccountUpdate;
import info.bitrich.xchangestream.binance.dto.user.BinanceExecutionReport;
import info.bitrich.xchangestream.binance.netty.WebSocketClientCompressionAllowClientNoContextHandler;
import info.bitrich.xchangestream.service.netty.JsonNettyStreamingService;
import info.bitrich.xchangestream.service.netty.StreamingObjectMapperHelper;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandler;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.knowm.xchange.binance.service.BinanceTradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * @author Nikita Belenkiy on 23/07/2018.
 */
public class BinanceUserDataStreamingService extends JsonNettyStreamingService {
    private static final Logger  logger = LoggerFactory.getLogger(BinanceUserDataStreamingService.class);
    private static final ObjectMapper objectMapper = StreamingObjectMapperHelper.getObjectMapper();

    private final BinanceTradeService tradeService;
    private String listenKey;

    public BinanceUserDataStreamingService(String apiUrl, BinanceTradeService tradeService) {
        super(apiUrl,  Integer.MAX_VALUE);
        this.tradeService = tradeService;
    }

    @Override
    public void messageHandler(String message) {
        try {
            JsonNode node = objectMapper.readTree(message);
            super.handleMessage(node);
        } catch (IOException e) {
            logger.error("Error  parsing json {}",message,  e);
        }
    }

    @Override
    protected URI getUri() {
        try {
            return new URI(super.getUri().toString() + "ws/" + listenKey);
        } catch (URISyntaxException e) {
            logger.error("Error creating URI with listenKey={}", listenKey, e);
            return null;
        }
    }

    @Override
    public Completable connect() {
        try {
            listenKey = tradeService.startUserDataStream().getListenKey();

            Observable.interval(20, 20, TimeUnit.MINUTES).subscribe(aLong -> {
                tradeService.keepAliveDataStream(listenKey);
            });
            return super.connect();
        } catch (IOException e) {
            logger.error("Error starting user data stream", e);
        }
        return null;
    }

    @Override
    public Completable disconnect() {
        try {
            tradeService.closeDataStream(listenKey);
            return super.disconnect();
        } catch (IOException e) {
            logger.error("Error closing user data stream", e);
        }
        return null;
    }

    @Override
    protected String getChannelNameFromMessage(JsonNode message) {
        String e = message.get("e").asText();
        if (e.equals(BinanceAccountUpdate.EVENT_TYPE)) {
            return BinanceAccountUpdate.EVENT_TYPE;
        }
        if (e.equals(BinanceExecutionReport.EVENT_TYPE)) {
            return BinanceExecutionReport.EVENT_TYPE;
        }
        return null;
    }

    @Override
    public String getSubscribeMessage(String channelName, Object... args) throws IOException {
        return null;
    }

    @Override
    public String getUnsubscribeMessage(String channelName) throws IOException {
        return null;
    }

    @Override
    protected WebSocketClientExtensionHandler getWebSocketClientExtensionHandler() {
        return WebSocketClientCompressionAllowClientNoContextHandler.INSTANCE;
    }


}
