package com.gaan.liver.data.constant;

public class ErrorConstants {

    public enum Error{
        SUCCESS(200),
        UNAUTHORIZED(401),
        BAD_REQUEST(400);


        private int status;

        Error(int status){
            this.status = status;
        }

        public int getStatus(){
            return status;
        }
    }

    public static final String Error_404 = "";

}
