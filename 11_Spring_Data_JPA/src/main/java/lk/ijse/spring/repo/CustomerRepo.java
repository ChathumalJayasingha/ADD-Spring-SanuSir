package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import java.util.List;
import java.util.Optional;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public interface CustomerRepo extends JpaRepository<Customer, String> {
    //query methods
    //Query Methods Subject Keywords
    //find..by
    //read..by
    //get..by
    //query..by
    //search..by
    //stream..by   Entity type/Collection Type /Streamable


    //count..by - Long
    //exist..by - boolean
    //delete..by ,remove..by ..void


    Optional<Customer> findTopByNameAndAddress(String name, String address);

    List<Customer> readByNameAndAddress(String name, String address, Pageable p);

    Optional<Customer> getByName(String name);

    Optional<Customer> queryByName(String name);

    Optional<Customer> searchByName(String name);

    Streamable<Customer> streamByName(String name);


    Long countByName(String name);

    boolean existsByName(String name);

    void removeCustomerByName(String name);

    //native sql
    @Query(value = "select * from Customer", nativeQuery = true)
    List<Customer> getMyCustomer();


    //jpql
    @Query(value = "select c from Customer c")
    List<Customer> getMyCustomer2();

    //hql
    @Query(value = "from Customer c")
    List<Customer> getMyCustomer3();


    //Parameters
    //Named Parameters
    //Positional Parameters

    //jpql Positional Parameters
    @Query(value = "select c from Customer c where c.id=?1 and c.address=?2")
    List<Customer> getMyCustomer4(String id, String address);

    //jpql Named Parameters
    @Query(value = "select c from Customer c where c.id=:id and c.address=:address")
    List<Customer> getMyCustomer5(@Param("id") String id, @Param("address") String address);


}
