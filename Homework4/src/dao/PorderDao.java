package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {
	//create-->void
	void create(Porder porder);
		
	//read-->List
	List<Porder> readAll();
	List<Porder> readById(int id);
		
	//update-->void
	void update(Porder porder);
		
	//delete-->void
	void delete(int id);

}
