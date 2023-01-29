package com.example.hrfaraonapp.utils;

public class SalaryCalculator {
    private Double salary;
   public SalaryCalculator(Double salary) {
        this.salary = salary;
     }

        public Double getPensionInsurance() {
            return salary *  0.0976;
        }
        public Double getDisabilityInsurance() {
            return salary *  0.015;
        }
        public Double getMedicalInsurance() {
            return salary *  0.0245;
        }
    public Double getHealthInsurance() {
            return (salary - (getPensionInsurance() + getDisabilityInsurance() + getMedicalInsurance())) * 0.09;
        }
    public Double getTax(){
            if((salary * 12) <= 120000 )
                return salary * 0.12;
            return salary * 0.32;
        }
    public Double getNetto(){
            return  salary - (getPensionInsurance() + getDisabilityInsurance() + getMedicalInsurance() + getHealthInsurance() + getTax());

        }

    }
