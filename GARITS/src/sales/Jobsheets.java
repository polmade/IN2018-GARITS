package sales;

public class Jobsheets {
	private long jobNumber;
	private String owner;
	private String mechanic;
	private String make;
	private String mode;
	private String description;
	private boolean jobComplete;
	private double duration;
	private long id;

	public Jobsheets(long jobNumber, String owner) {
		this.jobNumber = jobNumber;
		this.owner = owner;
	}

	public long getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(long jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getMechanic() {
		return mechanic;
	}

	public void setMechanic(String mechanic) {
		this.mechanic = mechanic;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isJobComplete() {
		return jobComplete;
	}

	public void setJobComplete(boolean jobComplete) {
		this.jobComplete = jobComplete;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
