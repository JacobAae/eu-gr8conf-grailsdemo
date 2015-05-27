package eu.gr8conf.grailsdemo

class TalkService {

    BigDecimal calculateAverageRating(Talk talk) {
        if( !talk || !talk.ratings ) {
            return null
        }
        talk.ratings*.value.sum() / talk.ratings.size()
    }
}
