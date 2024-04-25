package py.com.template.application.engine.response;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import py.com.template.application.engine.exception.TemplateException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

@Getter
@Setter
@Slf4j
public class EndpointResponse<T> {

    private T data;

    public static <T> EndpointResponse<T> of(T data) {
        try {
            EndpointResponse<T> response = new EndpointResponse<>();
            response.setData(data);
            return response;
        } catch (Throwable t){
            return responseError(t);
        }
    }

    public static <T> EndpointResponse<T> of(Optional<T> data) {
        EndpointResponse<T> response = new EndpointResponse<>();
        data.ifPresent(dt -> response.setData(dt));
        return response;
    }

    public static <T> EndpointResponse<T> of(Optional<T> data, HttpServletResponse response) {

        if(!data.isPresent()){
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return null;
        }else{
            EndpointResponse<T> res = new EndpointResponse<>();
            res.setData(data.get());
            return res;
        }

    }
    public static Object empty() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public static <T> EndpointResponse<T> responseError(Throwable t) {
        if (t == null) {
            t = new NullPointerException("unassigned error");
        }

        Map error = new HashMap();
        if (t instanceof TemplateException ex) {
            error.put("code", ex.getErrorCode());
            error.put("name", ex.getMessage());
//            error.put("extra", ex.getHttpStatus());
            error.put("text", ex.getMessage());
        } else {
            log.info("unexpected exception", t, Level.WARNING);

            error.put("code", 1);
            error.put("name", "unknwonw");
            error.put("extra", null); //
            error.put("text", t.getMessage());
        }

        // error body
        Map body = new HashMap();
        body.put("failure", error);
        body.put("status", error.get("code"));

        return responseError(500, body);
    }

    public static <T> EndpointResponse<T> responseError(int httpStatus, Map body) {
        EndpointResponse<T> response = new EndpointResponse<>();
        return response;
    }
}
