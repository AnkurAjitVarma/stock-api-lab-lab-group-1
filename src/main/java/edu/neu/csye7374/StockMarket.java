package edu.neu.csye7374;

import java.util.HashMap;
import java.util.Map;
import edu.neu.csye7374.Factories.*;

public class StockMarket {
    private static StockMarket instance;
    private final Map<String, Stock> stocks;

    private StockMarket() {
        stocks = new HashMap<>();
    }

    public static StockMarket getInstance() {
        if (instance == null) {
            synchronized (StockMarket.class) {
                if (instance == null) {
                    instance = new StockMarket();
                }
            }
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getName(), stock);
    }

    public void removeStock(String name) {
        stocks.remove(name);
    }

    public void showAllStocks() {
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }

    public void tradeStock(Stock stock, String bid) {
        stock.setBid(bid);
        System.out.println(stock);
    }

    public void initializeBiding(Stock stock, String[] bids) {
        for (String bid : bids) {
            tradeStock(stock, bid);
        }
    }

    public static void demo() {
        StockFactory appleFactory = new AppleFactory();
        StockFactory msftFactory = new MSFTFactory();
        StockFactory lazyAppleFactory = LazyAppleFactory.getInstance();
        StockFactory eagerMSFTFactory = EagerMSFTFactory.getInstance();

        Stock apple1 = appleFactory.createStock();
        Stock msft1 = msftFactory.createStock();
        Stock apple2 = lazyAppleFactory.createStock();
        Stock msft2 = eagerMSFTFactory.createStock();

        System.out.println("Non-singleton Apple Factory:"+"\t"+apple1.getMetric());
        System.out.println("Non-singleton Microsoft Factory:"+"\t"+msft1.getMetric());
        System.out.println("Lazy Singleton Apple Factory"+"\t"+apple2.getMetric());
        System.out.println("Eager Singleton Microsoft Factory"+"\t"+msft2.getMetric());
    }
}