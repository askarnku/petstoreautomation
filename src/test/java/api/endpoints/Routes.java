package api.endpoints;

public class Routes {

	// keeping only URLs

	// base url
	public static final String base_url = "https://petstore.swagger.io/v2";

	// User endpoints
	public static final String post_url = base_url + "/user";
	public static final String get_url = base_url + "/user/{username}";
	public static final String update_url = base_url + "/user/{username}";
	public static final String delete_url = base_url + "/user/{username}";

	// TODO
	// Store model
	// access to pet store orders
	public static final String order_get = base_url + "/store/order/{orderId}"; // For valid response should be 1-10 inclusive
	public static final String order_post = base_url + "/store/order"; // Place an order for pet
	public static final String orders_all_get = base_url + "/store/inventory"; // Returns pet inventories by status
	public static final String order_delete = base_url + "/store/order/{orderId}"; // Delete purchase order

	// pet module

	// Here you will create pet module

}
