package com.prioritizer.dao;

public class DBConnector {
	
	String addOrder = "INSERT INTO ORDERS (ID, HASHTAG, MESSAGE, CUSTOMERID, CREATED, ISDeleted) VALUES(?, ?, ?, ?, ?, ?);";
	String getOrders = "SELECT ID, HASHTAG, MESSAGE, CUSTOMERID, CREATED FROM ORDERS WHERE ISDELETED = 'N'";
	String deleteOrder = "UPDATE ORDERS SET isDeleted = 'Y' WHERE ID = ?;";
	
	public DBConnector(){
		//TODO
	}
	
	/*@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addOrder(long orderId, String orderMessage, String hashTag, String customerId, Date created){
		jdbcTemplate.update(addOrder, new Object[] {orderId, hashTag, orderMessage, customerId, created, "N"});
	}
	
	public List<FoodOrder> getOrders(){
	    List<FoodOrder> orders = jdbcTemplate.query(getOrders, new ResultSetExtractor<List<FoodOrder>>(){
	        public List<FoodOrder> extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            List<FoodOrder> orders = new ArrayList<FoodOrder>();
	            while(rs.next()) {
	                FoodOrder order = new FoodOrder(rs.getLong("ID"), rs.getString("HASHTAG"), rs.getString("MESSAGE"), rs.getString("CUSTOMERID"), rs.getDate("CREATED"));                    
	                orders.add(order);
	            }
	            return orders;
	        }});
	    return orders;
	}
	
	public int deleteOrder(long orderId){
		return jdbcTemplate.update(deleteOrder, new Object[] {orderId});
	}*/

}
