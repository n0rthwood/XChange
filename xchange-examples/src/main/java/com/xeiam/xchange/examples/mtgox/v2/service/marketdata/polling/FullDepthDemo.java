/**
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.examples.mtgox.v2.service.marketdata.polling;

import java.io.IOException;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.currency.Currencies;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.mtgox.v2.MtGoxExchange;
import com.xeiam.xchange.service.polling.PollingMarketDataService;

/**
 * Test requesting full depth at MtGox
 */
public class FullDepthDemo {

  public static void main(String[] args) throws IOException {

    // Use the factory to get the version 2 MtGox exchange API using default settings
    Exchange mtGoxExchange = ExchangeFactory.INSTANCE.createExchange(MtGoxExchange.class.getName());

    // Interested in the public market data feed (no authentication)
    PollingMarketDataService marketDataService = mtGoxExchange.getPollingMarketDataService();

    // Get the current full orderbook
    OrderBook fullOrderBook = marketDataService.getFullOrderBook(Currencies.BTC, Currencies.USD);
    System.out.println("Current Full Order Book size for BTC / USD: " + fullOrderBook.getAsks().size() + fullOrderBook.getBids().size());

  }

}
