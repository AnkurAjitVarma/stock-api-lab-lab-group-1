package edu.neu.csye7374.Factories;

import edu.neu.csye7374.MSFT;
import edu.neu.csye7374.Stock;

public class EagerMSFTFactory implements StockFactory {
    private static final EagerMSFTFactory instance = new EagerMSFTFactory();

    private EagerMSFTFactory() {}

    public static EagerMSFTFactory getInstance() {
        return instance;
    }

    @Override
    public Stock createStock() {
        return new MSFT();
    }
}
