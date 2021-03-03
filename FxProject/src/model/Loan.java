package model;

import javafx.beans.property.SimpleStringProperty;

public class Loan  {
	private SimpleStringProperty firstname ;
	private SimpleStringProperty type;
	private	SimpleStringProperty limit;
	private SimpleStringProperty loana;
	private SimpleStringProperty idcard;
	private	SimpleStringProperty thechap;
	private SimpleStringProperty usern;
	
	

	public Loan() 
	{}
	
	
	public Loan(String usern, String firstname, String type, String limit, String loana, String idcard,String tc) {
		super();
		this.firstname =  new SimpleStringProperty(firstname);
		this.type = new SimpleStringProperty(type);
		this.limit = new SimpleStringProperty(limit);
		this.loana = new SimpleStringProperty(loana);
		this.idcard = new SimpleStringProperty(idcard);
		this.usern=new SimpleStringProperty(usern);
		this.thechap=new SimpleStringProperty(tc);
	}
	
	
	
	public SimpleStringProperty getThechap() {
		return thechap;
	}



	public void setThechap(String thechap) {
		this.thechap.set(thechap);
	}

	public SimpleStringProperty getUsern() {
		return usern;
	}


	public void setUsern(String usern) {
		this.usern.set(usern);
	}


	public SimpleStringProperty getFirstname() {
		return firstname;
	}
	public void setFirstname(SimpleStringProperty firstname) {
		this.firstname=firstname;
	}
	public SimpleStringProperty getType() {
		return type;
	}
	public void setType(SimpleStringProperty type) {
		this.type=type;
	}
	public SimpleStringProperty getLimit() {
		return limit;
	}
	public void setLimit(SimpleStringProperty limit) {
		this.limit=limit;
	}
	public SimpleStringProperty getLoana() {
		return loana;
	}
	public void setLoana(SimpleStringProperty loana) {
		this.loana=loana;
	}
	public SimpleStringProperty getIdcard() {
		return idcard;
	}
	public void setIdcard(SimpleStringProperty newValue) {
		this.idcard=newValue;
	}
	
	
	

}
