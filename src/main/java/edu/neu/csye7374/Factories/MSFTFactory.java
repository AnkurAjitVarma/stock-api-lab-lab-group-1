package edu.neu.csye7374.Factories;

import edu.neu.csye7374.MSFT;
import edu.neu.csye7374.Stock;

public class MSFTFactory implements StockFactory {
    @Override
    public Stock createStock() {
        return new MSFT();
    }
}
