package binManagerDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import binManagerObject.Bin;
import binManagerObject.ListBin;
import binManagerObject.Position;
import binManagerPerson.Employee;
import binManagerPerson.ListEmployee;
import binManagerPerson.Person;

// TODO: Auto-generated Javadoc
/**
 * The Class ListBinDAOSQL.
 */
public class ListBinDAOSQL implements Dao<ListBin>{
	
	/** The url. */
	private String url = "jdbc:mysql://mysql-binmanager.alwaysdata.net/binmanager_bm";
	
	/** The login. */
	private String login = "196466";
	
	/** The passwd. */
	private String passwd ="BinManager";
	
	/** The query handler. */
	private QueryHandler queryHandler;
	
	/**
	 * Instantiates a new list bin DAOSQL.
	 */
	public ListBinDAOSQL() {
		this.queryHandler = new QueryHandler(this.url,this.login,this.passwd);
	}
	
	/**
	 * Checks if is exist.
	 *
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @return true, if is exist
	 */
	private boolean isExist(String latitude, String longitude) {
		String sql = "SELECT * from bin WHERE latitude='"+latitude+"' AND longitude='"+longitude+"';";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		try {
			boolean exist = false;
			while(rs.next()) {
				exist = true;
			}
			return exist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.queryHandler.close();
		return false;
	}
	
	/**
	 * Checks if is exist id.
	 *
	 * @param id the id
	 * @return true, if is exist id
	 */
	private boolean isExistId(int id) {
		String sql = "SELECT * from bin WHERE id='"+id+"';";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		try {
			boolean exist = false;
			while(rs.next()) {
				exist = true;
			}
			return exist;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.queryHandler.close();
		return false;
	}
	
	/**
	 * Update.
	 *
	 * @param infos the infos
	 */
	@Override
	public void update(ArrayList<String> infos) {
		int id=Integer.parseInt(infos.get(0));
		
		String type=infos.get(1);
		String state = infos.get(2);
		String tmp = infos.get(3).substring(1, infos.get(3).length()-1);
		String[] coord = tmp.split(",");
		String latitude = coord[0];
		String longitude = coord[1];
		
		if (isExistId(id)) {
			String sql = "UPDATE `bin` SET type='"+type+"', state='"+state+"', latitude='"+latitude+"', longitude='"+longitude+"' WHERE id='"+id+"';";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
		else {
			System.out.println("This bin doesn't exist");
		}
		
	}

	/**
	 * Delete.
	 *
	 * @param email the email
	 */
	@Override
	public void delete(String email) {
		//TODO modify email in this method
	}
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(int id) {
		String sql = "DELETE FROM `bin` WHERE id='"+id+"';";
		this.queryHandler.executeUpdate(sql);
		this.queryHandler.close();
	}

	/**
	 * Adds the.
	 *
	 * @param infos the infos
	 * @return true, if successful
	 */
	@Override
	public boolean add(ArrayList<String> infos) {
		String type=infos.get(0);
		String state=infos.get(1);
		String tmp = infos.get(2).substring(1, infos.get(2).length()-1);
		String[] coord = tmp.split(",");
		String latitude = coord[0];
		String longitude = coord[1];
		if (isExist(latitude, longitude)) {
			System.out.println("There's already a bin at this location");
			return false;
		}
		else {
			String sql = "INSERT INTO `bin` VALUES (NULL,'"+type+"','"+state+"','"+latitude+"','"+longitude+"');";
			this.queryHandler.executeUpdate(sql);
			this.queryHandler.close();
		}
		return true;
	}

	/**
	 * Load.
	 *
	 * @param infos the infos
	 * @return the list bin
	 */
	@Override
	public ListBin load(ArrayList<String> infos) {
		String sql = "SELECT * FROM `bin`;";
		ResultSet rs = this.queryHandler.executeQuery(sql);
		ListBin list = new ListBin();
		try {
			while(rs.next()) {
				boolean state=false;
				if(rs.getString("state").equals("full")){
					state = true;
				}
				Bin b = new Bin(Integer.parseInt(rs.getString("id")), rs.getString("type"), state, new Position(rs.getString("latitude"),rs.getString("longitude")));
				list.addBin(b);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

}
