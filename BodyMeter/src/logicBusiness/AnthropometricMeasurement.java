package logicBusiness;

import java.io.*;
import java.util.Arrays;
import javax.crypto.Cipher;


/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class AnthropometricMeasurement implements SaveData, CreateFile {

    private final String nameDoc = "Measurements.txt";

    //Medidas básicas 
    private double peso, tallaAltura, tallaSentado, envergaduraBrazos;

    //Pliegues cutáneos
    private double pliegueTriceps, pliegueSubescapular, pliegueBiceps, pliegueCrestaIliaca,
            pliegueSupraespinal, pliegueAbdominal, pliegueAnteriorMuslo,
            pliegueMedialPierna, plieguePectoral;

    //Perimetros
    private double perimetroCabeza, perimetroCuello, perimetroBrazoRelajado,
            perimetroBrazoFlexionado, perimetroAnteBrazo, perimetroMuneca,
            perimetroToracicoMesoesternal, perimetroAbdominalCinturaMinimo,
            perimetroAbdominal, perimetroGluteoCaderaMaximo, perimetroMusloA1cm,
            perimetroMusloTercioMedio, perimetroPiernaMaximo, perimetroTobilloMinimo;

    //Diametros
    private double diametroBiacromial, diametroAnteroPosteriorAbdominal,
            diametroBiiliocrestal, diametroTrasversoToraxMesoesternal,
            diametroAnteroPosteriorToraxPecho, diametroBiepicondileoHumeral,
            diametroBiestiloideoMuneca, diametroBiepicondileoFemoral;

    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/
    public AnthropometricMeasurement() {
    }

    //Builder Medidas básicas - basic Measures 
    public AnthropometricMeasurement(double peso, double tallaAltura, double tallaSentado, double envergaduraBrazos) {
        this.peso = peso;
        this.tallaAltura = tallaAltura;
        this.tallaSentado = tallaSentado;
        this.envergaduraBrazos = envergaduraBrazos;
    }

    //Builder pliegues cutáneos - skinfold measurements
    public AnthropometricMeasurement(double pliegueTriceps, double pliegueSubescapular, double pliegueBiceps, double pliegueCrestaIliaca, double pliegueSupraespinal, double pliegueAbdominal, double pliegueAnteriorMuslo, double pliegueMedialPierna, double plieguePectoral) {
        this.pliegueTriceps = pliegueTriceps;
        this.pliegueSubescapular = pliegueSubescapular;
        this.pliegueBiceps = pliegueBiceps;
        this.pliegueCrestaIliaca = pliegueCrestaIliaca;
        this.pliegueSupraespinal = pliegueSupraespinal;
        this.pliegueAbdominal = pliegueAbdominal;
        this.pliegueAnteriorMuslo = pliegueAnteriorMuslo;
        this.pliegueMedialPierna = pliegueMedialPierna;
        this.plieguePectoral = plieguePectoral;
    }

    //Builder Perimetros
    public AnthropometricMeasurement(double perimetroCabeza, double perimetroCuello, double perimetroBrazoRelajado, double perimetroBrazoFlexionado, double perimetroAnteBrazo, double perimetroMuneca, double perimetroToracicoMesoesternal, double perimetroAbdominalCinturaMinimo, double perimetroAbdominal, double perimetroGluteoCaderaMaximo, double perimetroMusloA1cm, double perimetroMusloTercioMedio, double perimetroPiernaMaximo, double perimetroTobilloMinimo) {
        this.perimetroCabeza = perimetroCabeza;
        this.perimetroCuello = perimetroCuello;
        this.perimetroBrazoRelajado = perimetroBrazoRelajado;
        this.perimetroBrazoFlexionado = perimetroBrazoFlexionado;
        this.perimetroAnteBrazo = perimetroAnteBrazo;
        this.perimetroMuneca = perimetroMuneca;
        this.perimetroToracicoMesoesternal = perimetroToracicoMesoesternal;
        this.perimetroAbdominalCinturaMinimo = perimetroAbdominalCinturaMinimo;
        this.perimetroAbdominal = perimetroAbdominal;
        this.perimetroGluteoCaderaMaximo = perimetroGluteoCaderaMaximo;
        this.perimetroMusloA1cm = perimetroMusloA1cm;
        this.perimetroMusloTercioMedio = perimetroMusloTercioMedio;
        this.perimetroPiernaMaximo = perimetroPiernaMaximo;
        this.perimetroTobilloMinimo = perimetroTobilloMinimo;
    }

    //Builder todas las medidas
    
    public AnthropometricMeasurement(double peso, double tallaAltura, double tallaSentado, double envergaduraBrazos, double pliegueTriceps, double pliegueSubescapular, double pliegueBiceps, double pliegueCrestaIliaca, double pliegueSupraespinal, double pliegueAbdominal, double pliegueAnteriorMuslo, double pliegueMedialPierna, double plieguePectoral, double perimetroCabeza, double perimetroCuello, double perimetroBrazoRelajado, double perimetroBrazoFlexionado, double perimetroAnteBrazo, double perimetroMuneca, double perimetroToracicoMesoesternal, double perimetroAbdominalCinturaMinimo, double perimetroAbdominal, double perimetroGluteoCaderaMaximo, double perimetroMusloA1cm, double perimetroMusloTercioMedio, double perimetroPiernaMaximo, double perimetroTobilloMinimo, double diametroBiacromial, double diametroAnteroPosteriorAbdominal, double diametroBiiliocrestal, double diametroTrasversoToraxMesoesternal, double diametroAnteroPosteriorToraxPecho, double diametroBiepicondileoHumeral, double diametroBiestiloideoMuneca, double diametroBiepicondileoFemoral) {
        this.peso = peso;
        this.tallaAltura = tallaAltura;
        this.tallaSentado = tallaSentado;
        this.envergaduraBrazos = envergaduraBrazos;
        this.pliegueTriceps = pliegueTriceps;
        this.pliegueSubescapular = pliegueSubescapular;
        this.pliegueBiceps = pliegueBiceps;
        this.pliegueCrestaIliaca = pliegueCrestaIliaca;
        this.pliegueSupraespinal = pliegueSupraespinal;
        this.pliegueAbdominal = pliegueAbdominal;
        this.pliegueAnteriorMuslo = pliegueAnteriorMuslo;
        this.pliegueMedialPierna = pliegueMedialPierna;
        this.plieguePectoral = plieguePectoral;
        this.perimetroCabeza = perimetroCabeza;
        this.perimetroCuello = perimetroCuello;
        this.perimetroBrazoRelajado = perimetroBrazoRelajado;
        this.perimetroBrazoFlexionado = perimetroBrazoFlexionado;
        this.perimetroAnteBrazo = perimetroAnteBrazo;
        this.perimetroMuneca = perimetroMuneca;
        this.perimetroToracicoMesoesternal = perimetroToracicoMesoesternal;
        this.perimetroAbdominalCinturaMinimo = perimetroAbdominalCinturaMinimo;
        this.perimetroAbdominal = perimetroAbdominal;
        this.perimetroGluteoCaderaMaximo = perimetroGluteoCaderaMaximo;
        this.perimetroMusloA1cm = perimetroMusloA1cm;
        this.perimetroMusloTercioMedio = perimetroMusloTercioMedio;
        this.perimetroPiernaMaximo = perimetroPiernaMaximo;
        this.perimetroTobilloMinimo = perimetroTobilloMinimo;
        this.diametroBiacromial = diametroBiacromial;
        this.diametroAnteroPosteriorAbdominal = diametroAnteroPosteriorAbdominal;
        this.diametroBiiliocrestal = diametroBiiliocrestal;
        this.diametroTrasversoToraxMesoesternal = diametroTrasversoToraxMesoesternal;
        this.diametroAnteroPosteriorToraxPecho = diametroAnteroPosteriorToraxPecho;
        this.diametroBiepicondileoHumeral = diametroBiepicondileoHumeral;
        this.diametroBiestiloideoMuneca = diametroBiestiloideoMuneca;
        this.diametroBiepicondileoFemoral = diametroBiepicondileoFemoral;
    }
    
    

    //Diametros
    public AnthropometricMeasurement(double diametroBiacromial, double diametroAnteroPosteriorAbdominal, double diametroBiiliocrestal, double diametroTrasversoToraxMesoesternal, double diametroAnteroPosteriorToraxPecho, double diametroBiepicondileoHumeral, double diametroBiestiloideoMuneca, double diametroBiepicondileoFemoral) {
        this.diametroBiacromial = diametroBiacromial;
        this.diametroAnteroPosteriorAbdominal = diametroAnteroPosteriorAbdominal;
        this.diametroBiiliocrestal = diametroBiiliocrestal;
        this.diametroTrasversoToraxMesoesternal = diametroTrasversoToraxMesoesternal;
        this.diametroAnteroPosteriorToraxPecho = diametroAnteroPosteriorToraxPecho;
        this.diametroBiepicondileoHumeral = diametroBiepicondileoHumeral;
        this.diametroBiestiloideoMuneca = diametroBiestiloideoMuneca;
        this.diametroBiepicondileoFemoral = diametroBiepicondileoFemoral;
    }

    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    @Override
    public void saveData() throws Exception {
        //Medidas básicas 
        String tempPeso = Double.toString(getPeso());
        String tempTallaAltura = Double.toString(getTallaAltura());
        String tempTallaSentado = Double.toString(getTallaSentado());
        String tempEnvergaduraBrazos = Double.toString(getEnvergaduraBrazos());
        //Pliegues cutáneos
        String tempPliegueTriceps = Double.toString(getPliegueTriceps());
        String tempPliegueSubescapular = Double.toString(getPliegueSubescapular());
        String tempPliegueBiceps = Double.toString(getPliegueBiceps());
        String tempPliegueCrestaIliaca = Double.toString(getPliegueCrestaIliaca());
        String tempPliegueSupraespinal = Double.toString(getPliegueSupraespinal());
        String tempPliegueAbdominal = Double.toString(getPliegueAbdominal());
        String tempPliegueAnteriorMuslo = Double.toString(getPliegueAnteriorMuslo());
        String tempPliegueMedialPierna = Double.toString(getPliegueMedialPierna());
        String tempPlieguePectoral = Double.toString(getPlieguePectoral());
        //Perimetros
        String tempPerimetroCabeza = Double.toString(getPerimetroCabeza());
        String tempPerimetroCuello = Double.toString(getPerimetroCuello());
        String tempPerimetroBrazoRelajado = Double.toString(getPerimetroBrazoRelajado());
        String tempPerimetroBrazoFlexionado = Double.toString(getPerimetroBrazoFlexionado());
        String tempPerimetroAnteBrazo = Double.toString(getPerimetroAnteBrazo());
        String tempPerimetroMuneca = Double.toString(getPerimetroMuneca());
        String tempPerimetroToracicoMesoesternal = Double.toString(getPerimetroToracicoMesoesternal());
        String tempPerimetroAbdominalCinturaMinimo = Double.toString(getPerimetroAbdominalCinturaMinimo());
        String tempPerimetroAbdominal = Double.toString(getPerimetroAbdominal());
        String tempPerimetroGluteoCaderaMaximo = Double.toString(getPerimetroGluteoCaderaMaximo());
        String tempPerimetroMusloA1cm = Double.toString(getPerimetroMusloA1cm());
        String tempPerimetroMusloTercioMedio = Double.toString(getPerimetroMusloTercioMedio());
        String tempPerimetroPiernaMaximo = Double.toString(getPerimetroPiernaMaximo());
        String tempPerimetroTobilloMinimo = Double.toString(getPerimetroTobilloMinimo());
        //Diametros
        String tempDiametroBiacromial = Double.toString(getDiametroBiacromial());
        String tempDiametroAnteroPosteriorAbdominal = Double.toString(getDiametroAnteroPosteriorAbdominal());
        String tempDiametroBiiliocrestal = Double.toString(getDiametroBiiliocrestal());
        String tempDiametroTrasversoToraxMesoesternal = Double.toString(getDiametroTrasversoToraxMesoesternal());
        String tempDiametroAnteroPosteriorToraxPecho = Double.toString(getDiametroAnteroPosteriorToraxPecho());
        String tempDiametroBiepicondileoHumeral = Double.toString(getDiametroBiepicondileoHumeral());
        String tempDiametroBiestiloideoMuneca = Double.toString(getDiametroBiestiloideoMuneca());
        String tempDiametroBiepicondileoFemoral = Double.toString(getDiametroBiepicondileoFemoral());

        String[] measurements = {tempPeso, tempTallaAltura, tempTallaSentado,
            tempEnvergaduraBrazos, tempPliegueTriceps, tempPliegueSubescapular,
            tempPliegueBiceps, tempPliegueCrestaIliaca, tempPliegueSupraespinal,
            tempPliegueAbdominal, tempPliegueAnteriorMuslo, tempPliegueMedialPierna,
            tempPlieguePectoral,
            tempPerimetroCabeza, tempPerimetroCuello, tempPerimetroBrazoRelajado,
            tempPerimetroBrazoFlexionado, tempPerimetroAnteBrazo, tempPerimetroMuneca,
            tempPerimetroToracicoMesoesternal, tempPerimetroAbdominalCinturaMinimo,
            tempPerimetroAbdominal, tempPerimetroGluteoCaderaMaximo, tempPerimetroMusloA1cm,
            tempPerimetroMusloTercioMedio, tempPerimetroPiernaMaximo, tempPerimetroTobilloMinimo,
            tempDiametroBiacromial, tempDiametroAnteroPosteriorAbdominal, tempDiametroBiiliocrestal,
            tempDiametroTrasversoToraxMesoesternal, tempDiametroAnteroPosteriorToraxPecho,
            tempDiametroBiepicondileoHumeral, tempDiametroBiestiloideoMuneca,
            tempDiametroBiepicondileoFemoral};

        try (FileWriter fw = new FileWriter(nameDoc, true);
                PrintWriter writeTXT = new PrintWriter(fw)) {

            for (int i = 0; i < measurements.length; i++) {
                String measurement = measurements[i];
                if (i<measurements.length) {
                    writeTXT.print(measurement);
                    //writeTXT.print(Arrays.toString(encrypt(measurement)));
                    writeTXT.print("\t");
                }else{
                    writeTXT.println(Arrays.toString(encrypt(measurement)));
                }
            }
            fw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/
    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTallaAltura() {
        return tallaAltura;
    }

    public void setTallaAltura(double tallaAltura) {
        this.tallaAltura = tallaAltura;
    }

    public double getTallaSentado() {
        return tallaSentado;
    }

    public void setTallaSentado(double tallaSentado) {
        this.tallaSentado = tallaSentado;
    }

    public double getEnvergaduraBrazos() {
        return envergaduraBrazos;
    }

    public void setEnvergaduraBrazos(double envergaduraBrazos) {
        this.envergaduraBrazos = envergaduraBrazos;
    }

    public double getPliegueTriceps() {
        return pliegueTriceps;
    }

    public void setPliegueTriceps(double pliegueTriceps) {
        this.pliegueTriceps = pliegueTriceps;
    }

    public double getPliegueSubescapular() {
        return pliegueSubescapular;
    }

    public void setPliegueSubescapular(double pliegueSubescapular) {
        this.pliegueSubescapular = pliegueSubescapular;
    }

    public double getPliegueBiceps() {
        return pliegueBiceps;
    }

    public void setPliegueBiceps(double pliegueBiceps) {
        this.pliegueBiceps = pliegueBiceps;
    }

    public double getPliegueCrestaIliaca() {
        return pliegueCrestaIliaca;
    }

    public void setPliegueCrestaIliaca(double pliegueCrestaIliaca) {
        this.pliegueCrestaIliaca = pliegueCrestaIliaca;
    }

    public double getPliegueSupraespinal() {
        return pliegueSupraespinal;
    }

    public void setPliegueSupraespinal(double pliegueSupraespinal) {
        this.pliegueSupraespinal = pliegueSupraespinal;
    }

    public double getPliegueAbdominal() {
        return pliegueAbdominal;
    }

    public void setPliegueAbdominal(double pliegueAbdominal) {
        this.pliegueAbdominal = pliegueAbdominal;
    }

    public double getPliegueAnteriorMuslo() {
        return pliegueAnteriorMuslo;
    }

    public void setPliegueAnteriorMuslo(double pliegueAnteriorMuslo) {
        this.pliegueAnteriorMuslo = pliegueAnteriorMuslo;
    }

    public double getPliegueMedialPierna() {
        return pliegueMedialPierna;
    }

    public void setPliegueMedialPierna(double pliegueMedialPierna) {
        this.pliegueMedialPierna = pliegueMedialPierna;
    }

    public double getPlieguePectoral() {
        return plieguePectoral;
    }

    public void setPlieguePectoral(double plieguePectoral) {
        this.plieguePectoral = plieguePectoral;
    }

    public double getPerimetroCabeza() {
        return perimetroCabeza;
    }

    public void setPerimetroCabeza(double perimetroCabeza) {
        this.perimetroCabeza = perimetroCabeza;
    }

    public double getPerimetroCuello() {
        return perimetroCuello;
    }

    public void setPerimetroCuello(double perimetroCuello) {
        this.perimetroCuello = perimetroCuello;
    }

    public double getPerimetroBrazoRelajado() {
        return perimetroBrazoRelajado;
    }

    public void setPerimetroBrazoRelajado(double perimetroBrazoRelajado) {
        this.perimetroBrazoRelajado = perimetroBrazoRelajado;
    }

    public double getPerimetroBrazoFlexionado() {
        return perimetroBrazoFlexionado;
    }

    public void setPerimetroBrazoFlexionado(double perimetroBrazoFlexionado) {
        this.perimetroBrazoFlexionado = perimetroBrazoFlexionado;
    }

    public double getPerimetroAnteBrazo() {
        return perimetroAnteBrazo;
    }

    public void setPerimetroAnteBrazo(double perimetroAnteBrazo) {
        this.perimetroAnteBrazo = perimetroAnteBrazo;
    }

    public double getPerimetroMuneca() {
        return perimetroMuneca;
    }

    public void setPerimetroMuneca(double perimetroMuneca) {
        this.perimetroMuneca = perimetroMuneca;
    }

    public double getPerimetroToracicoMesoesternal() {
        return perimetroToracicoMesoesternal;
    }

    public void setPerimetroToracicoMesoesternal(double perimetroToracicoMesoesternal) {
        this.perimetroToracicoMesoesternal = perimetroToracicoMesoesternal;
    }

    public double getPerimetroAbdominalCinturaMinimo() {
        return perimetroAbdominalCinturaMinimo;
    }

    public void setPerimetroAbdominalCinturaMinimo(double perimetroAbdominalCinturaMinimo) {
        this.perimetroAbdominalCinturaMinimo = perimetroAbdominalCinturaMinimo;
    }

    public double getPerimetroAbdominal() {
        return perimetroAbdominal;
    }

    public void setPerimetroAbdominal(double perimetroAbdominal) {
        this.perimetroAbdominal = perimetroAbdominal;
    }

    public double getPerimetroGluteoCaderaMaximo() {
        return perimetroGluteoCaderaMaximo;
    }

    public void setPerimetroGluteoCaderaMaximo(double perimetroGluteoCaderaMaximo) {
        this.perimetroGluteoCaderaMaximo = perimetroGluteoCaderaMaximo;
    }

    public double getPerimetroMusloA1cm() {
        return perimetroMusloA1cm;
    }

    public void setPerimetroMusloA1cm(double perimetroMusloA1cm) {
        this.perimetroMusloA1cm = perimetroMusloA1cm;
    }

    public double getPerimetroMusloTercioMedio() {
        return perimetroMusloTercioMedio;
    }

    public void setPerimetroMusloTercioMedio(double perimetroMusloTercioMedio) {
        this.perimetroMusloTercioMedio = perimetroMusloTercioMedio;
    }

    public double getPerimetroPiernaMaximo() {
        return perimetroPiernaMaximo;
    }

    public void setPerimetroPiernaMaximo(double perimetroPiernaMaximo) {
        this.perimetroPiernaMaximo = perimetroPiernaMaximo;
    }

    public double getPerimetroTobilloMinimo() {
        return perimetroTobilloMinimo;
    }

    public void setPerimetroTobilloMinimo(double perimetroTobilloMinimo) {
        this.perimetroTobilloMinimo = perimetroTobilloMinimo;
    }

    public double getDiametroBiacromial() {
        return diametroBiacromial;
    }

    public void setDiametroBiacromial(double diametroBiacromial) {
        this.diametroBiacromial = diametroBiacromial;
    }

    public double getDiametroAnteroPosteriorAbdominal() {
        return diametroAnteroPosteriorAbdominal;
    }

    public void setDiametroAnteroPosteriorAbdominal(double diametroAnteroPosteriorAbdominal) {
        this.diametroAnteroPosteriorAbdominal = diametroAnteroPosteriorAbdominal;
    }

    public double getDiametroBiiliocrestal() {
        return diametroBiiliocrestal;
    }

    public void setDiametroBiiliocrestal(double diametroBiiliocrestal) {
        this.diametroBiiliocrestal = diametroBiiliocrestal;
    }

    public double getDiametroTrasversoToraxMesoesternal() {
        return diametroTrasversoToraxMesoesternal;
    }

    public void setDiametroTrasversoToraxMesoesternal(double diametroTrasversoToraxMesoesternal) {
        this.diametroTrasversoToraxMesoesternal = diametroTrasversoToraxMesoesternal;
    }

    public double getDiametroAnteroPosteriorToraxPecho() {
        return diametroAnteroPosteriorToraxPecho;
    }

    public void setDiametroAnteroPosteriorToraxPecho(double diametroAnteroPosteriorToraxPecho) {
        this.diametroAnteroPosteriorToraxPecho = diametroAnteroPosteriorToraxPecho;
    }

    public double getDiametroBiepicondileoHumeral() {
        return diametroBiepicondileoHumeral;
    }

    public void setDiametroBiepicondileoHumeral(double diametroBiepicondileoHumeral) {
        this.diametroBiepicondileoHumeral = diametroBiepicondileoHumeral;
    }

    public double getDiametroBiestiloideoMuneca() {
        return diametroBiestiloideoMuneca;
    }

    public void setDiametroBiestiloideoMuneca(double diametroBiestiloideoMuneca) {
        this.diametroBiestiloideoMuneca = diametroBiestiloideoMuneca;
    }

    public double getDiametroBiepicondileoFemoral() {
        return diametroBiepicondileoFemoral;
    }

    public void setDiametroBiepicondileoFemoral(double diametroBiepicondileoFemoral) {
        this.diametroBiepicondileoFemoral = diametroBiepicondileoFemoral;
    }

    @Override
    public void createFile(String nameDoc) {
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter(nameDoc);
            String pathfile = new File("").getAbsolutePath() + "\\" + nameDoc;
            System.out.println("Archivo \'" + nameDoc + "\' creado satisfactoriamente en la ruta: \n" + pathfile);
            //BufferedWriter bfwriter = new BufferedWriter(flwriter);
            //bfwriter.close();
        } catch (IOException e) {
            System.out.print("Error, El archivo no Exite / No se puede leer el archivo");
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    System.out.print("Error, El archivo no Exite / No se puede leer el archivo");
                    e.printStackTrace();
                }
            }
        }
    }
}
