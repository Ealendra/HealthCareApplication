package in.hca.babu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_tab")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id_col")
	private Integer id;
	
	@Column(name="user_display_name_col")
	private String displayName;
	
	@Column(name="user_user_name_col")
	private String userName;
	
	@Column(name="user_password_col")
	private String password;
	
	@Column(name="user_user_roles_col")
	private String role;

}
