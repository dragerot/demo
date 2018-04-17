package com.example.demo.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;
import com.example.demo.domain.Person;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by T530 on 12.06.2017.
 */
public class PersonItemProcessor  implements ItemProcessor<Person, Person> {
    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final Person transformedPerson = new Person(firstName,lastName);
        return transformedPerson;
    }
}
