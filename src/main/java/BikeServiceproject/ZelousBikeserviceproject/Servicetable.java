package BikeServiceproject.ZelousBikeserviceproject;



import java.sql.Date;
import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Servicetable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int bikeJobcardno;
	private String[] bikeIssues;
	@JsonFormat(pattern="yyyy-mm-dd")
	private Date bikeDateofservice;
	private int bikeKilometer;
	private String bikeStatus;
	private String bikeTypeofservice;
	private int bikeEstimatecharge;
	private int bikeProductcost;
	private int bikeLabourcharge;
	@Column(name="bikeToalamount")
	private int bikeFinalamount;
	@ManyToOne (cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="bikeCustomerid")
	private BikeDetails bikedetails;// it ends here
	public Servicetable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Servicetable(int bikeJobcardno, String[] bikeIssues, Date bikeDateofservice, int bikeKilometer,
			String bikeStatus, String bikeTypeofservice, int bikeEstimatecharge, int bikeProductcost,
			int bikeLabourcharge, int bikeFinalamount, BikeDetails bikedetails) {
		super();
		this.bikeJobcardno = bikeJobcardno;
		this.bikeIssues = bikeIssues;
		this.bikeDateofservice = bikeDateofservice;
		this.bikeKilometer = bikeKilometer;
		this.bikeStatus = bikeStatus;
		this.bikeTypeofservice = bikeTypeofservice;
		this.bikeEstimatecharge = bikeEstimatecharge;
		this.bikeProductcost = bikeProductcost;
		this.bikeLabourcharge = bikeLabourcharge;
		this.bikeFinalamount = bikeFinalamount;
		this.bikedetails = bikedetails;
	}
	@Override
	public String toString() {
		return "Servicetable [bikeJobcardno=" + bikeJobcardno + ", bikeIssues=" + Arrays.toString(bikeIssues)
				+ ", bikeDateofservice=" + bikeDateofservice + ", bikeKilometer=" + bikeKilometer + ", bikeStatus="
				+ bikeStatus + ", bikeTypeofservice=" + bikeTypeofservice + ", bikeEstimatecharge=" + bikeEstimatecharge
				+ ", bikeProductcost=" + bikeProductcost + ", bikeLabourcharge=" + bikeLabourcharge
				+ ", bikeFinalamount=" + bikeFinalamount + ", bikedetails=" + bikedetails + "]";
	}
	public int getBikeJobcardno() {
		return bikeJobcardno;
	}
	public void setBikeJobcardno(int bikeJobcardno) {
		this.bikeJobcardno = bikeJobcardno;
	}
	public String[] getBikeIssues() {
		return bikeIssues;
	}
	public void setBikeIssues(String[] bikeIssues) {
		this.bikeIssues = bikeIssues;
	}
	public Date getBikeDateofservice() {
		return bikeDateofservice;
	}
	public void setBikeDateofservice(Date bikeDateofservice) {
		this.bikeDateofservice = bikeDateofservice;
	}
	public int getBikeKilometer() {
		return bikeKilometer;
	}
	public void setBikeKilometer(int bikeKilometer) {
		this.bikeKilometer = bikeKilometer;
	}
	public String getBikeStatus() {
		return bikeStatus;
	}
	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
	public String getBikeTypeofservice() {
		return bikeTypeofservice;
	}
	public void setBikeTypeofservice(String bikeTypeofservice) {
		this.bikeTypeofservice = bikeTypeofservice;
	}
	public int getBikeEstimatecharge() {
		return bikeEstimatecharge;
	}
	public void setBikeEstimatecharge(int bikeEstimatecharge) {
		this.bikeEstimatecharge = bikeEstimatecharge;
	}
	public int getBikeProductcost() {
		return bikeProductcost;
	}
	public void setBikeProductcost(int bikeProductcost) {
		this.bikeProductcost = bikeProductcost;
	}
	public int getBikeLabourcharge() {
		return bikeLabourcharge;
	}
	public void setBikeLabourcharge(int bikeLabourcharge) {
		this.bikeLabourcharge = bikeLabourcharge;
	}
	public int getBikeFinalamount() {
		return bikeFinalamount;
	}
	public void setBikeFinalamount(int bikeFinalamount) {
		this.bikeFinalamount = bikeFinalamount;
	}
	public BikeDetails getBikedetails() {
		return bikedetails;
	}
	public void setBikedetails(BikeDetails bikedetails) {
		this.bikedetails = bikedetails;
	}
	

}
