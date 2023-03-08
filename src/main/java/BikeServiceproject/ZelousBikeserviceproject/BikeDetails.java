package BikeServiceproject.ZelousBikeserviceproject;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;



//import lombok.Data;



@Entity
public class BikeDetails
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	private String cusBikeno;
	private String cusName;
	private long cubContactno;
	private String cusEmailid;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date cusDateofpurchase;
	@OneToMany (cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@Nullable
	@JsonBackReference
	@JoinTable(name="Allrecords",joinColumns = @JoinColumn(name="CustomerId"),inverseJoinColumns = @JoinColumn(name="ServicejobcasrdNo"))
	private Collection<Servicetable> myservicedetails=new ArrayList<Servicetable>();
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusBikeno() {
		return cusBikeno;
	}
	public void setCusBikeno(String cusBikeno) {
		this.cusBikeno = cusBikeno;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public long getCubContactno() {
		return cubContactno;
	}
	public void setCubContactno(long cubContactno) {
		this.cubContactno = cubContactno;
	}
	public String getCusEmailid() {
		return cusEmailid;
	}
	public void setCusEmailid(String cusEmailid) {
		this.cusEmailid = cusEmailid;
	}
	public Date getCusDateofpurchase() {
		return cusDateofpurchase;
	}
	public void setCusDateofpurchase(Date cusDateofpurchase) {
		this.cusDateofpurchase = cusDateofpurchase;
	}
	public Collection<Servicetable> getMyservicedetails() {
		return myservicedetails;
	}
	public void setMyservicedetails(Collection<Servicetable> myservicedetails) {
		this.myservicedetails = myservicedetails;
	}
	@Override
	public String toString() {
		return "BikeDetails [cusId=" + cusId + ", cusBikeno=" + cusBikeno + ", cusName=" + cusName + ", cubContactno="
				+ cubContactno + ", cusEmailid=" + cusEmailid + ", cusDateofpurchase=" + cusDateofpurchase
				+ ", myservicedetails=" + myservicedetails + "]";
	}
	public BikeDetails(int cusId, String cusBikeno, String cusName, long cubContactno, String cusEmailid,
			Date cusDateofpurchase, Collection<Servicetable> myservicedetails) {
		super();
		this.cusId = cusId;
		this.cusBikeno = cusBikeno;
		this.cusName = cusName;
		this.cubContactno = cubContactno;
		this.cusEmailid = cusEmailid;
		this.cusDateofpurchase = cusDateofpurchase;
		this.myservicedetails = myservicedetails;
	}
	public BikeDetails() {
		super();
	}
		// TODO Auto-generated constructor stub
}
	
	
	