package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TEST 1: Seller findById ===="); 
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n === TEST 2: Seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findbyDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 3: Seller findAll ====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 4: Seller Insert ====");
		Seller newSeller = new Seller(null, "Rapha", "rapha18023@gmail.com", new Date(), 3500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted, New id = " + newSeller.getId());
	
		System.out.println("\n === TEST 5: Seller Update ====");
		seller = sellerDao.findById(1);
		seller.setEmail("Gabriela@gmail.com");
		sellerDao.update(seller);
		System.out.println("Update Completed.");
		
		System.out.println("\n === TEST 6: Seller Delete ====");
		sellerDao.deleteById(10);
		System.out.println("Delete completed.");
	}
	
	
}