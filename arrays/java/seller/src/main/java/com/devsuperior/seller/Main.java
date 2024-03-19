package com.devsuperior.seller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.devsuperior.seller.entities.Seller;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static Seller findMaxSellerAmount(List<Seller> sellers) {
        double maxAmount = 0;
        Seller maxSeller = null;

        for (Seller seller : sellers) {
            if (seller.getAmount() > maxAmount) {
                maxAmount = seller.getAmount();
                maxSeller = seller;
            }
        }

        return maxSeller;
    }
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Seller> sellers = objectMapper.readValue(new File("file.json"), objectMapper.getTypeFactory().constructCollectionType(List.class, Seller.class));

        Seller maxSeller = findMaxSellerAmount(sellers);
        System.out.println(maxSeller);
    }
}