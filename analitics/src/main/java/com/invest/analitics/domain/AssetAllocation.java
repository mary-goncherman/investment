package com.invest.analitics.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "asset_allocation")
public class AssetAllocation implements Serializable {

    @Id
    @Column(name = "asset")
    private String asset;

    @Column(name = "price")
    private float price;

    public AssetAllocation() {}

    public AssetAllocation(String asset, float price) {
        this.asset = asset;
        this.price = price;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
