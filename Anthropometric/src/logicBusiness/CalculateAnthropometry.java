package logicBusiness;

/*
 * @author JULIAN C
 * @author DANIEL R
 * @author JUAN B
 */
public class CalculateAnthropometry extends AnthropometricMeasurement {

    /* ----------- METHODS ------------------------------------------------------------------------------------------------------*/
    public double calculateSkinMass(String sex, int age, double weight, double heightStature) {

        double constantSurfaceAreaMenOver12Years = 68.308;
        double constantSurfaceAreaWomenOver12Years = 73.704;
        double constantSurfaceAreaWomenAndMenUnder12Years = 70.691;
        double skinThicknessMen = 2.07;
        double skinThicknessWomen = 1.96;
        double skinDensity = 1.05;
        double skinMass = 0, bodySurface = 0; //bodySurface in metros^2

        if (age > 12) {
            if ("female".equals(sex)) {
                bodySurface = (constantSurfaceAreaWomenOver12Years * Math.pow(getPeso(), 0.425) * Math.pow(heightStature, 0.725)) / 10000;
            } else if ("male".equals(sex)) {
                bodySurface = (constantSurfaceAreaMenOver12Years * Math.pow(getPeso(), 0.425) * Math.pow(heightStature, 0.725)) / 10000;
            }
        } else {
            bodySurface = (constantSurfaceAreaWomenAndMenUnder12Years * Math.pow(getPeso(), 0.425) * Math.pow(heightStature, 0.725)) / 10000;
        }

        if ("female".equals(sex)) {
            skinMass = bodySurface * skinThicknessWomen * skinDensity;
        } else if ("male".equals(sex)) {
            skinMass = bodySurface * skinThicknessMen * skinDensity;
        }

        System.out.printf("1. Calculo de la masa de la piel(Kg): %.2f %n", skinMass);
        return skinMass;
    }

    public double adiposeMassPrediction(double heightStature) {
        double sAdipose = getPliegueTriceps() + getPliegueSubescapular() + getPliegueSupraespinal() + getPliegueAbdominal() + getPliegueAnteriorMuslo() + getPliegueMedialPierna();
        double scoreZAdiposeMass, adiposeMass;
        double phantomHeight = 170.18;
        double sumPhantomFolds = 116.41;
        double sumOfDEPhantomFolds = 34.79;
        double standardDeviationPhantomAdiposeMass = 5.85;
        double PhantomValueSpecificAdiposeMass = 25.6;

        scoreZAdiposeMass = (sAdipose * (phantomHeight / heightStature) - sumPhantomFolds) / sumOfDEPhantomFolds;
        adiposeMass = (scoreZAdiposeMass * standardDeviationPhantomAdiposeMass + PhantomValueSpecificAdiposeMass) / Math.pow((phantomHeight / heightStature), 3);

        System.out.printf("2. Prediccion masa adiposa(Kg): %.2f %n", adiposeMass);
        return adiposeMass;
    }

    public double muscleMassPrediction(double heightStature, double tricepsFold, double subscapularFold, double anteriorThighFold, double medialLegFold) {
        double relaxedArmCorrectedByPCT = getPerimetroBrazoRelajado() - (Math.PI * tricepsFold / 10); //PCT Pliegue Cutáneo del Triceps
        double forearmNotCorrected = getPerimetroAnteBrazo();
        double ribCageCorrectedByPCSE = getPerimetroToracicoMesoesternal() - ((Math.PI * subscapularFold) / 10);  //PCSE Pliegue Cutáneo SubEscapular
        double thighCorrectedByPCM = getPerimetroMusloA1cm() - ((Math.PI * anteriorThighFold) / 10); //PCM Pliegue cutáneo Muslo anterior
        double calfCorrectedByPCP = getPerimetroPiernaMaximo() - ((Math.PI * medialLegFold) / 10);//Pliegue Cutáneo Pantorrilla
        double sMuscular = relaxedArmCorrectedByPCT + forearmNotCorrected + ribCageCorrectedByPCSE
                + thighCorrectedByPCM + calfCorrectedByPCP;

        double scoreZMuscleMass, muscleMass;
        double phantomHeight = 170.18;
        double sumPhantomPerimeters = 207.21;
        double sumOfDEPhantomPerimeters = 13.74;
        double standardDeviationPhantomMuscleMass = 5.4;
        double PhantomValueSpecificMuscleMass = 24.5;

        scoreZMuscleMass = (sMuscular * (phantomHeight / heightStature) - sumPhantomPerimeters) / sumOfDEPhantomPerimeters;
        muscleMass = (scoreZMuscleMass * standardDeviationPhantomMuscleMass + PhantomValueSpecificMuscleMass) / Math.pow((phantomHeight / heightStature), 3);

        /*System.out.printf("\nBrazo relajado corregidos: %.2f %n",relaxedArmCorrectedByPCT);
        System.out.printf("Antebrazo no corregidos: %.2f %n",forearmNotCorrected);
        System.out.printf("Caja toracica corregidos: %.2f %n",ribCageCorrectedByPCSE);
        System.out.printf("Muslo corregidos: %.2f %n",thighCorrectedByPCM);
        System.out.printf("\nSuma perimetros corregidos: %.2f %n",summationOfPerimeters);
        System.out.printf("Indice proporcionalidad Z masa muscular: %.2f %n",scoreZMuscleMass);*/
        System.out.printf("3. Prediccion masa muscular(Kg): %.2f %n", muscleMass);
        return muscleMass;
    }

