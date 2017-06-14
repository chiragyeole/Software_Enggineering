/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng.edu.ctrl;

/**
 *
 * @author deeptichavan
 */
public class AssumptionsDAO {
    
    String assumption;
    int isCorrect;

    public AssumptionsDAO(String assumption, int isCorrect) {
        this.assumption = assumption;
        this.isCorrect = isCorrect;
    }

    public String getAssumption() {
        return assumption;
    }

    public void setAssumption(String assumption) {
        this.assumption = assumption;
    }

    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    
}
