package org.grails.plugins.rest

class Phone {

	static expose = 'phones'

	String phoneNumber
	String phoneType

    static belongsTo = [person:Person]

}
