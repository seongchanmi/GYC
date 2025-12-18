package ch1;

public class ProductMain {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAO();
		ProductService service = new ProductService(dao);
		ProductController controller = new ProductController(service);

		controller.run();

	}

}
