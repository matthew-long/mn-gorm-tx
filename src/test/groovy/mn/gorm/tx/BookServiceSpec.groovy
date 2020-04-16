package mn.gorm.tx

import io.micronaut.test.annotation.MicronautTest
import mn.gorm.tx.model.Book
import mn.gorm.tx.service.BookService
import org.hibernate.SessionFactory
import org.springframework.transaction.support.TransactionSynchronizationManager
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest(transactional = true, rollback = true, packages = "mn.gorm.tx.model")
class BookServiceSpec extends Specification {
    @Inject
    BookService bookService

    @Inject
    SessionFactory sessionFactory

    void "test1"() {
        given:
        println "tran active: ${TransactionSynchronizationManager.actualTransactionActive}"
        Book.withTransaction {
            println "tran active: ${TransactionSynchronizationManager.actualTransactionActive}"
        }
        Book book = new Book(name: "FOO").save(failOnError: true, flush: true)

        when:
        List<Book> books = bookService.getAllBooks()

        then:
        books.size() == 1
    }

    void "test2"() {
        given:
        Book book = new Book(name: "BAR").save(failOnError: true, flush: true)

        when:
        List<Book> books = bookService.getAllBooks()

        then:
        books.size() == 1
    }
}
