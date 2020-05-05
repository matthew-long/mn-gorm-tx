package mn.gorm.tx.service

import grails.gorm.transactions.ReadOnly
import mn.gorm.tx.model.Book

import javax.inject.Singleton

@Singleton
class BookService {

    @ReadOnly
    List<Book> getAllBooks() {
        return Book.findAll([sort: "name"])
    }
}
