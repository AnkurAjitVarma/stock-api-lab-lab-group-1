package edu.neu.csye7374.Factories;

import edu.neu.csye7374.Apple;
import edu.neu.csye7374.Stock;

public class LazyAppleFactory implements StockFactory {
    private static LazyAppleFactory instance;

    private LazyAppleFactory() {}

    public static synchronized LazyAppleFactory getInstance() {
        if (instance == null) {
            instance = new LazyAppleFactory();
        }
        return instance;
    }

    @Override
    public Stock createStock() {
        return new Apple();
    }
}
