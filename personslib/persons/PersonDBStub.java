package persons;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * A stub for interface IPersonDB, which does provide RAM persistency but no long-term persistency.
 * @author Charlotte Lecluze and Bruno Zanuttini, Universit&eacute; de Caen Basse-Normandie, France
 * @since February, 2013
 */
public class PersonDBStub implements IPersonDB {

    /** The list of persons itself (without passwords). */
    protected List<Person> persons;

    /** A list of passwords, in the same order as associated persons in {@link #persons}. */
    protected List<String> passwords;

    /**
     * Builds a new, empty list of persons.
     */
    public PersonDBStub () {
        this.persons=new ArrayList<Person> ();
        this.passwords=new ArrayList<String> ();
    }

    @Override
    public void create (Person p, String password) throws IllegalArgumentException {
        if (this.exists(p.getEmail())) {
            throw new IllegalArgumentException("Cannot add "+p+": email already exists");
        }
        this.persons.add(p);
        this.passwords.add(password);
    }

    @Override
    public Collection<Person> retrieveAll () {
        return this.persons;
    }

    @Override
    public Collection<String> retrieveAllEmails () {
        Collection<String> res=new ArrayList<String> ();
        for (Person p: this.persons) {
            res.add(p.getEmail());
        }
        return res;
    }

    @Override
    public Person retrieve (String email) throws IndexOutOfBoundsException {
        for (Person p: this.persons) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        throw new IndexOutOfBoundsException("No person with email "+email);
    }

    @Override
    public boolean isValid (String email, String password) {
        int i;
        for (i=0; i<this.persons.size(); i++) {
            if (this.persons.get(i).getEmail().equals(email)) {
                break;
            }
        }
        if (i==this.persons.size()) {
            return false;
        }
        return this.passwords.get(i).equals(password);
    }

    @Override
    public boolean exists (String email) {
        for (Person p: this.persons) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update (String email, Person person) throws IndexOutOfBoundsException {
        int index=-1;
        for (int i=0; i<this.persons.size(); i++) {
            if (this.persons.get(i).getEmail().equals(email)) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            throw new IndexOutOfBoundsException("No person with email "+email);
        }
        this.persons.set(index,person);
    }

    @Override
    public void updatePassword (String email, String password) throws IndexOutOfBoundsException {
        int index=-1;
        for (int i=0; i<this.persons.size(); i++) {
            if (this.persons.get(i).getEmail().equals(email)) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            throw new IndexOutOfBoundsException("No person with email "+email);
        }
        this.passwords.set(index,password);
    }

    @Override
    public void delete (String email) throws IndexOutOfBoundsException {    
        int index=-1;
        for (int i=0; i<this.persons.size(); i++) {
            if (this.persons.get(i).getEmail().equals(email)) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            throw new IndexOutOfBoundsException("No person with email "+email);
        }
        this.persons.remove(index);
    }

}
