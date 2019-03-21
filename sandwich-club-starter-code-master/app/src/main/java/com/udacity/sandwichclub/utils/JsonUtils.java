package com.udacity.sandwichclub.utils;



import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {


    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich= new Sandwich();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");

            //-----------alsoknownAs------------
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            int n = alsoKnownAs.length();
            List<String> knownAsList = new ArrayList<>(n);
            for(int j=0;j<n;j++){
                knownAsList.add(alsoKnownAs.getString(j));
            }
            sandwich.setAlsoKnownAs(knownAsList);

            //-----------placeholder------------
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            //-----------descoption-------------
            String description = jsonObject.getString("description");
            sandwich.setDescription(description);
            //-----------image------------------
            String image = jsonObject.getString("image");
            sandwich.setImage(image);
            //------------ingreients-------------
            JSONArray jIng = jsonObject.getJSONArray("ingredients");
            int m =jIng.length();
            List<String> ingredients = new ArrayList<>(m);
            for(int k =0;k<m;k++){
                ingredients.add(jIng.getString(k));
            }
            sandwich.setIngredients(ingredients);



            sandwich.setMainName(name.getString("mainName"));


        }catch (Exception e){
            System.out.println("Error"+ e);
        }
        return sandwich;
    }
}
