package in.hca.babu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="appointment_tab")
public class Appointment {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)//auto
	@Column(name="app_id_col")
	private  Integer id;
	@DateTimeFormat(iso =ISO.DATE)
	@Temporal(TemporalType.DATE)
	@Column(name="app_date_col")
	private Date date;
	@Column(name="app_nfs_col")
	private Integer noOfSlots;
	@Column(name="app_details_col")
	private String note;
	@Column(name="app_consultfee_col")
	private float consultFee;
	
	@ManyToOne
	@JoinColumn(name="app_id_fk_col")
	private Doctor doctor;

}
