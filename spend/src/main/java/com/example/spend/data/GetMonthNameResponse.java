package com.example.spend.data;

import java.util.ArrayList;
import java.util.Collection;

public class GetMonthNameResponse {

    private Collection<GetExpensesByMonthNameSummary> expenditureByMonth;



    public void addExpenditure(final GetExpensesByMonthNameSummary expenditure){
        if(expenditureByMonth==null){
            expenditureByMonth=new ArrayList<>();
        }
        expenditureByMonth.add(expenditure);
    }

    public Collection<GetExpensesByMonthNameSummary> getExpenditures(){
        return expenditureByMonth;
    }
}