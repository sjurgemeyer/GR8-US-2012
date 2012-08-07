package aa.gr8conf

import org.bson.types.ObjectId

class Conference {

	/* References defaults to DBRefs */
	static hasMany = [attendees: ConferenceAttendee, speakers: Speaker]

	ObjectId id // ObjectId is default MongoDB type for id. Better than Sequence for sharding.
	String name
	List<Double> location

	/* References could (and should) also be by id */
	static mapping = {
		name index: true
		location geoIndex: true
	}

	static embedded = ['speakers']

    static constraints = {
		location nullable: true
    }
}
