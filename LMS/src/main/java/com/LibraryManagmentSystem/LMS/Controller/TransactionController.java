package com.LibraryManagmentSystem.LMS.Controller;

import com.LibraryManagmentSystem.LMS.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
     @PutMapping("/make-transaction")
    public ResponseEntity makeTransaction(@RequestParam("cardId") int cardId, @RequestParam("bookId") int bookId) throws Exception {
        try {
            transactionService.makeTransaction(cardId, bookId);
            return new ResponseEntity<>("Transaction Made successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/complete-transaction")
    public ResponseEntity returnTransaction(@RequestParam("cardId") int cardId,@RequestParam("bookId") int bookId) throws Exception{
         try{
             transactionService.returnTransaction(cardId,bookId);
             return new ResponseEntity<>("Book returned Successfully",HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<>(e.getMessage(),HttpStatus.EXPECTATION_FAILED);
         }
    }
}
