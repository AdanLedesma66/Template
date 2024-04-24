package py.com.template.application.engine.response;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@Getter
@Setter
public class EndpointResponse<T> {

    private T data;

    public static <T> EndpointResponse<T> of(T data) {
        EndpointResponse<T> response = new EndpointResponse<>();
        response.setData(data);
        return response;
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
}
