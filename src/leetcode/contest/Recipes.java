package leetcode.contest;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/biweekly-contest-68/problems/find-all-possible-recipes-from-given-supplies/
public class Recipes {
    public static void main(String args[]){
        String[] recipes = new String[]{"bread"};
        List<String> ingrOfRcp1 = new ArrayList<String>();
        ingrOfRcp1.add("yeast");
        ingrOfRcp1.add("flour");
        List<List<String>> ingrsList = new ArrayList<>();
        ingrsList.add(ingrOfRcp1);
        String[] supplies = new String[]{"yeast","flour","corn"};
        Recipes r = new Recipes();
        List<String> outputList = r.findAllRecipes(recipes,ingrsList,supplies);
        for(String s : outputList){
            System.out.println(s);
        }
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> output = new ArrayList<String>();
        boolean isFound =true;
        for(int i=0;i<recipes.length;i++){
            for(int j=0;j<ingredients.get(i).size();j++){
                String ingredient = ingredients.get(i).get(j);
                isFound = true;
                for(int k=0;k<supplies.length;k++){
                    String supply = supplies[k];
                    if(supply.equals(ingredient)){
                        isFound = false;
                    }
                }
                if(!isFound){
                    for(int t=0;t<recipes.length;t++){
                        if(ingredient.equals(recipes[t])){
                            isFound=true;
                        }
                    }
                }
            }
            if(isFound){
                output.add(recipes[i]);
            }
        }
        return output;
    }
}
