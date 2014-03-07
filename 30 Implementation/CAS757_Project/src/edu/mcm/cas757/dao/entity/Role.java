package edu.mcm.cas757.dao.entity;


public class Role  extends BaseEntity{
	

	private static final long serialVersionUID = 4263965924077724055L;

	private Integer id;
	
	private String name;
	
	private String desc;
	
	public Role() {
		super();
	}
	
	public Role(String name) {
		super();
		this.name = name;
	}
	
	public Role(String name, String desc, Integer creatorId,
			String createDate) {
		super();
		this.name = name;
		this.desc = desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
