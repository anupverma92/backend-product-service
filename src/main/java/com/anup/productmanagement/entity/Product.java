package com.anup.productmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_product", schema = "product")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ARTICLE_NAME")
    private String articleName;

    @Column(name = "QUANTITY")
    private String quantity;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "CARAT")
    private String carat;

    @Column(name = "HALLMARK_ID")
    private String hallmarkId;

    @Column(name = "WEIGHT")
    private Double weight;

    @Column(name = "MATERIAL_COST_PRICE")
    private Double materialCostPrice;

    @Column(name = "ARTICLE_COST_PRICE")
    private Double articleCostPrice;

    @Column(name = "MATERIAL_SELL_PRICE")
    private Double materialSellPrice;

    @Column(name = "ARTICLE_SELL_PRICE")
    private Double articleSellPrice;

    @Column(name = "ARTICLE_MAKING_COST_PRICE")
    private Double articleMakingCostPrice;

    @Column(name = "ARTICLE_MAKING_SELL_PRICE")
    private Double articleMakingSellPrice;

    @Column(name = "ARTICLE_MATERIAL_PERCENTAGE")
    private Double articleMaterialPercentage;

    @Column(name = "HALLMARK")
    private boolean hallmark;
}
