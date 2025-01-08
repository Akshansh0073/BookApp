package com.order.details.OrderDetails.ExternalServices;

import com.order.details.OrderDetails.ExternalClasses.Book;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallback implements BookService {

    @Override
    public Book getBookById(Long id) {
        return null;
    }
}
