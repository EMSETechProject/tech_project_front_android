package com.camarasa.robin.nutritivecoach.Activities.ServeurCommunication;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription.Inscription_1_0_activity;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription.Inscription_2_0_activity;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Inscription.Inscription_4_0_activity;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Meal.FoodData;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Meal.MealIdea;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Meal.MealValuation;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Settings.SetObjectif;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Settings.SetPassword;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Stats.EnterWeight;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Stats.YourStatistics;
import com.camarasa.robin.nutritivecoach.Activities.Activities.Welcome.LogInActivity;
import com.camarasa.robin.nutritivecoach.Activities.Model.Course;
import com.camarasa.robin.nutritivecoach.Activities.Model.Food;
import com.camarasa.robin.nutritivecoach.Activities.Model.FoodCooking;
import com.camarasa.robin.nutritivecoach.Activities.Model.Objectif;
import com.camarasa.robin.nutritivecoach.Activities.Model.PhysicalData;
import com.camarasa.robin.nutritivecoach.Activities.Model.RecipeSelected;
import com.camarasa.robin.nutritivecoach.Activities.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 13/12/17.
 */

public class ConnectionToTheCoach {

    public static RequestQueue queue = null;
    public LogInActivity activity;
    public Inscription_1_0_activity activityIns1;
    public Inscription_2_0_activity activityIns2;
    public EnterWeight enterWeight;
    public YourStatistics yourStatistics;
    public Context context;
    public Inscription_4_0_activity inscription_4_0_activity;

    public ConnectionToTheCoach() {
    }

