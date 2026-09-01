package com.learning.telusko.question1;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderSummaryRepository repository;

    public OrderService(OrderSummaryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly=true)
    public OrderSummaryResponse getSummary(OrderSummaryRequest request){
        //If some Id's do not exist, PostgresSQL's 'IN' clause automatically drops them
        return repository.getOrderSummaryByIds(request.orderIDs());

    }
}
/**
 * Think of @Transactional(readOnly = true) like opening a document in "Read-Only Mode" on your computer.
 * Here is why we use it in simple terms:
 *
 * It’s Faster and Saves Energy: When you open a file
 * normally, your computer works hard in the background tracking every click and change you make
 * just in case you want to save it. In "Read-Only" mode, the computer knows you can't change
 * anything, so it relaxes and loads the data much faster.
 *
 * It Prevents Mistakes: It acts like a safety lock. If you accidentally write code that tries
 * to change or delete an order inside that method, the system will block it and say,
 * "Hey, you promised we were only reading data here!"
 *
 * It Helps the Database Relax: It tells your PostgreSQL database, "I am just looking around,
 * I won't change anything." The database then doesn't waste time locking tables or putting up
 * guards to protect the data from other users.
 */
