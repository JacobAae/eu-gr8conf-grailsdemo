package eu.gr8conf.grailsdemo

class Attendee {

    String name
    String email
    String nationality

    Date dateCreated
    Date lastUpdated

    static hasMany = [talks: Talk]

    static constraints = {
        name blank: false
        email blank: false, unique: true, email: true
        nationality nullable: true
    }

    @Override
    String toString() {
        name
    }

}
