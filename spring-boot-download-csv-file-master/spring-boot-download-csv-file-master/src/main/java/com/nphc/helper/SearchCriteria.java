package com.nphc.helper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {

    private String key;
    private SearchOperation operation;
    private Object value;
	public SearchCriteria(String key, SearchOperation operation, Object value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
    
    public SearchCriteria() {
    	
    }

	public String getKey() {
		return key;
	}

	public SearchOperation getOperation() {
		return operation;
	}

	public Object getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setOperation(SearchOperation operation) {
		this.operation = operation;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	 
	
	
    
}
