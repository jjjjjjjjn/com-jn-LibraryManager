package com.jn.service;

import com.jn.domain.Book;

public interface LendAndReturnService {
//    借书
    int lendBook(long book_id,long user_id);
//    还书
    int returnBook(long re_id,long book_id,long user_id);


}