    public double boneMassPrediction(double heightStature, double headPerimeter) {
        double scoreZBoneMassHead, boneMassHead, scoreZBoneMassBody, boneMassBody, totalBoneMass;
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

        scoreZBoneMassHead = (headPerimeter - perimeterHeadModelPhantom) / standardDeviationPhantomPerimeterForHead;
        boneMassHead = scoreZBoneMassHead * standardDeviationboneMassHead + BoneMassHeadPhantom;

        sBoneBody = getDiametroBiacromial() + getDiametroBiiliocrestal() + 2 * getDiametroBiepicondileoHumeral() + 2 * getDiametroBiepicondileoFemoral();
        scoreZBoneMassBody = (sBoneBody * (phantomHeight / heightStature) - sumPhantomDiameters) / sumOfDEPhantomDiameters;
        boneMassBody = (scoreZBoneMassBody * standardDeviationPhantomBoneMass + PhantomValueSpecificBoneMass) / Math.pow((phantomHeight / heightStature), 3);

        totalBoneMass = boneMassHead + boneMassBody;
        System.out.printf("4. Prediccion masa ósea total(Kg): %.2f %n", totalBoneMass);
        return totalBoneMass;

    }

    public double residualMassPrediction(double sittingSize, double waistPerimeter, double abdominalFold) {
        double waistPerimeterCorrectedByPCA = waistPerimeter - (Math.PI * abdominalFold / 10); //PCA - ¨liegue Cutáneo Abdominal
        double scoreZResidualMass, residualMass;
        double sResidual = getDiametroAnteroPosteriorToraxPecho()
                + getDiametroTrasversoToraxMesoesternal() + waistPerimeterCorrectedByPCA;
        double phantomSittingSize = 89.92;
        double sumPhantomVariables = 109.35;
        double sumOfDEPhantomVariables = 7.08;
        double standardDeviationPhantomResidualMass = 1.24;
        double PhantomValueSpecificResidualMass = 6.1;

        scoreZResidualMass = (sResidual * (phantomSittingSize / sittingSize) - sumPhantomVariables) / sumOfDEPhantomVariables;
        residualMass = (scoreZResidualMass * standardDeviationPhantomResidualMass + PhantomValueSpecificResidualMass) / Math.pow((phantomSittingSize / sittingSize), 3);

        System.out.printf("5. Prediccion masa residual(Kg): %.2f %n", residualMass);
        return residualMass;
    }

