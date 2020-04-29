package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author("Eric","Evans");
		Book book = new Book("Domain Driven Design","123123");
		eric.getBooks().add(book);
		book.getAuthors().add(eric);
		Publisher pub = new Publisher("Penguin Publishers","Some Street Number 1");
		publisherRepository.save(pub);
		book.setPublisher(pub);
		pub.getBooks().add(book);
		
		
		
		authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(pub);
		
		Author rod = new Author("Rod","Johnson");
		Book book2 = new Book("J2EE Development without EJB","456456");
		eric.getBooks().add(book2);
		book.getAuthors().add(rod);
		book2.setPublisher(pub);
		pub.getBooks().add(book2);
		
		authorRepository.save(rod);
		bookRepository.save(book2);
		publisherRepository.save(pub);
		
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
		System.out.println("Publisher number of books: " + pub.getBooks().size());

	}

}
