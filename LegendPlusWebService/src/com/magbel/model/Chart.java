package com.magbel.model;

import jakarta.ws.rs.Produces;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement 
public class Chart  {
    public String Category_Code;
    public String TotalCostPrice;

    
    public Chart() {
    	
    }
    
    public Chart(String Category_Code, String TotalCostPrice) {
    	this.Category_Code = Category_Code;
    	this.TotalCostPrice = TotalCostPrice;
    	
    }

	public String getCategory_Code() {
		return Category_Code;
	}

	public void setCategory_Code(String category_Code) {
		Category_Code = category_Code;
	}

	public String getTotalCostPrice() {
		return TotalCostPrice;
	}

	public void setTotalCostPrice(String totalCostPrice) {
		TotalCostPrice = totalCostPrice;
	}

	


}
