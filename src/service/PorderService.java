package service;

import java.util.List;

import model.Porder;

public interface PorderService {
	//create
	void createPorder(Porder porder);
	
	//read-->列印報表
	String readAllPorderText();
	List<Porder> readAllPorder();	
	Porder readPorderById(int id);
	
	//update
	void updatePorder(String name,int id);
	void updatePorder(int apple,int banana,int lemon,int id);
	void updtaePorder(Porder porder);
	
	//delete
	void deletePorderById(int id);
}
