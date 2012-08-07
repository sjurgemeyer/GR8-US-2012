class RsCoreDomainGrailsPlugin {

	def version = "0.1"
    def grailsVersion = "2.1 > *"

    def title = "Rs Core Domain Plugin" // Headline display name of the plugin
    def description = '''\
The core domain classes for the Album Store application
'''

	def author = "Andreas Arledal"
    def authorEmail = "andreas.arledal@find-out.se"

    def organization = [ name: "FindOut Technologies", url: "http://www.find-out.se/" ]

    def dependsOn = [
			jodaTime:"1.4"
	]

	def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

}
