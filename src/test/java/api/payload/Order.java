package api.payload;

public class Order {
	
	/*
	    	"id": 0,
  			"petId": 0,
  			"quantity": 0,
  			"shipDate": "2023-03-14T23:20:01.501Z",
  			"status": "placed",
  			"complete": true
	 */
	
	
	private int id;
	private int petId;
	private int quantity;
	private String dateTime;
	private String status;
	private boolean complete;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
