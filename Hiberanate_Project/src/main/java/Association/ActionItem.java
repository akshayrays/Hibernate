package Association;

import java.util.Set;

public class ActionItem {

	private int id;
	private String bids;
	private String description;
	private Set<Bid> bid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBids() {
		return bids;
	}

	public void setBids(String bids) {
		this.bids = bids;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Bid> getBid() {
		return bid;
	}

	public void setBid(Set<Bid> bid) {
		this.bid = bid;
	}

}
