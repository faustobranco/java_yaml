package com.faustobranco;

import com.faustobranco.model.UserAccess;
import com.faustobranco.model.UserDetails;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        // Merge two yaml files into a class... the second file update values from first
        System.out.println ("Merge two yaml files into a class: \n");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory ());
        UserAccess cls_UserAccess = new UserAccess ();
        ObjectReader objectReader = mapper.readerForUpdating(cls_UserAccess);
        objectReader.readValue(new File ("src/main/resources/useraccess.yaml"));
        objectReader.readValue(new File("src/main/resources/useraccess local.yaml"));
        System.out.println("Merge: " + cls_UserAccess);


        // Simple load from yaml file into a class
        System.out.println ("\nSimple load from yaml file into a class: \n");
        ObjectMapper mapper2 = new ObjectMapper (new YAMLFactory ());
        UserAccess cls_UserAccess2 = mapper2.readValue(new File("src/main/resources/useraccess local.yaml"), UserAccess.class);

        System.out.println ("Simple Load Class: " + cls_UserAccess2);

        // Load yaml file into a immutable class, using constructor (without setters)
        System.out.println ("\nLoad yaml file into a immutable class, using constructor: \n");
        ObjectMapper mapper_constructor = new ObjectMapper (new YAMLFactory ());
        UserDetails cls_UserDetails = mapper_constructor.readValue(new File("src/main/resources/useraccess local.yaml"), UserDetails.class);

        System.out.println ("Immutable Class: " + cls_UserDetails);


        // Load yaml file with properties that not exist into class.
        System.out.println ("\nLoad yaml file with properties that not exist into class: \n");
        ObjectMapper mapper_missing = new ObjectMapper (new YAMLFactory ());
        UserDetails cls_UserDetailsMissing = mapper_missing.readValue(new File("src/main/resources/userdetails missing.yaml"), UserDetails.class);

        System.out.println ("Missing properties: " + cls_UserDetailsMissing);

        // Load Yaml into a object
        System.out.println ("\nLoad Yaml into a object: \n");
        ObjectMapper mapper_Object = new ObjectMapper (new YAMLFactory ());
        JsonNode root = mapper_Object.readTree(new File("src/main/resources/userdetails missing.yaml"));

        System.out.println (root.path ("country"));

        JsonNode contactNode = root.path("uses");
        if (contactNode.isArray()) {

            System.out.println("Is this node an Array? " + contactNode.isArray());

            for (JsonNode node : contactNode) {
                String Database = node.path("Database").toString ();
                String Algorithm = node.path("Algorithm").toString ();
                System.out.println("Database : " + Database);
                System.out.println("Algorithm : " + Algorithm);

            }
        }

        // Yaml Differences - Using Guava
        System.out.println ("\nYaml Differences - Using Guava: \n");
        ObjectMapper mapperDiff = new ObjectMapper(new YAMLFactory());
        TypeReference<HashMap<String, Object>> type = new TypeReference<HashMap<String, Object>>() {};

        Map<String, Object> leftMap = mapperDiff.readValue(new File ("src/main/resources/useraccess.yaml"), type);
        Map<String, Object> rightMap = mapperDiff.readValue(new File("src/main/resources/useraccess local.yaml"), type);

        MapDifference<String, Object> difference = Maps.difference(leftMap, rightMap);

        System.out.println ("Only Left: " + difference.entriesOnlyOnLeft ());
        System.out.println ("Only Right: " + difference.entriesOnlyOnRight ());
        System.out.println ("Differing: " + difference.entriesDiffering ());

    }
}
