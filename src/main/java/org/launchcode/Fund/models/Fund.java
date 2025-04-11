package org.launchcode.Fund.models;

import javax.validation.Valid;
import javax.persistence.Entity;
import javax.validation.NotBlank;
import javax.validation.Size;

@Entity
public class Fund extends AbstractEntity {

    @NotBlank(message="Fund name is required")
    @Size(min=1, max 5, message="Please Enter Ticker Symbol")
    private String ticker;

    //To relate FundDetails to Fund class. Cascade saves FundDetails when Fund class is saved.
    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private FundDetails fundDetails;

    @ManyToOne
    @NotBlank(message="Asset Class is required")
    private AssetClass assetClass;


    public Fund(String ticker, AssetClass assetClass){
        this.ticker=ticker;
        this.assetClass=assetClass;
    }


    private Fund(){}

    public String getTicker(){return ticker;}

    //getter and setter for AssetClass and FundDetais
    public AssetClass getAssetClass(){return assetClass;}
    public void setAssetClass(AssetClass assetClass){
        this.assetClass=assetClass;
    }

    public FundDetails getFundDetails(){return fundDetails;}
    public void setFundDetails(FundDetails fundDetails){
        this.fundDetails=fundDetails;
    }

    @Override
    public String toString(){return.name;}

}
