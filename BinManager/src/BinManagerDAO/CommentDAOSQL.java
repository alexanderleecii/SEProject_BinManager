package BinManagerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BinManagerComment.Comment;
import BinManagerComment.ListComment;
import BinManagerPerson.Citizen;

public class CommentDAOSQL implements Dao<ListComment>{
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	private String login = "196466";
	private String passwd ="BinManager";
	private QueryHandler queryHandler;
	
	public CommentDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	
	@Override
	public void update(ArrayList<String> infos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		
	}
	
	@Override
	public boolean add(ArrayList<String> infos) {
		String binId=infos.get(0);
		String type=infos.get(1);
		String email=infos.get(2);
		String text=infos.get(3);
		
		String sql;
		if (type.contentEquals("Comment")) {
			sql = "INSERT INTO `comments` VALUES (null, '"+binId+"', '"+email+"','"+text+"', default);";
		}
		else {
			sql = "INSERT INTO `alerts` VALUES (null, '"+binId+"', '"+email+"','"+text+"', default);";
		}
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
		return true;
	}
	@Override
	public ListComment load(ArrayList<String> infos) {
		ListComment list = new ListComment();
		if(infos.get(0).equals("alerts")) {
			String sql = "SELECT * FROM `alerts` WHERE bin_id='"+infos.get(1)+"';";
			ResultSet rs = this.queryHandler.executeQuery(sql);
			try {
				while(rs.next()) {
					Comment c = new Comment(new Citizen(), Integer.parseInt(rs.getString("id")), rs.getString("date"), "alert", rs.getString("alert"));
					list.addComment(c);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			String sql = "SELECT * FROM `comments` WHERE bin_id='"+infos.get(1)+"';";
			ResultSet rs = this.queryHandler.executeQuery(sql);
			try {
				while(rs.next()) {
					Comment c = new Comment(new Citizen(), Integer.parseInt(rs.getString("id")), rs.getString("date"), "comment", rs.getString("comment"));
					list.addComment(c);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
