package employee.domain.model;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class UploadFileIdGenerator {

    public String generate() {
        return UUID.randomUUID().toString();
    }

}
