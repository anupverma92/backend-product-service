package com.anup.productmanagement.model;

import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    private String articleName;
    private String quantity;
    private String category;//ring, bracelet
    private String material;//gold, silver, diamond
    private String carat;//22, 18, NA
    private String hallmarkId;
    private Double weight;
    private Double materialCostPrice;
    private Double articleCostPrice;
    private Double materialSellPrice;
    private Double articleSellPrice;
    private Double articleMakingCostPrice;
    private Double articleMakingSellPrice;
    private Double articleMaterialPercentage;
    private boolean hallmark;
}
