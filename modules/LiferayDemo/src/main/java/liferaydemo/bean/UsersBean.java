package liferaydemo.bean;

//User Bean Model
public class UsersBean {

	//	Website Name
	public String sourceURL;
	//Host Name
	public String hostName;
	//Image
	public String image;
	//Event Address
	public String address;
	//Event Summary
	public String summary;
	//Total Event Users
	public String counts;

	public String getSourceURL() {
		return sourceURL;
	}

	public final void setSourceURL(final String sourceURL) {
		this.sourceURL = sourceURL;
	}

	public String getHostName() {
		return hostName;
	}

	public final void setHostName(final String hostName) {
		this.hostName = hostName;
	}

	public String getImage() {
		return image;
	}

	public final void setImage(final String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public final void setAddress(final String address) {
		this.address = address;
	}

	public String getSummary() {
		return summary;
	}

	public final void setSummary(final String summary) {
		this.summary = summary;
	}

	public String getCounts() {
		return counts;
	}

	public final void setCounts(final String counts) {
		this.counts = counts;
	}

	//All Method toString()
	@Override
	public String toString() {
		return "UsersBean{" +
				"sourceURL='" + sourceURL + '\'' +
				", hostName='" + hostName + '\'' +
				", image=" + image +
				", address='" + address + '\'' +
				", summary='" + summary + '\'' +
				", counts=" + counts +
				'}';
	}


	//Default Constructor
	public UsersBean() {
	}
}
