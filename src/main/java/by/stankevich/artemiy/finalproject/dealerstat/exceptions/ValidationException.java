package by.stankevich.artemiy.finalproject.dealerstat.exceptions;

import org.springframework.http.HttpStatus;
import java.util.List;

public class ValidationException {

    private HttpStatus status;
    private List<String> errors;

    public ValidationException(HttpStatus badRequest, List<String> errors) {
        this.status = badRequest;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
