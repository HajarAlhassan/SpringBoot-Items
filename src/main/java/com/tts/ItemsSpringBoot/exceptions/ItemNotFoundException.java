package com.tts.ItemsSpringBoot.exceptions;

public class ItemNotFoundException extends RuntimeException  {
    public ItemNotFoundException(String message,Throwable cause){
        super(message,cause);
    }


}
