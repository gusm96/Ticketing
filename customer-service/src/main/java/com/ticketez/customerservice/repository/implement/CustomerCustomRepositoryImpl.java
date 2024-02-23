package com.ticketez.customerservice.repository.implement;

import com.ticketez.customerservice.domain.Customer;
import com.ticketez.customerservice.repository.CustomerCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CustomerCustomRepositoryImpl implements CustomerCustomRepository {
    private EntityManager em;
    public CustomerCustomRepositoryImpl (EntityManager em){
        this.em = em;
    }
    @Override
    public Optional<Customer> findByUsername(String username) {
        try{
            Customer customer = em.createQuery("select c from Customer c " +
                            "where c.username = : username", Customer.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return Optional.of(customer);
        }catch (NoResultException e){
            return Optional.empty();
        }
    }
}
