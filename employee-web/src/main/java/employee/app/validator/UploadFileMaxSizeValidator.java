package employee.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

//(6)
public class UploadFileMaxSizeValidator implements
 ConstraintValidator<UploadFileMaxSize, MultipartFile> {

 private UploadFileMaxSize constraint;

 @Override
 public void initialize(UploadFileMaxSize constraint) {
     this.constraint = constraint;
 }

 @Override
 public boolean isValid(MultipartFile multipartFile,
     ConstraintValidatorContext context) {
     if (constraint.value() < 0 || multipartFile == null) {
         return true;
     }
     return multipartFile.getSize() <= constraint.value();
 }

}