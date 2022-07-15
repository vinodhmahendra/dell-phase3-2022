package simplilearn.repository;

import org.springframework.data.repository.CrudRepository;

import simplilearn.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Long>{

}
