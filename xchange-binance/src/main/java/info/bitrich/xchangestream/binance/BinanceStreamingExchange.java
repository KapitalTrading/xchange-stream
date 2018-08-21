package info.bitrich.xchangestream.binance;

import info.bitrich.xchangestream.core.ProductSubscription;
import info.bitrich.xchangestream.core.StreamingExchange;
import io.reactivex.Completable;
import io.reactivex.Observable;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.binance.BinanceExchange;
import org.knowm.xchange.binance.service.BinanceMarketDataService;
import org.knowm.xchange.binance.service.BinanceTradeService;
import org.knowm.xchange.currency.CurrencyPair;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinanceStreamingExchange extends BinanceExchange implements StreamingExchange {
    private static final String API_BASE_URI = "wss://stream.binance.com:9443/";

    private BinanceStreamingService streamingService;
    private BinanceUserDataStreamingService userDataStreamingService;
    private BinanceStreamingMarketDataService streamingMarketDataService;

    public BinanceStreamingExchange() {
    }

    /**
     * Binance streaming API expects connections to multiple channels to be defined at connection time. To define the channels for this
     * connection pass a `ProductSubscription` in at connection time.
     *
     * @param args A single `ProductSubscription` to define the subscriptions required to be available during this connection.
     * @return
     */
    @Override
    public Completable connect(ProductSubscription... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Subscriptions must be made at connection time");
        }
        if (streamingService != null) {
            throw new UnsupportedOperationException("Exchange only handles a single connection - disconnect the current connection.");
        }

        ProductSubscription subscriptions = args[0];
        streamingService = createStreamingService(subscriptions);
        userDataStreamingService = createUserDataStreamingService();
        streamingMarketDataService = new BinanceStreamingMarketDataService(streamingService, (BinanceMarketDataService) marketDataService, userDataStreamingService);
        Completable connect = streamingService.connect();

        if (userDataStreamingService != null) {
            connect = connect.mergeWith(userDataStreamingService.connect());
        }

        return connect.doOnComplete(() -> {
            streamingMarketDataService.openSubscriptions(subscriptions);
            if (userDataStreamingService != null) {
                streamingMarketDataService.openUserSubscriptions();
            }
        });
    }

    @Override
    public Completable disconnect() {
        BinanceStreamingService service = streamingService;
        streamingService = null;
        streamingMarketDataService = null;
        return service.disconnect();
    }

    @Override
    public boolean isAlive() {
        return streamingService!= null && streamingService.isSocketOpen();
    }

    @Override
    public Observable<Throwable> reconnectFailure() {
        return streamingService.subscribeReconnectFailure();
    }

    @Override
    public Observable<Object> connectionSuccess() {
        return streamingService.subscribeConnectionSuccess();
    }

    @Override
    public BinanceStreamingMarketDataService getStreamingMarketDataService() {
        return streamingMarketDataService;
    }

    private BinanceStreamingService createStreamingService(ProductSubscription subscription) {
        String path = API_BASE_URI + "stream?streams=" + buildSubscriptionStreams(subscription);
        BinanceStreamingService binanceStreamingService = new BinanceStreamingService(path, subscription);
        applyStreamingSpecification(exchangeSpecification, binanceStreamingService);
        return binanceStreamingService;
    }

    @Nullable
    private BinanceUserDataStreamingService createUserDataStreamingService() {
        ExchangeSpecification exchangeSpecification = getExchangeSpecification();
        if (exchangeSpecification != null && exchangeSpecification.getApiKey() != null && exchangeSpecification.getSecretKey() != null) {
            BinanceUserDataStreamingService binanceUserDataStreamingService = new BinanceUserDataStreamingService(API_BASE_URI, (BinanceTradeService) tradeService);
            applyStreamingSpecification(exchangeSpecification, binanceUserDataStreamingService);
            return binanceUserDataStreamingService;
        }
        return null;
    }

    public static String buildSubscriptionStreams(ProductSubscription subscription) {
        return Stream.of(buildSubscriptionStrings(subscription.getTicker(), "ticker"),
                buildSubscriptionStrings(subscription.getOrderBook(), "depth"),
                buildSubscriptionStrings(subscription.getTrades(), "trade"))
                    .filter(s -> !s.isEmpty())
                    .collect(Collectors.joining("/"));
    }

    private static String buildSubscriptionStrings(List<CurrencyPair> currencyPairs, String subscriptionType) {
        return subscriptionStrings(currencyPairs).map( s -> s + "@" + subscriptionType).collect(Collectors.joining("/"));
    }

    private static Stream<String> subscriptionStrings(List<CurrencyPair> currencyPairs) {
        return currencyPairs.stream()
                .map(pair -> String.join("", pair.toString().split("/")).toLowerCase());
    }

    @Override
    public void useCompressedMessages(boolean compressedMessages) { streamingService.useCompressedMessages(compressedMessages); }

}

