import java.util.ListIterator ;
import java.util.LinkedList ;
import java.lang.Math;
import java.util.Calendar;
import java.util.*;

class SalesTeam{
    private Map<String, Integer> ts;
    LinkedList<String> salesPeople;
    ListIterator<String> iterator;
    private int salesRecord;

    public SalesTeam(){
        salesPeople = new LinkedList<String>();
        ts = new HashMap<String, Integer>();
        salesPeople.add("Bonquisha");
        salesPeople.add("Guy");
        salesPeople.add("Tyrese");
        salesPeople.add("Tyrone");
        salesPeople.add("Barbara");
        ts.put("Tryone",0);
        ts.put("Bonquisha",0);
        ts.put("Tyrese",0);
        ts.put("Guy",0);
        ts.put("Barbara",0);
        salesRecord = 0;

        iterator = salesPeople.listIterator() ;
    }

    public String getPerson(){
        Integer tempValue = 0;
        int number=(int)(Math.random()*(salesPeople.size()));
        if (ts.get(salesPeople.get(number)) == null){
            tempValue = 1;
        }else if (ts.get(salesPeople.get(number)) != null){
            tempValue = ts.get(salesPeople.get(number))+ 1;
        }
        ts.put(salesPeople.get(number), tempValue);
        return salesPeople.get(number);
    }

    public String getTopSP(){
        String resultString = "";
        ArrayList<Integer> ducks = new ArrayList<Integer>();
        Integer max = 0;

        for (String x: ts.keySet()){
            ducks.add(ts.get(x));
        }
        max = Collections.max(ducks);
        setSalesRecord(max);

        for (String x: ts.keySet()){
            if (ts.get(x) == max){
                resultString = resultString + x + " ";
            }
        }

        return resultString;
    }

    public void setSalesRecord(Integer x){
        salesRecord = x;
    }

    public int getSalesRecord(){
        return salesRecord;
    }
    public String display(){
        String s="";
        while(iterator.hasNext()){
            s+=iterator.next()+" ";
        }
        return s;
    }
}