    //Linked to LogIn activity
    public void logIn(Context context, String pseudo, String password, LogInActivity activity) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.activity = activity;
        final String url = "https://limitless-mountain-74419.herokuapp.com/api/users/loaddata/"+pseudo+"/"+password;
        String ezf = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id = response.getString("id").toString();
                            String id_objectif = response.getString("id_objectif").toString();
                            String value = response.getString("value").toString();
                            User.setId(Long.parseLong(id));
                            Objectif.setValue(Float.parseFloat(value));
                            Objectif.setId(Long.parseLong(id_objectif));
                            ConnectionToTheCoach.this.activity.listenConnect(id);

                        } catch (JSONException e) {
                            ConnectionToTheCoach.this.activity.textViewtest.setText(e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activity.textViewtest.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void available(Context context, String pseudo, Inscription_1_0_activity activityIns1) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.activityIns1 = activityIns1;
        final String url = "https://limitless-mountain-74419.herokuapp.com/api/users/findbyp/"+pseudo;
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id_string = response.getString("id").toString();
                            Long id = Long.parseLong(id_string);
                            ConnectionToTheCoach.this.activityIns1.add(id);

                        } catch (JSONException e) {
                            ConnectionToTheCoach.this.activityIns1.textViewerror.setText(e.getMessage());
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }



    public void addPD(Context context, Float weight, Long age, Float size, Inscription_2_0_activity activityIns2) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.activityIns2 = activityIns2;
        this.context = context;
        final String url = "https://limitless-mountain-74419.herokuapp.com/api/physicaldatas/add/"+age+"/"+size+"/"+weight;
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id_string = response.getString("id").toString();
                            String weight_string = response.getString("weight").toString();
                            String age_string = response.getString("age").toString();
                            String size_string = response.getString("size");

                            Long id = Long.parseLong(id_string);
                            Float weight = Float.parseFloat(weight_string);
                            Long age = Long.parseLong(age_string);
                            Float size = Float.parseFloat(size_string);

                            PhysicalData.setSize(size);
                            PhysicalData.setAge(age);
                            PhysicalData.setWeight(weight);
                            PhysicalData.setId(id);
                            User.setPhysical_data(id);
                            addUser(ConnectionToTheCoach.this.context,User.getPseudo(),User.getPassword(),PhysicalData.getId(),ConnectionToTheCoach.this.activityIns2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void addUser(Context context, String pseudo, String password, Long id, final Inscription_2_0_activity activityIns2) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.activityIns2 = activityIns2;


        final String url = "https://limitless-mountain-74419.herokuapp.com/api/users/add/"+pseudo+"/"+password+"/"+id;
        String test = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id_string = response.getString("id");
                            Long id = Long.parseLong(id_string);
                            User.setId(id);
                            activityIns2.added();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void addWeight(Context context, Float value, final EnterWeight enterWeight) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.enterWeight = enterWeight;


        final String url = "https://limitless-mountain-74419.herokuapp.com/api/weights/add/"+User.getId()+"/"+value;
        String test = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id_string = response.getString("id");
                            enterWeight.addWeight();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void getGraph(Context context, Long id, final YourStatistics yourStatistics) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.yourStatistics = yourStatistics;


        final String url = "https://limitless-mountain-74419.herokuapp.com/api/weights/findlastten/"+id;
        String test = "";
        JsonArrayRequest contextRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<Float> weights = new ArrayList<>();
                        for (int i = 0 ; i < response.length() ; i++) {
                            try {
                                JSONObject jresponse = response.getJSONObject(i);
                                String weight_string =  jresponse.getString("value");
                                Float weight = Float.parseFloat(weight_string);
                                weights.add(weight);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                        yourStatistics.graph(weights);
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);

    }

    public void addObjectif(Context context, Float value, final Inscription_4_0_activity inscription_4_0_activity) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.inscription_4_0_activity = inscription_4_0_activity;

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/objectifs/add/"+User.getId()+"/"+value;
        String test = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String value_string = response.getString("value");
                            String id_string = response.getString("id");
                            Float value = Float.parseFloat(value_string);
                            Long id = Long.parseLong(id_string);
                            Objectif.setId(id);
                            Objectif.setValue(value);
                            inscription_4_0_activity.objectifadded();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void changeObjectif(Context context, Float value, final SetObjectif setObjectif) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/objectifs/modify/"+Objectif.getId()+"/"+value;
        String test = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String value_string = response.getString("value");
                            String id_string = response.getString("id");
                            Float value = Float.parseFloat(value_string);
                            Long id = Long.parseLong(id_string);
                            Objectif.setId(id);
                            Objectif.setValue(value);
                            setObjectif.back2();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void changePassword(Context context, String password, final SetPassword setPassword) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/users/modify/"+User.getId()+"/"+password;
        String test = "";
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String status = response.getString("status");
                            String id_string = response.getString("id");

                            User.setId(Long.parseLong(id_string));
                            User.setPassword(status);
                            setPassword.back2();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void getcat(Context context, final FoodData foodData) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        this.yourStatistics = yourStatistics;


        final String url = "https://limitless-mountain-74419.herokuapp.com/api/foods/cat";
        String test = "";
        JsonArrayRequest contextRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<String> categories = new ArrayList<>();
                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        JSONObject jresponse = response.getJSONObject(i);
                        String cat =  jresponse.getString("cat");
                        categories.add(cat);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                foodData.setCatspinner(categories);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
            }
        });
        queue.add(contextRequest);

    }

    public void getfoodcat(Context context, String cat, final FoodData foodData) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/foods/cat/" + cat;
        String test = "";
        JsonArrayRequest contextRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<String> categories = new ArrayList<>();
                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        JSONObject jresponse = response.getJSONObject(i);
                        String cat =  jresponse.getString("name");
                        categories.add(cat);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                foodData.loadfoad(categories);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
            }
        });
        queue.add(contextRequest);

    }

    public void fooddata(Context context, String name, final FoodData foodData) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }
        final String url = "https://limitless-mountain-74419.herokuapp.com/api/foods/findbyname/"+name;
        JsonObjectRequest contextRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Food food = new Food();
                        try {
                            String intitule = response.getString("intitule");
                            String energie = response.getString("energie");
                            String eau = response.getString("eau");
                            String proteines = response.getString("proteines");
                            String glucides = response.getString("glucides");
                            String lipides = response.getString("lipides");
                            String sucres = response.getString("sucres");
                            String fibres = response.getString("fibres");
                            String sel = response.getString("sel");
                            food.setIntitule(intitule);
                            food.setEnergie(Float.parseFloat(energie));
                            food.setEau(Float.parseFloat(eau));
                            food.setProteines(Float.parseFloat(proteines));
                            food.setGlucides(Float.parseFloat(glucides));
                            food.setLipides(Float.parseFloat(lipides));
                            food.setSucres(Float.parseFloat(sucres));
                            food.setFibres(Float.parseFloat(fibres));
                            food.setSel(Float.parseFloat(sel));

                        } catch (JSONException e) {
                        }
                        foodData.display(food);

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
                    }
                });
        queue.add(contextRequest);
    }

    public void getRecipes(Context context, final MealIdea mealIdea) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/recipes/meal/" + User.getId();
        String test = "";
        JsonArrayRequest contextRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                List<String> names = new ArrayList<>();
                List<String> ids = new ArrayList<>();

                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        JSONObject jresponse = response.getJSONObject(i);
                        String name =  jresponse.getString("name");
                        names.add(name);
                        String id =  jresponse.getString("id");
                        ids.add(id);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                mealIdea.updatebuttons(names,ids);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
            }
        });
        queue.add(contextRequest);

    }

    public void getRecipeData(Context context, final MealValuation mealValuation) {
        if(queue == null) {
            queue = Volley.newRequestQueue(context);
            queue.start();
        }

        final String url = "https://limitless-mountain-74419.herokuapp.com/api/recipes/ingredients/" + RecipeSelected.getId();
        String test = "";

        JsonArrayRequest contextRequest = new JsonArrayRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Course.setId(RecipeSelected.getId());
                Course.setName(RecipeSelected.getName());
                List<FoodCooking> foodCookings = new ArrayList<>();

                for (int i = 0 ; i < response.length() ; i++) {
                    try {
                        Food food = new Food();

                        JSONObject jresponse = response.getJSONObject(i);
                        JSONObject food_json =  jresponse.getJSONObject("food");
                        String intitule = food_json.getString("intitule");
                        String energie = food_json.getString("energie");
                        String weight = jresponse.getString("weight");
                        food.setIntitule(intitule);
                        food.setEnergie(Float.parseFloat(energie));
                        FoodCooking foodCooking = new FoodCooking(food,Float.parseFloat(weight));
                        foodCookings.add(foodCooking);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                Course.setFoodCookings(foodCookings);
                mealValuation.display();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                ConnectionToTheCoach.this.activityIns1.textViewerror.setText(error.getMessage());
            }
        });
        queue.add(contextRequest);



    }

}
