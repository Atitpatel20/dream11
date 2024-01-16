package com.dream11.dream11.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErroDetailes {

    private String message;
    private Date date;
    private String uri;
}
