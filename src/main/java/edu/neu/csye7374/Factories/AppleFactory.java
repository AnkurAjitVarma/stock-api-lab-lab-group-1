package edu.neu.csye7374.Factories;

import edu.neu.csye7374.Apple;
import edu.neu.csye7374.Stock;

public class AppleFactory implements StockFactory {
    @Override
    public Stock createStock() {
        return new Apple();
    }
}
