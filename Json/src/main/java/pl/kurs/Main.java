package pl.kurs;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.model.Kid;
import pl.kurs.model.Person;
import pl.kurs.model.SoundCloud;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Main {
    private static final String PATH = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        // deserializacja
        // tworzenie obiektu java z jsona
        Person person = mapper.readValue(new File(PATH + "adamnowak.json"), Person.class);
        System.out.println(person);

        Person janKowalski = new Person("Jan", "Kowalski", 50, false, List.of("pilka nozna", "siatkowka"),
                List.of(new Kid("LUki", "Kowalski", 15), new Kid("Alicja", "Kowalska", 60)));

        // serializacja
        // zapis obiektu java do pliku jsonowego
        mapper.writeValue(new File(PATH + "kowalski.json"), janKowalski);

        // zapisanie obiektu javowego jako string z jsonem
        Kid kid = new Kid("Franek", "Kimono", 10);
        String kidJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(kid);
        System.out.println(kidJsonString);

        // stworzenie pobietk ujava na podstawie stringa z jsoem
        String kidJson = "{\"firstName\":\"Franek\",\"lastName\":\"Kimono\",\"age\":10}";
        Kid kidFromString = mapper.readValue(kidJson, Kid.class);
        System.out.println(kidFromString);

        // https://soundcloud.com/oembed?url=http%3A//soundcloud.com/forss/flickermood&format=json
        URL url = new URL("https://soundcloud.com/oembed?url=http%3A//soundcloud.com/forss/flickermood&format=json");
        SoundCloud soundCloud = mapper.readValue(url, SoundCloud.class);
        System.out.println(soundCloud.getAuthor_name());
        System.out.println(soundCloud.getDescription());


    }
}
