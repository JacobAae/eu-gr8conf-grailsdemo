package eu.gr8conf.grailsdemo

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AttendeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Attendee.list(params), model:[attendeeCount: Attendee.count()]
    }

    def show(Attendee attendee) {
        respond attendee
    }

    def display(Long id) {
        Attendee attendee = Attendee.get(id)
        respond attendee
    }


    def create() {
        respond new Attendee(params)
    }

    @Transactional
    def save(Attendee attendee) {
        if (attendee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (attendee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond attendee.errors, view:'create'
            return
        }

        attendee.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendee.id])
                redirect attendee
            }
            '*' { respond attendee, [status: CREATED] }
        }
    }

    def edit(Attendee attendee) {
        respond attendee
    }

    @Transactional
    def update(Attendee attendee) {
        if (attendee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (attendee.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond attendee.errors, view:'edit'
            return
        }

        attendee.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendee.id])
                redirect attendee
            }
            '*'{ respond attendee, [status: OK] }
        }
    }

    @Transactional
    def delete(Attendee attendee) {

        if (attendee == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        attendee.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'attendee.label', default: 'Attendee'), attendee.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'attendee.label', default: 'Attendee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
