package com.cn.session_11.application_1_3;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by admin on 2018/8/6.
 * 造型前的检查
 * instanceof
 */
public class PetCount {

    static String[] typeNames = {
            "Pet", "Dog", "Pug", "Cat","Rodent", "Gerbil", "Hamster",
    };

    public static void main(String[] args) {
        Vector pets = new Vector();
        try {
            Class[] petTypes = {
                    Class.forName("com.cn.session_11.application_1_3.Dog"),
                    Class.forName("com.cn.session_11.application_1_3.Pug"),
                    Class.forName("com.cn.session_11.application_1_3.Cat"),
                    Class.forName("com.cn.session_11.application_1_3.Rodent"),
                    Class.forName("com.cn.session_11.application_1_3.Gerbil"),
                    Class.forName("com.cn.session_11.application_1_3.Hamster"),
            };
            for (int i = 0; i < 15; i++) {
                pets.addElement(petTypes[(int) (Math.random() * petTypes.length)].newInstance());
            }

        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassNotFoundException e) {
        }

        Hashtable h = new Hashtable();
        for (int i = 0; i < typeNames.length; i++) {
            h.put(typeNames[i], new Counter());
        }

        for (int i = 0; i < pets.size(); i++) {
            Object o = pets.elementAt(i);
            if (o instanceof Pet) {
                ((Counter) h.get("Pet")).i++;
            }

            if (o instanceof Dog) {
                ((Counter) h.get("Dog")).i++;
            }

            if (o instanceof Pug) {
                ((Counter) h.get("Pug")).i++;
            }

            if (o instanceof Cat) {
                ((Counter) h.get("Cat")).i++;
            }

            if (o instanceof Rodent) {
                ((Counter) h.get("Rodent")).i++;
            }

            if (o instanceof Gerbil) {
                ((Counter) h.get("Gerbil")).i++;
            }

            if (o instanceof Hamster) {
                ((Counter) h.get("Hamster")).i++;
            }

        }
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.elementAt(i).getClass().toString());
        }

        for (int i = 0; i < typeNames.length; i++) {
            System.out.println(typeNames[i] + " quantity: " + ((Counter) h.get(typeNames[i])).i);
        }
    }
}
