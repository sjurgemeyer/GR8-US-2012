/*
 * Make sure that you have mongoDB installed and running on default port. http://www.mongodb.org/
 * 
 * Run each part of this script in the Grails console for the example
 * application, "gr8conf-mongo".
 */



/*
 * 1:
 * Creating some conferences
 */

import aa.gr8conf.*

['GR8Conf US', 'GR8Conf EU', 'JFokus'].each {
	Conference conference = Conference.findOrCreateByName(it).save()
}



/*
 * 2:
 * Creating some attendees (many to many)
 */

import aa.gr8conf.*
// Fetch conferences
def gr8eu = Conference.findByName("GR8Conf EU")
def gr8us = Conference.findByName("GR8Conf US")

// Create some persons
def persons = ['Andreas Arledal', 'Shaun Jurgemeyer', 'Demo God']
persons.each { new Person(name: it).save() }

// Tie the persons to a conference
gr8eu.addToAttendees(new ConferenceAttendee(person: Person.findByName('Demo God')))
gr8eu.addToAttendees(new ConferenceAttendee(person: Person.findByName('Andreas Arledal')))
gr8eu.save()

gr8us.addToAttendees(new ConferenceAttendee(person: Person.findByName('Shaun Jurgemeyer')))
gr8us.addToAttendees(new ConferenceAttendee(person: Person.findByName('Demo God')))
gr8us.save()



/*
 * 3:
 * Query for conferences by attendee 
 */
import aa.gr8conf.*

// Fetch persons
def demoGod = Person.findByName('Demo God')
def andreas = Person.findByName('Andreas Arledal')

// Find conference by person
def demoGodConferences = ConferenceAttendee.findAllByPerson(demoGod)
println "Demo Gods conferences:"
demoGodConferences.each { println it.conference.name }

def andreasConferences = ConferenceAttendee.findAllByPerson(andreas)
println ""
println "Andreas's conferences:"
andreasConferences.each { println it.conference.name }

// Find attendees by Conference
def gr8us = Conference.findByName("GR8Conf US")
def gr8usAttendees = ConferenceAttendee.findAllByConference(gr8us)
println ""
println "GR8 US Attendees:"
gr8usAttendees.each { println it.person.name }



/*
 * 4:
 * Add some embedded speakers
 */

import aa.gr8conf.*

// Get the conferences
def gr8eu = Conference.findByName("GR8Conf EU")
def gr8us = Conference.findByName("GR8Conf US")

// Create and add speakers
gr8eu.addToSpeakers(new Speaker(name: 'Andreas Arledal'))
gr8eu.addToSpeakers(new Speaker(name: 'Peter Ledbrook'))
gr8eu.save()

gr8us.addToSpeakers(new Speaker(name: 'Burt Beckwith'))
gr8us.addToSpeakers(new Speaker(name: 'Andreas Arledal'))
gr8us.save()



/*
 * 5:
 * Query on speakers
 */

import aa.gr8conf.*

// Get conference
def gr8eu = Conference.findByName("GR8Conf EU")

println "GR8 Eu Speakers:"
gr8eu.speakers.each { println it.name }

// Find conferences where I speak
mySpeaches = Conference.where {
    speakers.name == "Andreas Arledal"
}
println ""
println "My speaches:"
mySpeaches.each { println it.name }



/*
 * 6:
 * Adding locations
 */

import aa.gr8conf.*

// Minneapolis
Conference gr8us = Conference.findOrCreateByName("GR8Conf US")
gr8us.location = [44.969948d, -93.274362d]
gr8us.save()

// Copenhagen
Conference gr8eu = Conference.findOrCreateByName("GR8Conf EU")
gr8eu.location = [55.659674d, 12.591105d]
gr8eu.save()

// Stockholm
Conference jfokus = Conference.findOrCreateByName("JFokus")
jfokus.location = [59.330037d, 18.060172d]
jfokus.save()



/*
 * 7:
 * Geospacial querying
 */

import aa.gr8conf.*

def center = [55.6033d, 13.0078d] // Malmoe - Sweden, close to Copenhagen
def radius = 1
def nearbyConferences = Conference.findAllByLocationWithinCircle([center, radius])

nearbyConferences.each { println it.name }



/*
 * 8:
 * Dynamic properties
 */

import aa.gr8conf.*

Conference gr8eu = Conference.findByName('GR8Conf EU')

gr8eu['beers'] = ['Gr8Beer', 'GroovyBeer'] // Yes, GR8Eu has it's own beer...
gr8eu.save()

println Conference.findAllByBeers('GroovyBeer').each { println it }
