package com.example.demo.takecaredemo;

import javafx.scene.control.Pagination;

import java.util.ArrayList;
import java.util.HashMap;

public class ErpRequest {
	private ArrayList<String> property; // property กำหนดเงื่อนไขในการคืนค่าออกไปยังหน้าบ้าน
	private Object criteria; // criteria กำหนดเงื่อนไขการค้อนหา

	// "currentPage", "limitItem", "totalItem"
	private Pagination pagination; // pagination กำหนดเงื่อนไขการเปลี่ยนหน้า
	private Object orderBy; // columnName => ASC || DESC
	private Object body; // body สำหรับ Method :: Add, Update

	public ArrayList<String> getProperty() {
		  if(property != null && property.size() > 0) {
		   HashMap<String, String> propertyMap = new HashMap<String, String>();

		   for (String item : property) {
		    if(item.contains("->")) {
		     String[] data = item.split("->");
		     int number = data.length;

		     while(number > 0) {
		      String property_key = "";

		      for(int i = 0; i < number; i++) {
		       property_key += data[i];

		       if(i < number - 1) {
		        property_key += "->";
		       }
		      }

		      propertyMap.put(property_key, property_key);

		      number--;
		     }
		    } else {
		     propertyMap.put(item, item);
		    }
		   }

		   if(propertyMap.size() > 0) {
		    property = new ArrayList<String>();
		    for (HashMap.Entry<String, String> entry : propertyMap.entrySet()) {
		        String value = entry.getValue();

		        property.add(value);
		    }
		   }
		  }

		  return property;
	}

	public void setProperty(ArrayList<String> property) {
		this.property = property;
	}

	public Object getCriteria() {
		return criteria;
	}

	public void setCriteria(Object criteria) {
		this.criteria = criteria;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Object getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Object orderBy) {
		this.orderBy = orderBy;
	}

	@Override
	public String toString() {
		return "ErpRequest [property=" + property + ", criteria=" + criteria + ", pagination=" + pagination + ", body="
				+ body + "]";
	}

}
