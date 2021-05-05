package trainee;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.MyConnection;

public class TraineeDAO implements Serializable {
	private Connection conn = null;
	private PreparedStatement stm = null;
	private ResultSet rs = null;

	private void closeConnection() throws SQLException {
		if (rs != null) {
			rs.close();
		}

		if (stm != null) {
			stm.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

	public TraineeDTO checkLogin(String trainee_account, String password) throws SQLException, ClassNotFoundException {
		TraineeDTO dto = null;
		try {
			conn = MyConnection.getConnection();
			if (conn != null) {
				String sql = "select trainee_name from Trainee where trainee_account = ? and password = ?";
				stm = conn.prepareStatement(sql);

				stm.setString(1, trainee_account);
				stm.setString(2, password);

				rs = stm.executeQuery();
				if (rs.next()) {
					String trainee_name = rs.getString("trainee_name");
					dto = new TraineeDTO(trainee_account, trainee_name);
				}
			}
		} finally {
			closeConnection();
		}
		return dto;
	}
}
