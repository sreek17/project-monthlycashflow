package cashflowcalculations.model;import java.util.Map;public class ExpenditureDetails {	private double totalExpenditure;	public double getTotalExpenditure() {		return totalExpenditure;	}	public void setTotalExpenditure(double totalExpenditure) {		this.totalExpenditure = totalExpenditure;	}	public Map<String, Double> getExpenditureMap() {		return expenditureMap;	}	public void setExpenditureMap(Map<String, Double> expenditureMap) {		this.expenditureMap = expenditureMap;	}	private Map<String, Double> expenditureMap;}