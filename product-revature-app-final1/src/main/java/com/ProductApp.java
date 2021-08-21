package com;

import java.util.List;
import java.util.Scanner;

import com.revature.pms.dao.ProductDAO;
import com.revature.pms.dao.ProductDAOImpl;
import com.revature.pms.model.Product;

public class ProductApp {
	int choice = 0;
	Scanner sc = new Scanner(System.in);
	ProductDAO productDAO = new ProductDAOImpl();
	boolean result;
	Product product = new Product();
	
	public void startProductApp() {
		while (true) {
			System.out.println("######### M E N U #########");
			System.out.println("1.Add Product ");
			System.out.println("2.Delete Product ");
			System.out.println("3.Update Product ");
			System.out.println("4.Find Product By Id");
			System.out.println("5.Find Product By Name ");
			System.out.println("6.Add Product ");
			System.out.println("9.E X I T ");
			
			System.out.println("Enter your choice : ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Wecome to add product section , please enter product enter details to  save##");
				product = acceptProductDetails();
				result = productDAO.addProduct(product);
				if (result)
					System.out.println(
							"#Product with product name : " + product.getProductName() + " , saved successfully");
				else
					System.out.println(
							"#Product with product name : " + product.getProductName() + ", not saved successfully");

				break;
			case 2:
				break;
			case 3:
				System.out
						.println("Wecome to update product section , please enter product enter details to  update ##");
				product = acceptProductDetails();
				result = productDAO.updateProduct(product);
				if (result)
					System.out.println(
							"#Product with product name : " + product.getProductName() + " , updated successfully");
				else
					System.out.println(
							"#Product with product name : " + product.getProductName() + ", not updated successfully");

				break;
			case 4:
				break;
			case 5:
				break;
			case 6:

				List<Product> products = productDAO.getAllProducts();
				System.out.println("###Printing all the products");
				System.out.println(products);
				break;
			case 9:
				System.out.println("##Thanks for using my product app");
				System.exit(0);
				break;
			}
		}
	}

	public Product acceptProductDetails() {
		System.out.println("Please enter product id : ");
		int productId = sc.nextInt();
		System.out.println("Please enter product name : ");
		String productName = sc.next();
		System.out.println("Please enter quantity on Hand: ");
		int quantityOnHand = sc.nextInt();
		System.out.println("Please enter price : ");
		int price = sc.nextInt();
		System.out.println("Please enter comments: ");
		String comments = sc.next();

		Product product = new Product(productId, productName, quantityOnHand, price, comments);
		return product;
	}

}
