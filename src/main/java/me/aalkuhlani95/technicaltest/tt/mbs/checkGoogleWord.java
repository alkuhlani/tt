/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.aalkuhlani95.technicaltest.tt.mbs;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Ahmed
 */
@Named(value = "checkGoogleWord")
@ViewScoped
public class checkGoogleWord implements Serializable {

    private String inputGoogle;
    private Boolean outputGoogle = false;
    private Boolean isDone = false;

    /**
     * Creates a new instance of checkGoogleWord
     */
    public checkGoogleWord() {
    }

    public void check() {
        boolean isGoogle = false;
        String gg = "[gG]";
        String oo = "[oO0]|<>|\\(\\)";
        String ll = "[lLI]";
        String ee = "[Ee3]";
        String d = inputGoogle;
        d = d.replaceAll(gg, "g");
        d = d.replaceAll(oo, "o");
        d = d.replaceAll(ll, "l");
        d = d.replaceAll(ee, "e");
        System.out.println("" + d);
        if (d.equals("google")) {
            outputGoogle = true;
        } else {
            outputGoogle = false;
        }
        isDone = true;
    }

    public String getInputGoogle() {
        return inputGoogle;
    }

    public void setInputGoogle(String inputGoogle) {
        this.inputGoogle = inputGoogle;
    }

    public Boolean getOutputGoogle() {
        return outputGoogle;
    }

    public void setOutputGoogle(Boolean outputGoogle) {
        this.outputGoogle = outputGoogle;
    }

    public Boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }

    
}
