package eu.gr8conf.grailsdemo.pages

import eu.gr8conf.grailsdemo.modules.AttendeeListItemModule
import eu.gr8conf.grailsdemo.modules.NavigationBarModule
import geb.Page

class AttendeeListPage extends Page {

    static url = "/attendee/list"

    static at = {
        title ==~ /Attendee List/
    }

    static content = {
        menubar { module NavigationBarModule }
        attendees { moduleList AttendeeListItemModule, $("table tr").tail() }
        fadeInMessage{ $('div.fade-me-in') }
    }

}
