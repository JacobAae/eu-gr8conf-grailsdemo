package eu.gr8conf.grailsdemo

class RatingTagLib {
    static defaultEncodeAs = [taglib:'html']
    static encodeAsForTags = [showRating: [taglib:'none']]

    TalkService talkService

    def showRating = { attrs ->
        Talk talk = attrs.talk
        BigDecimal averageRating = talkService.calculateAverageRating(talk)

        if( averageRating ) {
            out << "<span class='average-rating'>${roundAverage(averageRating)}</span>"
        } else {
            out << "N/A"
        }
    }

    private roundAverage(BigDecimal average) {
        "${Math.round(1.0 * average * 100) / 100 }"
    }

}
