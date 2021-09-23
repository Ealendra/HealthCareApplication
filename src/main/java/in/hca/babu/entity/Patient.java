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
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patient_tab")
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patent_id_col")
	private Long id;
	@Column(name="patent_fn_col")
	private String firstName;
	@Column(name="patent_ln_col")
	private String lastName;
	@Column(name="patent_gen_col")
	private String gender;
	@Column(name="patent_marrie_col")
	private String marialStatus;
	@Column(name="patent_paddr_col")
	private String prasentAddr;
	@Column(name="patent_caddr_col")
	private String commanAddr;
	@Column(name="patent_note_col")
	private String note;
	@Column(name="patent_img_col")
	private String photoLoc;
	

}
