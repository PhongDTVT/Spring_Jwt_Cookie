package com.fi.reqres;

import org.springframework.data.domain.Page;

import com.fi.product.PageableObject;

public class ResponseObject {
	private boolean isSuccess = false;
    private String message;
    private Object data;




    public <T> ResponseObject(T obj) {
        processReponseObject(obj);
    }
    public <T> ResponseObject(Page<T> page) {
        this.setSuccess(true);
        this.setMessage("Thành công");
        this.data = new PageableObject<T>(page);

    }
    public void processReponseObject(Object obj) {
        if (obj != null) {
            this.message = "Thành công";
            this.isSuccess = true;
            this.data = obj;
        }
    }
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
}
