package com.sda.auctionsservice.seller;

import com.sda.auctionsservice.auctions.Auction;
import com.sda.auctionsservice.dto.SellerReviewDTO;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class SellerService {

    private final SellerRepository repository;
    private final SellerReviewRepository sellerReviewRepository;

    public SellerService(SellerRepository repository, SellerReviewRepository reviewRepository) {
        this.repository = repository;
        this.sellerReviewRepository = reviewRepository;
    }
    SellerReview createReview(SellerReviewDTO sellerReviewDTO) {
        System.out.println(sellerReviewDTO.getSellerId());
        Optional<Seller> seller = repository.findById(sellerReviewDTO.getSellerId());
        if (seller.isPresent()){
            SellerReview sellerReview = new SellerReview(
                    sellerReviewDTO.getRate(),
                    sellerReviewDTO.getComment(),
                    seller.get(),
                    sellerReviewDTO.getReviewerId()
            );
            return sellerReviewRepository.save(sellerReview);
        }

        throw new EntityNotFoundException("Cannot find seller for seller id");
    }

    Seller save(Seller seller) {
        return repository.save(seller);
    }

    Set<Auction> findById(Integer id) {
        //Find if seller exist
        //Get auctions for seller
        //declarative style
//        return repository.findById(id)
//                .orElseThrow(() -> new ObjectNotFoundException(id, "seller not found"))
//                .getAuctions();

        //imperative style
        Optional<Seller> sellerFromRepo = repository.findById(id);
        if (sellerFromRepo.isPresent()) {
            Seller unwrapedSeller = sellerFromRepo.get();
            return unwrapedSeller.getAuctions();
        } else {
            throw new ObjectNotFoundException(id, "seller not found");
        }
    }
}
