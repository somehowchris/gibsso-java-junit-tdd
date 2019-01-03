package anwKonto;

import java.io.*;
/**
 * Verwalten eine Kontos
 *
 * @author mosimann
 */
public class Konto {
    private int knr;
    private String name;
    private String vorname;
    private double saldo;
    
    public Konto() {
        this.saldo=0;
    }
    
    public Konto( int knr ) throws FileNotFoundException, IOException {
        this.knr = knr;
        this.saldo = 0;
        BufferedReader f  = new BufferedReader( new FileReader(Integer.toString(knr)+".konto"));
        this.name = f.readLine();
        this.vorname = f.readLine();
        this.saldo = Double.parseDouble(f.readLine());
        f.close();
    }
    
    public void setKnr(int knr) {
        this.knr=knr;
    }
    
    public void setName(String name) {
        this.name=name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setVorname(String vorname) {
        this.vorname=vorname;
    }
    
    public String getVorname() {
        return this.vorname;
    }
    
    public void Einzahlen(double betrag) throws IOException {
        saldo += betrag;
        Speichern();
    }
    
    public void Abheben(double betrag) throws IOException {
        saldo -= betrag;
        Speichern();
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void Speichern() throws IOException {
        FileOutputStream outx = new FileOutputStream(Integer.toString(knr)+".konto", false);
	PrintStream out = new PrintStream(outx);
        out.println(name);
        out.println(vorname);
        out.println(Double.toString(saldo));
        out.close();
    }
    
}
