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


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="special_tab")
public class Specialization{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="special_id_col")
	private Integer id;
	@Column(name="special_code_col",length=10,nullable=false,unique=true) 
	private String code;
	@Column(name="special_name_col",length=25,nullable=false,unique=true)
	private String name;
	@Column(name="special_note_col",length=250,nullable=false,unique=true)
	private String note;

}
