package Dto;

public class LDto {

	private String firstname ;
	private String type;
	private	String limit;
	private String loana;
	private String idcard;
	private	String thechap;
	private String usern;
	
	

	public LDto() 
	{}
	
	
	public LDto(String usern, String firstname, String type, String limit, String loana, String idcard,String tc) {
		
		this.firstname = firstname;
		this.type =type;
		this.limit = limit;
		this.loana = loana;
		this.idcard = idcard;
		this.usern=usern;
		this.thechap=tc;
	}
	
	
	
	public String getThechap() {
		return thechap;
	}



	public void setThechap(String thechap) {
		this.thechap=thechap;
	}

	public String getUsern() {
		return usern;
	}


	public void setUsern(String usern) {
		this.usern=usern;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname=firstname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	public String getLimit() {
		return limit;
	}
	public void setLimit(String limit) {
		this.limit=limit;
	}
	public String getLoana() {
		return loana;
	}
	public void setLoana(String loana) {
		this.loana=loana;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard=idcard;
	}
	
	
	

}



