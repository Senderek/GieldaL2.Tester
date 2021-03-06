package pl.senderek.gieldal2.tester.service.external.impl;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.senderek.gieldal2.tester.dto.StockDTO;
import pl.senderek.gieldal2.tester.model.Stock;
import pl.senderek.gieldal2.tester.model.TestContext;
import pl.senderek.gieldal2.tester.model.User;
import pl.senderek.gieldal2.tester.service.external.StockService;
import pl.senderek.gieldal2.tester.service.external.mapper.StockMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Przedstawia implementacje metod do akcji.
 */
@Service
public class StockServiceImpl extends StockApiImpl implements StockService {

    /**
     * Adres endpointu do akcji
     */
    @Value("${test.API_URL}/api/Stocks")
    private String STOCK_API;

    private final StockMapper mapper = Mappers.getMapper(StockMapper.class);
    private final Logger logger = LoggerFactory.getLogger(ShareServiceImpl.class);

    /**
     * Metoda wywołująca żądanie get na adresie {@link #STOCK_API} za pomocą generycznej funkcji {@link #getList(TestContext, String, Class, String)}
     *
     * @param context Informacja o wykonywanym teście
     * @param token   Token zalogowanego użytkownika, uzyskany za pomocą metody {@link pl.senderek.gieldal2.tester.service.external.impl.StockApiImpl#authenticateUser(User)}
     * @return Zwraca uzyskaną z API listę wszystkich akcji jako liste obiektów typu {@link pl.senderek.gieldal2.tester.model.Stock}
     */
    @Override
    public List<Stock> getAllStocks(TestContext context, String token) {
        logger.info("Performing request to get all stocks.");
        String url = STOCK_API;
        List<Stock> response = getList(context, url, StockDTO.class, token).stream().map(mapper::stockDTOToStock).collect(Collectors.toList());
        logger.info("Get all stocks request returned list of " + response.size() + " stocks.");
        return response;
    }

    /**
     * Metoda wywołuje żądanie get dla akcji o podanym id
     *
     * @param context Informacja o wykonywanym teście
     * @param stockId Id akcji która zostanie zwrócona przez metodę
     * @param token   Token zalogowanego użytkownika, uzyskany za pomocą metody {@link #authenticateUser(User)}
     * @return Zwraca akcję o podanym Id lub {@code null} jeśli taka akcja nie isnieje
     */
    @Override
    public Optional<Stock> getStock(TestContext context, Long stockId, String token) {
        logger.info("Performing request to get buy offer with id " + stockId + ".");
        String url = STOCK_API + "/" + stockId;
        Optional<Stock> response = get(context, url, StockDTO.class, token).map(mapper::stockDTOToStock);
        if (response.isPresent())
            logger.info("Get stock request returned stock with id " + response.get().getId() + ".");
        else
            logger.info("Get stock request returned no stocks.");
        return response;
    }
}
