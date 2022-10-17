/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM_controller;

import ATM_model.Saldo;
import ATM_services.ATMService;
import ATM_services.ATMInterface;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

/**
 *
 * @author bayua
 */
@Named
@RequestScoped
public class UserActionBean {
    private ATMService _atmService;
    private int userInput;

    
    public int getUserInput(){
        return userInput;
    }
    
    public void setUserInput(int userInput){
        this.userInput = userInput;
    }

    public UserActionBean() {
        _atmService = new ATMService();
    }
    
    public String getSaldo() {
        return "Saldo anda sekarang Rp." + _atmService.getSaldo();
    }
    
    public String tarikUang(){
        int uang;
        uang = userInput;
        
        if (_atmService.getSaldo() - uang < 100000){
            return "nominal penarikan melebihi batas minimal sisa saldo";
        }
        
        else if (uang % 50000 == 0){
            _atmService.tarikan(uang);
            
        int saldoSekarang = _atmService.getSaldo(); 
                
        return "SALDO anda saat ini Rp." + saldoSekarang ;
        }
        
        else {
            return "Nominal bukan kelipatan Rp50.000";
        }
        
    }
    
    public String setorUang(){
        int uang;
        uang = userInput;
        
        if (uang % 50000 == 0){
            _atmService.setoran(uang);
            
            int saldoSekarang = _atmService.getSaldo();
            
            return "SALDO anda saat ini Rp." + saldoSekarang ;
        }
        
        else {
            return "Nominal bukan kelipatan Rp50.000";
        }
        
        
        
    }
   
}
