package com.nehaspring.springmvcrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nehaspring.springmvcrest.domain.Category;
import com.nehaspring.springmvcrest.domain.Customer;
import com.nehaspring.springmvcrest.domain.Product;
import com.nehaspring.springmvcrest.domain.Vendor;
import com.nehaspring.springmvcrest.repositories.CategoryRepository;
import com.nehaspring.springmvcrest.repositories.CustomerRepository;
import com.nehaspring.springmvcrest.repositories.ProductRepository;
import com.nehaspring.springmvcrest.repositories.VendorRepository;

/*
 * Note: CommandLineRunner only works for SpringBoot.
 */
@Component
public class Bootstrap implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	private VendorRepository vendorRepository;
	private ProductRepository productRepository;
	
	
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository,
			VendorRepository vendorRepository, ProductRepository productRepository			) {
		super();
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
		this.vendorRepository = vendorRepository;
		this.productRepository = productRepository;
	}


	@Override
	public void run(String... args) throws Exception {
	
		loadCategories();
		loadCustomers();
		loadVendors();
		loadProducts();
		
	}
	
	private void loadCustomers() {
		
		Customer customer1 = new Customer();
		customer1.setFirstname("Alex");
		customer1.setLastname("Bloch");
		
		Customer customer2 = new Customer();
		customer2.setFirstname("Rayden");
		customer2.setLastname("Loschivo");
		
		Customer customer3 = new Customer();
		customer3.setFirstname("Shannon");
		customer3.setLastname("Davis");
		
		Customer customer4 = new Customer();
		customer4.setFirstname("Joe");
		customer4.setLastname("Rogen");
		
		Customer customer5 = new Customer();
		customer5.setFirstname("Henrry");
		customer5.setLastname("Cavil");
		
		customerRepository.save(customer1);
		customerRepository.save(customer2);
		customerRepository.save(customer3);
		customerRepository.save(customer4);
		customerRepository.save(customer5);
		
		System.out.println("Data Loaded::::::Customers:"+customerRepository.count());
	}
	
	private void loadCategories() {
		 
		 Category fruits = new Category();
		 fruits.setName("Fruits");
		 
		 Category dried = new Category();
		 dried.setName("Dried");
		 
		 Category fresh = new Category();
		 fresh.setName("Fresh");
		 
		 Category exotic = new Category();
		 exotic.setName("Exotic");
		 
		 Category nuts = new Category();
		 nuts.setName("Nuts");
		 
		 categoryRepository.save(fruits);
		 categoryRepository.save(dried);
		 categoryRepository.save(fresh);
		 categoryRepository.save(exotic);
		 categoryRepository.save(nuts);
		 
		 System.out.println("Data Loaded::::::Category:"+categoryRepository.count());
	}
	private void loadVendors() {
		
		 Vendor western = new Vendor();
		 western.setName("Western Tasty Fruits Ltd.");
		 
		 Vendor exotic = new Vendor();
		 exotic.setName("Exotic Fruits Company.");
		 
		 Vendor home = new Vendor();
		 home.setName("Home Fruits");
		 
		 Vendor fun = new Vendor();
		 fun.setName("Fun Fresh Fruits Ltd.");
		 
		 Vendor nuts = new Vendor();
		 nuts.setName("Nuts for Nuts Company.");
		  
		 vendorRepository.save(western);
		 vendorRepository.save(exotic);
		 vendorRepository.save(home);
		 vendorRepository.save(fun);
		 vendorRepository.save(nuts);
		
		 
		 System.out.println("Data Loaded::::::Vendors:"+vendorRepository.count());
	}

	private void loadProducts() {
		
		Category dried = categoryRepository.findByName("Dried");
		Category nuts = categoryRepository.findByName("Nuts");
		Category fruits = categoryRepository.findByName("Fruits");
		Category fresh = categoryRepository.findByName("Fresh");
		
		Vendor western = vendorRepository.findByName("Western Tasty Fruits Ltd.");
		Vendor exotic =  vendorRepository.findByName("Exotic Fruits Company.");
		Vendor fun = vendorRepository.findByName("Fun Fresh Fruits Ltd.");
		Vendor nutsVendor = vendorRepository.findByName("Nuts for Nuts Company.");
		
		Product redapples = new Product();
		redapples.setName("Red Apple");
		redapples.setPrice(3.50);
		redapples.setCategory(fruits);
		redapples.setVendor(western);
		productRepository.save(redapples);
		
		
		Product pineapples = new Product();
		pineapples.setName("Pineapple");
		pineapples.setPrice(5.50);
		pineapples.setCategory(fruits);
		pineapples.setVendor(western);
		productRepository.save(pineapples);
		
		Product wildberries = new Product();
		wildberries.setName("Wild Berries");
		wildberries.setPrice(2.50);
		wildberries.setCategory(fresh);
		wildberries.setVendor(exotic);
		productRepository.save(wildberries);
		
		Product blueberries = new Product();
		blueberries.setName("Blue Berries");
		blueberries.setPrice(3.50);
		blueberries.setCategory(fresh);
		blueberries.setVendor(exotic);
		productRepository.save(blueberries);
		
		Product coconut = new Product();
		coconut.setName("Dried Coconut");
		coconut.setPrice(3.50);
		coconut.setCategory(dried);
		coconut.setVendor(fun);
		productRepository.save(coconut);
		
		Product rasins = new Product();
		rasins.setName("Dried Rasins");
		rasins.setPrice(3.50);
		rasins.setCategory(dried);
		rasins.setVendor(fun);
		productRepository.save(rasins);
		
		Product almonds = new Product();
		almonds.setName("Almonds");
		almonds.setPrice(3.50);
		almonds.setCategory(nuts);
		almonds.setVendor(nutsVendor);
		productRepository.save(almonds);
		
		Product walnuts = new Product();
		walnuts.setName("Walnuts");
		walnuts.setPrice(3.50);
		walnuts.setCategory(nuts);
		walnuts.setVendor(nutsVendor);
		productRepository.save(walnuts);
		
		
		System.out.println("Data Loaded::::::Products:"+productRepository.count());
	}
}
