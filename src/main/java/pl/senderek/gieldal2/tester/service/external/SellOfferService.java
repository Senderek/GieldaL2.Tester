package pl.senderek.gieldal2.tester.service.external;

import pl.senderek.gieldal2.tester.model.SellOffer;
import pl.senderek.gieldal2.tester.model.Stock;
import pl.senderek.gieldal2.tester.model.TestContext;
import pl.senderek.gieldal2.tester.model.User;

import java.util.List;
import java.util.Optional;

public interface SellOfferService extends StockApi {
    List<SellOffer> getAllSellOffers(TestContext context, String token);

    List<SellOffer> getUserSellOffers(TestContext context, User user);

    List<SellOffer> getStockSellOffers(TestContext context, Stock stock);

    void createSellOffer(TestContext context, SellOffer sellOffer, String token);

    Optional<SellOffer> getSellOffer(TestContext context, Long sellOfferId, String token);

    void deleteSellOffer(TestContext context, Long buyOfferId, String token);
}
