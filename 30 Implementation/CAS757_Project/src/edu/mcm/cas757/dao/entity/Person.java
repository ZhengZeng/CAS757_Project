package edu.mcm.cas757.dao.entity;


public class Person extends BaseEntity {

	private static final long serialVersionUID = 3877894737137272366L;

	private Integer id;

	private String name;

	private String email;

	private String voip;

	private String phone;

	private String deptInfo;

	private String defunct;

	public Person() {
		super();
	}

	public Person(String name, Integer creatorId, String createDate, String defunct) {
		super();
		this.name = name;
		this.defunct = defunct;
	}

	public Person(String name, String email, String voip, String phone,String deptInfo, User user,
			Integer creatorId, String createDate) {
		super();
		this.name = name;
		this.email = email;
		this.voip = voip;
		this.phone = phone;
		this.deptInfo = deptInfo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVoip() {
		return voip;
	}

	public void setVoip(String voip) {
		this.voip = voip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(String deptInfo) {
		this.deptInfo = deptInfo;
	}

	public String getDefunct() {
		return defunct;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

}
