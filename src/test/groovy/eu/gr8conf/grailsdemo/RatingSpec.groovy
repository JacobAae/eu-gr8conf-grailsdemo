package eu.gr8conf.grailsdemo

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Rating)
@Mock([Attendee, Talk])
class RatingSpec extends Specification {

    void "test rating with valid input"() {
        setup:
        Attendee attendee = new Attendee(name: 'Name', email: 'email@mail.com', nationality: 'DK').save(failOnError: true)
        Talk talk = new Talk(title: 'Title', presenter: 'Presenter', startsAt: new Date() ).save(failOnError: true)

        expect:
        new Rating(value: 3, ratedBy: attendee, talk: talk).validate()
    }
}
