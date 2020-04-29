/**
 * 
 */
package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.domain.Publisher;

/**
 * @author rever
 *
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long>{

}
