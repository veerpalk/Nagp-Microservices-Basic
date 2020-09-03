package com.nagarro.nagp.products.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nagarro.nagp.products.entities.Product;
import com.nagarro.nagp.products.enums.BrandName;
import com.nagarro.nagp.products.enums.Category;
import com.nagarro.nagp.products.enums.Color;
import com.nagarro.nagp.products.enums.Size;

@Component
public class ProductInventory {

	List<Product> products = new ArrayList<Product>() {
		{
			add(new Product("1", "Shirt", Color.BLACK, Size.LARGE, Category.TOPS, BrandName.ADIDAS,
					Double.valueOf(5000), Double.valueOf(10), Double.valueOf(4500), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("2", "T_Shirt", Color.BLACK, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.ADIDAS,
					Double.valueOf(8000), Double.valueOf(10), Double.valueOf(7200), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("3", "T_Shirt", Color.BLUE, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.ZARA,
					Double.valueOf(3000), Double.valueOf(20), Double.valueOf(2400), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("4", "kurta", Color.BLACK, Size.MEDIUM, Category.KURTAS, BrandName.ZARA,
					Double.valueOf(16000), Double.valueOf(10), Double.valueOf(14400), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("5", "Shirt", Color.YELLOW, Size.MEDIUM, Category.SHIRTS, BrandName.ZARA,
					Double.valueOf(6000), Double.valueOf(10), Double.valueOf(5400), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("6", "Kurta", Color.BLACK, Size.EXTRA_LARGE, Category.KURTAS, BrandName.ALLEN_SOLLY,
					Double.valueOf(3000), Double.valueOf(20), Double.valueOf(2400), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("7", "Shirt", Color.WHITE, Size.LARGE, Category.SHIRTS, BrandName.ALLEN_SOLLY,
					Double.valueOf(4000), Double.valueOf(10), Double.valueOf(3600), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("8", "T_Shirt", Color.WHITE, Size.MEDIUM, Category.T_SHIRTS, BrandName.ALLEN_SOLLY,
					Double.valueOf(6000), Double.valueOf(50), Double.valueOf(3000), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("9", "jean", Color.BLUE, Size.EXTRA_LARGE, Category.JEANS, BrandName.TOMMY_HILFIGER,
					Double.valueOf(6000), Double.valueOf(10), Double.valueOf(5400), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("10", "Jean", Color.BLUE, Size.EXTRA_LARGE, Category.JEANS, BrandName.TOMMY_HILFIGER,
					Double.valueOf(10000), Double.valueOf(30), Double.valueOf(7000), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("11", "T_Shirt", Color.BLUE, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.TOMMY_HILFIGER,
					Double.valueOf(6000), Double.valueOf(20), Double.valueOf(4800), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("12", "T_Shirt", Color.BLUE, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.TOMMY_HILFIGER,
					Double.valueOf(5000), Double.valueOf(15), Double.valueOf(4250), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("13", "Top", Color.BLUE, Size.EXTRA_LARGE, Category.TOPS, BrandName.NIKE,
					Double.valueOf(2000), Double.valueOf(10), Double.valueOf(1800), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("14", "Top", Color.WHITE, Size.SMALL, Category.TOPS, BrandName.NIKE, Double.valueOf(6000),
					Double.valueOf(10), Double.valueOf(5400), "pictureUrl", "details", "retunPolicy"));
			add(new Product("15", "Jean", Color.BLACK, Size.EXTRA_LARGE, Category.JEANS, BrandName.ONLY,
					Double.valueOf(7000), Double.valueOf(10), Double.valueOf(6500), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("16", "Jean", Color.BLUE, Size.EXTRA_LARGE, Category.JEANS, BrandName.ONLY,
					Double.valueOf(4000), Double.valueOf(10), Double.valueOf(3600), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("17", "T_Shirt", Color.YELLOW, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.LEVIS,
					Double.valueOf(1000), Double.valueOf(5), Double.valueOf(950), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("18", "Jean", Color.BLUE, Size.EXTRA_LARGE, Category.JEANS, BrandName.LEVIS,
					Double.valueOf(3000), Double.valueOf(10), Double.valueOf(2700), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("19", "Jean", Color.BLACK, Size.LARGE, Category.JEANS, BrandName.LEVIS,
					Double.valueOf(6000), Double.valueOf(10), Double.valueOf(5400), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("20", "Shirt", Color.RED, Size.MEDIUM, Category.SHIRTS, BrandName.LEVIS,
					Double.valueOf(8000), Double.valueOf(10), Double.valueOf(7200), "pictureUrl", "details",
					"retunPolicy"));

			add(new Product("21", "T_Shirt", Color.BLUE, Size.EXTRA_LARGE, Category.T_SHIRTS, BrandName.PUMA,
					Double.valueOf(4000), Double.valueOf(10), Double.valueOf(3600), "pictureUrl", "details",
					"retunPolicy"));
			add(new Product("22", "Top", Color.YELLOW, Size.SMALL, Category.TOPS, BrandName.PUMA, Double.valueOf(3000),
					Double.valueOf(10), Double.valueOf(2700), "pictureUrl", "details", "retunPolicy"));
		}
	};

	public List<Product> getAllProducts() {

		return this.products;

	}

	public void addProduct(Product product) {
		this.products.add(product);
	}
}
