package com.magbel.impl;

import java.util.List;

import com.magbel.model.Chart;

public interface ChartCreatorImpl {
	
	public List<Chart> getChart(String branchCode);

}
