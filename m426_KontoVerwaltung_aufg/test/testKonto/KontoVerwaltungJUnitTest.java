/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testKonto;

/**
 * Diese Klasse testet die Anwendung Foo. Beinhaltet also die eigentlichen
 * Testfälle basiesend auf JUnit und der Zusatzklasse TestUtils um die
 * (privaten) Komponenten des GUIs zu erhalten.
 *
 * Ausführen der Tests in Netbeans: Rechte Maustaste auf Prpojekt -> Test
 * (Alt-F6)
 *
 * @author Ichiro Suzuki is a physicist/computer engineer working in
 * experimental particle physics at Fermilab. He holds a Ph.D. in physics.
 */
import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import javax.swing.*;
import java.awt.*;
import anwKonto.KontoVerwaltung;
import static java.lang.Thread.sleep;

public class KontoVerwaltungJUnitTest {

    static KontoVerwaltung kontoApp;
    static int kontonr;
    static String firstname;
    static String lastname;
    @Before
    public void setUp() {
        KontoVerwaltungJUnitTest.kontoApp = new KontoVerwaltung();
        KontoVerwaltungJUnitTest.kontoApp.setVisible(true);
    }

    @Test
    //write 1 into field oc account
    public void testAccountNr1() throws Exception {
        JTextField input = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        assertNotNull(input); // component found?
        JTextField output = (JTextField) TestUtils.getChildNamed(kontoApp, "nachname");
        assertNotNull(output); // component found?
        final JButton transfer = (JButton) TestUtils.getChildNamed(kontoApp, "geldtransfer");
        assertNotNull(transfer); // component found?
        final JButton open = (JButton) TestUtils.getChildNamed(kontoApp, "oeffnen");
        assertNotNull(open); // component found?
        JTextField saldo = (JTextField) TestUtils.getChildNamed(kontoApp, "saldo");
        assertNotNull("JTextField NOT FOUND", saldo); // component found?
        JTextField betrag = (JTextField) TestUtils.getChildNamed(kontoApp, "betrag");
        assertNotNull("JTextField NOT FOUND", betrag); // component found?

        // TODO
        Thread.sleep(2000);
    }
    
