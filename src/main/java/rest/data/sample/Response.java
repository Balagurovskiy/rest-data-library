package rest.data.sample;

public class Response {
	private String description;
	private Object data;
	
	public Response(){}
	
	public Response(String description, Object data){
		this.description = description;
		this.data = data;
	}

	public String getStatus() {
		return description;
	}

	public void setStatus(String description) {
		this.description = description;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
