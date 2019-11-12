/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author andreashenriksson
 */
@Named(value = "testBean")
@SessionScoped
public class TestBean implements Serializable {
    private String Something;
    
    /**
     * Creates a new instance of TestBean
     */
    public TestBean() {
    }

    /**
     * @return the Something
     */
    public String getSomething() {
        return Math.random()>0.5?"SOMETHING BIG":"something small";
    }

    /**
     * @param Something the Something to set
     */
    public void setSomething(String Something) {
        this.Something = Something;
    }
    
}
