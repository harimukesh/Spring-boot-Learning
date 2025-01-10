package com.example.springbootpractice;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api")
public class ExceptionHandle {


    /* if we didn't give ResponseEntity it goes to defaultException , it might throw 400 error status 500 status , thats why we having ResponseEntity<>*/
    @GetMapping(path = "exception")
    public ResponseEntity<?> exception() {
        throw new CustomException(HttpStatus.BAD_REQUEST, "User_ID is missing");
    }

    @GetMapping(path = "getUser")
    public ResponseEntity<?> getUserException() {
        throw new ResponseException("User_ID is missing");
    }


    /* if @ExceptionHandler present in same class it invoke this method , if not it will check in @ControllerAdvice as Global Exception */
   /* @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleException(CustomException ex){
        return new ResponseEntity<>(ex.getMessage() , ex.getStatus());
    }*/

    @GetMapping(path = "getName")
    public void getName() throws Exception {
        throw new CustomException(HttpStatus.BAD_REQUEST,"User not found");
    }



    static class CustomException extends RuntimeException{
        HttpStatus status;
        String message;

        CustomException(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        public HttpStatus getStatus() {
            return status;
        }

        @Override
        public String getMessage(){
            return message;
        }


    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    static class ResponseException extends RuntimeException{
        HttpStatus status;
        String message;

        ResponseException(String message) {
            super(message);
        }


    }

}