    @Test
    public void testCraeteNewAction()throws Exception{     
        JTextField kontonr = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        JTextField firstname = (JTextField) TestUtils.getChildNamed(kontoApp, "vorname");
        JTextField lastname = (JTextField) TestUtils.getChildNamed(kontoApp, "nachname");
        JTextField betrag = (JTextField) TestUtils.getChildNamed(kontoApp, "betrag");
        
        JRadioButton einzahlen = (JRadioButton) TestUtils.getChildNamed(kontoApp, "einzahlen");
        
        JButton speichern = (JButton) TestUtils.getChildNamed(kontoApp, "speichern");
        JButton transfer = (JButton) TestUtils.getChildNamed(kontoApp, "geldtransfer");
        
        final JButton neu = (JButton) TestUtils.getChildNamed(kontoApp, "neu");
        
        assertNotNull(kontonr);
        assertNotNull(firstname);
        assertNotNull(lastname);
        assertNotNull(betrag);
        assertNotNull(neu);
        
        kontonr.setText("Test");
        firstname.setText("Test");
        lastname.setText("Test");
        betrag.setText("Test");
        
        neu.doClick();
        
        assertEquals(kontonr.getText(), "");
        assertEquals(firstname.getText(), "");
        assertEquals(lastname.getText(), "");
        assertEquals(betrag.getText(), "");
        assertEquals(einzahlen.isSelected(), true);
        assertEquals(speichern.isEnabled(), true);
        assertEquals(transfer.isEnabled(), false);
    }
    @Test
    public void testnewAccount()throws Exception{
        JTextField kontonr = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        JTextField firstname = (JTextField) TestUtils.getChildNamed(kontoApp, "vorname");
        JTextField lastname = (JTextField) TestUtils.getChildNamed(kontoApp, "nachname");
        
        JButton speichern = (JButton) TestUtils.getChildNamed(kontoApp, "speichern");
        JButton neu = (JButton) TestUtils.getChildNamed(kontoApp, "neu");
        
        assertNotNull(kontonr);
        assertNotNull(firstname);
        assertNotNull(lastname);
        assertNotNull(neu);
        assertNotNull(speichern);
        
        neu.doClick();
        KontoVerwaltungJUnitTest.kontonr = (int)(Math.random() * 999);
        KontoVerwaltungJUnitTest.lastname = "Other lastname";
        KontoVerwaltungJUnitTest.firstname = "Some dome";
        kontonr.setText(KontoVerwaltungJUnitTest.kontonr+"");
        firstname.setText(KontoVerwaltungJUnitTest.lastname);
        lastname.setText(KontoVerwaltungJUnitTest.firstname);
        
        speichern.doClick();
    }
    @Test
    public void testeditAccount()throws Exception{
        JTextField kontonr = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        JTextField firstname = (JTextField) TestUtils.getChildNamed(kontoApp, "vorname");
        JTextField lastname = (JTextField) TestUtils.getChildNamed(kontoApp, "nachname");
        
        JButton speichern = (JButton) TestUtils.getChildNamed(kontoApp, "speichern");
        JButton open = (JButton) TestUtils.getChildNamed(kontoApp, "oeffnen");
        
        assertNotNull(kontonr);
        assertNotNull(firstname);
        assertNotNull(lastname);
        assertNotNull(open);
        assertNotNull(speichern);
        
        kontonr.setText("1");
        
        open.doClick();
        
        String newfirstname = "Ruedi";
        firstname.setText(newfirstname);
        
        speichern.doClick();
        
        assertEquals(firstname.getText(), newfirstname);
        
    }
    @Test
    public void testaddtoBalance()throws Exception{
        JTextField kontonr = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        JButton speichern = (JButton) TestUtils.getChildNamed(kontoApp, "speichern");
        JButton open = (JButton) TestUtils.getChildNamed(kontoApp, "oeffnen");
        JTextField betrag = (JTextField) TestUtils.getChildNamed(kontoApp, "betrag");
        JTextField saldo = (JTextField) TestUtils.getChildNamed(kontoApp, "saldo");
        JButton transfer = (JButton) TestUtils.getChildNamed(kontoApp, "geldtransfer");
        JRadioButton einzahlen = (JRadioButton) TestUtils.getChildNamed(kontoApp, "einzahlen");
        
        assertNotNull(transfer);
        assertNotNull(einzahlen);
        assertNotNull(betrag);
        assertNotNull(kontonr);
        assertNotNull(open);
        assertNotNull(speichern);
        assertNotNull(saldo);
        
        open.doClick();
        
        int timeto = (int)(Math.random() * 50);
        
        int pre = new Integer(saldo.getText());
        int added = 0;
        for(int i = 0;i<timeto;i++){
            int amount = (int)(Math.random() * 100);
            added+=amount;
            betrag.setText(amount+"");
            einzahlen.setSelected(true);
            transfer.doClick();
        }
        int total = pre+added;
        
        kontonr.setText(saldo.getText());
        
        sleep(10000);
        int totalfound = new Integer(saldo.getText());
        assertEquals(total,totalfound);
    }
    @Test
    public void testremovefromBalance()throws Exception{
         JTextField kontonr = (JTextField) TestUtils.getChildNamed(kontoApp, "kontonummer");
        JButton speichern = (JButton) TestUtils.getChildNamed(kontoApp, "speichern");
        JButton open = (JButton) TestUtils.getChildNamed(kontoApp, "oeffnen");
        JTextField betrag = (JTextField) TestUtils.getChildNamed(kontoApp, "betrag");
        JTextField saldo = (JTextField) TestUtils.getChildNamed(kontoApp, "saldo");
        JButton transfer = (JButton) TestUtils.getChildNamed(kontoApp, "geldtransfer");
        JRadioButton einzahlen = (JRadioButton) TestUtils.getChildNamed(kontoApp, "einzahlen");
        
        assertNotNull(transfer);
        assertNotNull(einzahlen);
        assertNotNull(betrag);
        assertNotNull(kontonr);
        assertNotNull(open);
        assertNotNull(speichern);
        assertNotNull(saldo);
        
        open.doClick();
        
        int timeto = (int)(Math.random() * 50);
        
        int pre = new Integer(saldo.getText());
        int added = 0;
        for(int i = 0;i<timeto;i++){
            int amount = -(int)(Math.random() * 100);
            added+=amount;
            betrag.setText(amount+"");
            einzahlen.setSelected(true);
            transfer.doClick();
        }
        int total = pre+added;
        
        kontonr.setText(saldo.getText());
        
        sleep(10000);
        int totalfound = new Integer(saldo.getText());
        assertEquals(total,totalfound);
    }
    
    // @Test
      // TODO
    
}
