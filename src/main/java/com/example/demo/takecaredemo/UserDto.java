package com.example.demo.takecaredemo;

//@TABLE(prefix = "tb_")
public class UserDto extends ErpBaseDto {
	// รหัสบุคคล
//	@DBCriteria(criteriaType = CRITERIA_TYPE.EQUALS)
	private Long id;
	// ประเภทผู้ใช้ (Customer, Employee)
//	@DBCriteria(criteriaType = CRITERIA_TYPE.EQUALS)
	private String userType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
