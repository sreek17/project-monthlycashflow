package cashflowcalculations.serviceimpl;import java.util.HashMap;import java.util.Map;import java.util.Scanner;import cashflowcalculations.YearlyCashFlow;import cashflowcalculations.model.CashFlow;import cashflowcalculations.model.Expenditure;import cashflowcalculations.model.ExpenditureDetails;import cashflowcalculations.model.RecommendationDetails;import cashflowcalculations.service.ExpenditureAccumulation;public class ExpenditureAccumulationImpl implements ExpenditureAccumulation {	Map<String, Double> expenditureMap = new HashMap<>();	YearlyCashFlow yearlyCashFlow = new YearlyCashFlow();	private final String type = "Expenditure";	@Override	public CashFlow findTotalExpenditure() {		ExpenditureDetails expenditureDetails = new ExpenditureDetails();		CashFlow cashFlow = new Expenditure();		String optionSelected;		cashFlow.setCategory(yearlyCashFlow.getCategory(type));		getExpenditureAmount(cashFlow);		expenditureMap.put(cashFlow.getCategory(), cashFlow.getAmount());		optionSelected = yearlyCashFlow.getOptionSelected(type);		if (optionSelected.equals("1")) {			findTotalExpenditure();		} else {			System.out.println("\n");		}		expenditureDetails.setExpenditureMap(expenditureMap);		expenditureDetails.setTotalExpenditure(getExpenditureAmount(expenditureMap));		CashFlow cashflowFinal = new CashFlow();		cashflowFinal.setExpenditureDetails(expenditureDetails);		cashflowFinal.setRecommendationDetails(getSuggestionsForImprovement(expenditureMap));		return cashflowFinal;	}	private double getExpenditureAmount(CashFlow cashFlow) {		cashFlow.setAmount(yearlyCashFlow.getAmount((cashFlow.getCategory()), type));		return cashFlow.getAmount();	}	public double getExpenditureAmount(Map<String, Double> expenditureMap) {		double finalExpenditureAmount = 0;		for (Map.Entry<String, Double> map : expenditureMap.entrySet()) {			finalExpenditureAmount += map.getValue();		}		return finalExpenditureAmount;	}	@Override	public RecommendationDetails getSuggestionsForImprovement(Map<String, Double> expenditureMap) {		double maxValue = 0;		RecommendationDetails recommendationDetails = new RecommendationDetails();		for (Map.Entry<String, Double> entry : expenditureMap.entrySet()) {			if (entry.getValue() > maxValue) {				recommendationDetails.setCategory(entry.getKey());				recommendationDetails.setAmount(entry.getValue());				maxValue = entry.getValue();			}		}		return recommendationDetails;	}}