    public double predictionTotalBodyMass(double weight, double skinMass, double adiposeMass, double muscleMass, double totalBoneMass, double residualMass) {
        double totalBodyMass, predictiveTotalBodyMass, skinMassAdjusted, adiposeMassAdjusted;
        double muscleMassAdjusted, totalBoneMassAdjusted, residualMassAdjusted, predictiveTotalBodyMassLessActualWeight;

        
        predictiveTotalBodyMass = skinMass + adiposeMass + muscleMass + totalBoneMass + residualMass;
        //System.out.println(skinMass +"\n" + adiposeMass +"\n" +  muscleMass +"\n" + totalBoneMass +"\n" + residualMass);
        
        predictiveTotalBodyMassLessActualWeight = predictiveTotalBodyMass-weight;
        //System.out.println(predictiveTotalBodyMassLessActualWeight);
        
        
        skinMassAdjusted = skinMass -(predictiveTotalBodyMassLessActualWeight*skinMass/predictiveTotalBodyMass);
        adiposeMassAdjusted = adiposeMass - (predictiveTotalBodyMassLessActualWeight*adiposeMass/predictiveTotalBodyMass);
        muscleMassAdjusted = muscleMass - (predictiveTotalBodyMassLessActualWeight*muscleMass/predictiveTotalBodyMass);
        totalBoneMassAdjusted = totalBoneMass - (predictiveTotalBodyMassLessActualWeight*totalBoneMass/predictiveTotalBodyMass);
        residualMassAdjusted = residualMass - (predictiveTotalBodyMassLessActualWeight*residualMass/predictiveTotalBodyMass);
        
        totalBodyMass = skinMassAdjusted + adiposeMassAdjusted + muscleMassAdjusted + totalBoneMassAdjusted + residualMassAdjusted;
        System.out.printf("Prediccion masa corporal total(Kg): %.2f %n", totalBodyMass);//predictiveTotalBodyMass);
        return totalBodyMass;
    }

    public double totalSum(double a, double b, double c, double d, double e) {
        double totalSum;

        totalSum = a + b + c + d + e;

        System.out.printf("Total sumatoria: %.2f %n", totalSum);
        return totalSum;
    }

    /* ----------- BUILDER ------------------------------------------------------------------------------------------------------*/
    public CalculateAnthropometry() {
    }

    public CalculateAnthropometry(double peso, double tallaAltura, double tallaSentado, double envergaduraBrazos) {
        super(peso, tallaAltura, tallaSentado, envergaduraBrazos);
    }

    public CalculateAnthropometry(double pliegueTriceps, double pliegueSubescapular, double pliegueBiceps, double pliegueCrestaIliaca, double pliegueSupraespinal, double pliegueAbdominal, double pliegueAnteriorMuslo, double pliegueMedialPierna, double plieguePectoral) {
        super(pliegueTriceps, pliegueSubescapular, pliegueBiceps, pliegueCrestaIliaca, pliegueSupraespinal, pliegueAbdominal, pliegueAnteriorMuslo, pliegueMedialPierna, plieguePectoral);
    }

    public CalculateAnthropometry(double perimetroCabeza, double perimetroCuello, double perimetroBrazoRelajado, double perimetroBrazoFlexionado, double perimetroAnteBrazo, double perimetroMuñeca, double perimetroToracicoMesoesternal, double perimetroAbdominalCinturaMinimo, double perimetroAbdominal, double perimetroGluteoCaderaMaximo, double perimetroMusloA1cm, double perimetroMusloTercioMedio, double perimetroPiernaMaximo, double perimetroTobilloMinimo) {
        super(perimetroCabeza, perimetroCuello, perimetroBrazoRelajado, perimetroBrazoFlexionado, perimetroAnteBrazo, perimetroMuñeca, perimetroToracicoMesoesternal, perimetroAbdominalCinturaMinimo, perimetroAbdominal, perimetroGluteoCaderaMaximo, perimetroMusloA1cm, perimetroMusloTercioMedio, perimetroPiernaMaximo, perimetroTobilloMinimo);
    }

    public CalculateAnthropometry(double diametroBiacromial, double diametroAnteroPosteriorAbdominal, double diametroBiiliocrestal, double diametroTrasversoToraxMesoesternal, double diametroAnteroPosteriorToraxPecho, double diametroBiepicondileoHumeral, double diametroBiestiloideoMuñeca, double diametroBiepicondileoFemoral) {
        super(diametroBiacromial, diametroAnteroPosteriorAbdominal, diametroBiiliocrestal, diametroTrasversoToraxMesoesternal, diametroAnteroPosteriorToraxPecho, diametroBiepicondileoHumeral, diametroBiestiloideoMuñeca, diametroBiepicondileoFemoral);
    }

    /* ----------- SETTERS & GETTERS --------------------------------------------------------------------------------------------*/
}
