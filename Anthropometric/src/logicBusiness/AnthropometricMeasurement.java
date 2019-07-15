
package logicBusiness;


/*
 * @author ANONYMOUS
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */

public class AnthropometricMeasurement {
    
    //Medidas básicas 
    private double peso, tallaAltura, tallaSentado, envergaduraBrazos;
    
    //Pliegues cutáneos
    private double pliegueTriceps, pliegueSubescapular, pliegueBiceps, pliegueCrestaIliaca, pliegueSupraespinal,
            pliegueAbdominal, pliegueAnteriorMuslo, pliegueMedialPierna, plieguePectoral;
    
    //Perimetros
    private double  perimetroCabeza, perimetroCuello, perimetroBrazoRelajado, perimetroBrazoFlexionado, perimetroAnteBrazo,
            perimetroMuñeca, perimetroToracicoMesoesternal, perimetroAbdominalCinturaMinimo, perimetroAbdominal,
            perimetroGluteoCaderaMaximo, perimetroMusloA1cm, perimetroMusloTercioMedio, perimetroPiernaMaximo, perimetroTobilloMinimo;
    
    //Diametros
    private double diametroBiacromial, diametroAnteroPosteriorAbdominal, diametroBiiliocrestal, diametroTrasversoToraxMesoesternal, diametroAnteroPosteriorToraxPecho, diametroBiepicondileoHumeral, diametroBiestiloideoMuñeca, diametroBiepicondileoFemoral;
    
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

    public AnthropometricMeasurement(double perimetroCabeza, double perimetroCuello, double perimetroBrazoRelajado, double perimetroBrazoFlexionado, double perimetroAnteBrazo, double perimetroMuñeca, double perimetroToracicoMesoesternal, double perimetroAbdominalCinturaMinimo, double perimetroAbdominal, double perimetroGluteoCaderaMaximo, double perimetroMusloA1cm, double perimetroMusloTercioMedio, double perimetroPiernaMaximo, double perimetroTobilloMinimo) {
        this.perimetroCabeza = perimetroCabeza;
        this.perimetroCuello = perimetroCuello;
        this.perimetroBrazoRelajado = perimetroBrazoRelajado;
        this.perimetroBrazoFlexionado = perimetroBrazoFlexionado;
        this.perimetroAnteBrazo = perimetroAnteBrazo;
        this.perimetroMuñeca = perimetroMuñeca;
        this.perimetroToracicoMesoesternal = perimetroToracicoMesoesternal;
        this.perimetroAbdominalCinturaMinimo = perimetroAbdominalCinturaMinimo;
        this.perimetroAbdominal = perimetroAbdominal;
        this.perimetroGluteoCaderaMaximo = perimetroGluteoCaderaMaximo;
        this.perimetroMusloA1cm = perimetroMusloA1cm;
        this.perimetroMusloTercioMedio = perimetroMusloTercioMedio;
        this.perimetroPiernaMaximo = perimetroPiernaMaximo;
        this.perimetroTobilloMinimo = perimetroTobilloMinimo;
    }
    
    
    //Diametros
    public AnthropometricMeasurement(double diametroBiacromial, double diametroAnteroPosteriorAbdominal, double diametroBiiliocrestal, double diametroTrasversoToraxMesoesternal, double diametroAnteroPosteriorToraxPecho, double diametroBiepicondileoHumeral, double diametroBiestiloideoMuñeca, double diametroBiepicondileoFemoral) {
        this.diametroBiacromial = diametroBiacromial;
        this.diametroAnteroPosteriorAbdominal = diametroAnteroPosteriorAbdominal;
        this.diametroBiiliocrestal = diametroBiiliocrestal;
        this.diametroTrasversoToraxMesoesternal = diametroTrasversoToraxMesoesternal;
        this.diametroAnteroPosteriorToraxPecho = diametroAnteroPosteriorToraxPecho;
        this.diametroBiepicondileoHumeral = diametroBiepicondileoHumeral;
        this.diametroBiestiloideoMuñeca = diametroBiestiloideoMuñeca;
        this.diametroBiepicondileoFemoral = diametroBiepicondileoFemoral;
    }
    
    
    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
   
    
    
    
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

    public double getPerimetroMuñeca() {
        return perimetroMuñeca;
    }

    public void setPerimetroMuñeca(double perimetroMuñeca) {
        this.perimetroMuñeca = perimetroMuñeca;
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

    public double getDiametroBiestiloideoMuñeca() {
        return diametroBiestiloideoMuñeca;
    }

    public void setDiametroBiestiloideoMuñeca(double diametroBiestiloideoMuñeca) {
        this.diametroBiestiloideoMuñeca = diametroBiestiloideoMuñeca;
    }

    public double getDiametroBiepicondileoFemoral() {
        return diametroBiepicondileoFemoral;
    }

    public void setDiametroBiepicondileoFemoral(double diametroBiepicondileoFemoral) {
        this.diametroBiepicondileoFemoral = diametroBiepicondileoFemoral;
    }

    
}
