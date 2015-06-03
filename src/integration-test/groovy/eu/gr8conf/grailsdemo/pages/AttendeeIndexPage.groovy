package eu.gr8conf.grailsdemo.pages

import eu.gr8conf.grailsdemo.modules.NavigationBarModule
import geb.Page

class   AttendeeIndexPage extends Page {

    static url = "/attendee/index"

    static at = {
        title ==~ /Attendee List/
    }

    static content = {
        menubar { module NavigationBarModule }
        pagination(required: false) { $('span.currentStep') }
    }

    boolean hasPagination() {
        pagination.text()
    }
}
