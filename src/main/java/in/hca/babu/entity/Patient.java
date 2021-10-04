package in.hca.babu.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

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
	@Column(name="patient_num_col")
	
	
	private String phone;
	@Column(name="patent_marrie_col")
	
	
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	private String marialStatus;
	@Column(name="patent_paddr_col")
	private String prasentAddr;
	@Column(name="patent_caddr_col")
	private String commanAddr;
	
	
	@ElementCollection
	@CollectionTable(name="patient_child_mediHis_tab",
	joinColumns = @JoinColumn(name="patient_medihis_fk_col"))
	@Column(name="patient_medi_history_col")
	private Set<String> medicalHistory;
	
	@Column(name="patient_others_col")
	private String ifOthers;
	
	@Column(name="patent_note_col")
	private String note;
	
	@Column(name="patent_img_col")
	private String photoLoc;
	

}
