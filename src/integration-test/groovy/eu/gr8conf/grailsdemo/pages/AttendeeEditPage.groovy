package eu.gr8conf.grailsdemo.pages

import eu.gr8conf.grailsdemo.modules.AttendeeFormModule
import eu.gr8conf.grailsdemo.modules.NavigationBarModule
import geb.Page

class AttendeeEditPage extends Page {

    static url = "/attendee/edit"

    static at = {
        title ==~ /Edit Attendee/
    }

    static content = {
        menubar { module NavigationBarModule }
        form { module AttendeeFormModule }
        updateButton{ $("button.btn-primary") }
    }
}
