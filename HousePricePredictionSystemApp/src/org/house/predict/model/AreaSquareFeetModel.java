package org.house.predict.model;

public class AreaSquareFeetModel {
	public AreaSquareFeetModel()
	{
		
	}
	public AreaSquareFeetModel(int squareFeet)
	{
		this.squarefeet=squareFeet;
	}
	private int id;
	private int squarefeet;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSquarefeet() {
		return squarefeet;
	}
	public void setSquarefeet(int squarefeet) {
		this.squarefeet = squarefeet;
	}
	
}
