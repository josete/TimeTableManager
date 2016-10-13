/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.NoSolutionException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Term;
import alice.tuprolog.Theory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import prolog.Main;

/**
 *
 * @author Clara
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         try {
            Prolog engine = new Prolog();
            Theory theory = new Theory(new FileInputStream("resources/solapara.pl"));
            try {
                engine.setTheory(theory);
                SolveInfo info = engine.solve("solapanAsignaturas(posicion(X1,Y1),posicion(X2,Y2)).");
                Term solution = info.getSolution();
                System.out.println(solution);
            } catch (InvalidTheoryException ex) {
            } catch (MalformedGoalException | NoSolutionException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

   
