package se.findout.gr8conf.rs

class Album implements Comparable {

	String artist
	String title
	Integer itemsInStock = 0
	Double price
	String newField

	int compareTo(other) {
		this.artist <=> other.artist ?: this.title <=> other.title
	}

	static constraints = {
		artist blank: false
		title blank: false
		itemsInStock nullable: false
		price()
	}
}
