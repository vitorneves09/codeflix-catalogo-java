package br.com.neves.codeflix.domain.exceptions;

import java.util.List;
import br.com.neves.codeflix.domain.validation.Error;


public class DomainException  extends  RuntimeException{

   private final List<Error> errors;

    public DomainException(List<Error> anErrors) {
       super("",null,true,false);
       this.errors = anErrors;
   }


   public static DomainException with(final List<Error> anErrors) {
       return new DomainException(anErrors);
   }

   public List<Error> getErrors() {return this.errors;}
}
