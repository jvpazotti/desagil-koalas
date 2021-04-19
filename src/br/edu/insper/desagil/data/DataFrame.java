package br.edu.insper.desagil.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFrame {
	private Map<String, List<Double>> columns;

	public DataFrame() {
		this.columns = new HashMap<>();
	}

	public void addColumn(String label, List<Double> values) {
		this.columns.put(label, new ArrayList<>(values));
	}
	
	private double Soma(List<Double>values) {
		
		double s = 0;
		for (double value: values) {
			s += value;
		}
		return s;
	}
	private double MediaVar(List<Double> values, double m) {
		double s = 0;
		for (double value: values) {
			s += Math.pow(value - m, 2);
		}
		return s;
	}
	
		
		
	

	public double min(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double m = Double.POSITIVE_INFINITY;
		for (double value: values) {
			if (m > value) {
				m = value;
			}
		}
		return m;
	}

	public double max(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double m = Double.NEGATIVE_INFINITY;
		for (double value: values) {
			if (m < value) {
				m = value;
			}
		}
		return m;
	}

	public double sum(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

	
		return Soma(values);
	}

	public double avg(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		
		return Soma(values) / values.size();
	}

	public double var(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double s;

		
		double m = Soma(values) / values.size();

		
		return MediaVar(values,m) / values.size();
	}

	public double std(String label) {
		if (!this.columns.containsKey(label)) {
			throw new DataFrameException("Column " + label + " is invalid!");
		}
		List<Double> values = this.columns.get(label);
		if (values.size() == 0) {
			throw new DataFrameException("Column " + label + " is empty!");
		}

		double s, m;

		
		m = Soma(values) / values.size();

		
		s = MediaVar(values,m) / values.size();
		
		m=s/values.size();

		return Math.sqrt(m);
	}
}
