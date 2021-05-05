package trainee;

import java.io.Serializable;

public class TraineeDTO implements Serializable{
	private String trainee_account;
	private String password;
	private String trainee_name;
	
	public TraineeDTO(String trainee_account, String trainee_name) {
		super();
		this.trainee_account = trainee_account;
		this.trainee_name = trainee_name;
	}

	public String getTrainee_account() {
		return trainee_account;
	}

	public String getPassword() {
		return password;
	}

	public String getTrainee_name() {
		return trainee_name;
	}
	
	
}
