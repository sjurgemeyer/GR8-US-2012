package org.grails.plugins.rest

class Person {
	String firstName
	String lastName
	
	static expose = 'persons'
	
	static hasMany = [ 
        addresses: Address,  
        phones: Phone,  
    ]
}
