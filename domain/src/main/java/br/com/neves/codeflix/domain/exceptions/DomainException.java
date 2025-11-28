package br.com.neves.codeflix.domain.exceptions;

import java.util.List;
import br.com.neves.codeflix.domain.validation.Error;


public class DomainException  extends  NoStackTraceException{

   private final List<Error> errors;

    public DomainException(String aMessage,List<Error> anErrors) {
       super(aMessage);
       this.errors = anErrors;
   }

    public static DomainException with(final Error anErrors) {
        return new DomainException("",List.of(anErrors));
    }


    public static DomainException with(final List<Error> anErrors) {
       return new DomainException("",anErrors);
   }

   public List<Error> getErrors() {return this.errors;}
}
