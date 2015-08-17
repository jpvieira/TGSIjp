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
public class Diabete_pima {
    private  int id_pima;
    private float nb_pregnant;
    private float plasma_glucose;
    private float diastolic;
    private float triceps_skin;
    private float serum_insulin;
    private float body_mass;       
    private float diabetes;
    private float age;
    private float classe;

    public Diabete_pima() {
        
        this.id_pima=0;
        this.age=0;
        this.body_mass=0;
        this.classe=0;
        this.diabetes=0;
        this.diastolic=0;
        this.nb_pregnant=0;
        this.plasma_glucose=0;
        this.serum_insulin=0;
        this.triceps_skin=0;
    }
    public Diabete_pima(int id_pima,float nb_pregnant,float plasma_glucose,float diastolic,float triceps_skin,float serum_insulin,float body_mass,float diabetes,float age,float classe){
        this.age=age;
        this.body_mass=body_mass;
        this.classe=classe;
        this.diabetes=diabetes;
        this.diastolic=diastolic;
        this.id_pima=id_pima;
        this.nb_pregnant=nb_pregnant;
        this.plasma_glucose=plasma_glucose;
        this.serum_insulin=serum_insulin;
        this.triceps_skin=triceps_skin;
        
    
    
    }

    public int getId_pima() {
        return id_pima;
    }

    public void setId_pima(int id_pima) {
        this.id_pima = id_pima;
    }

    public float getNb_pregnant() {
        return nb_pregnant;
    }

    public void setNb_pregnant(float nb_pregnant) {
        this.nb_pregnant = nb_pregnant;
    }

    public float getPlasma_glucose() {
        return plasma_glucose;
    }

    public void setPlasma_glucose(float plasma_glucose) {
        this.plasma_glucose = plasma_glucose;
    }

    public float getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(float diastolic) {
        this.diastolic = diastolic;
    }

    public float getTriceps_skin() {
        return triceps_skin;
    }

    public void setTriceps_skin(float triceps_skin) {
        this.triceps_skin = triceps_skin;
    }

    public float getSerum_insulin() {
        return serum_insulin;
    }

    public void setSerum_insulin(float serum_insulin) {
        this.serum_insulin = serum_insulin;
    }

    public float getBody_mass() {
        return body_mass;
    }

    public void setBody_mass(float body_mass) {
        this.body_mass = body_mass;
    }

    public float getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(float diabetes) {
        this.diabetes = diabetes;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getClasse() {
        return classe;
    }

    public void setClasse(float classe) {
        this.classe = classe;
    }
    
    
}
