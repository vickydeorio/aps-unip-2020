/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aps.cc.unip.run;

import com.aps.cc.unip.front.frontInterface;

/**
 *
 * @author Gabriel Da Silva
 */
public class APS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        frontInterface front = new frontInterface();
        
        front.messageStart();
        front.setOption();
        front.runOption();


        
    }
    
}
