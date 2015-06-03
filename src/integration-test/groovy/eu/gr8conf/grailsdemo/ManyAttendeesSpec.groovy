package eu.gr8conf.grailsdemo

import eu.gr8conf.grailsdemo.pages.AttendeeIndexPage
import eu.gr8conf.grailsdemo.pages.AttendeeListPage
import grails.test.mixin.integration.Integration
import grails.transaction.*
import org.openqa.selenium.JavascriptExecutor
import spock.lang.*
import geb.spock.*

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@Integration
@Rollback
@Stepwise
class ManyAttendeesSpec extends GebReportingSpec {


    void "Test Pagination is not shown with few items"() {
        when:
        to AttendeeIndexPage

        then:
        !hasPagination()
    }

    void "Test Pagination is shown with 15 attendees"() {
        setup:
        Attendee.withNewTransaction {
            15.times {
                new Attendee(name: "Name $it", email: "m$it@it.dk").save()
            }
        }

        when:
        to AttendeeIndexPage

        then:
        hasPagination()
    }

    void "Test names of employees from list"() {
        when:
        to AttendeeListPage

        then:
        attendees*.name.containsAll(['Jacob Aae Mikkelsen', 'Guillaume Laforge'])
    }

    void "Test waiting for message displayed"() {
        when:
        to AttendeeListPage

        then:
        waitFor {
            fadeInMessage.text() == 'Hi - are yo waiting for me?'
        }
    }

    void "Test executing Javascript to reach button"() {
        when:
        to AttendeeListPage
        js('jQuery(".well").show();')

        $('a.btn-primary').click()

        then:
        at AttendeeIndexPage
    }

    def js( String script ){
        (driver as JavascriptExecutor).executeScript( script )
    }

}
