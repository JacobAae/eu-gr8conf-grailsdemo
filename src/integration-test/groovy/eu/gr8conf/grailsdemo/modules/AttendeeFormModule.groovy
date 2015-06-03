package eu.gr8conf.grailsdemo.modules

import geb.Module

class AttendeeFormModule extends Module {

    static base = { $('form') }

    static content = {
        nameInput { $('#name').value() }
        emailInput { $('#email').value() }
    }
}
