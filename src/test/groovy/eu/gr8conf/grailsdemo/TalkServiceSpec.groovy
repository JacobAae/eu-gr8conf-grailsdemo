package eu.gr8conf.grailsdemo

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TalkService)
class TalkServiceSpec extends Specification {

    @Unroll
    void "test robustness of calculateAverageRating"() {
        expect:
        service.calculateAverageRating(talk) == null

        where:
        talk << [null, new Talk(ratings: null), new Talk(ratings: [] as Set)]
    }

    @Unroll
    void "test calculation of calculateAverageRating"() {
        setup:
        Talk talk = new Talk(ratings: [])
        numbers.each {
            talk.ratings << new Rating(value: it)
        }

        expect:
        service.calculateAverageRating(talk) == expected

        where:
        numbers     | expected
        [1]         | 1.0
        [2,4]       | 3.0
        [2,3]       | 2.5
        [2,3,2]     | 7.0/3
    }

}
