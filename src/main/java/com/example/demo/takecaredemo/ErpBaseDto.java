package com.example.demo.takecaredemo;


import java.sql.Timestamp;

//@TABLE(prefix = "tb_")
public class ErpBaseDto {
//	@DB(fieldName = "recorder_id", fieldType = FIELD_DB_TYPE.type_bigint, size = 20, isNotNull = true, defaultValue = "")
//	@SetAuthenticationAuto(actionType = ACTION_TYPE.recorder)
	private UserDto recorder;
//	@SetCreateDate
	private Timestamp createDate;
//	@DB(fieldName = "editor_id", fieldType = FIELD_DB_TYPE.type_bigint, size = 20, isNotNull = true, defaultValue = "")
//	@SetAuthenticationAuto(actionType = ACTION_TYPE.editor)
	private UserDto editor;
//	@SetLastUpdate
	private Timestamp lastUpdate;
//	@DB(fieldName = "is_active", fieldType = FIELD_DB_TYPE.type_tinyint, size = 1, isNotNull = false, defaultValue = "1")
//	@SetActive
	private Boolean isActive;
//	@DB(fieldName = "is_deleted", fieldType = FIELD_DB_TYPE.type_tinyint, size = 1, isNotNull = false, defaultValue = "0")
//	@SetDelete
	private Boolean isDeleted;

	public UserDto getRecorder() {
		return recorder;
	}

	public void setRecorder(UserDto recorder) {
		this.recorder = recorder;
	}

	public UserDto getEditor() {
		return editor;
	}

	public void setEditor(UserDto editor) {
		this.editor = editor;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Boolean isActive() {
		return isActive;
	}

	public void setActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
