package edu.mcm.cas757.dao.entity;


public class LookupCode extends BaseEntity{
	private static final long serialVersionUID = 1721240986889546821L;
	
	private Integer id;
	
	private Integer code;
	
	private String codeName;
	
	private String desc;
	
	private boolean readable;
	
	private boolean writable;
	
	private boolean updatable;
	
	private boolean deletable;
	
	private boolean defunct;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isReadable() {
		return readable;
	}
	public void setReadable(boolean readable) {
		this.readable = readable;
	}
	public boolean isWritable() {
		return writable;
	}
	public void setWritable(boolean writable) {
		this.writable = writable;
	}
	public boolean isUpdatable() {
		return updatable;
	}
	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}
	public boolean isDeletable() {
		return deletable;
	}
	public void setDeletable(boolean deletable) {
		this.deletable = deletable;
	}
	public boolean isDefunct() {
		return defunct;
	}
	public void setDefunct(boolean defunct) {
		this.defunct = defunct;
	}
	
	
}
