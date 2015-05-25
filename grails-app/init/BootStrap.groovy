import eu.gr8conf.grailsdemo.Attendee
import eu.gr8conf.grailsdemo.Talk

class BootStrap {

    def init = { servletContext ->
        [
                ['Jacob Aae Mikkelsen', 'jacob@gr8conf.org', 'Danish'],
                ['Brian Johnsen' , 'brian@gr8conf.org', 'Danish'],
                ['Morten Kristiansen' , 'morten@gr8conf.org', 'Danish'],
                ['Guillaume Laforge' , 'glaforge@gmail.com', 'French'],
        ].each {
            new Attendee(name: it[0], email: it[1], nationality: it[2]).save(failOnError: true)
        }
        [
            ['Groovy Beginners Workshop', 'Danny Hyun', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 08:45' )],
            ['Unleashing the power of AST transformations - Workshop ', 'Andres Almiray', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 08:45' )],
            ['Grails Beginners Workshop', 'Jacob Aae Mikkelsen', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 12:30' )],
            ['Infrastructure Automation with Gradle and Puppet', 'Andrey Adamovich', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 12:30' )],
            ['Getting Groovy With Lego Mindstorms EV3', 'Ryan Vanderwerf', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 15:45' )],
            ['Ratpack 101', 'Alvaro Sanchez-Mariscal', Date.parse( 'yyyy-MM-dd hh:mm', '2015-06-02 15:45' )],
        ].each {
            new Talk(title: it[0], presenter: it[1], startsAt: it[2]).save(failOnError: true)
        }


    }
    def destroy = {
    }
}
