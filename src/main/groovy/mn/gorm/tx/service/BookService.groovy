package mn.gorm.tx.service

import mn.gorm.tx.model.Book

import javax.inject.Singleton

@Singleton
class BookService {

    List<Book> getAllBooks() {
        return Book.findAll([sort: "name"])
    }
}
