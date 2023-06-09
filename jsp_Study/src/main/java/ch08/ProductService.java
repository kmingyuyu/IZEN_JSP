package ch08;

import java.util.*;

public class ProductService {
	Map<String , Product> products = new HashMap<> ();
	
	
		public ProductService () {
			//DB에서 가져왔다고 가정한 가상의 데이터를 생성
			Product p1 = new Product
					("101" , "아이폰12" , "애플" , 1200000 , "2020.12.12");
			Product p2 = new Product
					("102" , "갤럭시21" , "삼성전자" , 1300000 , "2021.02.02");
			Product p3 = new Product
					("103" , "듀얼폰" , "LG" , 1100000 , "2021.03.12");
			products.put("101", p1);
			products.put("102", p2);
			products.put("103", p3);
			
		}
	
//	모든 상품 리스트를 가져온다.
		public List<Product> findAll() {
//			해쉬맵에 있는 데이터들을 가져와서 ArrayList에 담아 준다.
			return new ArrayList<>(products.values());
		}
//		특정 상품 리스트를 가져온다.
		public Product find(String id) {
				
			return products.get(id);
		}
				
	
}
