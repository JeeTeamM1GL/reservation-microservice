package com.example.Reservations.clients;

import com.example.Reservations.clients.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/v1/users/{id}")
    User findCustomerById(@PathVariable String id);

    default User getDefaultCustomer(String id , Exception exception ) {
        User user = new User();
        user.setId(id);
        user.setFirstName("Not available");
        user.setLastName("Not available");
        user.setEmail("Not available");
        return user;
    }

    @GetMapping("/api/v1/users")
    List<User> findAllCustomers();

    default List<User> findAllUsers() {
        return List.of();
    }
}
