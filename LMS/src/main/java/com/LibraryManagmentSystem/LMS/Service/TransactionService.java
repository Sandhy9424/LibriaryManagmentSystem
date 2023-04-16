package com.LibraryManagmentSystem.LMS.Service;

import com.LibraryManagmentSystem.LMS.Entity.Book;
import com.LibraryManagmentSystem.LMS.Entity.Transaction;
import com.LibraryManagmentSystem.LMS.Entity.libraryCard;
import com.LibraryManagmentSystem.LMS.Enum.TransactionStatus;
import com.LibraryManagmentSystem.LMS.Repository.BookRepo;
import com.LibraryManagmentSystem.LMS.Repository.TransactionRepo;
import com.LibraryManagmentSystem.LMS.Repository.libraryCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    libraryCardRepo cardRepo;
    @Autowired
    BookRepo bookRepo;
    @Autowired
    TransactionRepo trans;

    public void makeTransaction(int cardId,int bookId) throws Exception {
        libraryCard card=cardRepo.findById(cardId).get();
        Book book=bookRepo.findById(bookId).get();
        if(book.isAvailable()==false){
            throw new Exception("Book is Not Available");
        }
        Transaction transaction=new Transaction();
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setCard(card);
        transaction.setBook(book);
        List<Transaction>transactions=book.getTransactions();
        transactions.add(transaction);
        book.setTransactions(transactions);
        book.setCard(card);
        List<Transaction>transactionList=card.getTransactions();
        transactionList.add(transaction);
        card.setTransactions(transactionList);
        List<Book>bookList=card.getBookList();
        bookList.add(book);
        card.setBookList(bookList);
        cardRepo.save(card);
    }
    public void returnTransaction(int cardId, int bookId) throws Exception{
        libraryCard card=cardRepo.findById(cardId).get();
        List<Transaction>transactions=card.getTransactions();
        for (Transaction transaction:transactions){
            if(transaction.getBook().getBookId()==bookId){
                transaction.setTransactionStatus(TransactionStatus.COMPLETED);
                Book book=bookRepo.findById(bookId).get();
                book.setAvailable(true);
                List<Book>bookList=card.getBookList();
                bookList.remove(book);
                card.setBookList(bookList);
                cardRepo.save(card);
                return;
            }
        }
        throw new Exception("Enter Correct Book OR Id");
    }

}
