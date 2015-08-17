/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jp
 */
public class Amostra_paci {
   private int id_amostra; 
   private float age_amostra;
   private float body_mass_amostra;
   private float class_amostra;
   private float diabetes_amostra;
   private float diastolic_amostra;
   private float nbpregnant_amostra;
   private float plasma_glucose_amostra;       
   private float serum_isulin;
   private float triceps_skin_amostra;
   private String data_amostra;        
   
   public Amostra_paci(){
       this.age_amostra=0;
       this.body_mass_amostra=0;
       this.class_amostra=0;
       this.data_amostra="";
       this.diabetes_amostra=0;
       this.diastolic_amostra=0;
       this.id_amostra=0;
       this.nbpregnant_amostra=0;
       this.plasma_glucose_amostra=0;
       this.serum_isulin=0;
       this.triceps_skin_amostra=0;
       
   }
   
   public Amostra_paci(int id_amostra,float age_amostra,float body_mass_amostra,float class_amostra,float diabetes_amostra,float diastolic_amostra,float nbpregnant_amostra,float plasma_glucose_amostra,float serum_isulin,float triceps_skin_amostra, String data_amostra ){
    
       this.age_amostra=age_amostra;
       this.body_mass_amostra=body_mass_amostra;
       this.class_amostra=class_amostra; 
       this.data_amostra=data_amostra;
       this.diabetes_amostra=diabetes_amostra;
       this.diastolic_amostra=diastolic_amostra;
       this.id_amostra=id_amostra;
       this.nbpregnant_amostra=nbpregnant_amostra;
       this.plasma_glucose_amostra=plasma_glucose_amostra;
       this.serum_isulin=serum_isulin;
       this.triceps_skin_amostra=triceps_skin_amostra;
       
   }

    public int getId_amostra() {
        return id_amostra;
    }

    public void setId_amostra(int id_amostra) {
        this.id_amostra = id_amostra;
    }

    public float getAge_amostra() {
        return age_amostra;
    }

    public void setAge_amostra(float age_amostra) {
        this.age_amostra = age_amostra;
    }

    public float getBody_mass_amostra() {
        return body_mass_amostra;
    }

    public void setBody_mass_amostra(float body_mass_amostra) {
        this.body_mass_amostra = body_mass_amostra;
    }

    public float getClass_amostra() {
        return class_amostra;
    }

    public void setClass_amostra(float class_amostra) {
        this.class_amostra = class_amostra;
    }

    public float getDiabetes_amostra() {
        return diabetes_amostra;
    }

    public void setDiabetes_amostra(float diabetes_amostra) {
        this.diabetes_amostra = diabetes_amostra;
    }

    public float getDiastolic_amostra() {
        return diastolic_amostra;
    }

    public void setDiastolic_amostra(float diastolic_amostra) {
        this.diastolic_amostra = diastolic_amostra;
    }

    public float getNbpregnant_amostra() {
        return nbpregnant_amostra;
    }

    public void setNbpregnant_amostra(float nbpregnant_amostra) {
        this.nbpregnant_amostra = nbpregnant_amostra;
    }

    public float getPlasma_glucose_amostra() {
        return plasma_glucose_amostra;
    }

    public void setPlasma_glucose_amostra(float plasma_glucose_amostra) {
        this.plasma_glucose_amostra = plasma_glucose_amostra;
    }

    public float getSerum_isulin() {
        return serum_isulin;
    }

    public void setSerum_isulin(float serum_isulin) {
        this.serum_isulin = serum_isulin;
    }

    public float getTriceps_skin_amostra() {
        return triceps_skin_amostra;
    }

    public void setTriceps_skin_amostra(float triceps_skin_amostra) {
        this.triceps_skin_amostra = triceps_skin_amostra;
    }

    public String getData_amostra() {
        return data_amostra;
    }

    public void setData_amostra(String data_amostra) {
        this.data_amostra = data_amostra;
    }
   



}
