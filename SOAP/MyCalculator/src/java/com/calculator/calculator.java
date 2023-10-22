/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.calculator;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author ICT_Common
 */
@WebService
public class calculator {
    @WebMethod
    public int add(int a , int b){
        return a+b;
    }
    @WebMethod
    public int subs(int a , int b){
        return a-b;
    }
    @WebMethod
    public int multi(int a , int b){
        return a*b;
    }
    @WebMethod
    public int divi(int a , int b){
        return a/b;
    }
}
