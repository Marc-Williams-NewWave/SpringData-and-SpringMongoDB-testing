package hello.springmongodb.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import hello.springmongodb.model.Person;

@Repository
public class PersonService {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String COLLECTION_NAME = "person";

	public void addperson(Person person) {
		if (!mongoTemplate.collectionExists(Person.class)) {
			mongoTemplate.createCollection(Person.class);
		}
		person.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(person, COLLECTION_NAME);
	}

	public boolean equals(Person person) {
		for (Person stranger : mongoTemplate.findAll(Person.class)) {
			if (person.getFirstName().equals(stranger.getFirstName())
					&& person.getLastName().equals(stranger.getLastName())) {
				return true;
			}
		}
		return false;
	}

	public Person specificUser(Person person) {
		return mongoTemplate.findById(person.getId(), Person.class);
	}

	public void clearList() {
		Query query = new Query();
		mongoTemplate.remove(query, COLLECTION_NAME);
	}

	public List<Person> listPerson() {
		return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
	}

	public void deletePerson(Person person) {
		mongoTemplate.remove(person, COLLECTION_NAME);
	}

	public void updatePerson(Person person) {
		mongoTemplate.insert(person, COLLECTION_NAME);
	}
}
