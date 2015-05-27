package eu.gr8conf.grailsdemo

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(RatingTagLib)
class RatingTagLibSpec extends Specification {

    def setup() {
        tagLib.talkService = new TalkService()
    }

    @Unroll
    void "test output from showRating"() {
        when:
        String output = tagLib.showRating(talk: new Talk(ratings: ratings), { a -> a })

        then:
        output == expected

        where:
        ratings                                                             | expected
        null                                                                | 'N/A'
        [new Rating(value: 5)]                                              | "<span class='average-rating'>5</span>"
        [new Rating(value: 2),new Rating(value: 3)]                         | "<span class='average-rating'>2.5</span>"
        [new Rating(value: 2),new Rating(value: 2),new Rating(value: 3)]    | "<span class='average-rating'>2.33</span>"
        [new Rating(value: 2),new Rating(value: 2),new Rating(value: 1)]    | "<span class='average-rating'>1.67</span>"

    }
}
