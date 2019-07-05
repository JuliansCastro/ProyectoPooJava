
package logicBusiness;


/*
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
    
    /* -----------------------------------------------------------------------------------------------------------------*/
    //Builders
    
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
    
    
    //methods
    
    public double calculateSkinMass(String sex, int age,double weight,double heightStature){
        
        double constantSurfaceAreaMenOver12Years = 68.308;
        double constantSurfaceAreaWomenOver12Years = 73.704;
        double constantSurfaceAreaWomenAndMenUnder12Years = 70.691;
        double skinThicknessMen = 2.07;
        double skinThicknessWomen = 1.96;
        double skinDensity = 1.05;
        double skinMass = 0, bodySurface = 0; //bodySurface in metros^2
        
        if(age>12){
            if("female".equals(sex)){
                bodySurface = (constantSurfaceAreaWomenOver12Years*Math.pow(peso, 0.425)*Math.pow(heightStature,0.725))/10000;
            }else if("male".equals(sex)){
                bodySurface = (constantSurfaceAreaMenOver12Years*Math.pow(peso,0.425)*Math.pow(heightStature,0.725))/10000;
            }
        }else{
            bodySurface = (constantSurfaceAreaWomenAndMenUnder12Years*Math.pow(peso,0.425)*Math.pow(heightStature,0.725))/10000;
        }
        
        if("female".equals(sex)){
            skinMass = bodySurface*skinThicknessWomen*skinDensity;
        }else if("male".equals(sex)){
            skinMass = bodySurface*skinThicknessMen*skinDensity;
        }
        
        System.out.printf("1. Calculo de la masa de la piel(Kg): %.2f %n",skinMass);
        return skinMass;
    }
    
    public double adiposeMassPrediction(double heightStature){
        double sAdipose = pliegueTriceps + pliegueSubescapular + pliegueSupraespinal + pliegueAbdominal + pliegueAnteriorMuslo + pliegueMedialPierna;
        double scoreZAdiposeMass, adiposeMass;
        double phantomHeight = 170.18;
        double sumPhantomFolds = 116.41;
        double sumOfDEPhantomFolds = 34.79;
        double standardDeviationPhantomAdiposeMass = 5.85;
        double PhantomValueSpecificAdiposeMass = 25.6;
        
        scoreZAdiposeMass = (sAdipose*(phantomHeight/heightStature)-sumPhantomFolds)/sumOfDEPhantomFolds;
        adiposeMass = (scoreZAdiposeMass*standardDeviationPhantomAdiposeMass + PhantomValueSpecificAdiposeMass)/Math.pow((phantomHeight/heightStature), 3);
        
        System.out.printf("2. Prediccion masa adiposa(Kg): %.2f %n",adiposeMass);
        return adiposeMass;
    }
    
    public double muscleMassPrediction(double heightStature, double tricepsFold, double subscapularFold, double anteriorThighFold,double medialLegFold){
        double relaxedArmCorrectedByPCT = perimetroBrazoRelajado - (Math.PI*tricepsFold/10); //PCT Pliegue Cutáneo del Triceps
        double forearmNotCorrected = perimetroAnteBrazo;
        double ribCageCorrectedByPCSE = perimetroToracicoMesoesternal - ((Math.PI*subscapularFold)/10);  //PCSE Pliegue Cutáneo SubEscapular
        double thighCorrectedByPCM = perimetroMusloA1cm - ((Math.PI*anteriorThighFold)/10); //PCM Pliegue cutáneo Muslo anterior
        double calfCorrectedByPCP = perimetroPiernaMaximo - ((Math.PI*medialLegFold)/10);//Pliegue Cutáneo Pantorrilla
        double sMuscular = relaxedArmCorrectedByPCT + forearmNotCorrected + ribCageCorrectedByPCSE 
                + thighCorrectedByPCM + calfCorrectedByPCP;
        
        double scoreZMuscleMass, muscleMass;
        double phantomHeight = 170.18;
        double sumPhantomPerimeters = 207.21;
        double sumOfDEPhantomPerimeters = 13.74;
        double standardDeviationPhantomMuscleMass = 5.4;
        double PhantomValueSpecificMuscleMass = 24.5;
        
        scoreZMuscleMass = (sMuscular*(phantomHeight/heightStature)-sumPhantomPerimeters)/sumOfDEPhantomPerimeters;
        muscleMass = (scoreZMuscleMass*standardDeviationPhantomMuscleMass + PhantomValueSpecificMuscleMass)/Math.pow((phantomHeight/heightStature), 3);
        
        /*System.out.printf("\nBrazo relajado corregidos: %.2f %n",relaxedArmCorrectedByPCT);
        System.out.printf("Antebrazo no corregidos: %.2f %n",forearmNotCorrected);
        System.out.printf("Caja toracica corregidos: %.2f %n",ribCageCorrectedByPCSE);
        System.out.printf("Muslo corregidos: %.2f %n",thighCorrectedByPCM);
        System.out.printf("\nSuma perimetros corregidos: %.2f %n",summationOfPerimeters);
        System.out.printf("Indice proporcionalidad Z masa muscular: %.2f %n",scoreZMuscleMass);*/
        
        System.out.printf("3. Prediccion masa muscular(Kg): %.2f %n",muscleMass);
        return muscleMass;
    }
    
    public double boneMassPrediction(double heightStature, double headPerimeter){
        double scoreZBoneMassHead, boneMassHead, scoreZBoneMassBody, boneMassBody, boneMass = 0;
        double standardDeviationPhantomPerimeterForHead = 1.44;
        double perimeterHeadModelPhantom = 56;
        double standardDeviationboneMassHead = 0.18;
        double BoneMassHeadPhantom = 1.2;
        double phantomHeight = 170.18;
        double sumPhantomDiameters = 98.88;
        double sumOfDEPhantomDiameters = 5.33;
        double standardDeviationPhantomBoneMass = 1.34;
        double PhantomValueSpecificBoneMass = 6.7;
        double sBoneBody;
        
        scoreZBoneMassHead = (headPerimeter - perimeterHeadModelPhantom)/standardDeviationPhantomPerimeterForHead;
        boneMassHead = scoreZBoneMassHead*standardDeviationboneMassHead + BoneMassHeadPhantom;
        
        sBoneBody = diametroBiacromial + diametroBiiliocrestal + 2*diametroBiepicondileoHumeral +2*diametroBiepicondileoFemoral;
        scoreZBoneMassBody = (sBoneBody*(phantomHeight/heightStature)-sumPhantomDiameters)/sumOfDEPhantomDiameters;
        boneMassBody = (scoreZBoneMassBody*standardDeviationPhantomBoneMass + PhantomValueSpecificBoneMass)/Math.pow((phantomHeight/heightStature), 3);
        
        boneMass = boneMassHead + boneMassBody;
        System.out.printf("4. Prediccion masa ósea total(Kg): %.2f %n",boneMass);
        return boneMass;
        
    }
    
    
    public double residualMassPrediction(double sittingSize,double waistPerimeter,double abdominalFold){
        double waistPerimeterCorrectedByPCA = waistPerimeter - (Math.PI*abdominalFold/10); //PCA - ¨liegue Cutáneo Abdominal
        double scoreZResidualMass, residualMass = 0;
        double sResidual = diametroAnteroPosteriorToraxPecho + diametroTrasversoToraxMesoesternal + waistPerimeterCorrectedByPCA;
        double phantomSittingSize = 89.92;
        double sumPhantomVariables = 109.35;
        double sumOfDEPhantomVariables = 7.08;
        double standardDeviationPhantomResidualMass = 1.24;
        double PhantomValueSpecificResidualMass = 6.1;
        
        scoreZResidualMass = (sResidual*(phantomSittingSize/sittingSize)-sumPhantomVariables)/sumOfDEPhantomVariables;
        //System.out.printf("Score Z masa residual: %.2f %n",scoreZResidualMass);
        
        
        residualMass = (scoreZResidualMass*standardDeviationPhantomResidualMass + PhantomValueSpecificResidualMass)/Math.pow((phantomSittingSize/sittingSize), 3);
        
        System.out.printf("5. Prediccion masa residual(Kg): %.2f %n",residualMass);
        return residualMass;
    }
    
    /*public double predictionTotalBodyMass(){
        double totalBodyMass = 0;
        totalBodyMass = adiposeMassPrediction();
        return totalBodyMass;
        }
    */
    /* -----------------------------------------------------------------------------------------------------------------*/
    //Setters & Getters

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
