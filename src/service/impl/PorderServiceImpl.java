package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import service.PorderService;

public class PorderServiceImpl implements PorderService {

	public static void main(String[] args) {
		// addPorder
		//Porder porder=new Porder("ccc",2,3,2);
		//new PorderServiceImpl().addPorder(porder);
		
		//AllPorder
		//System.out.println(new PorderServiceImpl().AllPorder());
		
		//System.out.println(new PorderServiceImpl().findAllPorder());

		//System.out.println(new PorderServiceImpl().findById(3));
		
		//new PorderServiceImpl().updatePorder(10, 11, 12, 3);
		
		
	
	}

	private static PorderDaoImpl porderdaoimpl=new PorderDaoImpl();
	
	@Override
	public void createPorder(Porder porder) {
		if (porder.getApple()>=0 && porder.getBanana()>=0 && porder.getLemon()>=0)
		{
			porderdaoimpl.create(porder);;
		}		
	}

	@Override
	public String readAllPorderText() {
		List<Porder> l=porderdaoimpl.readAll();
		String show="";
		
		for(Porder p:l)
		{
			int sum=p.getApple()*50+p.getBanana()*20+p.getLemon()*30;
			
			/*
			show=show+"訂單編號:"+p.getId()+
					"\t客戶名稱:"+p.getName()+
					"\t蘋果數量:"+p.getApple()+
					"\t香蕉數量:"+p.getBanana()+
					"\t檸檬數量:"+p.getLemon()+
					"\t金額:"+sum+"元\n";
			*/
			show+=String.format("訂單編號:%d 客戶名稱:%s 蘋果數量:%d 香蕉數量:%d 檸檬數量:%d 金額:%d元\n", 
					p.getId(), p.getName(), p.getApple(), p.getBanana(), p.getLemon(), sum);
		}
			
		return show;
	}

	@Override
	public List<Porder> readAllPorder() {
		return porderdaoimpl.readAll();
	}

	@Override
	public Porder readPorderById(int id) {
		/*
		 * 1.id>=0
		 * 2.Porder無訂單--->null
		 */
		Porder porder=null;
		if(id>=0)
		{
			List<Porder> l=porderdaoimpl.readById(id);
			if(l.size()>0)
			{
				porder=l.get(0);
			}
			
		}			
		return porder;
	}

	@Override
	public void updatePorder(String name, int id) {
		Porder porder=readPorderById(id); //findById(int id)
		porder.setName(name);
		porderdaoimpl.update(porder);	
	}

	@Override
	public void updatePorder(int apple, int banana, int lemon, int id) {
		Porder porder=readPorderById(id);
		porder.setApple(apple);
		porder.setBanana(banana);
		porder.setLemon(lemon);		
		porderdaoimpl.update(porder);
	}

	@Override
	public void updtaePorder(Porder porder) {
		//Porder porder=findById(porder.getId());
		porderdaoimpl.update(porder);
		
	}

	@Override
	public void deletePorderById(int id) {
		if(id>0)
		{
			porderdaoimpl.delete(id);
		}		
	}


}
