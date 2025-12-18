package ch1;

import java.util.List;

public class OrderService {
	
	private OrderDAO dao;
	int nextId;
	
	public OrderService(OrderDAO dao) {
		this.dao = dao;
		this.nextId = getId() +1;
	}
	
	private int getId() {
		int max = 0;
		for(OrderDTO dto : dao.findAll()) {
			if(dto.getId() > max) {
				max = dto.getId();
			}
		}
		return max;
	}

	public void saveOrder(String name, int price, int limit, int stock) {
		OrderDTO dto = new OrderDTO(nextId++, name, price, limit, stock);
		dao.save(dto);
	}

	public List<OrderDTO> getAllOrder() {
		return dao.findAll();
	}

	public OrderDTO getById(int id) {
		return dao.findById(id);
	}

	public boolean deleteOrder(int id) {
		return dao.deleteById(id);
	}

	public boolean updateOrder(int id, String newName, int newPrice, int newLimit, int newStock) {
		return dao.updateDAO(id, newName, newPrice, newLimit, newStock);
	}

	public int getSumTotal() {
		int sum = 0;
		for (OrderDTO dto : getAllOrder()) {
			sum += dto.getTotal();
		}
		return sum;
	}

	public int getOrderCnt() {
		return dao.count();
	}
	

}
