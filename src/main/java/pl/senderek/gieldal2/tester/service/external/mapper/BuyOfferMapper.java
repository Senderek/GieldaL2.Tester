package pl.senderek.gieldal2.tester.service.external.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.senderek.gieldal2.tester.dto.BuyOfferDTO;
import pl.senderek.gieldal2.tester.model.BuyOffer;

/**
 * Interfejs pozwalający na mapowanie obiektów typu {@link pl.senderek.gieldal2.tester.model.BuyOffer} na obieky {@link pl.senderek.gieldal2.tester.dto.BuyOfferDTO} oraz na odwrót
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, StockMapper.class})
public interface BuyOfferMapper {
    @Mappings({
            @Mapping(source = "buyer.id", target = "userId"),
            @Mapping(source = "stock.id", target = "stockId")
    })
    BuyOfferDTO buyOfferToBuyOfferDTO(BuyOffer buyOffer);

    BuyOffer buyOfferDTOToBuyOffer(BuyOfferDTO buyOfferDTO);
}
