package galaxy.service;

import galaxy.meta.PersonModelMeta;
import galaxy.model.PersonModel;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class PersonalEntryService {

    public List<galaxy.model.PersonModel> getAll() {
        PersonModelMeta m = PersonModelMeta.get();
        return Datastore.query(m).asList();
    }

    public void insert(PersonModel personData) throws Exception {
        // TODO Auto-generated method stub
        personData.setKey(Datastore.allocateId(PersonModelMeta.get()));

        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.put(tx, personData);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }        
    }

    public void update(PersonModel personData) throws Exception {
        Transaction tx = Datastore.beginTransaction();
        try {
            Datastore.get(tx, PersonModelMeta.get(), personData.getKey(), personData.getVersion());
            Datastore.put(tx, personData);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }        
    }

    public void delete(Key personkey) throws Exception {
        Transaction tx = Datastore.beginTransaction();
        try {
            PersonModel person = Datastore.get(tx, PersonModelMeta.get(), personkey);
            Datastore.delete(tx, personkey);
            tx.commit();
        }
        catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }        
    }

    public PersonModel get(Key personkey) {
        return Datastore.getOrNull(PersonModelMeta.get(), personkey);
    }


}
