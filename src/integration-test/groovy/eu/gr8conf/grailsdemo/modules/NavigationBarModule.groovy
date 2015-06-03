package eu.gr8conf.grailsdemo.modules

import geb.Module

class NavigationBarModule extends Module {

    static base = { $('nav.navbar') }

    static content = {
        home(required: false) { $('a.home') }
        listAttendee(required: false) { $('a.list') }
        newAttendee(required: false) { $('a.create') }
    }
}
