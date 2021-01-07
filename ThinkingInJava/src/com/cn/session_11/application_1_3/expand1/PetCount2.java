package com.cn.session_11.application_1_3.expand1;

import com.cn.session_11.application_1_3.Rodent;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by admin on 2018/8/6.
 * 使用类标记
 */
//public class PetCount2 {
//
//    public static void main(String[] args) {
//        Vector pets = new Vector();
//        Class[] petTypes = {
//                // Class literals work in Java 1.1+ only:
//                Pet.class,
//                Dog.class,
//                Pug.class,
//                Cat.class,
//                Rodent.class,
//                Gerbil.class,
//                Hamster.class,
//        };
//        try {
//            for (int i = 0; i < 15; i++) {
//                // Offset by one to eliminate Pet.class:
//                int rnd = 1 + (int) (Math.random() * (petTypes.length - 1));
//
//                System.out.println( petTypes[rnd].newInstance());
//                pets.addElement( petTypes[rnd].newInstance());
//            }
//        } catch (InstantiationException e) {
//        } catch (IllegalAccessException e) {
//        }
//        Hashtable h = new Hashtable();
//        for (int i = 0; i < petTypes.length; i++){
//            h.put(petTypes[i].toString(),new Counter());
//        }
//
//        for (int i = 0; i < pets.size(); i++) {
//            Object o = pets.elementAt(i);
//            if (o instanceof Pet) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1.Pet")).i++;
//            }
//
//            if (o instanceof Dog) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1.Dog")).i++;
//            }
//
//            if (o instanceof Pug) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1.Pug")).i++;
//            }
//
//            if (o instanceof Cat) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1.Cat")).i++;
//            }
//
//            if (o instanceof Rodent) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1..Rodent")).i++;
//            }
//
//            if (o instanceof Gerbil) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1..Gerbil")).i++;
//            }
//
//            if (o instanceof Hamster) {
//                ((Counter) h.get("com.cn.session_11.application_1_3.expand1..Hamster")).i++;
//            }
//
//        }
//        for (int i = 0; i < pets.size(); i++) {
//            System.out.println(pets.elementAt(i).getClass().toString());
//        }
//
//        Enumeration keys = h.keys();
//        while (keys.hasMoreElements()) {
//            String nm = (String) keys.nextElement();
//            Counter cnt = (Counter) h.get(nm);
//            System.out.println(nm.substring(nm.lastIndexOf('.') + 1) +" quantity: " + cnt.i);
//        }
//    }
//}
