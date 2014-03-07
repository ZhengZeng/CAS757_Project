package edu.mcm.cas757.dao.entity;


public class Code extends BaseEntity {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer lookupCode;
	
	private String value;
	
	private String desc;
	
	private Integer seq;
	
	private boolean defunct;
	
	public Code(){
		super();
	}

	public Code(Integer lookupCode, String value, String desc,
			Integer creatorId, String createDate,boolean defunct) {
		super();
		this.lookupCode = lookupCode;
		this.value = value;
		this.desc = desc;
		this.defunct = defunct;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(Integer lookupCode) {
		this.lookupCode = lookupCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public boolean isDefunct() {
		return defunct;
	}

	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
	}
	
	
	
}
