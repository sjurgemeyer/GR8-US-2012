package aa.gr8conf

import org.bson.types.ObjectId

class ConferenceAttendee {

	ObjectId id
	static belongsTo = [conference: Conference]
	Person person

	static mapping = {
		person reference: false
	}

}
