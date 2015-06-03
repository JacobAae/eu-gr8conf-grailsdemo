package eu.gr8conf.grailsdemo.pages

import eu.gr8conf.grailsdemo.modules.AttendeeFormModule
import eu.gr8conf.grailsdemo.modules.NavigationBarModule
import geb.Page

class AttendeeCreatePage extends Page {

    static url = "/attendee/create"

    static at = {
        title ==~ /Create Attendee/
    }

    static content = {
        menubar { module NavigationBarModule }
        form { module AttendeeFormModule }
        submitButton{ $("button.btn-primary") }
    }
}
