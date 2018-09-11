package com.example.android.smartreminder;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.*;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.classifiers.Classifier;
import weka.core.converters.CSVLoader;
import weka.filters.unsupervised.attribute.Remove;
import weka.core.Instances;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class QuestionAnswerAnalyzer {
    private Classifier c = new J48();

    private Instances ins;
    private String pathToFile;

    public QuestionAnswerAnalyzer(String pathToFile) {
        this.pathToFile=pathToFile;
        trainModel(c, "J48");
    }

    private void trainModel(Classifier c, String name){
        Evaluation e;
        setInstances(pathToFile);
        try {
            e = new Evaluation(ins);
            e.crossValidateModel(c, ins, 10, new Random(1));
            System.out.println("****Results of "+name+"****");
            System.out.println(e.toSummaryString());
            System.out.println(e.toClassDetailsString());
            System.out.println(e.toCumulativeMarginDistributionString());
            System.out.println(e.toMatrixString());
            System.out.println("*********************");
            saveModel(c, name);
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

    }

    private void setInstances(String inputFile) {
        String[] nominalVals =  {"42:positive,negative,neutral"};
        ins = null;
        try {
            CSVLoader csvSource = new CSVLoader();
            csvSource.setSource(new File(inputFile));
            csvSource.setFieldSeparator("\t");
            csvSource.setNominalAttributes("15-16");
            csvSource.setStringAttributes("3,4,6,8,10-12,14");
            csvSource.setNominalLabelSpecs(nominalVals);
            ins = csvSource.getDataSet();
            Remove r = new Remove();
            r.setAttributeIndices("3-4,6,8,10-12,14,40-41");
            r.setInputFormat(ins);
            ins = Remove.useFilter(ins, r);
            //System.out.println(unlabled.toSummaryString());
            r = new Remove();
            System.out.println(ins.toSummaryString());

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int cIdx = ins.numAttributes() - 1;
        ins.setClassIndex(cIdx);
    }

    private void saveModel(Classifier c, String name) throws IOException{


        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream("./models/" + name + ".model"));

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        oos.writeObject(c);
        oos.flush();
        oos.close();

    }
}