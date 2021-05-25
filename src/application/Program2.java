package application;

import java.util.Scanner;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
			
		System.out.println("===TEST 1: department findById===");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);
		
		System.out.println("===TEST 2: department insert===");
		Department obj = new Department(null, "Music");
		departmentDao.insert(obj);
		System.out.println("Inserted! new Id = : " + obj.getId());
		
		System.out.println("===TEST 3: department update===");
		dep = departmentDao.findById(5);
		dep.setName("Country");
		departmentDao.update(dep);
		System.out.println("Update completed!" + dep);
		
		System.out.println("===TEST 4: department findAll===");
		List<Department> list = departmentDao.findAll();
		for (Department depList: list) {
			System.out.println(depList);
		}
		System.out.println("===TEST 5: department deleteById===");
		System.out.println("Enter Id for delete test");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
	}

}
