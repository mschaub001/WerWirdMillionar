package services;


import objects.Admin;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Admin, Long> {

}
