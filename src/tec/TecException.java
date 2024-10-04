package tec;

public class TecException extends Exception{

    TecException(String errmsg){
        super(errmsg);
    }


    TecException(Exception e){
        super(e);
    }

}