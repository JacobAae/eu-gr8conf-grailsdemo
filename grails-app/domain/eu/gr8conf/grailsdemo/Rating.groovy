package eu.gr8conf.grailsdemo

class Rating {

    Integer value
    String comment
    Attendee ratedBy

    static belongsTo = [talk:Talk]

    static constraints = {
        value min: 1, max: 5
        comment nullable: true
        ratedBy nullable: false
    }

    @Override
    String toString() {
        "$value"
    }
}
